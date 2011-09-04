/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import dataExtraction.DocumentReader;
import ComparisonEngine.ShingleCloudAlgorithm;
import ComparisonEngine.CosineSimilarityAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import ComparisonEngine.ComparisonResult;
import Helper.TextFileFilter;
import de.tud.kom.stringmatching.shinglecloud.ShingleCloudMatch;
import gui.form.ProgressBarManager;
import java.lang.String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import net.didion.jwnl.JWNLException;
import paraphaseDetection.ParaphaseManage;
import preprocess.*;

/**
 *
 * @author Compaq
 */
public class Manager {

    ComparisonResult cr = new ComparisonResult();
    CosineSimilarityAlgorithm cossim = new CosineSimilarityAlgorithm();
    DocumentReader docreader = new DocumentReader();
    StopWordRemover stopremover = new StopWordRemover();
    SynonymReplacer synReplaser = new SynonymReplacer();
    Stemmer stem = new Stemmer();

    public HashMap<String, String[]> compareFiles(String fileName, String downloadedFilePathforInternet, String downloadedFilePathforServer, ArrayList<String> indexedFiles, JProgressBar preprocesspbar, JProgressBar crosscheckpbar, boolean paraphaseDetection) throws IOException {

        HashMap<String, String[]> resultsMap = new HashMap<String, String[]>();
        String documentToCompare = fileName;
        String downloadedFolderPath = downloadedFilePathforInternet;
        String downloadedFolderPath2 = downloadedFilePathforServer;
        ArrayList<String> preIndexedFiles = indexedFiles;
        HashMap hm = new HashMap();
        String[] downloadedFilesList = null;
        String[] downloadedFilesList2 = null;
        ProgressBarManager crossCheck = new ProgressBarManager(crosscheckpbar);
        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(threads);
        List<Future> futures = new ArrayList<Future>();
        int number = 0;




        if (downloadedFolderPath != null) {
            File downloadedFiles = new File(downloadedFolderPath);
            downloadedFilesList = downloadedFiles.list();
        }

        if (downloadedFilePathforServer != null) {
            File downloadedFiles2 = new File(downloadedFilePathforServer);
            downloadedFilesList2 = downloadedFiles2.list();
        }

        if (downloadedFilesList != null) {
            for (int i = 0; i < downloadedFilesList.length; i++) {
                System.out.println("document downloaded " + i + " " + downloadedFilesList[i]);
            }
        }
        for (int i = 0; i < indexedFiles.size(); i++) {
            System.out.println("document indexed " + i + " " + indexedFiles.get(i));
        }


        String preprocessTextOfTheComparisonFile = preprocessText(documentToCompare);
        ProgressBarManager preprocessProgressBar = new ProgressBarManager(preprocesspbar);
        
        documentPreprocessorForDownloadedFiles(downloadedFilesList,downloadedFolderPath,hm,preprocessProgressBar);
        documentPreprocessorForDownloadedFiles(downloadedFilesList2,downloadedFolderPath2,hm,preprocessProgressBar);
        documentPreprocessorforIndexedFiles(preIndexedFiles,hm,preprocessProgressBar);


        if (downloadedFilesList != null) {
            for (final String downloadedFileName : downloadedFilesList) {
                SingleSearchDownloadFileProcessor processFiles = new SingleSearchDownloadFileProcessor(downloadedFilesList, crossCheck, preprocessTextOfTheComparisonFile, hm, downloadedFolderPath, documentToCompare, paraphaseDetection, number, resultsMap);
                number++;
                futures.add(service.submit(processFiles));
            }
        }
        if (downloadedFilesList2 != null) {
            number = 0;
            for (final String downloadedFileName : downloadedFilesList2) {
                SingleSearchDownloadFileProcessor processFiles = new SingleSearchDownloadFileProcessor(downloadedFilesList2, crossCheck, preprocessTextOfTheComparisonFile, hm, downloadedFolderPath2, documentToCompare, paraphaseDetection, number, resultsMap);
                number++;
                futures.add(service.submit(processFiles));
            }
        }
        number = 0;
        for (final String indexedFileName : preIndexedFiles) {
            SingleSearchIndexedFileProcessor processFiles = new SingleSearchIndexedFileProcessor(preIndexedFiles, crossCheck, preprocessTextOfTheComparisonFile, hm, downloadedFolderPath, documentToCompare, paraphaseDetection, number, resultsMap);
            number++;
            futures.add(service.submit(processFiles));
        }



        service.shutdown();
        resultsMap = setDetailsToOutput(futures);
        return resultsMap;
    }

