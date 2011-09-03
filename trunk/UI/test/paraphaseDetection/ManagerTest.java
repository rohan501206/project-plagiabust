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
public class ManagerTest {
    
    public ManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of manage method, of class Manager.
     */
    @Test
    public void testManage() {
        System.out.println("manage");
        String sentenceOne = "";
        String sentenceTwo = "";
        Manager instance = new Manager();
        instance.manage(sentenceOne, sentenceTwo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of idf method, of class Manager.
     */
    @Test
    public void testIdf() {
        System.out.println("idf");
        String word = "test";
        String sentence = "this is a test";
        String secondSentence = "test for correctness";
        Manager instance = new Manager();
        double expResult = 0.5108256237659906;
        double result = instance.idf(word, sentence, secondSentence);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of getLevenshteinDistance method, of class Manager.
     */
    @Test
    public void testGetLevenshteinDistance() {
        System.out.println("getLevenshteinDistance");
        String s = "this is a test";
        String t = "test for correctness";
        Manager instance = new Manager();
        int expResult = 14;
        int result = instance.getLevenshteinDistance(s, t);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of maxSimilarity method, of class Manager.
     */
    @Test
    public void testMaxSimilarity() {
        System.out.println("maxSimilarity");
        String word = "test";
        String sentence = "test for correctness";
        Manager instance = new Manager();
        double expResult = 1.0;
        double result = instance.maxSimilarity(word, sentence);
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of synonymSimilarity method, of class Manager.
     */
    @Test
    public void testSynonymSimilarity() {
        System.out.println("synonymSimilarity");
        String word = "get";
        String sentence = "take the bus";
        Manager instance = new Manager();
        double expResult = 1.0;
        double result = instance.synonymSimilarity(word, sentence);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of lenthSimilarity method, of class Manager.
     */
    @Test
    public void testLenthSimilarity() {
        System.out.println("lenthSimilarity");
        String firstSentence = "test for correctness";
        String secondSentence = "test for correctness";
        Manager instance = new Manager();
        double expResult = 0.5;
        double result = instance.lenthSimilarity(firstSentence, secondSentence);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of similarity method, of class Manager.
     */
    @Test
    public void testSimilarity() {
        System.out.println("similarity");
        String firstSentence = "test for correctness";
        String secondSentence = "test for correctness and bugs";
        Manager instance = new Manager();
        double expResult = 0.6625208947993662;
        double result = instance.similarity(firstSentence, secondSentence);
        assertEquals(expResult, result, 0.0);
        
    }
}
