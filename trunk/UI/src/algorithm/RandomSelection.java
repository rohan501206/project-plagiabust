/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithm;

/**
 *
 * @author Brave Heart
 */
public class RandomSelection {

    float selectedSentenceRatio = 0.4f;

    public void setSelectedSentenceRatio(float ratio) {
        if(ratio > 0.0 && ratio < 1.0)
        {
            this.selectedSentenceRatio = ratio;
        }
    }

    public float getSelectedSentenceRatio() {
        return this.selectedSentenceRatio;
    }
}
