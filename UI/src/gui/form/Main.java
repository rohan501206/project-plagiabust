/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import ch.randelshofer.quaqua.QuaquaManager;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Brave Heart
 */
public class Main {
    
    private static File desktop = new File(System.getProperty("user.home") + File.separatorChar + "Desktop");

    public static File getDesktop(){
        return desktop;
    }

    public static void main(String[] args) {

        // Set look and feel
        try {
            System.setProperty("Quaqua.design", "jaguar");
            UIManager.setLookAndFeel(QuaquaManager.getLookAndFeel());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error", "Couldn't apply quaqua", JOptionPane.ERROR_MESSAGE);
        }
        MainForm.getInstance().setVisible(true);
    }
}
