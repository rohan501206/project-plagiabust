/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

/**
 * Copyright (2008)
 * Denis Bauer
 *
 */

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.PopupFactory;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


/**
 * Generates an expandable ToolTip, which is a popup dispaying a short description
 * of the component (ToolTip) but also, when focused, allows for displaying a
 * longer help text
 * @author d.bauer
 *
 */
public class ExpandableToolTip  implements KeyListener, MouseListener, FocusListener, HyperlinkListener {
	JFrame popup;				// PopUp
	JPanel toolTip;				// panel holding the tooltip and information how to expand
	JScrollPane help;			// panel holding the help text
	JEditorPane h;				// editor containing the help text (hyperlinks)
	JComponent owner;			// JCompontent the ToolTip was attached to
        JEditorPane browser;
	PopupFactory factory;		// factory for generating the different popUps
	int x;						// X location for popUp
	int y;						// Y location for popUp
	boolean helpActive=false;	// switch indicating if the interactiv help popUp is active
	Thread t;					// sleeping thread
	int WIDTH_HTML=400;			// width of table in the HTML code
	int WIDTH_SC=400;			// associated width of the help window
	int HEIGHT_SC=100;			// height of the help window
	int WIDTH_TT=300;			// width of the toolTip window
	int HEIGHT_TT=25;			// height of the toolTip window
	/**
	 * Generates the two display panels that are shown
	 * @param toolTipText
	 * @param helpText
	 * @param owner
	 */

	public ExpandableToolTip(String toolTipText, String helpText,JComponent owner, JEditorPane browser){
		this.owner = owner;
                this.browser=browser;
		/* Attach mouseListener to component.
		 * If we attach the toolTip to a JComboBox our MouseListener is not
		 * used, we therefore need to attach the MouseListener to each
		 * component in the JComboBox
		 */
			
		owner.addMouseListener(this) ;		
		JPanel helpContent = new JPanel();
		helpContent.setBackground(Color.WHITE);

		/* generate editor to display html help text and put in scrollpane*/
		h = new JEditorPane();
		h.setContentType("text/html");
		h.addHyperlinkListener(this);
		String context = "<html><body><table width='"+WIDTH_HTML+"'><tr><td><p><font size=+1>"+toolTipText+"</font></p>"+helpText+"</td></tr></table></body></html>";
		h.setText(context);
		h.setEditable(false);
		h.addHyperlinkListener(this);
		helpContent.add(h);
		help = new JScrollPane(helpContent);
		help.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		help.setPreferredSize(new Dimension(WIDTH_SC,HEIGHT_SC));
		popup=new JFrame();
		popup.setUndecorated(true);
                helpActive=true;

		popup.setLocation(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
		popup.add(help);
		popup.pack();
		popup.setVisible(true);

			/* request Focus in editor so that it can be hidden when focus is lost */
			h.requestFocus();
			h.addFocusListener(this);


	}

	public void keyPressed(KeyEvent arg0) {




	}

	public void keyReleased(KeyEvent arg0) {

	}

	/**
	 * If 'd' was typed swap toolTip-popUp with help-popup and
	 * set helpActive to true to prevent that the mouseExited
	 * event causes the popup to go away.
	 */
	public void keyTyped(KeyEvent arg0) {
		if(arg0.getKeyChar()=='d'){
			helpActive=true;
			try{
				popup.remove(toolTip);
			}
			catch(Exception e){}
			popup.setLocation(x,y);
			popup.add(help);
			popup.pack();
			popup.setVisible(true);

			/* request Focus in editor so that it can be hidden when focus is lost */
			h.requestFocus();
			h.addFocusListener(this);

		}
	}

	public void mouseClicked(MouseEvent arg0) {




	}

	public void mouseEntered(MouseEvent arg0) {



    }

	/**
	 * Hide popUp if not 'd' was pressed before and the help popUp is now displayed
	 */
	public void mouseExited(MouseEvent arg0) {

		/* interrupt sleep because mouse was moved away from the object */
		//arg0.consume();
		//t.interrupt();

		if(!helpActive){
			popup.setVisible(false);
		}
	}

	public void mousePressed(MouseEvent arg0) {
		//t.interrupt();
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void focusGained(FocusEvent arg0) {
	}

	/**
	 * If the focus is lost (user clicked somwhere else) hide popUp.
	 */
	public void focusLost(FocusEvent arg0) {
		helpActive=false;
		popup.setVisible(false);
	}

	/**
	 * Do something with the Hyperlink
	 */
	public void hyperlinkUpdate(HyperlinkEvent event) {
        try {
            //TODO add open link in default browser
            browser.setPage(event.getURL());
            /*URL s= event.getURL();
            URI uri = null;
            try {
            uri = new URI(s.toString());
            } catch (URISyntaxException ex) {
            Logger.getLogger(ReportHyperlinkListner.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.open(uri);*/
        } catch (IOException ex) {
            Logger.getLogger(ExpandableToolTip.class.getName()).log(Level.SEVERE, null, ex);
        }

			
		}

	

       private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                        desktop.browse(uri);
                } catch (IOException e) {
                        // TODO: error handling
                }
        } else {
                // TODO: error handling
        }
    }

	public static void main(String[] args){

		
	}


}
