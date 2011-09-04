/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.PopupFactory;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**

 * @author nuwan
 *
 */
public class SourceViewer implements KeyListener, MouseListener, FocusListener, HyperlinkListener {

    private JFrame popup;
    private JPanel toolTip;
    private JScrollPane help;
    private JEditorPane h;
    private JComponent owner;
    private JEditorPane browser;
    private JPanel browserpanel;
    private boolean helpActive = false;
    private Thread t;
    private int WIDTH_HTML = 400;
    private int WIDTH_SC = 600;
    private int HEIGHT_SC = 200;
    private int WIDTH_TT = 400;
    private int HEIGHT_TT = 100;

    public SourceViewer(String toolTipText, String helpText, JComponent owner, JEditorPane browser, JPanel browserpanel) {
        this.owner = owner;
        this.browser = browser;
        this.browserpanel = browserpanel;
        owner.addMouseListener(this);
        JPanel helpContent = new JPanel();
        helpContent.setBackground(Color.WHITE);
        h = new JEditorPane();
        h.setEditable(false);
        h.setContentType("text/html");
        h.addHyperlinkListener(this);
        String context = "<html><body><table width='" + WIDTH_HTML + "'><tr><td><p><font size=+1>" + toolTipText + "</font></p>" + helpText + "</td></tr></table></body></html>";
        h.setText(context);
        helpContent.add(h);
        help = new JScrollPane(helpContent);
        help.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        help.setPreferredSize(new Dimension(WIDTH_SC, HEIGHT_SC));
        popup = new JFrame();
        popup.setUndecorated(true);
        helpActive = true;
        popup.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        popup.add(help);
        popup.pack();
        popup.setVisible(true);
        h.requestFocus();
        h.addFocusListener(this);
    }

    public void keyPressed(KeyEvent arg0) {
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }

    public void mouseClicked(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {

        if (!helpActive) {
            popup.setVisible(false);
        }
    }

    public void mousePressed(MouseEvent arg0) {
    }

    public void mouseReleased(MouseEvent arg0) {
    }

    public void focusGained(FocusEvent arg0) {
    }

    /**
     * user clicked somewhere else hide popUp.
     */
    public void focusLost(FocusEvent arg0) {
        helpActive = false;
        popup.setVisible(false);
    }

    /**
     * The hyperlink listener for the tooltip
     */
    public void hyperlinkUpdate(HyperlinkEvent event) {
        if (event.getEventType()
                == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                browser.setPage(event.getURL());
                browserpanel.setVisible(true);
                Thread.sleep(2000);
                URL s = event.getURL();
                URI uri = null;
                try {
                    uri = new URI(s.toString());
                } catch (URISyntaxException ex) {
                    Logger.getLogger(ReportHyperlinkListner.class.getName()).log(Level.SEVERE, null, ex);
                }
                open(uri);
            } catch (InterruptedException ex) {
                Logger.getLogger(SourceViewer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SourceViewer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * open the url in the browser
     * @param uri
     */
    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(uri);
            } catch (IOException e) {
            }
        } else {
        }
    }
}
