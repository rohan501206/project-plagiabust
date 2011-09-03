/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocess;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.codehaus.groovy.ant.FileScanner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Compaq
 */
public class KeyWordsRemoverTest {

    public KeyWordsRemoverTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of addKeyWordsToList method, of class KeyWordsRemover.
     */
    @Test
    public void testAddKeyWordsToList() throws FileNotFoundException, IOException {
        System.out.println("addKeyWordsToList");
        String fileName = "test" + File.separatorChar + "preprocess" + File.separatorChar + "StopwordListTest";
        String content = "Table of Content";
        KeyWordsRemover instance = new KeyWordsRemover();
        instance.addKeyWordsToList(fileName, content);
        String result = this.testAddkeyWordsToListHelp();
        System.out.println(result);
        assertEquals(content,result);

    }

    public String testAddkeyWordsToListHelp() throws FileNotFoundException, IOException{
        String content = null;
        String fileName = "test" + File.separatorChar + "preprocess" + File.separatorChar + "StopwordListTest";
        FileInputStream fstream = new FileInputStream(fileName);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine = "Table of Content";
        
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            //System.out.println (strLine);
            strLine = br.readLine();
        }
        in.close();
       return strLine;
    }






}