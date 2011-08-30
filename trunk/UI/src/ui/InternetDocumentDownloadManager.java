/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import gui.form.AdminInforForm;
import internetsearch.BingSearch;
import internetsearch.InternetSearchAPI;
import internetsearch.InternetSearchManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author nuwan
 */
public class InternetDocumentDownloadManager {

    String downloadFolderPath;
    HashMap<String, ArrayList<String>> downloadedFileList;
    ArrayList<String> fileArrayList;
    ArrayList<String> urlList;
    HashMap<String, String> urlFileMap;
    JProgressBar pbar;
    int maxNumOfSourcesPerDocument = 10;
    InternetSearchAPI searchAPI;

    public InternetDocumentDownloadManager(JProgressBar pbar, InternetSearchAPI searchAPI) {
        this.pbar = pbar;
        this.searchAPI = searchAPI;
    }

    public InternetDocumentDownloadManager() {
    }

    public String downloadFiles(String destFolderPath, String fName) {
        System.out.println("Start Downloading the internet files........");
        if (AdminInforForm.getInternetSearchAPI() instanceof BingSearch) {
            System.out.println("Internet Search is powered by Bing Live Search 2.0");
        } else {
            System.out.println("Internet Search is powered by Google");
        }
        InternetSearchManager sd = new InternetSearchManager(searchAPI);
        sd.setMaxNumOfSourcesPerDocument(maxNumOfSourcesPerDocument);
        downloadFolderPath = sd.downloadSourcesForFile(destFolderPath + File.separator + fName, pbar);
        urlList = sd.getUrlList();
        urlFileMap = sd.getMap();
        return downloadFolderPath;
    }

    public ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public HashMap<String, String> getMap() {
        return this.urlFileMap;
    }

    public HashMap<String, ArrayList<String>> downloadFilesForMultiplePeerSearch(ArrayList<String> arr, String folderPath, JProgressBar pbar) {
        fileArrayList = arr;
        String destFolderPath = folderPath;

        InternetSearchManager sd = new InternetSearchManager(searchAPI);
        sd.setMaxNumOfSourcesPerDocument(maxNumOfSourcesPerDocument);
        downloadedFileList = sd.downloadSourcesForFileFolder(fileArrayList, destFolderPath, pbar);
        return downloadedFileList;
    }

    public int getMaxNumOfSourcesPerDocument() {
        return maxNumOfSourcesPerDocument;
    }

    public void setMaxNumOfSourcesPerDocument(int maxNumOfSourcesPerDocument) {
        this.maxNumOfSourcesPerDocument = maxNumOfSourcesPerDocument;
    }
}
