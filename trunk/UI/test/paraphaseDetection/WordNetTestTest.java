/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paraphaseDetection;

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
public class WordNetTestTest {
    
    public WordNetTestTest() {
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
     * Test of getSynonyms method, of class WordNetTest.
     */
    @Test
    public void testGetSynonyms() {
        System.out.println("getSynonyms");
        String word = "";
        WordNetTest instance = new WordNetTest();
        String[] expResult = null;
        String[] result = instance.getSynonyms(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class WordNetTest.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        WordNetTest.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
