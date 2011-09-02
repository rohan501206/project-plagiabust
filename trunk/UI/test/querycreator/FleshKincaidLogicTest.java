/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasun
 */
public class FleshKincaidLogicTest {
    
    public FleshKincaidLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of processString method, of class FleshKincaidLogic.
     */
    @Test
    public void testProcessString() {
        System.out.println("processString");
        String inputText = "";
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.processString(inputText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processText method, of class FleshKincaidLogic.
     */
    @Test
    public void testProcessText() {
        System.out.println("processText");
        String inputText = "";
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.processText(inputText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPunctuationThatEndsASentence method, of class FleshKincaidLogic.
     */
    @Test
    public void testAddPunctuationThatEndsASentence() {
        System.out.println("addPunctuationThatEndsASentence");
        String punctuation = "";
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.addPunctuationThatEndsASentence(punctuation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePunctuationThatEndsASentence method, of class FleshKincaidLogic.
     */
    @Test
    public void testRemovePunctuationThatEndsASentence() {
        System.out.println("removePunctuationThatEndsASentence");
        String punctuation = "";
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.removePunctuationThatEndsASentence(punctuation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCountingFragment method, of class FleshKincaidLogic.
     */
    @Test
    public void testSetCountingFragment() {
        System.out.println("setCountingFragment");
        boolean inputBoolean = false;
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.setCountingFragment(inputBoolean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCountingFragments method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetCountingFragments() {
        System.out.println("getCountingFragments");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        boolean expResult = false;
        boolean result = instance.getCountingFragments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWordsInFile method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetWordsInFile() {
        System.out.println("getWordsInFile");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        int expResult = 0;
        int result = instance.getWordsInFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSentencesInFile method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetSentencesInFile() {
        System.out.println("getSentencesInFile");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        int expResult = 0;
        int result = instance.getSentencesInFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSyllablesInFile method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetSyllablesInFile() {
        System.out.println("getSyllablesInFile");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        int expResult = 0;
        int result = instance.getSyllablesInFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSyllablesPerWordInFile method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetSyllablesPerWordInFile() {
        System.out.println("getSyllablesPerWordInFile");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        double expResult = 0.0;
        double result = instance.getSyllablesPerWordInFile();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFleschKincaidGradeLevel method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetFleschKincaidGradeLevel() {
        System.out.println("getFleschKincaidGradeLevel");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        double expResult = 0.0;
        double result = instance.getFleschKincaidGradeLevel();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFleschReadingEaseScore method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetFleschReadingEaseScore() {
        System.out.println("getFleschReadingEaseScore");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        double expResult = 0.0;
        double result = instance.getFleschReadingEaseScore();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAverageWordsPerSentence method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetAverageWordsPerSentence() {
        System.out.println("getAverageWordsPerSentence");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        double expResult = 0.0;
        double result = instance.getAverageWordsPerSentence();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStoreResults method, of class FleshKincaidLogic.
     */
    @Test
    public void testSetStoreResults() {
        System.out.println("setStoreResults");
        boolean newValue = false;
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.setStoreResults(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoreResults method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetStoreResults() {
        System.out.println("getStoreResults");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        boolean expResult = false;
        boolean result = instance.getStoreResults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWordList method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetWordList() {
        System.out.println("getWordList");
        FleshKincaidLogic instance = new FleshKincaidLogic();
        WordList expResult = null;
        WordList result = instance.getWordList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSentenceValid method, of class FleshKincaidLogic.
     */
    @Test
    public void testIsSentenceValid() {
        System.out.println("isSentenceValid");
        String sentence = "";
        FleshKincaidLogic instance = new FleshKincaidLogic();
        boolean expResult = false;
        boolean result = instance.isSentenceValid(sentence);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
