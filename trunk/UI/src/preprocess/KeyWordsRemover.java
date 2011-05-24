/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Compaq
 */
public class KeyWordsRemover {

    public void addKeyWordsToList(String fileName, String content) {
        File file = new File(fileName);
        try {
            if (file.exists()) {
                FileWriter fw = new FileWriter(file, true);
                fw.write(content);
                fw.close();
            }
        } catch (IOException ex) {
        }

    }
}