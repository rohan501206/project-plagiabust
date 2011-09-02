/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocess;

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
public class KeyWordsRemoverTest {
    
    public KeyWordsRemoverTest() {
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
     * Test of addKeyWordsToList method, of class KeyWordsRemover.
     */
    @Test
    public void testAddKeyWordsToList() {
        System.out.println("addKeyWordsToList");
        String fileName = "";
        String content = "";
        KeyWordsRemover instance = new KeyWordsRemover();
        instance.addKeyWordsToList(fileName, content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
