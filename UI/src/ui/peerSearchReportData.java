/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Compaq
 */
public class peerSearchReportData {

    private HashMap<String, HashMap<String,String>> internetFilesReportData ;
    private HashMap<String, HashMap<String,String>> peerFilesReportData ;


    public HashMap<String, HashMap<String,String>> getInternetFilesReportData(){
        return this.internetFilesReportData;
    }

    public HashMap<String, HashMap<String,String>> getPeerFilesReportData(){
        return this.peerFilesReportData;
    }

    public void setInternetFilesReportData(String checkingFile, HashMap<String,String> internetSouceFileMatchMap){
        this.internetFilesReportData.put(checkingFile, internetSouceFileMatchMap);
    }

    public void setPeerFilesReportData(String checkingFile, HashMap<String,String> peerSouceFileMatchMap){
         this.internetFilesReportData.put(checkingFile, peerSouceFileMatchMap);
    }

}
