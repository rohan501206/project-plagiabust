/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ComparisonEngine;

import de.tud.kom.stringmatching.shinglecloud.ShingleCloud;
import de.tud.kom.stringmatching.shinglecloud.ShingleCloudMatch;

/**
 *
 * @author kasun
 */
public class ShingleCloudAlgorithm {

    public String getSimilarity(String input1, String input2) {
        /* preparing the match object */

        String result;
        ShingleCloud sc = new ShingleCloud(input1);
        sc.setNGramSize(4);
        sc.setMinimumNumberOfOnesInMatch(6);
        sc.setSortMatchesByRating(false);

        /* searching for the needle */
        sc.match(input2);

        /* displaying results */
        result = "ShingleCloud Algorithm\n";
        System.out.println("-------------------------------ShingleCloud----------------------------------");
        result = result + "ShingleCloud found " + sc.getMatches().size() + " match(es).\n\n";
        System.out.println("ShingleCloud found " + sc.getMatches().size() + " match(es).");

        float containmentInHaystack = 0;
        float containmentInNeedle = 0;

        for (int i = 0; i < sc.getMatches().size(); i++) {
            ShingleCloudMatch match = sc.getMatches().get(i);

            result = result + "The "+i+" match consists of "
                                     + match.getNumberOfMatchedShingles() + " shingle(s).\n";
            System.out.println("The "+i+" match consists of "
                                     + match.getNumberOfMatchedShingles() + " shingle(s).");

             result = result + "Containment InHaystack " + match.getContainmentInHaystack()+ "\n";
            System.out.println("Containment InHaystack " + match.getContainmentInHaystack());
            result = result + "Containment InNeedle " + match.getContainmentInNeedle()+"\n";
            System.out.println("Containment InNeedle " + match.getContainmentInNeedle());
            result = result + "The matching shingles were: " + match.getMatchedShingles()+"\n\n";
            System.out.println("The matching shingles were: " + match.getMatchedShingles()+"\n");

            containmentInHaystack += match.getContainmentInHaystack();
            containmentInNeedle += match.getContainmentInNeedle();
        }

        result = result + "Total Containment InHaystack " + containmentInHaystack+"\n";
        System.out.println("Total Containment InHaystack " + containmentInHaystack);
        result = result + "Totla Containment InNeedle " + containmentInNeedle;
        System.out.println("Totla Containment InNeedle " + containmentInNeedle);

        return result;
    }
}