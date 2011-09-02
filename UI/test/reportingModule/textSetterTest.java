/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

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
public class textSetterTest {
    
    public textSetterTest() {
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
     * Test of main method, of class textSetter.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        textSetter.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of textSetter method, of class textSetter.
     */
    @Test
    public void testTextSetter() {
        System.out.println("textSetter");
        String fileName1 = "";
        textSetter instance = new textSetter();
        String expResult = "";
        String result = instance.textSetter(fileName1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
