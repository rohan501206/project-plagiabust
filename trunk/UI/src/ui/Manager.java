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
//
public StringBuilder manage(String fileFolder) throws IOException, JWNLException{
        StringBuilder temp = new StringBuilder( );
        File dir = new File(fileFolder);
		String[] children = dir.list();
        String [][] filenameText = new String [children.length][1];
		if (children == null) {
		    // Either dir does not exist or is not a directory
            return temp.append("Either dir does not exist or is not a directory");
		}
		else {
		    for (int i=0; i<children.length; i++) {
		        // Get filename of file or directory
		        String filename = children[i];
		        String fullFilename = fileFolder+"\\"+filename;
		        System.out.print(fullFilename);
		        System.out.println();
                // document reading
		        String documentText =docreader.processFileAndGetText(fullFilename);
                // removing numbers
                
                String nuberRemoveText = documentText.replaceAll("[^a-zA-Z ]", "");
                
                //snawball analyser
		        ArrayList<String> token = null;
				token = stemstopremover.analyze(nuberRemoveText);
				String preprocessText = synReplaser.replaceSynonyms(token);
				filenameText[i][0] =  preprocessText;
                
		    }


            for (int i=0; i<children.length; i++) {
                temp.append("File"+(i+1)+" \n");
                for (int j=0; j<children.length; j++) {
                    String output = sca.getSimilarity(filenameText[i][0], filenameText[j][0]);
                    temp.append("With File"+(j+1)+" \n");
                    temp.append(output+"\n\n");
                }
                temp.append("Next file \n\n\n");
            }


            System.out.println("Comparison Finished");
            return temp;
        }

}


}
