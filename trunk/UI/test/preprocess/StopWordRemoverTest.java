/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocess;

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
public class StopWordRemoverTest {
    
    public StopWordRemoverTest() {
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
     * Test of analyze method, of class StopWordRemover.
     */
    @Test
    public void testAnalyze() throws Exception {
        System.out.println("analyze");
        String text = "";
        StopWordRemover instance = new StopWordRemover();
        ArrayList expResult = null;
        ArrayList result = instance.analyze(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeStopwordInstopwordArray method, of class StopWordRemover.
     */
    @Test
    public void testRemoveStopwordInstopwordArray() throws Exception {
        System.out.println("removeStopwordInstopwordArray");
        String text = "";
        String[] stopwords = null;
        StopWordRemover instance = new StopWordRemover();
        ArrayList expResult = null;
        ArrayList result = instance.removeStopwordInstopwordArray(text, stopwords);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
