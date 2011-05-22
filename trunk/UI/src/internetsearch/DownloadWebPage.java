/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package internetsearch;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.htmlparser.beans.StringBean;

/**
 *
 * @author Compaq
 */
public class DownloadWebPage implements Runnable {
    HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();
    int downloadedDocuments = 1;
    String downloadedFilesFolder;

    public DownloadWebPage(HashMap<String, Integer> selectedSources, String downloadedFilesFolder){
        this.selectedSources = selectedSources;
        this.downloadedFilesFolder = downloadedFilesFolder;
    }

    public void run() {
        Iterator it = selectedSources.entrySet().iterator();
        while (it.hasNext()) {
        System.out.println(Thread.currentThread().getName() + " counter="+ it);
            Map.Entry pair = (Map.Entry) it.next();
            String url = (String) pair.getKey();
            String path = downloadedFilesFolder + File.separatorChar + downloadedDocuments + ".txt";
            downloadedDocuments++;
            try {
                this.downloadWebPageAsText(url, path); // secondcall
            } catch (IOException ex) {
                Logger.getLogger(DownloadWebPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


     private void downloadWebPageAsText(String url, String fileName) throws IOException { // most time consumming task
        String content = "";
        StringBean stringBean = new StringBean();
        stringBean.setURL(url);
        content = stringBean.getStrings();
        File file = new File(fileName);
        try {
            file.createNewFile();
            if (file.exists()) {
                FileWriter fw = new FileWriter(file, false);
                fw.write(content);
                fw.close();
            }
        } catch (IOException ex) {
        }
    }


}
