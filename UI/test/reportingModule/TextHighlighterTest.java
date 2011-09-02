/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nuwan
 */
public class TextHighlighterTest {

    public TextHighlighterTest() {
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
     * Test of highlightTexts method, of class TextHighlighter.
     */
    @Test
    public void testHighlightTexts() {
        System.out.println("highlightTexts");
        String contentOftheFile = "";
        String query = "";
        TextHighlighter instance = new TextHighlighter();
        Integer[] expResult = null;
        Integer[] result = instance.highlightTexts(contentOftheFile, query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaximum method, of class TextHighlighter.
     */
    @Test
    public void testGetMaximum() {
        System.out.println("getMaximum");
        ArrayList<Integer> array = new ArrayList<Integer>();     
        array.add(123);
        array.add(12333);
        array.add(122);
        array.add(12323);
        array.add(45654);




        TextHighlighter instance = new TextHighlighter();
        int expResult = 45654;
        int result = instance.getMaximum(array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("failed");
    }

    /**
     * Test of getSearchQueryPattern method, of class TextHighlighter.
     */
    @Test
    public void testGetSearchQueryPattern() {
        System.out.println("getSearchQueryPattern");
        ArrayList<String> preprocessedModifiedArrayList = null;
        TextHighlighter instance = new TextHighlighter();
        String expResult = "";
        String result = instance.getSearchQueryPattern(preprocessedModifiedArrayList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondMaximum method, of class TextHighlighter.
     */
    @Test
    public void testGetSecondMaximum() throws Exception {
        System.out.println("getSecondMaximum");
        ArrayList<Integer> array = null;
        TextHighlighter instance = new TextHighlighter();
        int expResult = 0;
        int result = instance.getSecondMaximum(array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}