/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package internetsearch;

import java.util.ArrayList;

/**
 *
 * @author Brave Heart
 */
public abstract class InternetSearchAPI {

    public String appId;

    public InternetSearchAPI(String appId){
        this.appId = appId;
    };

    public abstract ArrayList<ResponseResult> searchInternet(String query);
}
