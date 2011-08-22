/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.form;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Compaq
 */
public class ReportData {
    private HashMap<String,String[]> downloadFolderPath ;
    private ArrayList<String> urlList;
    private HashMap<String, String> map;
    public ReportData(HashMap<String,String[]> adownloadFolderPath,ArrayList<String> aurlList){
        this.downloadFolderPath = adownloadFolderPath;
        this.urlList = aurlList;
    }

    public ReportData(HashMap<String,String[]> adownloadFolderPath,HashMap<String, String> amap){
        this.downloadFolderPath = adownloadFolderPath;
        this.map = amap;
    }


     public ReportData(HashMap<String,String[]> adownloadFolderPath,HashMap<String, String> amap,ArrayList<String> aurlList){
        this.downloadFolderPath = adownloadFolderPath;
        this.map = amap;
        this.urlList = aurlList;
    }

    public ArrayList<String> getUrlList(){
        return this.urlList;
    }

    public HashMap<String,String[]> getFolder(){
        return this.downloadFolderPath;
    }

    public HashMap<String, String> getFileUrlMap(){
        return this.map;
    }

}
