/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.htmlparser.beans.StringBean;

/**
 *
 * @author Brave Heart
 */
public class SourceDetectionManager {

    private QuerySelectionAlgorithm qsa = QuerySelectionAlgorithm.Random;
    private QueryCreator qc = new QueryCreator();
    private HashMap<String, Integer> sources = new HashMap<String, Integer>();
    private HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();
    private final BingSearch bingSearch;
    private int maxNumOfSourcesPerDocument = 10;

    public SourceDetectionManager(BingSearch bingSearch) {
        this.bingSearch = bingSearch;
    }

    public void setQuerySelectionAlgorithm(QuerySelectionAlgorithm selectionAlgo) {
        qsa = selectionAlgo;
    }

    public QuerySelectionAlgorithm getQuerySelectionAlgorithm() {
        return qsa;
    }

    public void downloadSourcesForFile(String filePath) {

        ArrayList<String> queryList = qc.getQueryList(filePath, qsa);
        for (Iterator<String> it = queryList.iterator(); it.hasNext();) {
            String query = it.next();
            ArrayList<ResponseResult> response = bingSearch.searchInternet(query);
            if (!response.isEmpty()) {
                for (Iterator<ResponseResult> it1 = response.iterator(); it1.hasNext();) {
                    ResponseResult responseResult = it1.next();
                    // if url already exist
                    if (sources.get(responseResult.getUrl()) != null) {
                        String result = responseResult.getUrl();
                        int num = sources.get(result) + 1;
                        sources.put(result, num);
                    } // if url doesnt exist in hashmap
                    else {
                        sources.put(responseResult.getUrl(), 1);
                    }
                }
            }
        }

        // Sorting hashmap
        selectedSources = (HashMap<String, Integer>) this.sortByValue(sources);

        // Create directory
        File file = new File(filePath);
        String[]  nameAndExt = file.getName().split("[.]");

        
        String downloadedFilesFolder = file.getParent() + File.separator + nameAndExt[0];
        boolean folderCreated = new File(downloadedFilesFolder).mkdir();

        // Downloading page
        int downloadedDocuments = 1;
        Iterator it = selectedSources.entrySet().iterator();
        while (it.hasNext() && downloadedDocuments <=10) {
            Map.Entry pair = (Map.Entry) it.next();
            String url = (String) pair.getKey();
            String path = downloadedFilesFolder + File.separatorChar + downloadedDocuments + ".txt";
            downloadedDocuments++;
            this.downloadWebPageAsText(url, path);
            System.out.println(url);
        }


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

    private void downloadWebPageAsText(String url, String fileName) {
        String content = "";
        StringBean stringBean = new StringBean();
        stringBean.setURL(url);
        content = stringBean.getStrings();

        File file = new File(fileName);
        try {
            file.createNewFile();
            if (file.exists()) {
                FileWriter fw = new FileWriter(file, false);
                fw.write(content);
                fw.close();
            }
        } catch (IOException ex) {
        }

    }

    public void setRandomSelectionRatio(float ratio) {
        qc.setRandomSelectionRatio(ratio);
    }

    private void selectTopSources() {
    }

    public int getMaxNumOfSourcesPerDocument() {
        return maxNumOfSourcesPerDocument;
    }

    public void setMaxNumOfSourcesPerDocument(int maxNumOfSourcesPerDocument) {
        this.maxNumOfSourcesPerDocument = maxNumOfSourcesPerDocument;
    }
}
