/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiabustwebserver;

import Helper.SortingHelper;
import gui.form.ProgressBarManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JProgressBar;
import querycreator.QueryCreator;
import querycreator.QuerySelectionAlgorithm;

/**
 *
 * @author Brave Heart
 */
public class PlagiabustWebSearchManager {

    private QuerySelectionAlgorithm qsa = QuerySelectionAlgorithm.Exhaustive;
    private QueryCreator qc = new QueryCreator();
    private final Client searchClient;
    private int maxNumOfSourcesPerDocument = 10;
    private ArrayList<String> idList = new ArrayList<String>();

    public PlagiabustWebSearchManager(Client searchClient) {
        this.searchClient = searchClient;
    }

    public void setQuerySelectionAlgorithm(QuerySelectionAlgorithm selectionAlgo) {
        qsa = selectionAlgo;
    }

    public QuerySelectionAlgorithm getQuerySelectionAlgorithm() {
        return qsa;
    }

    public String downloadSourcesForFile(String filePath, JProgressBar pbar) {
        ProgressBarManager pmanager = new ProgressBarManager(pbar);

        File file = new File(filePath);
        String[] nameAndExt = file.getName().split("[.]");
        String downloadedFilesFolder = file.getParent() + File.separator + nameAndExt[0];
        File fi = new File(downloadedFilesFolder);
        if (!(fi.exists())) {
            boolean folderExist = new File(downloadedFilesFolder).mkdir();
            HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();
            // Get list of sources
            selectedSources = this.getPlagiabustServerSourcesForFile(filePath);
            // Create directory
            // Downloading page
            int downloadedDocuments = 1;
            int total = selectedSources.size();
            Iterator it = selectedSources.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                String id = (String) pair.getKey();
                System.out.println(id);
                String path = downloadedFilesFolder + File.separatorChar + downloadedDocuments + ".txt";
                downloadedDocuments++;
                this.downloadSourceContentAsText(id, path);
                idList.add(id);
                pmanager.runProgress((downloadedDocuments * 100) / total);

            }

        }
        pmanager.runProgress(100);
        return downloadedFilesFolder;
    }

    public ArrayList<String> getIdList() {
        return this.idList;
    }

    /*
    public String downloadSourcesForFile(String filePath) {         // firstcall

    HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();
    // Get list of sources
    selectedSources = this.getPlagiabustServerSourcesForFile(filePath);   //call
    // Create directory
    File file = new File(filePath);
    String[] nameAndExt = file.getName().split("[.]");
    String downloadedFilesFolder = file.getParent() + File.separator + nameAndExt[0];
    boolean folderCreated = new File(downloadedFilesFolder).mkdir();
    // Downloading page
    int downloadedDocuments = 1;
    //parellel code
    /*    long t1 = System.currentTimeMillis();
    Runnable runnable = new DownloadWebPage(selectedSources ,downloadedFilesFolder);
    ExecutorService pool = Executors.newFixedThreadPool(3);
    // run the task 5 times using the pool
    for (int i = 0; i < 5; i++) {
    pool.execute(runnable);
    }
    pool.shutdown();
    while(!pool.isTerminated()){};
    long t2 = System.currentTimeMillis();
    System.out.print((t2-t1)/1000);*/
    //remove to check for parellel

    /*        long t1 = System.currentTimeMillis();
    Iterator it = selectedSources.entrySet().iterator();
    while (it.hasNext()) {
    Map.Entry pair = (Map.Entry) it.next();
    String id = (String) pair.getKey();
    String path = downloadedFilesFolder + File.separatorChar + downloadedDocuments + ".txt";
    downloadedDocuments++;
    this.downloadSourceContentAsText(id, path);   // secondcall
    }
    long t2 = System.currentTimeMillis();
    System.out.print((t2-t1)/1000);
    return downloadedFilesFolder;
    }*/
    public HashMap<String, ArrayList<String>> downloadSourcesForFileFolder(ArrayList<String> filePathList, String fileFolderPath) {
        // file name maps to list of downloaded sources
        HashMap<String, ArrayList<String>> fileAndSorcesMap = new HashMap<String, ArrayList<String>>();
        HashMap<String, String> idAndDownloadedPathMap = new HashMap<String, String>();
        // Search for each file and sort
        int downloadedFileIndex = 0;
        String downloadedFileFolderPath = fileFolderPath + File.separator + "PlagiabustWebServer";
        boolean folderCreated = new File(downloadedFileFolderPath).mkdir();
        for (Iterator<String> it = filePathList.iterator(); it.hasNext();) {
            String filePath = it.next();
            // take sources for file
            HashMap<String, Integer> sourcesOfFile = this.getPlagiabustServerSourcesForFile(filePath);
            ArrayList<String> downloadedFilesList = new ArrayList<String>();
            // download file
            Iterator sourceIterator = sourcesOfFile.entrySet().iterator();
            while (sourceIterator.hasNext()) {
                Map.Entry pair = (Map.Entry) sourceIterator.next();
                String id = (String) pair.getKey();
                System.out.println(id);
                if (idAndDownloadedPathMap.get(id) == null) {
                    // mark new file and download
                    downloadedFileIndex++;
                    String filePathToDownload = downloadedFileFolderPath + File.separator + downloadedFileIndex + ".txt";
                    idAndDownloadedPathMap.put(id, filePathToDownload);
                    this.downloadSourceContentAsText(id, filePathToDownload);
                    downloadedFilesList.add(filePathToDownload);
                } else {
                    String fileDownloadedPath = idAndDownloadedPathMap.get(id);
                    downloadedFilesList.add(fileDownloadedPath);
                }
            }
            fileAndSorcesMap.put(filePath, downloadedFilesList);
        }
        return fileAndSorcesMap;
    }

    private HashMap<String, Integer> getPlagiabustServerSourcesForFile(String filePath) {

        ArrayList<String> queryList = qc.getQueryList(filePath, qsa);
        HashMap<String, Integer> sources = new HashMap<String, Integer>();
        HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();

        for (Iterator<String> it = queryList.iterator(); it.hasNext();) {
            String query = it.next();
            System.out.println(query);
            ArrayList<PlagiabustServerResponse> response = searchClient.getQueryResponse(query);
            if (!response.isEmpty()) {
                for (Iterator<PlagiabustServerResponse> it1 = response.iterator(); it1.hasNext();) {
                    PlagiabustServerResponse responseResult = it1.next();
                    System.out.println(responseResult.getID());
                    // if id already exist
                    if (sources.get(responseResult.getID()) != null) {
                        String result = responseResult.getID();
                        int num = sources.get(result) + 1;
                        sources.put(result, num);
                    } // if id doesnt exist in hashmap
                    else {
                        sources.put(responseResult.getID(), 1);
                    }
                }
            }
        }

        // Sorting hashmap
        SortingHelper sortingHelper = new SortingHelper();
        HashMap<String, Integer> sortedSources = (HashMap<String, Integer>) sortingHelper.sortByValue(sources);
        Iterator sortedSourceIterator = sortedSources.entrySet().iterator();
        int numberOfSelectedDoc = 1;
        while (sortedSourceIterator.hasNext() && numberOfSelectedDoc <= maxNumOfSourcesPerDocument) {
            Map.Entry pair = (Map.Entry) sortedSourceIterator.next();
            String key = (String) pair.getKey();
            int value = (Integer) pair.getValue();

            selectedSources.put(key, value);
            numberOfSelectedDoc++;
        }
        return selectedSources;
    }

    public void downloadSourceContentAsText(String id, String fileName) {
        String content = "";
        content = searchClient.getContentById(id);

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

    public int getMaxNumOfSourcesPerDocument() {
        return maxNumOfSourcesPerDocument;
    }

    public void setMaxNumOfSourcesPerDocument(int maxNumOfSourcesPerDocument) {
        this.maxNumOfSourcesPerDocument = maxNumOfSourcesPerDocument;
    }
}
