/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    JProgressBar pbar;
    JProgressBar pbar2;
    JProgressBar pbar3;
    JProgressBar pbar4;
    int maxIndexfiles;
    boolean UsePlagiabustWebServer;
    
    boolean paraphaseDetection = false;
    ArrayList<String> indexedFiles = new ArrayList<String>();

    public PeerSearchWorker(String destFolderPath, File[] files, String indexFolderPath, ArrayList<String> fileArrayList, Manager manager,
            JProgressBar pbar, JProgressBar pbar2, JProgressBar pbar3, JProgressBar pbar4, int maxNumOfInternetSources, int maxIndexfiles, boolean UsePlagiabustWebServer,boolean paraphaseDetection) {
        this.destFolderPath = destFolderPath;
        this.files = files;
        this.indexFolderPath = indexFolderPath;
        this.fileArrayList = fileArrayList;
        this.manager = manager;
        this.pbar2 = pbar2;
        this.pbar3 = pbar3;
        this.pbar4 = pbar4;
        this.pbar = pbar;
        this.idm.setMaxNumOfSourcesPerDocument(maxNumOfInternetSources);
        this.maxIndexfiles = maxIndexfiles;
        this.UsePlagiabustWebServer = UsePlagiabustWebServer;
        this.paraphaseDetection = paraphaseDetection;
    }

    @Override
    protected peerSearchReportData doInBackground() throws Exception {
        HashMap<String, ArrayList<String>> downloadedFileList;
        if (UsePlagiabustWebServer) {
            System.out.println("Start Downloading from Plagiabust Web server........................");
            downloadedFileList = plagiabustServerSourceDownloadManager.downloadFilesForMultiplePeerSearch(fileArrayList, destFolderPath, pbar);
            System.out.println("Finished Downloading the internet files........................");

        } else {
            System.out.println("Start Downloading the internet files........................");
            downloadedFileList = idm.downloadFilesForMultiplePeerSearch(fileArrayList, destFolderPath, pbar);
            System.out.println("Finished Downloading the internet files........................");
        }


        System.out.println("Start indexing the files........................");
        indexedFileList = indexingManger.indexSearchforMultiplePeers(files, indexFolderPath, pbar2, maxIndexfiles);
        System.out.println("Finished indexing the files........................");



        try {
            System.out.println("Start comparing files........................");
            temp = manager.compareAllFiles(indexedFileList, downloadedFileList, pbar3, pbar4,paraphaseDetection);
            System.out.println("Finished comparing files........................");
        } catch (IOException ex) {
            System.out.println("There are no similar files or some error has occured");
        }

        return temp;

    }

    public peerSearchReportData getOutPut() {
        return this.temp;
    }
}
