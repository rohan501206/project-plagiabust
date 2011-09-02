/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

import java.text.BreakIterator;
import java.util.ArrayList;
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
public class QueryCreatorTest {
    
    public QueryCreatorTest() {
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
     * Test of getRandomSelectionRatio method, of class QueryCreator.
     */
    @Test
    public void testGetRandomSelectionRatio() {
        System.out.println("getRandomSelectionRatio");
        QueryCreator instance = new QueryCreator();
        float expResult = 0.0F;
        float result = instance.getRandomSelectionRatio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRandomSelectionRatio method, of class QueryCreator.
     */
    @Test
    public void testSetRandomSelectionRatio() {
        System.out.println("setRandomSelectionRatio");
        float selectionRatio = 0.0F;
        QueryCreator instance = new QueryCreator();
        instance.setRandomSelectionRatio(selectionRatio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQueryList method, of class QueryCreator.
     */
    @Test
    public void testGetQueryList_String_QuerySelectionAlgorithm() {
        System.out.println("getQueryList");
        String fileName = "";
        QuerySelectionAlgorithm querySelectionAlgo = null;
        QueryCreator instance = new QueryCreator();
        ArrayList expResult = null;
        ArrayList result = instance.getQueryList(fileName, querySelectionAlgo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQueryList method, of class QueryCreator.
     */
    @Test
    public void testGetQueryList_String_float() {
        System.out.println("getQueryList");
        String fileName = "";
        float ratio = 0.0F;
        QueryCreator instance = new QueryCreator();
        ArrayList expResult = null;
        ArrayList result = instance.getQueryList(fileName, ratio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of markBoundaries method, of class QueryCreator.
     */
    @Test
    public void testMarkBoundaries() {
        System.out.println("markBoundaries");
        String target = "";
        BreakIterator iterator = null;
        QueryCreator.markBoundaries(target, iterator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printEachForward method, of class QueryCreator.
     */
    @Test
    public void testPrintEachForward() {
        System.out.println("printEachForward");
        BreakIterator boundary = null;
        String source = "";
        QueryCreator.printEachForward(boundary, source);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectSentencesExhaustively method, of class QueryCreator.
     */
    @Test
    public void testSelectSentencesExhaustively() {
        System.out.println("selectSentencesExhaustively");
        QueryCreator instance = new QueryCreator();
        ArrayList expResult = null;
        ArrayList result = instance.selectSentencesExhaustively();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuotedList method, of class QueryCreator.
     */
    @Test
    public void testGetQuotedList() {
        System.out.println("getQuotedList");
        ArrayList<String> sentenceList = null;
        QueryCreator instance = new QueryCreator();
        ArrayList expResult = null;
        ArrayList result = instance.getQuotedList(sentenceList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
