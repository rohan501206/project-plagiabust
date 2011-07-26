/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.form;

import java.io.File;

/**
 *
 * @author Kasun
 */
public class FileChooserFilter extends javax.swing.filechooser.FileFilter{

    @Override
    public boolean accept(File pathname) {
         if (pathname.getName().endsWith(".txt")) {
            return true;
        }
        if (pathname.getName().endsWith(".pdf")) {
            return true;
        }
        if (pathname.getName().endsWith(".rtf")) {
            return true;
        }
        if (pathname.getName().endsWith(".doc")) {
            return true;
        }
        if (pathname.getName().endsWith(".docx")) {
            return true;
        }
        if (pathname.isDirectory()) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "";
    }

}
