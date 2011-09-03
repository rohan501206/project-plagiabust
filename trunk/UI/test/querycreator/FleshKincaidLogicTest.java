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
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.processString("The use of electronic documents became increasingly popular and nowadays almost every academic institute uses online submission of assignments, projects, reports, etc.");
        double expResult = 19.808181818181826;
        double result = instance.getFleschKincaidGradeLevel();
        assertEquals(expResult, result, 0.0);
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
