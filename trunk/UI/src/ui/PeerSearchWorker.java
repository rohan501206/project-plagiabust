/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.SwingWorker;

/**
 *
 * @author Compaq
 */
public class PeerSearchWorker extends SwingWorker<String[][], String> {
    ArrayList<String> fileArrayList = new ArrayList<String>();
    HashMap<File, ArrayList<String>> indexedFileList = new HashMap<File, ArrayList<String>>();
    InternetDocumentDownloadManager idm=new InternetDocumentDownloadManager();
    DocumentIndexingManager indexingManger=new DocumentIndexingManager();
    FormMain form = new FormMain();
    String[][] temp = null;
    String destFolderPath;
    File[] files;
    String indexFolderPath;
    String selectedDocumentPath;
    Manager manager;
    ArrayList<String> indexedFiles = new ArrayList<String>();
    public PeerSearchWorker(String destFolderPath,File[] files,String indexFolderPath,ArrayList<String> fileArrayList,Manager manager){
        this.destFolderPath = destFolderPath;
        this.files = files;
        this.indexFolderPath = indexFolderPath;
        this.fileArrayList =  fileArrayList;
        this.manager = manager;
    }

    @Override
    protected String[][] doInBackground() throws Exception {
        System.out.println("Start indexing the files........................");
        indexedFileList = indexingManger.indexSearchforMultiplePeers(files, indexFolderPath);
        System.out.println("Finished indexing the files........................");
        System.out.println("Start Downloading the internet files........................");
        HashMap<String, ArrayList<String>> downloadedFileList = idm.downloadFilesForMultiplePeerSearch(fileArrayList, destFolderPath);
        System.out.println("Finished Downloading the internet files........................");
        try {
            System.out.println("Start comparing files........................");
            temp = manager.compareAllFiles(indexedFileList, downloadedFileList);
            System.out.println("Finished comparing files........................");
        } catch (IOException ex) {
            System.out.println("There are no similar files or some error has occured");
        }
    return temp;
    }



    public String[][] getOutPut(){
        return this.temp;
    }

}
