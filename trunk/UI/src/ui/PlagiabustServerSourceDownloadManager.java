/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JProgressBar;
import plagiabustwebserver.Client;
import plagiabustwebserver.PlagiabustWebSearchManager;

/**
 *
 * @author Brave Heart
 */
public class PlagiabustServerSourceDownloadManager {

    String downloadFolderPath;
    HashMap<String, ArrayList<String>> downloadedFileList;
    ArrayList<String> fileArrayList;
    ArrayList<String> idList;
    HashMap<String, String> idFileMap;
    JProgressBar pbar;
    int maxNumOfSourcesPerDocument = 10;

    public PlagiabustServerSourceDownloadManager(JProgressBar pbar) {
        this.pbar = pbar;
    }

    public PlagiabustServerSourceDownloadManager() {
    }

    public String downloadFiles(String destFolderPath, String fName) {
        System.out.println("Start downloading sources from Plagiabust Web Server...");
        Client client = new Client();
        PlagiabustWebSearchManager sd = new PlagiabustWebSearchManager(client);
        sd.setMaxNumOfSourcesPerDocument(maxNumOfSourcesPerDocument);
        sd.setRandomSelectionRatio(0.2f);
        downloadFolderPath = sd.downloadSourcesForFile(destFolderPath + File.separator + fName, pbar);
        idList = sd.getIdList();
        idFileMap = sd.getIdFileMap();
        return downloadFolderPath;
    }

    public ArrayList<String> getIdList() {
        return this.idList;
    }

    public HashMap<String, String> getIdFileMap() {
        return this.idFileMap;
    }

    public HashMap<String, ArrayList<String>> downloadFilesForMultiplePeerSearch(ArrayList<String> arr, String folderPath, JProgressBar pbar) {
        fileArrayList = arr;
        String destFolderPath = folderPath;
        Client client = new Client();
        PlagiabustWebSearchManager sd = new PlagiabustWebSearchManager(client);

        sd.setMaxNumOfSourcesPerDocument(maxNumOfSourcesPerDocument);
        sd.setRandomSelectionRatio(0.2f);
        downloadedFileList = sd.downloadSourcesForFileFolder(fileArrayList, destFolderPath, pbar);
        return downloadedFileList;
    }

    public int getMaxNumOfSourcesPerDocument() {
        return maxNumOfSourcesPerDocument;
    }

    public void setMaxNumOfSourcesPerDocument(int maxNumOfSourcesPerDocument) {
        this.maxNumOfSourcesPerDocument = maxNumOfSourcesPerDocument;
    }

    public static void main(String[] args){
        PlagiabustServerSourceDownloadManager psd = new PlagiabustServerSourceDownloadManager(new JProgressBar());
        psd.downloadFiles("C:/Users/Brave Heart/Desktop", "source-document00122.txt");
    }
}
