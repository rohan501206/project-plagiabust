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
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import ui.Manager;
import ui.InternetDocumentDownloadManager;
import ui.DocumentIndexingManager;
import ui.FormMain;

/**
 *
 * @author Compaq
 */
public class Worker extends SwingWorker<ReportData, String> {
   // InternetDocumentDownloadManager idm=new InternetDocumentDownloadManager();
    InternetDocumentDownloadManager idm;
    DocumentIndexingManager indexingManger=new DocumentIndexingManager();
    FormMain form = new FormMain();
    String[][] temp = null;
    String destFolderPath;
    String fName;
    String indexFolderPath;
    String selectedDocumentPath;
    Manager manager;

    JProgressBar pbar2;
    JProgressBar pbar3;
    JProgressBar pbar4;

    int maxIndexfiles;
    
    ArrayList<String> indexedFiles = new ArrayList<String>();
    public Worker(String destFolderPath,String fName,String indexFolderPath,String selectedDocumentPath,Manager manager,JProgressBar pbar,JProgressBar pbar2,JProgressBar pbar3,JProgressBar pbar4, int maxNumOfInternetSources,int maxIndexfiles){
        this.destFolderPath = destFolderPath;
        this.fName = fName;
        this.indexFolderPath = indexFolderPath;
        this.selectedDocumentPath=  selectedDocumentPath;
        this.manager = manager;
        this.idm = new InternetDocumentDownloadManager(pbar);
        this.pbar2 = pbar2;
        this.pbar3 = pbar3;
        this.pbar4 = pbar4;
        this.idm.setMaxNumOfSourcesPerDocument(maxNumOfInternetSources);
        this.maxIndexfiles = maxIndexfiles;
    }

    @Override
    protected ReportData doInBackground() throws Exception {
        String downloadFolderPath = idm.downloadFiles(destFolderPath, fName);
        ArrayList<String> urlList = idm.getUrlList();
        HashMap<String, String> map = idm.getMap();
        System.out.println("Finished Downloading the internet files........................");
        System.out.println("Start indexing the files........................");
        indexedFiles=indexingManger.indexSearch(indexFolderPath,selectedDocumentPath,pbar2,maxIndexfiles);
        System.out.println("Finished indexing the files........................");
         try {
            System.out.println("Start comparing files........................");
            temp = manager.compareFiles(selectedDocumentPath, downloadFolderPath, indexedFiles,pbar3,pbar4);
            System.out.println("Finished comparing files........................");

        } catch (IOException ex) {
            System.out.println("There are no similar files or some error has occured");
        }
        ReportData repData = new ReportData(temp, urlList);
        //ReportData repData = new ReportData(temp, map);

        return repData ;
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