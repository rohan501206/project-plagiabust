/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

/**
 *
 * @author nuwan
 */
public class StringDiffer {
    public String state;
    public  String processedString;

    public StringDiffer(String state, String preprocessString)
    {
       this.state=state;
       this.processedString=preprocessString;
    }

    public String getState(){
        return this.state;
    }

    public String getProcessedString(){
        return this.processedString;
    }


    
}
