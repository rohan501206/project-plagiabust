/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

/**
 *
 * @author nuwan
 */
public class InternetSourceStore {
private String name;

public InternetSourceStore(String nameTemp){

    name=nameTemp;

}

public InternetSourceStore()
{
    
}


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


}
