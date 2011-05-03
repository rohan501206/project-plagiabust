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
StemmerWithStopWordRemover stemstopremover = new StemmerWithStopWordRemover();
SynonymReplacer synReplaser = new SynonymReplacer();
Stemmer stem = new Stemmer();
//
public String [][] manage(String fileFolder) throws IOException, JWNLException{
        StringBuilder temp = new StringBuilder( );
        File dir = new File(fileFolder);
		String[] children = dir.list();
        HashMap hm = new HashMap();
        HashMap hmNew = new HashMap();
        String [][] filenameText = new String [children.length][4];
		if (children == null) {
		    // Either dir does not exist or is not a directory
            return null;
		}
		else {
		    for (int i=0; i<children.length; i++) {
		        // Get filename of file or directory
		        String filename = children[i];
		        String fullFilename = fileFolder+"\\"+filename;
                // document reading
		        String documentText =docreader.processFileAndGetText(fullFilename);
                // removing numbers
                
                String nuberRemoveText = documentText.replaceAll("[^a-zA-Z ]", "");
                
                //snawball analyser
                ArrayList<String> token = null;
                ArrayList<String> tokens = null;
				token = stemstopremover.analyze(nuberRemoveText);
                StringBuilder out = new StringBuilder();
                for (Object o : token){
                     out.append(o.toString());
                     out.append(" ");
                }
				tokens = stem.analyze(out.toString());
                String preprocessText = synReplaser.replaceSynonyms(tokens);
				hm.put(filename, preprocessText);

                
		    }


            for (int i=0; i<children.length; i++) {
                for (int j=0; j<children.length; j++) {
                    float output = sca.getSimilarity(hm.get(children[i]).toString(), hm.get(children[j]).toString());
                    String match = sca.getList();
                    String firstFile = fileFolder+"\\"+children[i];
                    String secondFile = fileFolder+"\\"+children[j];
                    filenameText[i][0]=firstFile;
                    filenameText[i][1]=secondFile;
                    filenameText[i][2]= match;
                    String Isplagarised = null;
                    if(output>1.5){
                        Isplagarised = "1";
                    }
                    else{
                        Isplagarised = "0";
                    }
                    filenameText[i][3]=  Isplagarised;
                }
                temp.append("Next file \n\n\n");
            }
            return filenameText;
        }

}


}
