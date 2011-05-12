/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Brave Heart
 */
public class test {

    public static void main(String args[]) {
        TextFileIndexer indexer = null;
        String doucmentFolderPath = "C:/Users/Brave Heart/Desktop/txtFolder";
        File documentFolder = new File(doucmentFolderPath);
        String indexFolderPath = documentFolder.getAbsolutePath() + File.separator + documentFolder.getName() + "_Index";
        try {
            indexer = new TextFileIndexer(indexFolderPath);
            indexer.indexFileOrDirectory(doucmentFolderPath);
            indexer.closeIndex();
        } catch (Exception ex) {
        }

        IndexSearch is = new IndexSearch(indexFolderPath);
        PeerSearchManager psm  = new PeerSearchManager(is);
        psm.setRandomSelectionRatio(.74f);
        HashMap<String, Integer> selectedSources = psm.getSuspiciousDocList("C:/Users/Brave Heart/Desktop/txtFolder/_080113V_4WeeklyReport_1.pdf.txt");
        Iterator it = selectedSources.entrySet().iterator();
        int downloadedDocuments = 0;
        while (it.hasNext() && downloadedDocuments <= 10) {
            Map.Entry pair = (Map.Entry) it.next();
            String filePath = (String) pair.getKey();
            downloadedDocuments++;
            System.out.println(filePath);
        }
    }
}
