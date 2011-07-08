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
    InternetDocumentDownloadManager idm = new InternetDocumentDownloadManager();
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
        long t1 = System.currentTimeMillis();
        System.out.println("Start indexing the files........................");
        indexedFileList = indexingManger.indexSearchforMultiplePeers(files, indexFolderPath,null);
        System.out.println("Finished indexing the files........................");
        System.out.println("Start Downloading the internet files........................");
        //HashMap<String, ArrayList<String>> downloadedFileList = idm.downloadFilesForMultiplePeerSearch(fileArrayList, destFolderPath);
       HashMap<String, ArrayList<String>> downloadedFileList = null;
        System.out.println("Finished Downloading the internet files........................");
        try {
            System.out.println("Start comparing files........................");
            temp = manager.compareAllFiles(indexedFileList, downloadedFileList);
            System.out.println("Finished comparing files........................");
        } catch (IOException ex) {
            System.out.println("There are no similar files or some error has occured");
        }

       long t2 = System.currentTimeMillis();
       long result = (t2-t1)/1000;
       System.out.println("**********************************************");
       System.out.println(result);
       
    return temp;

    }



    public String[][] getOutPut(){
        return this.temp;
    }

}
