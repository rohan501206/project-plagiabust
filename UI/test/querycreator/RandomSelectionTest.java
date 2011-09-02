/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

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
public class RandomSelectionTest {
    
    public RandomSelectionTest() {
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
     * Test of setSelectedSentenceRatio method, of class RandomSelection.
     */
    @Test
    public void testSetSelectedSentenceRatio() {
        System.out.println("setSelectedSentenceRatio");
        float ratio = 0.0F;
        RandomSelection instance = new RandomSelection();
        instance.setSelectedSentenceRatio(ratio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedSentenceRatio method, of class RandomSelection.
     */
    @Test
    public void testGetSelectedSentenceRatio() {
        System.out.println("getSelectedSentenceRatio");
        RandomSelection instance = new RandomSelection();
        float expResult = 0.0F;
        float result = instance.getSelectedSentenceRatio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
