/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.form;

import java.util.ArrayList;

/**
 *
 * @author Compaq
 */
public class ReportData {
    private String[][] downloadFolderPath ;
    private ArrayList<String> urlList;

    public ReportData(String[][] adownloadFolderPath,ArrayList<String> aurlList){
        this.downloadFolderPath = adownloadFolderPath;
        this.urlList = aurlList;
    }

    public ArrayList<String> getUrlList(){
        return this.urlList;
    }

    public String[][] getFolder(){
        return this.downloadFolderPath;
    }

}
