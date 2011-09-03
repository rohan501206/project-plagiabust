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
public class NumberRemoverTest {
    
    public NumberRemoverTest() {
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
     * Test of removeNumbersAndOtherChars method, of class NumberRemover.
     */
    @Test
    public void testRemoveNumbersAndOtherChars() {
        System.out.println("removeNumbersAndOtherChars");
        String input = "udana12chathuranga @ 123";
        NumberRemover instance = new NumberRemover();
        String expResult = "udanachathuranga";
        String result = instance.removeNumbersAndOtherChars(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}
