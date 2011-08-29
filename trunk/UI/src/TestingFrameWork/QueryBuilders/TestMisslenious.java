/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingFrameWork.QueryBuilders;

import documenttypesupport.AnyToTextConverter;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Brave Heart
 */
public class TestMisslenious {
    public static void main(String[] args){

        JFileChooser  fc = new JFileChooser(System.getProperty("user.home") + File.separatorChar + "desktop");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        AnyToTextConverter tc = new AnyToTextConverter(System.getProperty("user.home") + File.separatorChar + "desktop");
        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            tc.convertSingleFile(fc.getSelectedFile().getAbsolutePath());
        }
    }


}
