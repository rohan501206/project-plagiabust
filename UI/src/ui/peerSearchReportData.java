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

    private HashMap<String, HashMap<String,String[]>> internetFilesReportData = new HashMap<String, HashMap<String,String[]>>() ;
    private HashMap<String, HashMap<String,String[]>> peerFilesReportData = new HashMap<String, HashMap<String,String[]>>();
    private HashMap<String ,String> peerUrlList = new HashMap<String, String>();

    public HashMap<String, HashMap<String,String[]>> getInternetFilesReportData(){
        return this.internetFilesReportData;
    }

    public HashMap<String, HashMap<String,String[]>> getPeerFilesReportData(){
        return this.peerFilesReportData;
    }

    public void setInternetFilesReportData(String checkingFile, HashMap<String,String[]> internetSouceFileMatchMap){
        this.internetFilesReportData.put(checkingFile, internetSouceFileMatchMap);
    }

    public void setPeerFilesReportData(String checkingFile, HashMap<String,String[]> peerSouceFileMatchMap){
         this.peerFilesReportData.put(checkingFile, peerSouceFileMatchMap);
    }

    public void setPeerUrlList(HashMap<String ,String> aPeerUrlList){
        this.peerUrlList = aPeerUrlList;
    }
    
    public HashMap<String ,String> getPeerUrlList(){
        return this.peerUrlList;
    }
    
    
    
}
