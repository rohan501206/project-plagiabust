/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author nuwan
 */
public class ColourMap {

    public ColourMap() {
    }

    /**
     * Get the colour List for the number of queries
     * @param queries
     * @return List of Colours
     */
    public ArrayList<Color> getColourArray(String[] queries) {
        int queryCount = queries.length;
        ArrayList<Color> colourArray = new ArrayList<Color>();
        HashMap<Integer, Color> colorToIntegerMap = new HashMap<Integer, Color>();
        colourArray.add(Color.cyan);
        colorToIntegerMap.put(0, Color.cyan);
        colourArray.add(Color.yellow);
        colorToIntegerMap.put(1, Color.yellow);
        colourArray.add(Color.MAGENTA);
        colorToIntegerMap.put(2, Color.MAGENTA);
        colourArray.add(Color.LIGHT_GRAY);
        colorToIntegerMap.put(3, Color.LIGHT_GRAY);
        colourArray.add(Color.pink);
        colorToIntegerMap.put(4, Color.pink);
        colourArray.add(Color.ORANGE);
        colorToIntegerMap.put(5, Color.ORANGE);
        colourArray.add(new Color(124, 252, 0));
        colorToIntegerMap.put(6, new Color(124, 252, 0));
        colourArray.add(new Color(245, 222, 179));
        colorToIntegerMap.put(7, new Color(245, 222, 179));
        colourArray.add(new Color(245, 245, 220));
        colorToIntegerMap.put(8, new Color(245, 245, 220));
        colourArray.add(new Color(221, 160, 221));
        colorToIntegerMap.put(9, new Color(221, 160, 221));
        colourArray.add(new Color(255, 222, 173));
        colorToIntegerMap.put(10, new Color(255, 222, 173));
        colourArray.add(new Color(245, 245, 245));
        colorToIntegerMap.put(11, new Color(245, 245, 245));
        colourArray.add(new Color(135, 206, 235));
        colorToIntegerMap.put(12, new Color(135, 206, 235));
        colourArray.add(new Color(224, 255, 255));
        colorToIntegerMap.put(13, new Color(224, 255, 255));
        colourArray.add(new Color(238, 232, 170));
        colorToIntegerMap.put(14, new Color(238, 232, 170));
        if (colourArray.size() < queryCount) {
            while (colourArray.size() != queryCount) {
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(14);
                colourArray.add((Color) colorToIntegerMap.get(randomInt));
            }
        }
        return colourArray;
    }
}
