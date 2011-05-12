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
import java.util.HashMap;
import java.util.List;
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

    public String[][] manage(String fileFolder) throws IOException, JWNLException {
        File dir = new File(fileFolder);
        String[] children = dir.list();
        HashMap hm = new HashMap();
        int fileNo=0;
        String[][] filenameText = new String[children.length*children.length][4];
        System.out.println("Size of the files is"+children.length);
        if (children == null) {
            // Either dir does not exist or is not a directory
            return null;
        }
        else {
            for (int i = 0; i < children.length; i++) {
                // Get filename of file or directory
                String filename = children[i];
                String preprocessText = preprocessText(filename,fileFolder);
                hm.put(filename, preprocessText);

            }
            for (int i = 0; i < children.length; i++) {
                for (int j = 0; j < children.length; j++) {
                    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                    if(i!=j){
                    float output = sca.getSimilarity(hm.get(children[i]).toString(), hm.get(children[j]).toString());
                    String match = sca.getList();
                    String firstFile = fileFolder + "\\" + children[i];
                    String secondFile = fileFolder + "\\" + children[j];
                    System.out.println(firstFile);
                    System.out.println(secondFile);
                    //System.out.println("the string of the first text is" + hm.get(children[i]).toString( ));
                   // System.out.println("the string of the second text is" + hm.get(children[j]).toString( ));                    
                    System.out.println("match is "+ match);
                    System.out.println("Size of the fileNop is"+fileNo);
                    if(!match.isEmpty()){
                             //////////////// just for testing purposes
                    filenameText[fileNo][0] = firstFile;
                    filenameText[fileNo][1] = secondFile;
                    filenameText[fileNo][2] = match;
                    fileNo++;
                        
                    String Isplagarised = null;
                    if (output > 1.5) {
                        Isplagarised = "1";
                    }
                    else {
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

    public String arraylistToSting(ArrayList<String> token) {
        StringBuilder out = new StringBuilder();
        for (Object o : token) {
            out.append(o.toString());
            out.append(" ");
        }
        return out.toString();
    }

    public String preprocessText(String filename,String fileFolder)throws IOException{
                String fullFilename = fileFolder + "\\" + filename;
                // document reading
                String documentText = docreader.processFileAndGetText(fullFilename);
                // removing numbers
                String numberRemoveText = documentText.replaceAll("[^a-zA-Z ]", "");
                //snawball analyser
                ArrayList<String> numberRemovedToken = null;
                ArrayList<String> stopWordRemovedTokens = null;
                numberRemovedToken = stopremover.analyze(numberRemoveText);
                String stopwordRemovedString = this.arraylistToSting(numberRemovedToken);
                stopWordRemovedTokens= stem.analyze(stopwordRemovedString);
                //String preprocessText = synReplaser.replaceSynonyms(tokens);
                String preprocessText = this.arraylistToSting(stopWordRemovedTokens);
                return preprocessText;
    }
}
