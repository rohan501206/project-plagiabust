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
import de.tud.kom.stringmatching.shinglecloud.ShingleCloudMatch;
import gui.form.ProgressBarManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import net.didion.jwnl.JWNLException;
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

    /**
     *
     * @param fileFolder
     * @return Multi dimensional string array which consists of the the relevant files and the matching shingles
     * @throws IOException
     * @throws JWNLException
     */
    public String[][] manage(String fileFolder) throws IOException, JWNLException {

        File dir = new File(fileFolder);
        String[] downloadedFilesList = dir.list();
        HashMap hm = new HashMap();
        int fileNo = 0;
        String[][] filenameText = new String[downloadedFilesList.length * downloadedFilesList.length][4];
        System.out.println("Size of the files is" + downloadedFilesList.length);
        if (downloadedFilesList == null) {
            // Either dir does not exist or is not a directory
            return null;
        } else {
            for (int i = 0; i < downloadedFilesList.length; i++) {
                // Get filename of file or directory
                String filename = downloadedFilesList[i];
                String preprocessText = preprocessText(filename, fileFolder);
                hm.put(filename, preprocessText);

            }
            for (int i = 0; i < downloadedFilesList.length; i++) {
                for (int j = 0; j < downloadedFilesList.length; j++) {
                    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                    if (i != j) {
                        float output = sca.getSimilarity(hm.get(downloadedFilesList[i]).toString(), hm.get(downloadedFilesList[j]).toString());
                        String match = sca.getList();
                        String firstFile = fileFolder + File.separator + downloadedFilesList[i];
                        String secondFile = fileFolder + File.separator + downloadedFilesList[j];
                        System.out.println(firstFile);
                        System.out.println(secondFile);
                        System.out.println("the string of the first text is" + hm.get(downloadedFilesList[i]).toString( ));
                         System.out.println("the string of the second text is" + hm.get(downloadedFilesList[j]).toString( ));
                        System.out.println("match is " + match);
                        System.out.println("Size of the fileNop is" + fileNo);
                        if (!match.isEmpty()) {
                            //////////////// just for testing purposes
                            filenameText[fileNo][0] = firstFile;
                            filenameText[fileNo][1] = secondFile;
                            filenameText[fileNo][2] = match;
                            fileNo++;

                            String Isplagarised = null;
                            if (output > 1.5) {
                                Isplagarised = "1";
                            } else {
                                Isplagarised = "0";
                            }
                            // filenameText[i][3] = Isplagarised;
                        }
                    }
                }
            }
            return filenameText;
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
    public String[][] compareFiles(String fileName, String downloadedFilePath, ArrayList<String> indexedFiles,JProgressBar preprocesspbar,JProgressBar crosscheckpbar) throws IOException {
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
        String[][] filenameText = new String[20][4];  // 20 because we download 10 files and index another 10 files and then we coompare
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
            System.out.println();
            System.out.println(firstFile);
            System.out.println(secondFile);
            //System.out.println("the string of the first text is " + preprocessTextOfTheComparisonFile);
            //System.out.println("the string of the second text is " + hm.get(downloadedFilesList[i]).toString());
            System.out.println("match is " + match);
            System.out.println("Size of the matched files is " + fileNo);
            System.out.println();
            if (!match.isEmpty()) {
                //////////////// just for testing purposes
                filenameText[fileNo][0] = firstFile;
                filenameText[fileNo][1] = secondFile;
                filenameText[fileNo][2] = match;
                fileNo++;
                String Isplagarised = null;
                if (output > 1.5) {
                    Isplagarised = "1";
                } else {
                    Isplagarised = "0";
                }
                // filenameText[i][3] = Isplagarised;
            }

        }
        for (int i = 0; i < preIndexedFiles.size(); i++) {


            if(i==preIndexedFiles.size()-1){
                crossCheck.runProgress(100);
            }
            else{
                crossCheck.runProgress((i*100)/preIndexedFiles.size());
            }

            ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
            float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(preIndexedFiles.get(i)).toString());
            String match = sca.getList();
            String firstFile = documentToCompare;
            String secondFile = preIndexedFiles.get(i);
            System.out.println();
            System.out.println(firstFile);
            System.out.println(secondFile);
            //System.out.println("the string of the first text is" + preprocessTextOfTheComparisonFile);
            //System.out.println("the string of the second text is" + hm.get(preIndexedFiles.get(i)).toString());
            System.out.println("match is " + match);
            System.out.println("Size of the matched files is " + fileNo);
            System.out.println();
            if (!match.isEmpty()) {
                //////////////// just for testing purposes
                filenameText[fileNo][0] = firstFile;
                filenameText[fileNo][1] = secondFile;
                filenameText[fileNo][2] = match;
                fileNo++;

                String Isplagarised = null;
                if (output > 1.5) {
                    Isplagarised = "1";
                } else {
                    Isplagarised = "0";
                }
                // filenameText[i][3] = Isplagarised;
            }
        }
        return filenameText;
    }

    /**
     * Compare the downloaded files, indexed files with all the submitted documents and return the possible matching phrases with relevant files.
     * @param indexedFilesList
     * @param downloadedFilesList
     * @return he possible matching phrases with relevant files.
     * @throws IOException
     */
    public  peerSearchReportData compareAllFiles(HashMap<File, ArrayList<String>> indexedFilesList, HashMap<String, ArrayList<String>> downloadedFilesList) throws IOException {
        peerSearchReportData repData = new peerSearchReportData();

        HashMap<String,String> internetFilesReportData = new HashMap<String,String>() ;
        
        Iterator downloadIterator = downloadedFilesList.entrySet().iterator();
        Iterator it = indexedFilesList.entrySet().iterator();
        ArrayList indexedFilesForFile = new ArrayList();
        ArrayList downloadedFilesForFile = new ArrayList();
        
        while (it.hasNext()) {
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

        

        while (downloadIterator.hasNext()) {
            Map.Entry pair = (Map.Entry) downloadIterator.next();
            String filePath = (String) pair.getKey();
            File checkfile = new File((String)pair.getKey());
            downloadedFilesForFile = downloadedFilesList.get(filePath);
            

            for (int i = 0; i < downloadedFilesForFile.size(); i++) {
                ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                File createFile = new File((String) downloadedFilesForFile.get(i));
                float output = sca.getSimilarity(preprocessText(checkfile.getAbsolutePath()), preprocessText(createFile.getAbsolutePath()));
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
        File[] downloadedFilesList = dir.listFiles();
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
}
