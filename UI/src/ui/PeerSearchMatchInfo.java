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
import java.util.Map;
import java.util.concurrent.Callable;
import preprocess.Stemmer;
import preprocess.StopWordRemover;
import preprocess.SynonymReplacer;

/**
 *
 * @author nuwan
 */
public class PeerSearchMatchInfo implements Callable {
    
    ComparisonResult cr = new ComparisonResult();
    CosineSimilarityAlgorithm cossim = new CosineSimilarityAlgorithm();
    DocumentReader docreader = new DocumentReader();
    StopWordRemover stopremover = new StopWordRemover();
    SynonymReplacer synReplaser = new SynonymReplacer();
    Stemmer stem = new Stemmer();
    ArrayList<String> indexedFilesForFile;
    HashMap<String,String[]> peerFilesReportData= new HashMap<String,String[]>() ;
    int counter;
    File filePath;

    PeerSearchMatchInfo(ArrayList<String> indexedFilesForFileTemp, int counterTemp, File filePathTemp) {

        indexedFilesForFile=indexedFilesForFileTemp;
        counter=counterTemp;
        filePath=filePathTemp;

    }




    public HashMap<String,String[]> call() throws Exception {



                String[] matchValuePair=new String[2];
                ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                File createFile = new File((String) indexedFilesForFile.get(counter));
                float output = sca.getSimilarity(preprocessText(filePath.getAbsolutePath()), preprocessText(createFile.getAbsolutePath()));
                String match = sca.getList();
                matchValuePair[0]=match;
                matchValuePair[1]=String.valueOf(roundNumber(output,2)*100/2);
                String firstFile = filePath.getAbsolutePath();
                String secondFile = createFile.getAbsolutePath();
                System.out.println();
                System.out.println(firstFile);
                System.out.println(secondFile);
                System.out.println("match is " + match);
                System.out.println();

                if (!(match.isEmpty()) &&  !(firstFile.equalsIgnoreCase(secondFile))) {
                    peerFilesReportData.put(createFile.getAbsolutePath(), matchValuePair);
                }

                return peerFilesReportData;

            }

















public float roundNumber(float Rval, int Rpl) {
  float p = (float)Math.pow(10,Rpl);
  Rval = Rval * p;
  float tmp = Math.round(Rval);
  return (float)tmp/p;
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
