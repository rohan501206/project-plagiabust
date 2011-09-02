/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataExtraction;

import java.io.File;
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
public class DocumentFilterTest {
    
    public DocumentFilterTest() {
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
     * Test of accept method, of class DocumentFilter.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        File pathname = null;
        DocumentFilter instance = new DocumentFilter();
        boolean expResult = false;
        boolean result = instance.accept(pathname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
