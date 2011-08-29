/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 *
 * @author Brave Heart
 */
public class IndexSearch {

    private String indexPath = "";
    private int numOfSourcesPerSearch = 10;
    private QueryParser qParser = new QueryParser(Version.LUCENE_29, "contents", new StandardAnalyzer(Version.LUCENE_29));

    public IndexSearch(String path) {
        this.indexPath = path;
    }

    public ArrayList<String> searchIndex(String qStr) throws CorruptIndexException, IOException {

        ArrayList<String> docList = new ArrayList<String>();
        Query q = null;
        try {
            q = qParser.parse(qStr);
            FSDirectory dir = FSDirectory.open(new File(indexPath));

            IndexSearcher searcher = new IndexSearcher(dir, true);
            TopScoreDocCollector collector = TopScoreDocCollector.create(numOfSourcesPerSearch, true);
            searcher.search(q, collector);
            ScoreDoc[] hits = collector.topDocs().scoreDocs;

            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                docList.add(d.get("path"));
            }

            searcher.close();
        } catch (ParseException ex) {
            //Logger.getLogger(IndexSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docList;
    }

    public String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }

    public int getNumOfSourcesPerSearch() {
        return numOfSourcesPerSearch;
    }

    public void setNumOfSourcesPerSearch(int numOfSources) {
        if (numOfSources >= 10) {
            this.numOfSourcesPerSearch = numOfSources;
        }

    }
}
