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

double capacity; // should be private
double weight;
String edgeName;
// should be private for good practice
int id;
public CustomEdge(String edgeNameTemp) {

this.edgeName=edgeNameTemp;


}

public String toString() { // Always good for debugging
return edgeName;
}


}
