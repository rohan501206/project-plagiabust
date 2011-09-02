/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiabustwebserver;

import java.util.List;
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
public class AddDocumentsBackgroundWorkerTest {
    
    public AddDocumentsBackgroundWorkerTest() {
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
     * Test of doInBackground method, of class AddDocumentsBackgroundWorker.
     */
    @Test
    public void testDoInBackground() {
        System.out.println("doInBackground");
        AddDocumentsBackgroundWorker instance = null;
        Integer expResult = null;
        Integer result = instance.doInBackground();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of process method, of class AddDocumentsBackgroundWorker.
     */
    @Test
    public void testProcess() {
        System.out.println("process");
        List<Integer> publishedVals = null;
        AddDocumentsBackgroundWorker instance = null;
        instance.process(publishedVals);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
