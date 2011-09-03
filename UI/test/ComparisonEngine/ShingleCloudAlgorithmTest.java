/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparisonEngine;

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
public class ShingleCloudAlgorithmTest {
    
    public ShingleCloudAlgorithmTest() {
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
     * Test of getSimilarity method, of class ShingleCloudAlgorithm.
     */
    @Test
    public void testGetSimilarity() {
        String input1 = "This is a test";
        String input2 = "This is a test";
        ShingleCloudAlgorithm instance = new ShingleCloudAlgorithm();
        float expResult = 0.0F;
        float result = instance.getSimilarity(input1, input2);
        assertEquals(2, result, 0.0);
    }
}
