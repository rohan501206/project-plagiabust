/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import javax.swing.SwingWorker;
import reportingModule.ReportingModule;
import reportingModule.MsgBox;
/**
 *
 * @author Compaq
 */
public class ReportWorker extends SwingWorker<ReportingModule, String> {

    String selectedDocumentPath;
    ReportData repdata;
    ReportingModule rp = new ReportingModule();

    public ReportWorker(String aselectedDocumentPath, ReportData arepdata) {
        this.repdata = arepdata;
        this.selectedDocumentPath = aselectedDocumentPath;

    }

    @Override
    protected ReportingModule doInBackground() throws Exception {
        //MsgBox msg =new MsgBox(rp,true);
       // msg.setVisible(true);
        //rp.setVisible(true);
        System.out.println("Generating Results Please Wait...............");

        rp.setDocument(selectedDocumentPath);
        rp.setTemp(repdata.getFolder());
        rp.setUrl(repdata.getUrlList());
        rp.setMap(repdata.getFileUrlMap());
        rp.setData();
        System.err.print("end");
        //msg.setVisible(false);

        return rp;
    }
}
