/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingFrameWork.QueryBuilders;

import internetsearch.ResponseResult;
import java.util.ArrayList;

/**
 *
 * @author Brave Heart
 */
public abstract class InternetSearchAPI {

    public abstract ArrayList<ResponseResult> searchInternet(String query);
}
