/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

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
public class HelpTest {
    
    public HelpTest() {
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
     * Test of loadFiles method, of class Help.
     */
    @Test
    public void testLoadFiles() {
        System.out.println("loadFiles");
        File f = null;
        Help instance = new Help();
        instance.loadFiles(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSelectedFile method, of class Help.
     */
    @Test
    public void testShowSelectedFile() throws Exception {
        System.out.println("showSelectedFile");
        String selectedValue = "";
        Help instance = new Help();
        instance.showSelectedFile(selectedValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Help.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Help.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
