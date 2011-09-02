/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paraphaseDetection;

import java.util.ArrayList;
import java.util.List;
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
public class ParaphaseManageTest {
    
    public ParaphaseManageTest() {
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
     * Test of checkForParaPhase method, of class ParaphaseManage.
     */
    @Test
    public void testCheckForParaPhase() throws Exception {
        System.out.println("checkForParaPhase");
        String firstString = "";
        String secondString = "";
        ParaphaseManage instance = null;
        String[] expResult = null;
        String[] result = instance.checkForParaPhase(firstString, secondString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arraylistToSting method, of class ParaphaseManage.
     */
    @Test
    public void testArraylistToSting() {
        System.out.println("arraylistToSting");
        ArrayList<String> token = null;
        ParaphaseManage instance = null;
        String expResult = "";
        String result = instance.arraylistToSting(token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlagiarismValueForParaphraseDetect method, of class ParaphaseManage.
     */
    @Test
    public void testGetPlagiarismValueForParaphraseDetect() throws Exception {
        System.out.println("getPlagiarismValueForParaphraseDetect");
        String match = "";
        ParaphaseManage instance = null;
        float expResult = 0.0F;
        float result = instance.getPlagiarismValueForParaphraseDetect(match);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParagraphs method, of class ParaphaseManage.
     */
    @Test
    public void testGetParagraphs() {
        System.out.println("getParagraphs");
        String document = "";
        ParaphaseManage instance = null;
        List expResult = null;
        List result = instance.getParagraphs(document);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSentences method, of class ParaphaseManage.
     */
    @Test
    public void testGetSentences() {
        System.out.println("getSentences");
        String paragraph = "";
        ParaphaseManage instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getSentences(paragraph);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatchList method, of class ParaphaseManage.
     */
    @Test
    public void testGetMatchList() throws Exception {
        System.out.println("getMatchList");
        ParaphaseManage instance = null;
        String[] expResult = null;
        String[] result = instance.getMatchList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
