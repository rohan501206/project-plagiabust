/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ComparisonEngine;
import uk.ac.shef.wit.simmetrics.similaritymetrics.CosineSimilarity;
/**
 *
 * @author Compaq
 */
public class CosineSimilarityAlgorithm {
    CosineSimilarity cos = new CosineSimilarity();

    public ComparisonResult getSimilarity(String input1, String input2) {
        ComparisonResult cr = new ComparisonResult();

        cr.Similarity = cos.getSimilarity(input1, input2);
        cr.EstimatedTime = cos.getSimilarityTimingEstimated(input1, input2);

        return cr;
    }

}
