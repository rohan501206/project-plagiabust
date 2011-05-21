/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uibase;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Brave Heart
 */
public class TextFieldBase extends JTextField {

    private int horizontalAlignment = SwingConstants.LEFT;
    private int verticleAlignment = SwingConstants.CENTER;
    private Font buttonFont = new Font("Tahoma", Font.PLAIN, 18);

    public TextFieldBase() {
        this.setHorizontalAlignment(horizontalAlignment);
        this.setVerticleAlignment(verticleAlignment);
        this.setFont(buttonFont);
    }

    @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(alignment);
    }

    public void setVerticleAlignment(int verticleAlignment) {
        this.verticleAlignment = verticleAlignment;
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
    }
}
