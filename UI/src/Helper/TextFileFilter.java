/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Helper;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author nuwan
 */
public class TextFileFilter implements FileFilter {

    public boolean accept(File file) {
        if (file.getName().endsWith(".txt")){
            return true;
        }
    else{
      return false;
    }

}
}
