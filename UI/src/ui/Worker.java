/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Compaq
 */
public class Worker extends SwingWorker<String[][], String> {
    JProgressBar pbar2;
    JProgressBar pbar3;
    JProgressBar pbar;
    InternetDocumentDownloadManager idm=new InternetDocumentDownloadManager();
    DocumentIndexingManager indexingManger=new DocumentIndexingManager();
    FormMain form = new FormMain();
    String[][] temp = null;
    String destFolderPath;
    String fName;
    String indexFolderPath;
    String selectedDocumentPath;
    Manager manager;
    ArrayList<String> indexedFiles = new ArrayList<String>();
    public Worker(String destFolderPath,String fName,String indexFolderPath,String selectedDocumentPath,Manager manager){
        this.destFolderPath = destFolderPath;
        this.fName = fName;
        this.indexFolderPath = indexFolderPath;
        this.selectedDocumentPath=  selectedDocumentPath;
        this.manager = manager;
    }

    @Override
    protected String[][] doInBackground() throws Exception {
        String downloadFolderPath = idm.downloadFiles(destFolderPath, fName);
        System.out.println("Finished Downloading the internet files........................");
        System.out.println("Start indexing the files........................");
        indexedFiles=indexingManger.indexSearch(indexFolderPath,selectedDocumentPath,pbar,10);
        System.out.println("Finished indexing the files........................");
        
            System.out.println("Start comparing files........................");
            //temp = manager.compareFiles(selectedDocumentPath, downloadFolderPath, indexedFiles,pbar2,pbar3);
            System.out.println("Finished comparing files........................");

        
        return temp;
    }

    public String[][] getOutPut(){
        return this.temp;
    }

    @Override
    protected void done(){

    }



    /*protected void done(){
        form.jTextField3.setText(temp[0][0]);
        form.jTextField4.setText(temp[0][1]);
        form.jTextField2.setText(temp[0][2]);
        if(!(form.jTextField3.getText().equalsIgnoreCase("")||form.jTextField4.getText().equalsIgnoreCase(""))){

            String fileName1 = form.jTextField3.getText();
            String fileName2 = form.jTextField4.getText();
            form.jTabbedPane2.setSelectedIndex(1);
            FileOperator setTextToTextAreas= new  FileOperator();
            String[] texts=setTextToTextAreas.textSetter(fileName1, fileName2);
            String field1=texts[0];
            String field2=texts[1];
            form.firstFileTextArea.setText(field1.toLowerCase());
            form.secondFileTextArea.setText(field2.toLowerCase());
    }
}*/
}