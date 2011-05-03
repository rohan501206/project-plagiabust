/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ComparisonEngine;

import de.tud.kom.stringmatching.shinglecloud.ShingleCloud;
import de.tud.kom.stringmatching.shinglecloud.ShingleCloudMatch;
import java.util.List;

/**
 *
 * @author kasun
 */
public class ShingleCloudAlgorithm {
    List <ShingleCloudMatch> shingleCloudMatchlist;
    String result = "";
    public float getSimilarity(String input1, String input2) {
        /* preparing the match object */

        
        ShingleCloud sc = new ShingleCloud(input1);
        sc.setNGramSize(4);
        sc.setMinimumNumberOfOnesInMatch(6);
        sc.setSortMatchesByRating(false);

        /* searching for the needle */
        sc.match(input2);

        /* displaying results */
        //result = "ShingleCloud Algorithm\n";
        System.out.println("-------------------------------ShingleCloud----------------------------------");
       // result = result + "ShingleCloud found " + sc.getMatches().size() + " match(es).\n\n";
        System.out.println("ShingleCloud found " + sc.getMatches().size() + " match(es).");

        float containmentInHaystack = 0;
        float containmentInNeedle = 0;
        shingleCloudMatchlist = sc.getMatches();

        for (int i = 0; i < sc.getMatches().size(); i++) {
            ShingleCloudMatch match = sc.getMatches().get(i);
            result = result+match.getMatchedShingles()+":";
            //System.out.println("The matching shingles were: " + match.getMatchedShingles()+"\n")
            containmentInHaystack += match.getContainmentInHaystack();
            containmentInNeedle += match.getContainmentInNeedle();
        }

       // result = result + "Total Containment InHaystack " + containmentInHaystack+"\n";
       //System.out.println("Total Containment InHaystack " + containmentInHaystack);
      // result = result + "Totla Containment InNeedle " + containmentInNeedle;
       // System.out.println("Totla Containment InNeedle " + containmentInNeedle);
        float plagiarismValue = containmentInHaystack+containmentInNeedle;
        return plagiarismValue;
    }


    public String getList(){
        return this.result;
    }





}