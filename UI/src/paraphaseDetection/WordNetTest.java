/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paraphaseDetection;
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

    public WordNetTest() {
            try {
                this.map = new SynonymMap(new FileInputStream("Resources"+File.separatorChar+"wn"+File.separatorChar+"wn_s.pl"));
            } catch (IOException ex) {
                Logger.getLogger(WordNetTest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hard", "woods", "forest", "wolfish", "xxxx"};
        SynonymMap map = null;
        try {
            map = new SynonymMap(new FileInputStream("Resources"+File.separatorChar+"wn"+File.separatorChar+"wn_s.pl"));
        } catch (IOException ex) {
            Logger.getLogger(WordNetTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = map.getSynonyms(words[i]);
            System.out.println(words[i] + ":" + java.util.Arrays.asList(synonyms).toString());
        }
    }


    public String[] getSynonyms(String word){
        String[] synonyms = map.getSynonyms(word);
        return synonyms;
    }


}