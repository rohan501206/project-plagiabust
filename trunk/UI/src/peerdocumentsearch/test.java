/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

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

        IndexSearch si = new IndexSearch(indexFolderPath);
        ArrayList<String> docList;
        try {
            docList = si.Search("wso2 nadeeshani");
            for (Iterator<String> it = docList.iterator(); it.hasNext();) {
                String string = it.next();
                System.out.println(string);
            }
        } catch (Exception ex) {
            System.out.println("Error");
        }


    }
}
