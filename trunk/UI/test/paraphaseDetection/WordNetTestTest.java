/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paraphaseDetection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Compaq
 */
public class WordNetTestTest {
    
    public WordNetTestTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getSynonyms method, of class WordNetTest.
     */
    @Test
    public void testGetSynonyms() {
        System.out.println("getSynonyms");
        String word = "take";
        WordNetTest instance = new WordNetTest();
        String expResult = "accept acquire";
        String[] result = instance.getSynonyms(word);
        String resultString = result[0]+" "+result[1];
        assertEquals(expResult, resultString);
        
    }

    /**
     * Test of main method, of class WordNetTest.
     */
    //@Test
    //public void testMain() {
      //  System.out.println("main");
      //  String[] args = null;
     //   WordNetTest.main(args);
        
    //}
}
