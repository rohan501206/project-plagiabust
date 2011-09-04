/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

import com.google.code.bing.search.client.BingSearchClient;
import com.google.code.bing.search.client.BingSearchClient.SearchRequestBuilder;
import com.google.code.bing.search.client.BingSearchServiceClientFactory;
import com.google.code.bing.search.schema.AdultOption;
import com.google.code.bing.search.schema.SearchRequest;
import com.google.code.bing.search.schema.SearchResponse;
import com.google.code.bing.search.schema.SourceType;
import com.google.code.bing.search.schema.web.WebResult;
import com.google.code.bing.search.schema.web.WebSearchOption;
import java.util.ArrayList;

/**
 *
 * @author Brave Heart
 */
public class BingSearch extends InternetSearchAPI {
    // Search Internet and get results

    public BingSearch(String appId) {
        super(appId);
    }

    @Override
    public ArrayList<ResponseResult> searchInternet(String searchWord) {
        ArrayList<ResponseResult> responseResultsList = new ArrayList<ResponseResult>();

        BingSearchServiceClientFactory factory = BingSearchServiceClientFactory.newInstance();
        BingSearchClient client = factory.createBingSearchClient();

        SearchResponse response = client.search(createSearchRequest(client, appId, searchWord));
        if (response.getWeb() != null) {
            for (WebResult result : response.getWeb().getResults()) {

                ResponseResult responseResult = new ResponseResult();

                responseResult.setUrl(result.getUrl());
                responseResult.setDescription(result.getDescription());
                responseResult.setDisplayUrl(result.getDisplayUrl());
                responseResult.setTitle(result.getTitle());

                responseResultsList.add(responseResult);
            }
        }

        return responseResultsList;
    }

    private SearchRequest createSearchRequest(BingSearchClient client, String applicationId, String query) {
        SearchRequestBuilder builder = client.newSearchRequestBuilder();
        builder.withAppId(applicationId);
        builder.withQuery(query);
        builder.withSourceType(SourceType.WEB);
        builder.withVersion("2.0");
        builder.withAdultOption(AdultOption.STRICT);
        builder.withWebRequestFileType("html");

        builder.withWebRequestCount(10L);
        builder.withWebRequestOffset(0L);
        builder.withWebRequestSearchOption(WebSearchOption.DISABLE_HOST_COLLAPSING);
        builder.withWebRequestSearchOption(WebSearchOption.DISABLE_QUERY_ALTERATIONS);

        return builder.getResult();
    }
}
