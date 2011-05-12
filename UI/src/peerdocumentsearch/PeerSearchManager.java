/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

import java.util.HashMap;

/**
 *
 * @author Brave Heart
 */
public class PeerSearchManager {

    private int numOfSourcesPerDoc = 10;
    private float randomSelectionRatio = 0.5f;

    public PeerSearchManager() {
    }

   // public HashMap<String, Integer> getSuspiciousDocList() {
  //  }

    public int getNumOfSourcesPerDoc() {
        return numOfSourcesPerDoc;
    }

    public void setNumOfSourcesPerDoc(int numOfSources) {
        if (numOfSources >= 10) {
            this.numOfSourcesPerDoc = numOfSources;
        }
    }

    public float getRandomSelectionRatio() {
        return randomSelectionRatio;
    }

    public void setRandomSelectionRatio(float randomRatio) {
        if (randomRatio > 0.0f && randomRatio < 1.0f) {
            this.randomSelectionRatio = randomRatio;
        }
    }
}
