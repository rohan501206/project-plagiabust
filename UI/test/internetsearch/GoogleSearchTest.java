/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

import gui.form.AdminInforForm;
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
public class GoogleSearchTest {
    
    public GoogleSearchTest() {
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
     * Test of searchInternet method, of class GoogleSearch.
     */
    @Test
    public void testSearchInternet() {
        System.out.println("searchInternet");
        String search = "plagiarism";
        GoogleSearch instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.searchInternet(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
