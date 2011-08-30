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

    public GoogleSearch() {
        this("AIzaSyBPM9e5SyUgJBEbz5l8J6LoKsbWxGFo-B0");
    }

    public GoogleSearch(String appId) {
       super(appId);
    }

    public void searchInGoogle(String search) {
        GoogleSearchQueryFactory factory = GoogleSearchQueryFactory.newInstance(appId);
        WebSearchQuery query = factory.newWebSearchQuery();
        PagedList<WebResult> response = query.withQuery(search).list();
        System.out.println(response.getCurrentPageIndex());
        System.out.println(response.getEstimatedResultCount());
        System.out.println(response.getMoreResultsUrl());
        System.out.println(response.getPages());
        for (WebResult result : response) {
            System.out.println(result.getTitle());
            System.out.println(result.getContent());
            System.out.println(result.getUrl());
            System.out.println("=======================================");
        }
    }

    public static void main(String[] args){
        GoogleSearch googleSearchAPI = new GoogleSearch();
        googleSearchAPI.searchInGoogle("mediafire");
    }

    @Override
    public ArrayList<ResponseResult> searchInternet(String search) {
        ArrayList<ResponseResult> responseResultList = new ArrayList<ResponseResult>();

        GoogleSearchQueryFactory factory = GoogleSearchQueryFactory.newInstance(appId);
        WebSearchQuery query = factory.newWebSearchQuery();
        PagedList<WebResult> response = query.withQuery(search).list();

        for (WebResult result : response) {
            System.out.println(result.getUrl());
            ResponseResult responseResult = new ResponseResult();
            responseResult.setUrl(result.getUrl());
            responseResult.setTitle(result.getTitle());
            responseResult.setDisplayUrl(result.getVisibleUrl());

            responseResultList.add(responseResult);
        }

        return responseResultList;
    }
}
