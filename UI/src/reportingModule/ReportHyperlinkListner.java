/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRHyperlink;
import net.sf.jasperreports.engine.JRPrintHyperlink;
import net.sf.jasperreports.view.JRHyperlinkListener;

/**
 *
 * @author user
 */
public class ReportHyperlinkListner implements JRHyperlinkListener {




    public void gotoHyperlink(JRPrintHyperlink jrph) throws JRException {

      
        String hyperlink= jrph.getHyperlinkReference();          
        if(hyperlink!=null){
        URI uri = null;
        try {
            uri = new URI(hyperlink);
        } catch (URISyntaxException ex) {


        }
        this.open(uri);
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
                
        }
    }

}
