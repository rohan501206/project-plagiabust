/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paraphaseDetection;
import dataExtraction.DocumentReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.wordnet.SynonymMap;
/**
 *
 * @author Compaq
 */
public class WordNetTest {
    SynonymMap map = null;

    
    /**
     * Constructor for WordNetTest
     */
    public WordNetTest() {
            try {
                this.map = new SynonymMap(new FileInputStream("Resources"+File.separatorChar+"wn"+File.separatorChar+"wn_s.pl"));
            } catch (IOException ex) {
                Logger.getLogger(WordNetTest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
    
    /**
     * Get synonyms for a given word
     * @param word
     * @return 
     */
    public String[] getSynonyms(String word){
        String[] synonyms = map.getSynonyms(word);
        return synonyms;
    }
    
    
    /**
     * Main method to testing
     * @param args 
     */
    public static void main(String[] args) {
        DocumentReader docreader = new DocumentReader();
	String documentText = docreader.processFileAndGetText("50.txt");
        String[] words = documentText.split("\\b");
       
        SynonymMap map = null;
        try {
            map = new SynonymMap(new FileInputStream("Resources"+File.separatorChar+"wn"+File.separatorChar+"wn_s.pl"));
        } catch (IOException ex) {
            Logger.getLogger(WordNetTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = map.getSynonyms(words[i]);
            System.out.println(words[i] + ":" + java.util.Arrays.asList(synonyms).toString());
        }
        long t2 = System.currentTimeMillis();
        System.out.println();
	System.out.println("Time taken :" + (t2-t1));
    }


   


}