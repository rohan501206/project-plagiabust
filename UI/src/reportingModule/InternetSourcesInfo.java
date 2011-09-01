/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

/**
 *
 * @author nuwan
 */
public class InternetSourcesInfo {
private String urlName;

   public  InternetSourcesInfo(String name){
urlName=name;
   }

   public  InternetSourcesInfo(){

   }

    /**
     * @return the urlname
     */
    public String getUrlName() {
        return urlName;
    }

    /**
     * @param urlname the urlname to set
     */
    public void setUrlName(String urlname) {
        this.urlName = urlname;
    }



}
