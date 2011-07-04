package plagiabustwebserver;

import Helper.FileHelper;
import java.io.File;

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
        String query = "No Doubt this is going to work";

        Client sc = new Client(localhost);
        FileHelper helper = new FileHelper();

        sc.commitDocumentsToSolrServer(true, helper.listFilesInFolder(new File(documentsFolderName)));
        sc.getQueryResponse(query);

    }
}
