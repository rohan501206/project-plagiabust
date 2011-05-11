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

    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
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
        String[][] filenameText = new String[children.length][4];
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
                    float output = sca.getSimilarity(hm.get(children[i]).toString(), hm.get(children[j]).toString());
                    String match = sca.getList();
                    String firstFile = fileFolder + "\\" + children[i];
                    String secondFile = fileFolder + "\\" + children[j];
                    filenameText[i][0] = firstFile;
                    filenameText[i][1] = secondFile;
                    filenameText[i][2] = match;
                    String Isplagarised = null;
                    if (output > 1.5) {
                        Isplagarised = "1";
                    }
                    else {
                        Isplagarised = "0";
                    }
                    filenameText[i][3] = Isplagarised;
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
