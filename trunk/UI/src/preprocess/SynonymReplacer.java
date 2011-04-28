/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocess;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.IndexWordSet;
import net.didion.jwnl.data.PointerType;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;

public class SynonymReplacer {


	public SynonymReplacer(){
		WordNetHelper.initialize("src"+ File.separatorChar +"preprocess"+ File.separatorChar +"file_properties.xml");
	}

	public   String   replaceSynonyms(ArrayList<String> tokens) throws JWNLException {
	     System.out.println("This program will take the following paragraph and replace" +
	     "\nall words with a synonym, if it can find one.\n\n");
	     StringBuilder temp = new StringBuilder( );
	     String newSentence = "";
	     // Walk through all tokens
	     Iterator e = tokens.iterator();
	     while (e.hasNext()) {
	         // This will our replace word, if we don't find anything to replace it with
	         // we just use the same word

	    	 String newWord = (String) e.next();;
	         // LookUp all IndexWords and store in an array
	         IndexWordSet set = Dictionary.getInstance().lookupAllIndexWords(newWord);
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
	         temp.append(newWord);
	         temp.append(" ");
	       //  newSentence += newWord+" ";

	     }
	     String s = temp.toString( );
	     System.out.println("\n\nHere is the revised paragraph: ");
	     System.out.println("\n" + s);
         return s;
	 }

	 public static String getSynonym(IndexWord w) throws JWNLException {
	     // Use the helper class to get an ArrayList of similar Synsets for an IndexWord
	     ArrayList a = WordNetHelper.getRelated(w,PointerType.SIMILAR_TO);
	     // As long as we have a non-empty ArrayList
	     if (a != null && !a.isEmpty()) {
	         Synset s = (Synset) a.get(0);
	         // Pick a random Word from that Synset
	         Word[] words = s.getWords();
	        // rand = (int) (Math.random() * words.length);
	         return words[0].getLemma();
	     }
	     return null;
	 }




}
