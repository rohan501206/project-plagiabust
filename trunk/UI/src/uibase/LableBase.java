/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uibase;

import java.awt.Font;
import javax.swing.SwingConstants;

/**
 *
 * @author Brave Heart
 */
public class LableBase extends javax.swing.JLabel {

    private int horizontalAlignment = SwingConstants.LEFT;
    private int verticleAlignment = SwingConstants.CENTER;
    private Font font = new Font("Tahoma", Font.PLAIN, 18);

    public LableBase() {
        this.setHorizontalAlignment(horizontalAlignment);
        this.setVerticalAlignment(verticleAlignment);
        this.setFont(font);
    }

    @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(alignment);
    }

    @Override
    public void setVerticalAlignment(int alignment) {
        super.setVerticalAlignment(alignment);
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
    }
}
