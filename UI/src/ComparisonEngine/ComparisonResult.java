/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ComparisonEngine;

/**
 *
 * @author Compaq
 */
public class ComparisonResult {
    public float Similarity;
    public float EstimatedTime;

    public String PrintResults(String algorithm)
    {
        String text = algorithm + " similarity " + Similarity+"\n"+algorithm + " time " + EstimatedTime ;
        //System.out.println(algorithm + " similarity " + Similarity);
        //System.out.println(algorithm + " time " + EstimatedTime + "\n");

        return text;
    }
}
