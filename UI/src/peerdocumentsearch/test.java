/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.lucene.index.CorruptIndexException;

/**
 *
 * @author Brave Heart
 */
public class test {

    public static void main(String args[]) throws CorruptIndexException, IOException {TextFileIndexer indexer = null;
        String doucmentFolderPath = "C:/Users/user/Desktop/Assignments - 100/new/new";
        File documentFolder = new File(doucmentFolderPath);
        String indexFolderPath = documentFolder.getAbsolutePath() + File.separator + documentFolder.getName() + "_Index";
        try {
            indexer = new TextFileIndexer(indexFolderPath);
            indexer.indexFileOrDirectory(doucmentFolderPath);
            indexer.closeIndex();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        IndexSearch is = new IndexSearch(indexFolderPath);
        PeerSearchManager psm  = new PeerSearchManager(is);
        ArrayList<String> selectedSources = is.searchIndex("software");
        Iterator it = selectedSources.iterator();
        int downloadedDocuments = 0;
        while (it.hasNext() ) {
            String filePath = (String) it.next();
            System.out.println(filePath);
        }
    }
        
}
