package uibase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Font;
import javax.jws.soap.SOAPBinding.Style;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Brave Heart
 */
public class ButtonBase extends JButton {

    private int horizontalAlignment = SwingConstants.LEFT;
    private int verticleAlignment = SwingConstants.CENTER;
    private Font font = new Font("Tahoma", Font.PLAIN, 18);;

    public ButtonBase() {
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
        super.setHorizontalAlignment(alignment);
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
    }
}
