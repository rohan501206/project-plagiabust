/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiabustwebserver;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
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
public class ClientTest {
    
    public ClientTest() {
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
     * Test of deleteAllDocumentFromServer method, of class Client.
     */
    @Test
    public void testDeleteAllDocumentFromServer() {
        System.out.println("deleteAllDocumentFromServer");
        Client instance = new Client();
        instance.deleteAllDocumentFromServer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commitDocumentAsBackGroundWork method, of class Client.
     */
    @Test
    public void testCommitDocumentAsBackGroundWork() {
        System.out.println("commitDocumentAsBackGroundWork");
        JProgressBar progressBar = null;
        JLabel label = null;
        ArrayList<String> fileList = null;
        JTextArea textArea = null;
        Client instance = new Client();
        instance.commitDocumentAsBackGroundWork(progressBar, label, fileList, textArea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commitDocumentsToSolrServer method, of class Client.
     */
    @Test
    public void testCommitDocumentsToSolrServer() {
        System.out.println("commitDocumentsToSolrServer");
        ArrayList<String> fileList = null;
        Client instance = new Client();
        instance.commitDocumentsToSolrServer(fileList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContentById method, of class Client.
     */
    @Test
    public void testGetContentById() {
        System.out.println("getContentById");
        String id = "";
        Client instance = new Client();
        String expResult = "";
        String result = instance.getContentById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQueryResponse method, of class Client.
     */
    @Test
    public void testGetQueryResponse() {
        System.out.println("getQueryResponse");
        String query = "";
        Client instance = new Client();
        ArrayList expResult = null;
        ArrayList result = instance.getQueryResponse(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
