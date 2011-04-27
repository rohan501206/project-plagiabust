/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.io.File;
import dataExtraction.DocumentReader;
import ComparisonEngine.ShingleCloudAlgorithm;
import ComparisonEngine.CosineSimilarityAlgorithm;
import java.util.ArrayList;
import ComparisonEngine.ComparisonResult;
/**
 *
 * @author Compaq
 */
public class Manager {
    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();

 ComparisonResult cr = new ComparisonResult();
CosineSimilarityAlgorithm cossim = new CosineSimilarityAlgorithm();
DocumentReader docreader = new DocumentReader();
//StemmerWithStopWordRemover stemstopremover = new StemmerWithStopWordRemover();
//SynonymReplacer synReplaser = new SynonymReplacer();
//
public StringBuilder manage(String fileFolder){
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
		        String documentText =docreader.processFileAndGetText(fullFilename);
                //System.out.print(documentText);
                filenameText[i][0] =  documentText;
                
		      //snawball analyser
		       /* ArrayList<String> token = null;
				token = stemstopremover.analyze(documentText);

				for(int k=0 ; k<token.size();k++){
					System.out.print(token.get(k)+"	");
				}

				//synReplaser.replaceSynonyms(token);
				System.out.println();*/

		    }
            for (int i=0; i<children.length; i++) {
                temp.append("File"+(i+1)+" \n");
                for (int j=0; j<children.length; j++) {
                    String output3 = sca.getSimilarity(filenameText[i][0], filenameText[j][0]);
                    temp.append("With File"+(j+1)+" \n");
                    temp.append(output3+"\n\n");
                    /*cr = cossim.getSimilarity(filenameText[i][0], filenameText[j][0]);
                    if(cr.Similarity>0.85){
                        temp.append("With File"+(j+1)+" \n");
                        temp.append(cr.PrintResults("CosineSimilarity"));
                        temp.append("\n");
                    }*/
                }
                temp.append("Next file \n\n\n");
            }
            System.out.println("Comparison Finished");
            return temp;
        }

}


}
