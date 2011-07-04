/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import querycreator.QueryCreator;
import querycreator.QuerySelectionAlgorithm;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.lucene.index.CorruptIndexException;

/**
 *
 * @author Brave Heart
 */
public class PeerSearchManager {

    private int numOfSourcesPerDoc = 10;
    private QuerySelectionAlgorithm qsa = QuerySelectionAlgorithm.Random;
    private QueryCreator qc = new QueryCreator();
    private HashMap<String, Integer> sources = new HashMap<String, Integer>();
    private HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();
    private final IndexSearch indexSearch;

    public PeerSearchManager(IndexSearch indexSearch) {
        this.indexSearch = indexSearch;
    }

    
    public HashMap<String, Integer> getSuspiciousDocList(String filePath) {
        ArrayList<String> queryList = qc.getQueryList(filePath, qsa);
        for (Iterator<String> it = queryList.iterator(); it.hasNext();) {
            String query = it.next();
            try {
                ArrayList<String> response = indexSearch.searchIndex(query);
                if (!response.isEmpty()) {
                    for (Iterator<String> it1 = response.iterator(); it1.hasNext();) {
                        String responseResult = it1.next();
                        // if file already exist
                        if (sources.get(responseResult) != null) {
                            String result = responseResult;
                            int num = sources.get(result) + 1;
                            sources.put(result, num);
                        } // if file doesnt exist in hashmap
                        else {
                            sources.put(responseResult, 1);
                        }
                    }

                    // Sorting hashmap
                    selectedSources = (HashMap<String, Integer>) this.sortByValue(sources);

                }
            } catch (CorruptIndexException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return selectedSources;
    }

    private Map sortByValue(Map map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public void setQuerySelectionAlgorithm(QuerySelectionAlgorithm selectionAlgo) {
        qsa = selectionAlgo;
    }

    public QuerySelectionAlgorithm getQuerySelectionAlgorithm() {
        return qsa;
    }

    public void setRandomSelectionRatio(float ratio) {
        qc.setRandomSelectionRatio(ratio);
    }

    public int getNumOfSourcesPerDoc() {
        return numOfSourcesPerDoc;
    }

    public void setNumOfSourcesPerDoc(int numOfSources) {
        this.numOfSourcesPerDoc = numOfSources;
    }
}
