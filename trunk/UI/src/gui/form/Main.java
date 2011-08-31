/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import ch.randelshofer.quaqua.QuaquaManager;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Brave Heart
 */
public class Main {

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
