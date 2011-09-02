/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

import java.awt.Color;
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
public class CrossCheckModuleTest {
    
    public CrossCheckModuleTest() {
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
     * Test of setData method, of class CrossCheckModule.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        CrossCheckModule instance = null;
        instance.setData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of highlighter method, of class CrossCheckModule.
     */
    @Test
    public void testHighlighter() {
        System.out.println("highlighter");
        String queryTemp = "";
        String firstFileMatch = "";
        String secondFileMatch = "";
        CrossCheckModule instance = null;
        instance.highlighter(queryTemp, firstFileMatch, secondFileMatch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of highlighterForBothFields method, of class CrossCheckModule.
     */
    @Test
    public void testHighlighterForBothFields() {
        System.out.println("highlighterForBothFields");
        String[] query = null;
        String content = "";
        String content2 = "";
        ArrayList<Color> colourArrayTemp = null;
        CrossCheckModule instance = null;
        instance.highlighterForBothFields(query, content, content2, colourArrayTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
