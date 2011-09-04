/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import ui.DocumentIndexingManager;
import ui.InternetDocumentDownloadManager;
import ui.Manager;
import ui.PlagiabustServerSourceDownloadManager;
import ui.peerSearchReportData;

/**
 *
 * @author Compaq
 */
public class PeerSearchWorker extends SwingWorker<peerSearchReportData, String> {

    ArrayList<String> fileArrayList = new ArrayList<String>();
    HashMap<File, ArrayList<String>> indexedFileList = new HashMap<File, ArrayList<String>>();
    InternetDocumentDownloadManager idm = new InternetDocumentDownloadManager(AdminInforForm.getInternetSearchAPI());
    PlagiabustServerSourceDownloadManager plagiabustServerSourceDownloadManager = new PlagiabustServerSourceDownloadManager();
    DocumentIndexingManager indexingManger = new DocumentIndexingManager();
    peerSearchReportData temp = null;
    String destFolderPath;
    File[] files;
    String indexFolderPath;
    String selectedDocumentPath;
    Manager manager;
    JProgressBar internetSearchProgressBar;
    JProgressBar plagiabustSearchProgressBar;
    JProgressBar pbar2;
    JProgressBar pbar3;
    JProgressBar pbar4;
    int maxIndexfiles;
    boolean UsePlagiabustWebServer;
    boolean UseInternetSearch;
    boolean paraphaseDetection = false;
    ArrayList<String> indexedFiles = new ArrayList<String>();

    public PeerSearchWorker(String destFolderPath, File[] files, String indexFolderPath, ArrayList<String> fileArrayList, Manager manager,
            JProgressBar internetSearchProgressBar, JProgressBar plagiabustSearchProgressBar, JProgressBar pbar2, JProgressBar pbar3, JProgressBar pbar4, int maxNumOfInternetSources, int maxIndexfiles, boolean UsePlagiabustWebServer, boolean UseInternetSource, boolean paraphaseDetection) {
        this.destFolderPath = destFolderPath;
        this.files = files;
        this.indexFolderPath = indexFolderPath;
        this.fileArrayList = fileArrayList;
        this.manager = manager;
        this.pbar2 = pbar2;
        this.pbar3 = pbar3;
        this.pbar4 = pbar4;
        this.internetSearchProgressBar = internetSearchProgressBar;
        this.plagiabustSearchProgressBar = plagiabustSearchProgressBar;
        this.idm.setMaxNumOfSourcesPerDocument(maxNumOfInternetSources);
        this.maxIndexfiles = maxIndexfiles;
        this.UsePlagiabustWebServer = UsePlagiabustWebServer;
        this.UseInternetSearch = UseInternetSource;
        this.paraphaseDetection = paraphaseDetection;
    }

    @Override
    protected peerSearchReportData doInBackground() throws Exception {
        HashMap<String, ArrayList<String>> downloadedFileList = new HashMap<String, ArrayList<String>>();
        HashMap<String, String> urlFileMap = new HashMap<String, String>();
        
        long Start = System.currentTimeMillis();
        if (UsePlagiabustWebServer) {
            System.out.println("Start Downloading Sources From Plaiabust Web Server.");
            downloadedFileList = plagiabustServerSourceDownloadManager.downloadFilesForMultiplePeerSearch(fileArrayList, destFolderPath, plagiabustSearchProgressBar);
            urlFileMap = plagiabustServerSourceDownloadManager.getIdFileMap();
            System.out.println("Finished Downloading the Plaiabust Web Server files.");

        }
        if (UseInternetSearch) {
            System.out.println("Start Downloading Sources From Internet.");

            // Append to Hashmap
            HashMap<String, ArrayList<String>> tempMap = idm.downloadFilesForMultiplePeerSearch(fileArrayList, destFolderPath, internetSearchProgressBar);
            Iterator it = tempMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                downloadedFileList.put((String)pairs.getKey(), (ArrayList<String>)pairs.getValue());
            }

            HashMap<String, String> tempUrlFileMap = idm.getMap();
            Iterator it2 = tempUrlFileMap.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry pairs = (Map.Entry) it2.next();
                urlFileMap.put((String)pairs.getKey(), (String)pairs.getValue());
            }
            
            System.out.println("Finished Downloading the Internet Sources.");
        }


        System.out.println("Start Searching File Index.");
        indexedFileList = indexingManger.indexSearchforMultiplePeers(files, indexFolderPath, pbar2, maxIndexfiles);
        System.out.println("Finished Searching in Index.");



        try {
            System.out.println("Start comparing files........................");
            temp = manager.compareAllFiles(indexedFileList, downloadedFileList, urlFileMap, pbar3, pbar4, paraphaseDetection);
            System.out.println("Finished comparing files........................");
        } catch (IOException ex) {
            System.out.println("There are no similar files or some error has occured");
        }
        
        long End = System.currentTimeMillis();
        long timeInSeconds = (End-Start)/1000;
        if(timeInSeconds > 60){
            System.out.println("Execution Time: "+(timeInSeconds)/60+"min");
        }
        else{
            System.out.println("Execution Time: "+timeInSeconds+"s");
        }
  
        return temp;

    }

    public peerSearchReportData getOutPut() {
        return this.temp;
    }
}
