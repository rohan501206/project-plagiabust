/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import gui.form.ProgressBarManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JProgressBar;
import peerdocumentsearch.IndexSearch;
import peerdocumentsearch.PeerSearchManager;

/**
 *
 * @author nuwan
 */
public class DocumentIndexingManager {
    int maxNoIndexfiles = 0;

    public String indexFolderPath;
    public String selectedDocumentPath;
    public ArrayList<String> indexedFiles=new ArrayList<String>();
    HashMap<File, ArrayList<String>> indexedFileList = new HashMap<File, ArrayList<String>>();


    public ArrayList<String> indexSearch(String indexpath,String selectDocPath,JProgressBar pbar,int amaxNoIndexfiles){
        ProgressBarManager pmanager = new ProgressBarManager(pbar);
        maxNoIndexfiles = amaxNoIndexfiles;
        selectedDocumentPath=selectDocPath;
        indexFolderPath=indexpath;
        IndexSearch is = new IndexSearch(indexFolderPath);
        PeerSearchManager psm = new PeerSearchManager(is);
        HashMap<String, Integer> selectedSources = psm.getSuspiciousDocList(selectedDocumentPath);
        Iterator it = selectedSources.entrySet().iterator();
        int selectedDocuments = 0;
        int size = selectedSources.size();
        while (it.hasNext() && selectedDocuments <= maxNoIndexfiles) {
            Map.Entry pair = (Map.Entry) it.next();
            String filePath = (String) pair.getKey();
            selectedDocuments++;
            if (!filePath.equalsIgnoreCase(selectedDocumentPath)) {
                indexedFiles.add(filePath);
            }
            if(size>=maxNoIndexfiles){
                pmanager.runProgress((selectedDocuments*100)/maxNoIndexfiles);
            }
            else{
                pmanager.runProgress((selectedDocuments*100)/size);
            }
        }
        return indexedFiles;
    }



    public HashMap<File, ArrayList<String>> indexSearchforMultiplePeers(File[] files,String indexFolderPathTemp,JProgressBar pbar,int amaxNoIndexfiles){
        maxNoIndexfiles = amaxNoIndexfiles;
        ProgressBarManager pmanager = new ProgressBarManager(pbar); // progress bar
        indexFolderPath=indexFolderPathTemp;
        IndexSearch is = new IndexSearch(indexFolderPath);
        PeerSearchManager psm = new PeerSearchManager(is);
        for (int i = 0; i < files.length; i++) {
             // progress bar
            pmanager.runProgress(((i+1)*100)/files.length);
            ArrayList<String> indexedFilesTesting = new ArrayList<String>();
            if (files[i].isFile()) {
                System.out.println("testing Indexing files........................\n");
                HashMap<String, Integer> selectedSources = psm.getSuspiciousDocList(files[i].getAbsolutePath());
                Iterator it = selectedSources.entrySet().iterator();
                int selectedDocuments = 0;
                while (it.hasNext() && selectedDocuments < maxNoIndexfiles) {
                    Map.Entry pair = (Map.Entry) it.next();
                    String filePath = (String) pair.getKey();
                    selectedDocuments++;
                    indexedFilesTesting.add(filePath);
                }
                indexedFileList.put(files[i], indexedFilesTesting);
                System.out.println("file " + files[i].getAbsolutePath());
                for (int j = 0; j < indexedFilesTesting.size(); j++) {
                    System.out.println("indexed file " + j + " " + indexedFilesTesting.get(j));
                }
                System.out.println("");
            }
        }

        return indexedFileList;
    }




}
