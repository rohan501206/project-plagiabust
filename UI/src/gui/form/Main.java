/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import ch.randelshofer.quaqua.QuaquaButtonUI;
import ch.randelshofer.quaqua.QuaquaManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.vecmath.Color3b;

/**
 *
 * @author Brave Heart
 */
public class Main {

    public static void main(String[] args) {

        // Set look and feel
        try {            
            System.setProperty("Quaqua.design", "panther");
            UIManager.setLookAndFeel(QuaquaManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        MainForm.getInstance().setVisible(true);
    }
}
