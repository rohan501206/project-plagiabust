/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocess;

import java.io.File;
import java.util.ArrayList;

import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.IndexWordSet;
import net.didion.jwnl.data.PointerType;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;

public class SynonymReplacer {

	public  String  replaceSynonyms(ArrayList<String> tokens) throws JWNLException {
	     // Initialize the database
	     // You must configure the properties file to point to your dictionary files
	     WordNetHelper.initialize("src" + File.separatorChar + "preprocess" + File.separatorChar + "file_properties.xml");
	     String newSentence = "";
	     String newSentencefromIndex = "";
	     // Walk through all tokens
	     for (int i = 0; i < tokens.size(); i++) {
	         // This will our replace word, if we don't find anything to replace it with
	         // we just use the same word
	         String newWord = tokens.get(i);
	         // LookUp all IndexWords and store in an array
	         IndexWordSet set = Dictionary.getInstance().lookupAllIndexWords(tokens.get(i));
	         IndexWord[] words = set.getIndexWordArray();
	         // Try to get a Synonym for any IndexWord, first come first serve!
	         for (int j = 0; j < words.length; j++) {
	             String found = getSynonym(words[j]);
	             // If we found something let's get out of here
	             if (found != null) {
	                 newWord = found;
	                 break;
	             }
	         }
	         // Rebuild new sentence
	         newSentence += newWord+" ";

	     }
	     System.out.println("\n\nHere is the revised paragraph: ");
	     System.out.println("\n" + newSentence);
	     return newSentence;
	 }

	 public static String getSynonym(IndexWord w) throws JWNLException {
	     // Use the helper class to get an ArrayList of similar Synsets for an IndexWord
	     ArrayList a = WordNetHelper.getRelated(w,PointerType.SIMILAR_TO);
	     // As long as we have a non-empty ArrayList
	     if (a != null && !a.isEmpty()) {
	         System.out.println("Found a synonym for " + w.getLemma() + ".");
	         // Pick a random Synset
	        // int rand = (int) (Math.random() * a.size());
	         Synset s = (Synset) a.get(0);
	         // Pick a random Word from that Synset
	         Word[] words = s.getWords();
	        // rand = (int) (Math.random() * words.length);
	         return words[0].getLemma();
	     }
	     return null;
	 }




}