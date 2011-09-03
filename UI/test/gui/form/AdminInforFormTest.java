/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import internetsearch.InternetSearchAPI;
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
public class AdminInforFormTest {
    
    public AdminInforFormTest() {
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
     * Test of getInternetSearchAPI method, of class AdminInforForm.
     */
    @Test
    public void testGetInternetSearchAPI() {
        System.out.println("getInternetSearchAPI");
        InternetSearchAPI expResult = null;
        InternetSearchAPI result = AdminInforForm.getInternetSearchAPI();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDefaults method, of class AdminInforForm.
     */
    @Test
    public void testSetDefaults() {
        System.out.println("setDefaults");
        AdminInforForm instance = new AdminInforForm();
        instance.setDefaults();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
