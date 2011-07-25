package plagiabustwebserver;

import Helper.FileHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JProgressBar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Brave Heart
 */
public class SolrClientTest {

    public SolrClientTest() {
    }

    public static void main(String args[]) {
        String localhost = "http://localhost:8983/solr";
        // Enter text document folder: Please note only txt is supported currently
        String documentsFolderName = "E:/Plagiarism Detector/Sample Data/pan-plagiarism-corpus-2010/source-documents/part1";
        String query = "No Doubt, this is going to work";


        Client sc = new Client(localhost);
        FileHelper helper = new FileHelper();

        PlagiabustWebSearchManager plagiabustServerManager = new PlagiabustWebSearchManager(sc);

        // Unit testing

        
         // Adding documents
         //sc.commitDocumentsToSolrServer(helper.listFilesInFolder(new File(documentsFolderName)));
        

        /*
        // Search for a query word
        ArrayList<PlagiabustServerResponse> serverResponses = sc.getQueryResponse(query);
        int documentIndex = 0;
        for (Iterator<PlagiabustServerResponse> it = serverResponses.iterator(); it.hasNext();) {
            PlagiabustServerResponse plagiabustServerResponse = it.next();
            System.out.println(plagiabustServerResponse.getUrl());
        }
        */
        
        
        // Delete all documents from the solr server
        //sc.deleteAllDocumentFromServer();
        

        
        // Download document to a local directry
       //System.out.println(sc.getContentById("00227cdf-288d-4ece-bd68-70d788c6aecb"));
        

      //plagiabustServerManager.downloadSourceContentAsText("00227cdf-288d-4ece-bd68-70d788c6aecb", "C:/Users/Brave Heart/Desktop/1.txt");

        plagiabustServerManager.downloadSourcesForFile("C:/Users/Brave Heart/Desktop/suspicious-document00001.txt", new JProgressBar());
    }
}
