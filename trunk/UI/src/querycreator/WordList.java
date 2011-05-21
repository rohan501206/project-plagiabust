/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package querycreator;

import java.util.Hashtable;

/**
 *
 * @author kasun
 */
public class WordList {
private Hashtable wordTable = null;

	public WordList() {
		// TODO Play with initial capacity and load factor
		wordTable = new Hashtable();
	}

	public void storeResults(String word, int syllables) {
		if (wordTable.containsKey(word)) {
			int[] newWordStats = (int[]) wordTable.get(word);
			newWordStats[0]++;

			wordTable.put(word, newWordStats);
		} else {
			int[] wordStats = new int[2];
			wordStats[0] = 1;			// number of instances of this word
			wordStats[1] = syllables;   // number of syllables in this word

			wordTable.put(word, wordStats);
		}
	}

}