    /**
     * Compare the downloaded files, indexed files with all the submitted documents and return the possible matching phrases with relevant files.
     * @param indexedFilesList
     * @param downloadedFilesList
     * @return he possible matching phrases with relevant files.
     * @throws IOException
     */
    public peerSearchReportData compareAllFiles(HashMap<File, ArrayList<String>> indexedFilesList, HashMap<String, ArrayList<String>> downloadedFilesList, HashMap<String, String> urlFileMap, JProgressBar preprocesspbar, JProgressBar crosscheckpbar,boolean paraphraseDetection) throws IOException {

        peerSearchReportData repData = new peerSearchReportData();
        repData.setPeerUrlList(urlFileMap);
        Iterator downloadIterator = null;

        if (downloadedFilesList != null) {
            downloadIterator = downloadedFilesList.entrySet().iterator();
        }


        Iterator it = indexedFilesList.entrySet().iterator();
        ArrayList<String> indexedFilesForFile = new ArrayList<String>();
        ArrayList<String> downloadedFilesForFile = new ArrayList<String>();
        ProgressBarManager preprocessProgressBar = new ProgressBarManager(preprocesspbar);
        ProgressBarManager crossCheck = new ProgressBarManager(crosscheckpbar);
        int firstCounter = 0;
        int secondCounter = 0;

        while (it.hasNext()) {
            firstCounter++;
            preprocessProgressBar.runProgress((firstCounter * 100) / indexedFilesList.entrySet().size());
            HashMap<String, String[]> peerFilesReportData = new HashMap<String, String[]>();
            Map.Entry pair = (Map.Entry) it.next();
            File filePath = (File) pair.getKey();
            indexedFilesForFile = (ArrayList<String>) indexedFilesList.get(filePath);
            int threads = Runtime.getRuntime().availableProcessors();
            ExecutorService service = Executors.newFixedThreadPool(threads);
            List<Future> futures = new ArrayList<Future>();
            int counter = 0;
            for (final String indexedFileName : indexedFilesForFile) {
                PeerSearchMatchInfo processFiles = new PeerSearchMatchInfo(indexedFilesForFile, indexedFileName, filePath,paraphraseDetection);
                counter++;
                futures.add(service.submit(processFiles));
            }
            service.shutdown();
            peerFilesReportData = setDetailsToOutput(futures);
            if(!peerFilesReportData.isEmpty()){
            repData.setPeerFilesReportData(filePath.getAbsolutePath(), peerFilesReportData);
            }
        }


        if (downloadIterator != null) {
            if (!downloadIterator.hasNext()) {
                crossCheck.runProgress(100);
            }

            while (downloadIterator.hasNext()) {
                secondCounter++;
                crossCheck.runProgress((secondCounter * 100) / downloadedFilesList.entrySet().size());
                HashMap<String, String[]> internetFilesReportData = new HashMap<String, String[]>();
                Map.Entry pair = (Map.Entry) downloadIterator.next();
                String filePath = (String) pair.getKey();
                File checkfile = new File((String) pair.getKey());
                downloadedFilesForFile = (ArrayList<String>) downloadedFilesList.get(filePath);
                int threads = Runtime.getRuntime().availableProcessors();
                ExecutorService service = Executors.newFixedThreadPool(threads);
                List<Future> futures = new ArrayList<Future>();
                int counter = 0;
                for (final String indexedFileName : downloadedFilesForFile) {
                    PeerSearchMatchInfo processFiles = new PeerSearchMatchInfo(downloadedFilesForFile, indexedFileName, checkfile,paraphraseDetection);
                    counter++;
                    futures.add(service.submit(processFiles));
                }
                service.shutdown();
                internetFilesReportData = setDetailsToOutput(futures);
                if(!internetFilesReportData.isEmpty()){
                repData.setInternetFilesReportData(checkfile.getAbsolutePath(), internetFilesReportData);
                }
            }
        }
        return repData;
    }

