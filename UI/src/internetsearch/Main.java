/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package internetsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JProgressBar;

/**
 *
 * @author Brave Heart
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JProgressBar pbar2 = null;
        // TODO code application logic here
        /*BingSearch bs = new BingSearch();
        bs.setBingAppID("F138552F897E2CA7C264FDAC64F8EF2021ABD3AF");
        ArrayList<ResponseResult> rslist = bs.searchInternet("father");
        for (Iterator<ResponseResult> it = rslist.iterator(); it.hasNext();) {
            ResponseResult responseResult = it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(responseResult.getDescription() + "\n");
            sb.append(responseResult.getUrl() + "\n");
            System.out.println(sb.toString());
        }*/

        ArrayList<String> fileList = new ArrayList<String>();
        fileList.add("C:/Users/Brave Heart/Desktop/New folder/060112A_SoftwareArchitectureDocument.txt");
        fileList.add("C:/Users/Brave Heart/Desktop/New folder/060501P-CS3200-Software_Architecture_Document_2.txt");
        fileList.add("C:/Users/Brave Heart/Desktop/New folder/070014J_Software_Architecture_Document.txt");
        BingSearch bingSearch = new BingSearch("F138552F897E2CA7C264FDAC64F8EF2021ABD3AF");
        bingSearch.setMaxNumOfResults(5);
        InternetSearchManager sd = new InternetSearchManager(bingSearch);
        sd.setRandomSelectionRatio(0.1f);
        HashMap<String, ArrayList<String>> map = sd.downloadSourcesForFileFolder(fileList, "C:/Users/Brave Heart/Desktop/New folder",pbar2);
        
        Iterator mapIterator = map.entrySet().iterator();
        while(mapIterator.hasNext())
        {
            Map.Entry pair = (Map.Entry) mapIterator.next();
            String filePath = (String) pair.getKey();
            ArrayList<String> downloadedFileList = (ArrayList<String>) pair.getValue();
            System.out.println(filePath);
            for (Iterator<String> it = downloadedFileList.iterator(); it.hasNext();) {
                String string = it.next();
                System.out.println(string);
            }
            
            System.out.println("!!!!!!!!!!!!!!!!!!");
        }

    }

        
    

}
