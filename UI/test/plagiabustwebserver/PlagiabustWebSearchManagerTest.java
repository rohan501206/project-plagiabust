/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiabustwebserver;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JProgressBar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import querycreator.QuerySelectionAlgorithm;

/**
 *
 * @author Kasun
 */
public class PlagiabustWebSearchManagerTest {
    
    public PlagiabustWebSearchManagerTest() {
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
     * Test of setQuerySelectionAlgorithm method, of class PlagiabustWebSearchManager.
     */
    @Test
    public void testSetQuerySelectionAlgorithm() {
        System.out.println("setQuerySelectionAlgorithm");
        QuerySelectionAlgorithm selectionAlgo = null;
        PlagiabustWebSearchManager instance = null;
        instance.setQuerySelectionAlgorithm(selectionAlgo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuerySelectionAlgorithm method, of class PlagiabustWebSearchManager.
     */
    @Test
    public void testGetQuerySelectionAlgorithm() {
        System.out.println("getQuerySelectionAlgorithm");
        PlagiabustWebSearchManager instance = null;
        QuerySelectionAlgorithm expResult = null;
        QuerySelectionAlgorithm result = instance.getQuerySelectionAlgorithm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of downloadSourcesForFile method, of class PlagiabustWebSearchManager.
     */
    @Test
    public void testDownloadSourcesForFile() {
        System.out.println("downloadSourcesForFile");
        String filePath = "";
        JProgressBar pbar = null;
        PlagiabustWebSearchManager instance = null;
        String expResult = "";
        String result = instance.downloadSourcesForFile(filePath, pbar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdList method, of class PlagiabustWebSearchManager.
     */
    @Test
    public void testGetIdList() {
        System.out.println("getIdList");
        PlagiabustWebSearchManager instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getIdList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdFileMap method, of class PlagiabustWebSearchManager.
     */
    @Test
    public void testGetIdFileMap() {
        System.out.println("getIdFileMap");
        PlagiabustWebSearchManager instance = null;
        HashMap expResult = null;
        HashMap result = instance.getIdFileMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of downloadSourcesForFileFolder method, of class PlagiabustWebSearchManager.
     */
    @Test
    public void testDownloadSourcesForFileFolder() {
        System.out.println("downloadSourcesForFileFolder");
        ArrayList<String> filePathList = null;
        String fileFolderPath = "";
        JProgressBar pbar = null;
        PlagiabustWebSearchManager instance = null;
        HashMap expResult = null;
        HashMap result = instance.downloadSourcesForFileFolder(filePathList, fileFolderPath, pbar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxNumOfSourcesPerDocument method, of class PlagiabustWebSearchManager.
     */
    @Test
    public void testGetMaxNumOfSourcesPerDocument() {
        System.out.println("getMaxNumOfSourcesPerDocument");
        PlagiabustWebSearchManager instance = null;
        int expResult = 0;
        int result = instance.getMaxNumOfSourcesPerDocument();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxNumOfSourcesPerDocument method, of class PlagiabustWebSearchManager.
     */
    @Test
    public void testSetMaxNumOfSourcesPerDocument() {
        System.out.println("setMaxNumOfSourcesPerDocument");
        int maxNumOfSourcesPerDocument = 0;
        PlagiabustWebSearchManager instance = null;
        instance.setMaxNumOfSourcesPerDocument(maxNumOfSourcesPerDocument);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