    public HashMap<String, String[]> setDetailsToOutput(List<Future> futureList) {

        HashMap<String, String[]> resultsMap = new HashMap<String, String[]>();
        for (Future futureT : futureList) {
            try {
                HashMap<String, String[]> results = (HashMap<String, String[]>) futureT.get();
                Iterator futureIterator = results.entrySet().iterator();
                while (futureIterator.hasNext()) {
                    Map.Entry pair = (Map.Entry) futureIterator.next();
                    String filename = (String) pair.getKey();
                    String[] matchinfo = (String[]) pair.getValue();
                    resultsMap.put(filename, matchinfo);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultsMap;



    }

    /**
     * convert Arraylist to string
     * @param token
     * @return string
     */
    public String arraylistToSting(ArrayList<String> token) {
        StringBuilder out = new StringBuilder();
        for (Object o : token) {
            out.append(o.toString());
            out.append(" ");
        }
        return out.toString();
    }

    /**
     * convert vector to string
     * @param token
     * @return String
     */
    public String vectorToSting(Vector token) {
        StringBuilder out = new StringBuilder();
        for (Object o : token) {
            out.append(o.toString());
            out.append("\n");
        }
        return out.toString();
    }

    /**
     * return the files inside a folder
     * @param path
     * @return files inside the folder.
     */
    public File[] getFilesIntheFolder(String path) {

        File dir = new File(path);
        ArrayList<File> fileArrayList = new ArrayList<File>();
        File[] downloadedFilesList = dir.listFiles(new TextFileFilter());
        return downloadedFilesList;

    }

    /**
     * preprocess the original document texts
     * @param filename
     * @param fileFolder
     * @return preprocessed text
     * @throws IOException
     */
    public String preprocessText(String filename, String fileFolder) throws IOException {
        String fullFilename = fileFolder + File.separator + filename;
        // document reading
        String documentText = docreader.processFileAndGetText(fullFilename);
        // removing numbers
        String numberRemoveText = documentText.replaceAll("[^a-zA-Z ]", "");
        //snawball analyser
        ArrayList<String> numberRemovedToken = null;
        ArrayList<String> stopWordRemovedTokens = null;
        numberRemovedToken = stopremover.analyze(numberRemoveText);
        String stopwordRemovedString = this.arraylistToSting(numberRemovedToken);
        stopWordRemovedTokens = stem.analyze(stopwordRemovedString);
        //String preprocessText = synReplaser.replaceSynonyms(tokens);
        String preprocessText = this.arraylistToSting(stopWordRemovedTokens);
        return preprocessText;
    }

    /**
     * preprocess the original document texts.
     * @param filename
     * @return preprocessed String
     * @throws IOException
     */
    public String preprocessText(String filename) throws IOException {

        String fullFilename = filename;        
        String documentText = docreader.processFileAndGetText(fullFilename);
        // removing numbers

        String numberRemoveText = documentText.replaceAll("[^a-zA-Z ]", "");
        //snawball analyser
        ArrayList<String> numberRemovedToken = null;
        ArrayList<String> stopWordRemovedTokens = null;
        numberRemovedToken = stopremover.analyze(numberRemoveText);
        String stopwordRemovedString = this.arraylistToSting(numberRemovedToken);
        stopWordRemovedTokens = stem.analyze(stopwordRemovedString);
        //String preprocessText = synReplaser.replaceSynonyms(tokens);
        String preprocessText = this.arraylistToSting(stopWordRemovedTokens);
        return preprocessText;
    }

    public float roundNumber(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float) tmp / p;
    }


    private void documentPreprocessorForDownloadedFiles(String[] downloadedFilesList, String downloadedFolderPath, HashMap hm, ProgressBarManager preprocessProgressBar) {
        if (downloadedFilesList != null) {
            for (int i = 0; i < downloadedFilesList.length; i++) {
                try {
                    String downloadedFileName = downloadedFilesList[i];
                    String preprocessText = preprocessText(downloadedFileName, downloadedFolderPath);
                    hm.put(downloadedFileName, preprocessText);
                    if (i == downloadedFilesList.length - 1) {
                        preprocessProgressBar.runProgress(100);
                    } else {
                        preprocessProgressBar.runProgress((i * 100) / downloadedFilesList.length);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    private void documentPreprocessorforIndexedFiles(ArrayList<String> indexedFilesList, HashMap hm, ProgressBarManager preprocessProgressBar) {
        if (indexedFilesList != null) {
            for (int i = 0; i < indexedFilesList.size(); i++) {
                try {
                    String preprocessText = preprocessText(indexedFilesList.get(i));
                     hm.put(indexedFilesList.get(i), preprocessText);
                    if (i == indexedFilesList.size() - 1) {
                        preprocessProgressBar.runProgress(100);
                    } else {
                        preprocessProgressBar.runProgress((i * 100) / indexedFilesList.size());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


}





        /**
     * Compare the downloaded files, indexed files with the submitted document and return the possible matching phrases with relevant files.
     * @param fileName
     * @param downloadedFilePath
     * @param indexedFiles
     * @return Multi dimensional string array which consists of the the relevant files and the matching shingles
     * @throws IOException
     */
    /**

    public HashMap<String,String[]> compareFiles(String fileName, String downloadedFilePath, ArrayList<String> indexedFiles,JProgressBar preprocesspbar,JProgressBar crosscheckpbar,boolean paraphaseDetection) throws IOException {

    HashMap<String,String[]> resultsMap=new HashMap<String, String[]>();
    String documentToCompare = fileName;
    String downloadedFolderPath = downloadedFilePath;
    ArrayList<String> preIndexedFiles = indexedFiles;
    File downloadedFiles = new File(downloadedFolderPath);
    String[] downloadedFilesList = downloadedFiles.list();
    HashMap hm = new HashMap();
    int fileNo = 0;
    if (downloadedFilesList != null) {
    for (int i = 0; i < downloadedFilesList.length; i++) {
    System.out.println("document downloaded " + i + " " + downloadedFilesList[i]);
    }
    }

    for (int i = 0; i < indexedFiles.size(); i++) {
    System.out.println("document indexed " + i + " " + indexedFiles.get(i));
    }
    String preprocessTextOfTheComparisonFile = preprocessText(documentToCompare);

    ProgressBarManager preprocessProgressBar = new ProgressBarManager(preprocesspbar);
    // progress bar preprocess

    for (int i = 0; i < downloadedFilesList.length; i++) {
    String downloadedFileName = downloadedFilesList[i];
    String preprocessText = preprocessText(downloadedFileName, downloadedFolderPath);
    hm.put(downloadedFileName, preprocessText);
    if(i==downloadedFilesList.length-1){
    preprocessProgressBar.runProgress(100);
    }
    else{
    preprocessProgressBar.runProgress((i*100)/downloadedFilesList.length);
    }
    }
    for (int i = 0; i < preIndexedFiles.size(); i++) {
    String preprocessText = preprocessText(preIndexedFiles.get(i));
    hm.put(preIndexedFiles.get(i), preprocessText);

    if(i==preIndexedFiles.size()-1){
    preprocessProgressBar.runProgress(100);
    }
    else{
    preprocessProgressBar.runProgress((i*100)/preIndexedFiles.size());
    }

    }

    ProgressBarManager crossCheck = new ProgressBarManager(crosscheckpbar);
    // progress bar cross check



    for (int i = 0; i < downloadedFilesList.length; i++) {

    String[] matchValue=new String[4];
    if(i==downloadedFilesList.length-1){
    crossCheck.runProgress(100);
    }
    else{
    crossCheck.runProgress((i*100)/downloadedFilesList.length);
    }
    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
    float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(downloadedFilesList[i]).toString());
    String match = sca.getList();
    String firstFile = documentToCompare;
    String secondFile = downloadedFolderPath + File.separator + downloadedFilesList[i];

    String[] matchedText=new String[2];
    // Paraphased added

    //use paraphase detection
    if(paraphaseDetection){
    ParaphaseManage paramanager = new ParaphaseManage(firstFile,secondFile, downloadedFolderPath);
    matchedText = paramanager.getMatchList();
    }
    else{
    matchedText[0] = "";
    matchedText[1] = "";
    }

    System.out.println();
    System.out.println(firstFile);
    System.out.println(secondFile);
    System.out.println("match is " + match);
    System.out.println("Size of the matched files is " + fileNo);
    System.out.println();



    if ((!match.isEmpty() &&  !(firstFile.equalsIgnoreCase(secondFile)))  || (!(firstFile.equalsIgnoreCase(secondFile)) && !matchedText[0].isEmpty() )) {
    //////////////// just for testing purposes

    matchValue[0] = match;
    matchValue[1] = String.valueOf(roundNumber(output,2)*100/2);
    matchValue[2] = matchedText[0];
    matchValue[3] = matchedText[1];
    resultsMap.put(secondFile, matchValue);


    fileNo++;

    }

    }





    for (int i = 0; i < preIndexedFiles.size(); i++) {
    String[] matchValue=new String[4];

    if(i==preIndexedFiles.size()-1){
    crossCheck.runProgress(100);
    }
    else{
    crossCheck.runProgress((i*100)/preIndexedFiles.size());
    }

    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
    float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(preIndexedFiles.get(i)).toString());
    String match = sca.getList();

    String[] matchedText=new String[2];
    // Paraphased added

    //use paraphase detection
    if(paraphaseDetection){
    ParaphaseManage paramanager = new ParaphaseManage(documentToCompare,preIndexedFiles.get(i), downloadedFolderPath);
    matchedText = paramanager.getMatchList();
    }
    else{
    matchedText[0] = "";
    matchedText[1] = "";
    }
    String firstFile = documentToCompare;
    String secondFile = preIndexedFiles.get(i);
    System.out.println();
    System.out.println(firstFile);
    System.out.println(secondFile);
    System.out.println("match is " + match);
    System.out.println("Size of the matched files is " + fileNo);
    System.out.println();
    if ((!match.isEmpty() &&  !(firstFile.equalsIgnoreCase(secondFile))) || (!(firstFile.equalsIgnoreCase(secondFile)) && !matchedText[0].isEmpty() )) {
    //////////////// just for testing purposes
    matchValue[0]=match;
    matchValue[1]=String.valueOf(roundNumber(output,2)*100/2);;
    matchValue[2] = matchedText[0];
    matchValue[3] = matchedText[1];
    resultsMap.put(secondFile, matchValue);
    fileNo++;


    }
    }
    return resultsMap;
    }
     **/


/**

      public  peerSearchReportData compareAllFiles(HashMap<File, ArrayList<String>> indexedFilesList, HashMap<String, ArrayList<String>> downloadedFilesList,JProgressBar preprocesspbar,JProgressBar crosscheckpbar) throws IOException {
        peerSearchReportData repData = new peerSearchReportData();

        HashMap<String,String> internetFilesReportData = new HashMap<String,String>() ;

        Iterator downloadIterator = downloadedFilesList.entrySet().iterator();
        Iterator it = indexedFilesList.entrySet().iterator();
        ArrayList indexedFilesForFile = new ArrayList();
        ArrayList downloadedFilesForFile = new ArrayList();

        ProgressBarManager preprocessProgressBar = new ProgressBarManager(preprocesspbar);
        ProgressBarManager crossCheck = new ProgressBarManager(crosscheckpbar);

        int firstCounter = 0;
        int secondCounter = 0;

        while (it.hasNext()) {

            firstCounter ++;
            preprocessProgressBar.runProgress((firstCounter*100)/indexedFilesList.entrySet().size());



            HashMap<String,String> peerFilesReportData= new HashMap<String,String>() ;
            Map.Entry pair = (Map.Entry) it.next();
            File filePath = (File) pair.getKey();
            indexedFilesForFile = indexedFilesList.get(filePath);

            for (int i = 0; i < indexedFilesForFile.size(); i++) {
                ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                File createFile = new File((String) indexedFilesForFile.get(i));
                float output = sca.getSimilarity(preprocessText(filePath.getAbsolutePath()), preprocessText(createFile.getAbsolutePath()));
                String match = sca.getList();
                String firstFile = filePath.getAbsolutePath();
                String secondFile = createFile.getAbsolutePath();
                System.out.println();
                System.out.println(firstFile);
                System.out.println(secondFile);
                //System.out.println("the string of the first text is " + preprocessText(filePath.getAbsolutePath()));
               // System.out.println("the string of the second text is " + preprocessText(createFile.getAbsolutePath()));
                System.out.println("match is " + match);
                //System.out.println("Size of the matched files is " + fileNo);
                System.out.println();
                if (!(match.isEmpty()) &&  !(firstFile.equalsIgnoreCase(secondFile))) {
                    peerFilesReportData.put(createFile.getAbsolutePath(), match);
                }
            }

            repData.setPeerFilesReportData(filePath.getAbsolutePath(), peerFilesReportData);

        }


        if(!downloadIterator.hasNext()){

            crossCheck.runProgress(100);

        }
        while (downloadIterator.hasNext()) {

            secondCounter++;
            crossCheck.runProgress((secondCounter*100)/downloadedFilesList.entrySet().size());



            Map.Entry pair = (Map.Entry) downloadIterator.next();
            String filePath = (String) pair.getKey();
            File checkfile = new File((String)pair.getKey());
            downloadedFilesForFile = downloadedFilesList.get(filePath);

            for (int i = 0; i < downloadedFilesForFile.size(); i++) {
                ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                File createFile = new File((String) downloadedFilesForFile.get(i));
                float output = sca.getSimilarity(preprocessText(filePath), preprocessText(createFile.getAbsolutePath()));
                String match = sca.getList();
                String firstFile = filePath;
                String secondFile = createFile.getAbsolutePath();
                System.out.println();
                System.out.println(firstFile);
                System.out.println(secondFile);
                System.out.println("match is " + match);
               // System.out.println("Size of the matched files is " + fileNo);
                System.out.println();
                if (!match.isEmpty() &&  !(firstFile.equalsIgnoreCase(secondFile))) {
                       internetFilesReportData.put(createFile.getAbsolutePath(), match);
                }

            }

            repData.setInternetFilesReportData(checkfile.getAbsolutePath(), internetFilesReportData);
        }



        return repData;
    }


**/



/*

if (downloadedFilesList != null) {
            for (int i = 0; i < downloadedFilesList.length; i++) {
                String downloadedFileName = downloadedFilesList[i];
                String preprocessText = preprocessText(downloadedFileName, downloadedFolderPath);
                hm.put(downloadedFileName, preprocessText);
                if (i == downloadedFilesList.length - 1) {
                    preprocessProgressBar.runProgress(100);
                } else {
                    preprocessProgressBar.runProgress((i * 100) / downloadedFilesList.length);
                }
            }
        }
        if (downloadedFilesList2 != null) {
            for (int i = 0; i < downloadedFilesList2.length; i++) {
                String downloadedFileName = downloadedFilesList2[i];
                String preprocessText = preprocessText(downloadedFileName, downloadedFilePathforServer);
                hm.put(downloadedFileName, preprocessText);
                if (i == downloadedFilesList2.length - 1) {
                    preprocessProgressBar.runProgress(100);
                } else {
                    preprocessProgressBar.runProgress((i * 100) / downloadedFilesList2.length);
                }
            }
        }
        for (int i = 0; i < preIndexedFiles.size(); i++) {
            String preprocessText = preprocessText(preIndexedFiles.get(i));
            hm.put(preIndexedFiles.get(i), preprocessText);

            if (i == preIndexedFiles.size() - 1) {
                preprocessProgressBar.runProgress(100);
            } else {
                preprocessProgressBar.runProgress((i * 100) / preIndexedFiles.size());
            }
        }
*/