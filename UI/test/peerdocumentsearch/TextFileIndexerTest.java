/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

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
public class TextFileIndexerTest {
    
    public TextFileIndexerTest() {
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
     * Test of indexFileOrDirectory method, of class TextFileIndexer.
     */
    @Test
    public void testIndexFileOrDirectory() throws Exception {
        System.out.println("indexFileOrDirectory");
        String fileName = "";
        TextFileIndexer instance = null;
        instance.indexFileOrDirectory(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeIndex method, of class TextFileIndexer.
     */
    @Test
    public void testCloseIndex() throws Exception {
        System.out.println("closeIndex");
        TextFileIndexer instance = null;
        instance.closeIndex();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
