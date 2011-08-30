/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

import com.googleapis.ajax.common.PagedList;
import com.googleapis.ajax.schema.WebResult;
import com.googleapis.ajax.services.GoogleSearchQueryFactory;
import com.googleapis.ajax.services.WebSearchQuery;
import java.util.ArrayList;

/**
 *
 * @author Brave Heart
 */
public class GoogleSearch extends InternetSearchAPI{

    public GoogleSearch(String appId) {
       super(appId);
    }

    @Override
    public ArrayList<ResponseResult> searchInternet(String search) {
        ArrayList<ResponseResult> responseResultList = new ArrayList<ResponseResult>();

        GoogleSearchQueryFactory factory = GoogleSearchQueryFactory.newInstance(appId);
        WebSearchQuery query = factory.newWebSearchQuery();
        PagedList<WebResult> response = query.withQuery(search).list();

        for (WebResult result : response) {
            ResponseResult responseResult = new ResponseResult();
            responseResult.setUrl(result.getUrl());
            responseResult.setTitle(result.getTitle());
            responseResult.setDisplayUrl(result.getVisibleUrl());

            responseResultList.add(responseResult);
        }

        return responseResultList;
    }
}
