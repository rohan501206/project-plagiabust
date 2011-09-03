/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

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
public class ProgressBarManagerTest {
    
    public ProgressBarManagerTest() {
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
     * Test of runProgress method, of class ProgressBarManager.
     */
    @Test
    public void testRunProgress() {
        System.out.println("runProgress");
        int presentage = 0;
        ProgressBarManager instance = null;
        instance.runProgress(presentage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBar method, of class ProgressBarManager.
     */
    @Test
    public void testUpdateBar() {
        System.out.println("updateBar");
        int newValue = 0;
        ProgressBarManager instance = null;
        instance.updateBar(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
