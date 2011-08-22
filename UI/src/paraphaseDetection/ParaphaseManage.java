/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paraphaseDetection;

import dataExtraction.DocumentReader;
import java.io.File;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Compaq
 */
public class ParaphaseManage {
    
    String matchList = null;
    String firstString = null;
    String secondString = null;
    DocumentReader docreader = new DocumentReader();
    Manager manager = new Manager();
     Double threshod =  0.27;       // best one so far
    
    public ParaphaseManage(String firstFile, String secondFile, String path){   
       firstString = docreader.processFileAndGetText(firstFile);
       secondString = docreader.processFileAndGetText(secondFile);  
      
       
    }
    
    public String checkForParaPhase(String firstString,String secondString){
        ArrayList<String> firstStringSentences = new ArrayList<String> ();
        ArrayList<String> secondStringSentences = new ArrayList<String> ();
        
        firstStringSentences = this.getSentences(firstString);
        secondStringSentences = this.getSentences(secondString);
        
        System.err.println(firstStringSentences);
        System.err.println(secondStringSentences);
        
        
        String result = "";
        for (int i = 0; i < firstStringSentences.size(); i++) {
            for (int j = 0; j < secondStringSentences.size(); j++) {
                double similarityValue = manager.similarity(firstStringSentences.get(i),secondStringSentences.get(j));  
                if (similarityValue > threshod) {
                    System.out.println();
                    result = result + firstStringSentences.get(i).trim()+":";
                }
            }
            
        }
        
        return result;
        
    }
    
    public List<String> getParagraphs (String document){
		String [] temp = document.split("[\\r\\n]+");
		return Arrays.asList(temp);
	}
    
    public ArrayList<String> getSentences(String paragraph){
		BreakIterator bi = BreakIterator.getSentenceInstance();
		bi.setText(paragraph);
		int index = 0;
		ArrayList<String> list = new ArrayList<String>();
		while (bi.next() != BreakIterator.DONE) {
		    String sentence = paragraph.substring(index, bi.current());
		    list.add(sentence);
		   //System.out.println("Sentence: " + sentence);
		    index = bi.current();
		}
		return list;
	}
    
    
    public String getMatchList(){
        matchList = this.checkForParaPhase(firstString, secondString);
        return matchList;
    }
    
}
