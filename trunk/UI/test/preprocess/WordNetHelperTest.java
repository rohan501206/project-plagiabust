/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocess;

import java.util.ArrayList;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.PointerType;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.relationship.Relationship;
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
public class WordNetHelperTest {
    
    public WordNetHelperTest() {
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
     * Test of initialize method, of class WordNetHelper.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        String propsFile = "";
        WordNetHelper.initialize(propsFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPOS method, of class WordNetHelper.
     */
    @Test
    public void testGetPOS() throws Exception {
        System.out.println("getPOS");
        String s = "";
        POS[] expResult = null;
        POS[] result = WordNetHelper.getPOS(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRelated method, of class WordNetHelper.
     */
    @Test
    public void testGetRelated_IndexWord_PointerType() throws Exception {
        System.out.println("getRelated");
        IndexWord word = null;
        PointerType type = null;
        ArrayList expResult = null;
        ArrayList result = WordNetHelper.getRelated(word, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRelated method, of class WordNetHelper.
     */
    @Test
    public void testGetRelated_Synset_PointerType() throws Exception {
        System.out.println("getRelated");
        Synset sense = null;
        PointerType type = null;
        ArrayList expResult = null;
        ArrayList result = WordNetHelper.getRelated(sense, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showRelatedTree method, of class WordNetHelper.
     */
    @Test
    public void testShowRelatedTree_3args_1() throws Exception {
        System.out.println("showRelatedTree");
        IndexWord word = null;
        int depth = 0;
        PointerType type = null;
        WordNetHelper.showRelatedTree(word, depth, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showRelatedTree method, of class WordNetHelper.
     */
    @Test
    public void testShowRelatedTree_3args_2() throws Exception {
        System.out.println("showRelatedTree");
        Synset sense = null;
        int depth = 0;
        PointerType type = null;
        WordNetHelper.showRelatedTree(sense, depth, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRelationship method, of class WordNetHelper.
     */
    @Test
    public void testGetRelationship() throws Exception {
        System.out.println("getRelationship");
        IndexWord start = null;
        IndexWord end = null;
        PointerType type = null;
        Relationship expResult = null;
        Relationship result = WordNetHelper.getRelationship(start, end, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRelationshipSenses method, of class WordNetHelper.
     */
    @Test
    public void testGetRelationshipSenses() throws Exception {
        System.out.println("getRelationshipSenses");
        Relationship rel = null;
        ArrayList expResult = null;
        ArrayList result = WordNetHelper.getRelationshipSenses(rel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWord method, of class WordNetHelper.
     */
    @Test
    public void testGetWord() throws Exception {
        System.out.println("getWord");
        POS pos = null;
        String s = "";
        IndexWord expResult = null;
        IndexWord result = WordNetHelper.getWord(pos, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
