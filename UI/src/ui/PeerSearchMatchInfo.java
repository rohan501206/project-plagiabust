/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ComparisonEngine.ComparisonResult;
import ComparisonEngine.CosineSimilarityAlgorithm;
import ComparisonEngine.ShingleCloudAlgorithm;
import dataExtraction.DocumentReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import paraphaseDetection.ParaphaseManage;
import preprocess.Stemmer;
import preprocess.StopWordRemover;
import preprocess.SynonymReplacer;

/**
 *
 * @author nuwan
 */
public class PeerSearchMatchInfo implements Callable {

    private DocumentReader docreader = new DocumentReader();
    private StopWordRemover stopremover = new StopWordRemover();
    private Stemmer stem = new Stemmer();
    private HashMap<String, String[]> peerFilesReportData = new HashMap<String, String[]>();
    private File filePath;
    private String file;
    private boolean paraphaseDetection = false;

    PeerSearchMatchInfo(ArrayList<String> indexedFilesForFileTemp, String fileTemp, File filePathTemp, boolean paraphraseDetection) {
        file = fileTemp;
        filePath = filePathTemp;
        this.paraphaseDetection = paraphraseDetection;
    }

    /**
     * implementation of the call method
     * @return comparison results
     * @throws Exception
     */
    public HashMap<String, String[]> call() throws Exception {
        String[] matchValuePair = new String[4];
        ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
        File createFile = new File(file);
        float output = sca.getSimilarity(preprocessText(filePath.getAbsolutePath()), preprocessText(createFile.getAbsolutePath()));
        String match = sca.getList();
        String[] matchedText = new String[2];
        String downloadedFolderPath = "";
        float paraphasedValue = 0;
        if (paraphaseDetection) {
            ParaphaseManage paramanager = new ParaphaseManage(filePath.getAbsolutePath(), createFile.getAbsolutePath(), downloadedFolderPath);
            matchedText = paramanager.getMatchList();
            paraphasedValue = paramanager.getPlagiarismValueForParaphraseDetect(match);
        } else {
            matchedText[0] = "";
            matchedText[1] = "";
            paraphasedValue = 0;
        }
        matchValuePair[0] = match;
        if (roundNumber(output, 2) * 100 / 2 + paraphasedValue > 100) {
            matchValuePair[1] = "100";
        } else {
            matchValuePair[1] = String.valueOf(roundNumber(output, 2) * 100 / 2 + paraphasedValue);
        }

        matchValuePair[2] = matchedText[0];
        matchValuePair[3] = matchedText[1];
        String firstFile = filePath.getAbsolutePath();
        String secondFile = createFile.getAbsolutePath();
        System.out.println();
        System.out.println(firstFile);
        System.out.println(secondFile);
        if (match.length() > 0) {
            System.out.println("match is " + match);
        } else {
            System.out.println("There is no match between the above two files");
        }
        System.out.println();

        if (!(match.isEmpty()) && !(firstFile.equalsIgnoreCase(secondFile))) {
            peerFilesReportData.put(createFile.getAbsolutePath(), matchValuePair);
        }

        return peerFilesReportData;

    }

    public float roundNumber(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float) tmp / p;
    }

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

    public String arraylistToSting(ArrayList<String> token) {
        StringBuilder out = new StringBuilder();
        for (Object o : token) {
            out.append(o.toString());
            out.append(" ");
        }
        return out.toString();
    }
}
