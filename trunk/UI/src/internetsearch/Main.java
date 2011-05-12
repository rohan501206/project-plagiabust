/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package internetsearch;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Brave Heart
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

        BingSearch bingSearch = new BingSearch("F138552F897E2CA7C264FDAC64F8EF2021ABD3AF");
        bingSearch.setMaxNumOfResults(5);
        InternetSearchManager sd = new InternetSearchManager(bingSearch);
        sd.setRandomSelectionRatio(0.75f);
        sd.downloadSourcesForFile("C:/Users/Brave Heart/Desktop/New Text Document.txt");
        }

        
    

}
