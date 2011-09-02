/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocess;

import java.util.ArrayList;
import net.didion.jwnl.data.IndexWord;
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
public class SynonymReplacerTest {
    
    public SynonymReplacerTest() {
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
     * Test of replaceSynonyms method, of class SynonymReplacer.
     */
    @Test
    public void testReplaceSynonyms() throws Exception {
        System.out.println("replaceSynonyms");
        ArrayList<String> tokens = null;
        SynonymReplacer instance = new SynonymReplacer();
        String expResult = "";
        String result = instance.replaceSynonyms(tokens);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSynonym method, of class SynonymReplacer.
     */
    @Test
    public void testGetSynonym() throws Exception {
        System.out.println("getSynonym");
        IndexWord w = null;
        String expResult = "";
        String result = SynonymReplacer.getSynonym(w);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
