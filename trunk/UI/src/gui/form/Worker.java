/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import ui.Manager;
import ui.InternetDocumentDownloadManager;
import ui.DocumentIndexingManager;
import ui.FormMain;
import ui.PlagiabustServerSourceDownloadManager;

/**
 *
 * @author Compaq
 */
public class Worker extends SwingWorker<ReportData, String> {

    InternetDocumentDownloadManager idm;
    PlagiabustServerSourceDownloadManager plagiabustServerSourceDownloadManager = new PlagiabustServerSourceDownloadManager();
    DocumentIndexingManager indexingManger = new DocumentIndexingManager();
    FormMain form = new FormMain();
    HashMap<String, String[]> temp = null;
    String destFolderPath;
    String fName;
    String indexFolderPath;
    String selectedDocumentPath;
    Manager manager;
    JProgressBar pbar2;
    JProgressBar pbar3;
    JProgressBar pbar4;
    int maxIndexfiles;
    boolean UsePlagiabustWebServer = false;
    boolean UseInternetSearch = false;
    boolean paraphaseDetection = false;
    ArrayList<String> indexedFiles = new ArrayList<String>();

    public Worker(String destFolderPath, String fName, String indexFolderPath, String selectedDocumentPath, Manager manager, JProgressBar internetSearchProgressBar, JProgressBar plagiabustSearchProgressBar,
            JProgressBar pbar2, JProgressBar pbar3, JProgressBar pbar4, int maxNumOfInternetSources, int maxIndexfiles, boolean UsePlagiabustWebServer, boolean UseInternetSearch, boolean paraphaseDetection) {
        this.destFolderPath = destFolderPath;
        this.fName = fName;
        this.indexFolderPath = indexFolderPath;
        this.selectedDocumentPath = selectedDocumentPath;
        this.manager = manager;
        this.idm = new InternetDocumentDownloadManager(internetSearchProgressBar, AdminInforForm.getInternetSearchAPI());
        this.plagiabustServerSourceDownloadManager = new PlagiabustServerSourceDownloadManager(plagiabustSearchProgressBar);
        this.pbar2 = pbar2;
        this.pbar3 = pbar3;
        this.pbar4 = pbar4;
        this.idm.setMaxNumOfSourcesPerDocument(maxNumOfInternetSources);
        this.maxIndexfiles = maxIndexfiles;
        this.UsePlagiabustWebServer = UsePlagiabustWebServer;
        this.UseInternetSearch = UseInternetSearch;
        this.paraphaseDetection = paraphaseDetection;
    }

    @Override
    protected ReportData doInBackground() throws Exception {
        String downloadPathForInternet = null;
        String downloadPathForPlagiabust = null;
        ArrayList<String> urlList = new ArrayList<String>();
        HashMap<String, String> map = new HashMap<String, String>();

        if (UsePlagiabustWebServer) {
            System.out.println("Start Downloading Sources From Plaiabust Web Server.");
            downloadPathForPlagiabust = plagiabustServerSourceDownloadManager.downloadFiles(destFolderPath, fName);
            urlList = plagiabustServerSourceDownloadManager.getIdList();
            map = plagiabustServerSourceDownloadManager.getIdFileMap();
            System.out.println("Finished Downloading the Plaiabust Web Server files.");
        }


        if (UseInternetSearch) {
            System.out.println("Start Downloading Sources From Internet.");
            downloadPathForInternet = idm.downloadFiles(destFolderPath, fName);

            // Apped to urlList
            ArrayList<String> tempList = idm.getUrlList();
            for (Iterator<String> it = tempList.iterator(); it.hasNext();) {
                String url = it.next();
                urlList.add(url);
            }

            // Append to Hashmap
            HashMap<String, String> tempMap = idm.getMap();
            Iterator it = tempMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                map.put((String)pairs.getKey(), (String)pairs.getValue());
            }

            System.out.println("Finished Downloading the Internet Sources.");
        }
        System.out.println("Start Searching File Index.");
        indexedFiles = indexingManger.indexSearch(indexFolderPath, selectedDocumentPath, pbar2, maxIndexfiles);
        System.out.println("Finished Searching in Index.");
        try {
            System.out.println("Start comparing files.");
            temp = manager.compareFiles(selectedDocumentPath, downloadPathForInternet, downloadPathForPlagiabust, indexedFiles, pbar3, pbar4, paraphaseDetection);
            System.out.println("Finished comparing files.");

        } catch (IOException ex) {
            System.out.println("There are no similar files or some error has occured");
        }

        ReportData repData = new ReportData(temp, map, urlList);
        return repData;
    }

    public HashMap<String, String[]> getOutPut() {
        return this.temp;
    }

    @Override
    protected void done() {
    }
}
