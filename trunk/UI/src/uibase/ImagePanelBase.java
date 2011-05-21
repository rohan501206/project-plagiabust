/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uibase;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Brave Heart
 */
public class ImagePanelBase extends JPanel {

    private Image panelImage;

    public ImagePanelBase(String imagePath) {
        panelImage = new ImageIcon(imagePath).getImage();
        Dimension size = new Dimension(panelImage.getWidth(null), panelImage.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(panelImage, 0, 0, null);
    }
}