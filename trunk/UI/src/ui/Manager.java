/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import dataExtraction.DocumentReader;
import ComparisonEngine.CosineSimilarityAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import ComparisonEngine.ComparisonResult;
import Helper.TextFileFilter;
import gui.form.ProgressBarManager;
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
                for (final String downloadedFileName : downloadedFilesForFile) {
                    PeerSearchMatchInfo processFiles = new PeerSearchMatchInfo(downloadedFilesForFile, downloadedFileName, checkfile,paraphraseDetection);
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
            for(int i=0;i<downloadedFilesList.length;i++){

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

            float paraphasedValue = 0;

            if(paraphaseDetection){
                ParaphaseManage paramanager = new ParaphaseManage(firstFile,secondFile, downloadedFolderPath);
                matchedText = paramanager.getMatchList();
                paraphasedValue = paramanager.getPlagiarismValueForParaphraseDetect(match);
            }
            else{
                matchedText[0] = "";
                matchedText[1] = "";
                 paraphasedValue = 0;
            }

            System.out.println();
            System.out.println(firstFile);
            System.out.println(secondFile);
            System.out.println("match is " + match);
            System.out.println();



            if ((!match.isEmpty() &&  !(firstFile.equalsIgnoreCase(secondFile)))  || (!(firstFile.equalsIgnoreCase(secondFile)) && !matchedText[0].isEmpty() )) {

                matchValue[0] = match;
                matchValue[1] = String.valueOf(roundNumber(output,2)*100/2 + +paraphasedValue);
                matchValue[2] = matchedText[0];
                matchValue[3] = matchedText[1];
                resultsMap.put(secondFile, matchValue);
            }




        }
        }

        if (downloadedFilesList2 != null) {
            for(int i=0;i<downloadedFilesList2.length;i++){

            String[] matchValue=new String[4];
             if(i==downloadedFilesList2.length-1){
                crossCheck.runProgress(100);
             }
             else{
                  crossCheck.runProgress((i*100)/downloadedFilesList2.length);
             }
            ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
            float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(downloadedFilesList2[i]).toString());
            String match = sca.getList();
            String firstFile = documentToCompare;
            String secondFile = downloadedFolderPath2 + File.separator + downloadedFilesList2[i];

            String[] matchedText=new String[2];

            float paraphasedValue = 0;

            if(paraphaseDetection){
                ParaphaseManage paramanager = new ParaphaseManage(firstFile,secondFile, downloadedFolderPath2);
                matchedText = paramanager.getMatchList();
                paraphasedValue = paramanager.getPlagiarismValueForParaphraseDetect(match);
            }
            else{
                matchedText[0] = "";
                matchedText[1] = "";
                 paraphasedValue = 0;
            }

            System.out.println();
            System.out.println(firstFile);
            System.out.println(secondFile);
            System.out.println("match is " + match);
            System.out.println();



            if ((!match.isEmpty() &&  !(firstFile.equalsIgnoreCase(secondFile)))  || (!(firstFile.equalsIgnoreCase(secondFile)) && !matchedText[0].isEmpty() )) {

                matchValue[0] = match;
                matchValue[1] = String.valueOf(roundNumber(output,2)*100/2 + +paraphasedValue);
                matchValue[2] = matchedText[0];
                matchValue[3] = matchedText[1];
                resultsMap.put(secondFile, matchValue);
            }




        }
        }
        number = 0;

        for(int i=0;i<indexedFiles.size();i++){
        String[] matchValue=new String[4];

            if( i==preIndexedFiles.size()-1){
                crossCheck.runProgress(100);
            }
            else{
                crossCheck.runProgress(( i*100)/preIndexedFiles.size());
            }

            ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
            float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(preIndexedFiles.get( i)).toString());
            String match = sca.getList();

            String[] matchedText=new String[2];
            // Paraphased added
            float paraphasedValue = 0;

            //use paraphase detection
            if(paraphaseDetection){
                ParaphaseManage paramanager = new ParaphaseManage(documentToCompare,preIndexedFiles.get( i), downloadedFolderPath);
                matchedText = paramanager.getMatchList();
                paraphasedValue = paramanager.getPlagiarismValueForParaphraseDetect(match);
            }
            else{
                matchedText[0] = "";
                matchedText[1] = "";
                paraphasedValue = 0;

            }
            String firstFile = documentToCompare;
            String secondFile = preIndexedFiles.get( i);
            System.out.println();
            System.out.println(firstFile);
            System.out.println(secondFile);
            System.out.println("match is " + match);
            //System.out.println("Size of the matched files is " + fileNo);
            System.out.println();
            if ((!match.isEmpty() &&  !(firstFile.equalsIgnoreCase(secondFile))) || (!(firstFile.equalsIgnoreCase(secondFile)) && !matchedText[0].isEmpty() )) {
                //////////////// just for testing purposes
                matchValue[0]=match;
                matchValue[1]=String.valueOf(roundNumber(output,2)*100/2+paraphasedValue);;
                matchValue[2] = matchedText[0];
                matchValue[3] = matchedText[1];
                resultsMap.put(secondFile, matchValue);
               // fileNo++;


            }

        }




        return resultsMap;
    }

   
    public peerSearchReportData compareAllFiles(HashMap<File, ArrayList<String>> indexedFilesList, HashMap<String, ArrayList<String>> downloadedFilesList, JProgressBar preprocesspbar, JProgressBar crosscheckpbar,boolean paraphraseDetection) throws IOException {

        peerSearchReportData repData = new peerSearchReportData();
        //HashMap<String, String[]> peerFilesReportData = new HashMap<String, String[]>();
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


            for(int i=0;i<indexedFilesForFile.size();i++){



            String[] matchValuePair = new String[4];
        ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
        File createFile = new File(indexedFilesForFile.get(i));
        float output = sca.getSimilarity(preprocessText(filePath.getAbsolutePath()), preprocessText(createFile.getAbsolutePath()));
        String match = sca.getList();
        String[] matchedText = new String[2];
        String downloadedFolderPath = "";
        float paraphasedValue = 0;

        if (paraphraseDetection) {
            ParaphaseManage paramanager = new ParaphaseManage(filePath.getAbsolutePath(), createFile.getAbsolutePath(), downloadedFolderPath);
            matchedText = paramanager.getMatchList();
            paraphasedValue = paramanager.getPlagiarismValueForParaphraseDetect(match);
        } else {
            matchedText[0] = "";
            matchedText[1] = "";
            paraphasedValue = 0;
        }

        matchValuePair[0] = match;
        matchValuePair[1] = String.valueOf(roundNumber(output, 2) * 100 / 2 + paraphasedValue);
        matchValuePair[2] = matchedText[0];
        matchValuePair[3] = matchedText[1];


        String firstFile = filePath.getAbsolutePath();
        String secondFile = createFile.getAbsolutePath();
        System.out.println();
        System.out.println(firstFile);
        System.out.println(secondFile);
        System.out.println("match is " + match);
        System.out.println();

        if (!(match.isEmpty()) && !(firstFile.equalsIgnoreCase(secondFile))) {
            peerFilesReportData.put(createFile.getAbsolutePath(), matchValuePair);
        }
            }
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
                Map.Entry pair2 = (Map.Entry) downloadIterator.next();
                String filePath2 = (String) pair2.getKey();
                File checkfile = new File((String) pair2.getKey());
                downloadedFilesForFile = (ArrayList<String>) downloadedFilesList.get(filePath2);
                for(int i=0;i<downloadedFilesForFile.size();i++){



            String[] matchValuePair = new String[4];
        ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
        File createFile = new File(downloadedFilesForFile.get(i));
        float output = sca.getSimilarity(preprocessText(filePath2), preprocessText(createFile.getAbsolutePath()));
        String match = sca.getList();
        String[] matchedText = new String[2];
        String downloadedFolderPath = "";
        float paraphasedValue = 0;

        if (paraphraseDetection) {
            ParaphaseManage paramanager = new ParaphaseManage(filePath2, createFile.getAbsolutePath(), downloadedFolderPath);
            matchedText = paramanager.getMatchList();
            paraphasedValue = paramanager.getPlagiarismValueForParaphraseDetect(match);
        } else {
            matchedText[0] = "";
            matchedText[1] = "";
            paraphasedValue = 0;
        }

        matchValuePair[0] = match;
        matchValuePair[1] = String.valueOf(roundNumber(output, 2) * 100 / 2 + paraphasedValue);
        matchValuePair[2] = matchedText[0];
        matchValuePair[3] = matchedText[1];


        String firstFile = filePath2;
        String secondFile = createFile.getAbsolutePath();
        System.out.println();
        System.out.println(firstFile);
        System.out.println(secondFile);
        System.out.println("match is " + match);
        System.out.println();

        if (!(match.isEmpty()) && !(firstFile.equalsIgnoreCase(secondFile))) {
           internetFilesReportData.put(createFile.getAbsolutePath(), matchValuePair);
        };
            if(!internetFilesReportData.isEmpty()){
            repData.setPeerFilesReportData(filePath2, internetFilesReportData);
            }
        }
                repData.setInternetFilesReportData(checkfile.getAbsolutePath(), internetFilesReportData);
                }
            }

        return repData;
    }



**/

    





