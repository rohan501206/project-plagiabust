/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import documenttypesupport.AnyToTextConverter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import peerdocumentsearch.TextFileIndexer;

/**
 *
 * @author nuwan
 */
public class FileOperator {

    public String sourceFolder;
    public String destinationFolder;
    public String indexFolderPath;



    public FileOperator(String sourceFolder){


        this.sourceFolder=sourceFolder;
    }


    public FileOperator(){


        
    }


    public void anyToTextConverter(){


        File souceFolder = new File(sourceFolder);

        if (souceFolder.isDirectory()) {
            destinationFolder = souceFolder.getAbsolutePath() + File.separator + souceFolder.getName();
            boolean destFolderCreated = new File( destinationFolder).mkdir();
            if (destFolderCreated) {
                AnyToTextConverter tc = new AnyToTextConverter(destinationFolder);
                tc.convertFilesInFolder(sourceFolder);
            }
        }




    }

    public String getDestinatonFolderPath(){
        return destinationFolder;
    }

    public String getIndexFolderPath(){
        return indexFolderPath;
    }



    public void TextFileIndexer(){

        TextFileIndexer indexer = null;
        String doucmentFolderPath = destinationFolder;
        File documentFolder = new File(doucmentFolderPath);
        indexFolderPath = documentFolder.getAbsolutePath() + File.separator + documentFolder.getName() + "_Index";
        try {
            indexer = new TextFileIndexer(indexFolderPath);
            indexer.indexFileOrDirectory(doucmentFolderPath);
            indexer.closeIndex();
        } catch (Exception ex) {
        }


    }

    public String[] textSetter(String fileName1, String fileName2){

        String[] text=new String[2];
        File testFile1 = new File(fileName1);
        File testFile2 = new File(fileName2);
        String field1 = "";
        String field2 = "";
        try {
            FileReader fr = new FileReader(testFile1);
            FileReader fr2 = new FileReader(testFile2);

            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(fr2);
            System.out.println("testing phase");
            try {
                while (br.readLine() != null) {
                    field1 = field1 + br.readLine();
                }
                while (br2.readLine() != null) {
                    field2 = field2 + br2.readLine();
                }

            } catch (IOException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        text[0]=field1;
        text[1]=field2;


        return text;







    }






}
