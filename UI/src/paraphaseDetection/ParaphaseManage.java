/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paraphaseDetection;

import dataExtraction.DocumentReader;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import preprocess.Stemmer;
import preprocess.StopWordRemover;

/**
 *
 * @author Udana Chathuranga
 */
public class ParaphaseManage {
    
    String matchList[] = new String[2];
    String firstString = null;
    String secondString = null;
    String firstfileName = null;
    String secondfileName = null;
    DocumentReader docreader = new DocumentReader();
    CalculationManager manager = new CalculationManager();
     
       Double threshod =  0.60;   // best one so far
    StopWordRemover stopremover = new StopWordRemover();
    Stemmer stem = new Stemmer();
    
    /**
     * Constructor for the ParaphaseManager 
     * @param firstFile
     * @param secondFile
     * @param path 
     */
    public ParaphaseManage(String firstFile, String secondFile, String path){   
       firstString = docreader.processFileAndGetText(firstFile);
       secondString = docreader.processFileAndGetText(secondFile);  
       firstfileName = firstFile;
       secondfileName = secondFile;
    }
    
    /**
     * Check and return the paraphrased sentences
     * @param firstString
     * @param secondString
     * @return
     * @throws IOException 
     */
    public String[] checkForParaPhase(String firstString,String secondString) throws IOException{
        ArrayList<String> firstStringSentences = new ArrayList<String> ();
        ArrayList<String> secondStringSentences = new ArrayList<String> ();        
        firstStringSentences = this.getSentences(firstString);
        secondStringSentences = this.getSentences(secondString);
        String result[] = new String[2];
        String firstfileMatch = "";
        String secondfileMatch = "";             
        
        for (int i = 0; i < firstStringSentences.size(); i++) {   
            boolean isParaphased = false;
            
            for (int j = 0; j < secondStringSentences.size(); j++) {           
                double similarityValue = manager.similarity(firstStringSentences.get(i),secondStringSentences.get(j));  
                if (similarityValue > threshod) { 
                    isParaphased = true;
                    secondfileMatch = secondfileMatch+secondStringSentences.get(j).toLowerCase()+"~";  
                    break;
                }
            }
            
            if(isParaphased){
                firstfileMatch = firstfileMatch+firstStringSentences.get(i).toLowerCase()+"~";
            }
            
        }
        
        result[0] = firstfileMatch;
        result[1] = secondfileMatch;
        return result;
    }
    
    /**
     * Convert arraylist to a string
     * @param token
     * @return 
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
     * Calaculate the Plagiarism value for the paraphrase match
     * @param match
     * @return
     * @throws IOException 
     */
    public float getPlagiarismValueForParaphraseDetect(String match) throws IOException{        
        String paraphasedString = this.matchList[0];
        String matchOnlyText = match.replaceAll("~"," ");
        String paraphasedOnlyText = paraphasedString.replaceAll("~"," ");
        String [] machedTextArray = matchOnlyText.split(" ");
        String onlyParaphasedText = this.arraylistToSting(stopremover.removeStopwordInstopwordArray(paraphasedOnlyText, machedTextArray));
        int all = firstString.length();
        int para = onlyParaphasedText.length();
        
        return (para*100)/all;        
    }
    
   /**
     * Split a document into paragraphs
     * @param document
     * @return 
     */
    public List<String> getParagraphs (String document){
		String [] temp = document.split("[\\r\\n]+");
		return Arrays.asList(temp);
	}

    /**
     * Split a paragraph into sentences
     * @param paragraph
     * @return 
     */
    public ArrayList<String> getSentences(String paragraph) {
        BreakIterator bi = BreakIterator.getSentenceInstance();
        bi.setText(paragraph);
        int index = 0;
        ArrayList<String> list = new ArrayList<String>();
        while (bi.next() != BreakIterator.DONE) {
            String sentence = paragraph.substring(index, bi.current());
            list.add(sentence);
            index = bi.current();
        }
        return list;
    }
    
    
    /**
     * Return the paraphrased match list 
     * @return
     * @throws IOException 
     */
    public String[] getMatchList() throws IOException{
        matchList = this.checkForParaPhase(firstString, secondString);
        return matchList;
    }
    
}
