/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

/**
 *
 * @author nuwan
 */
public class CustomEdge {
private double capacity;
    private double weight;
    private String edgeName;
    private int id;

public CustomEdge(String edgeNameTemp) {

this.edgeName=edgeNameTemp;



}

public String toString() { // Always good for debugging
return  getEdgeName();
}

    /**
     * @return the capacity
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the edgeName
     */
    public String getEdgeName() {
        return edgeName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }


}
