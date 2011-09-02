/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

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
public class TextHighlighterParaphraseTest {
    
    public TextHighlighterParaphraseTest() {
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
     * Test of highlightTexts method, of class TextHighlighterParaphrase.
     */
    @Test
    public void testHighlightTexts() {
        System.out.println("highlightTexts");
        String contentOftheFile = "";
        String query = "";
        TextHighlighterParaphrase instance = new TextHighlighterParaphrase();
        String[] expResult = null;
        String[] result = instance.highlightTexts(contentOftheFile, query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
