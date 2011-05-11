/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package internetsearch;


import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Brave Heart
 */
public class BingSearch
{

    static XPathFactory factory = null;
    static XPath xpath = null;
    static XPathExpression expr = null;
    private Document doc = null;
    private String appId;
    private ArrayList<ResponseResult> responseResultsList;
    private SearchError err = SearchError.None;
    private int maxNumOfResults;

    public BingSearch(String appID) {
        this.appId = appID;
        maxNumOfResults = 10;
    }

    public BingSearch() {
         maxNumOfResults = 10;
    }

    // Set the bing search ID
    public void setBingAppID(String appID) {
        this.appId = appID;
    }

    // Set the bing search ID
    public String getBingAppID() {
        return appId;
    }

    public void setMaxNumOfResults(int num) {
        if(num > 0 && num <= 10)
        {
            maxNumOfResults = num;
        }
    }

    public int getMaxNumOfResults() {
        return maxNumOfResults;
    }

    // Search Internet and get results
    public ArrayList<ResponseResult> searchInternet(String searchWord) {

        responseResultsList = new ArrayList<ResponseResult>();

        if(!searchWord.equals(null))
        {
            try
            {
                String request = this.BuildRequest(searchWord);
                doc = this.getResponse(request);
                responseResultsList = this.getResponseResults();
            }
            catch(Exception ex)
            {
                err = SearchError.ConnectionError;
            }
        }

        return responseResultsList;
    }

    private String BuildRequest(String searchWord) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("http://api.search.live.net/xml.aspx?");
        stringBuilder.append("AppId=" + appId);
        stringBuilder.append("&Query=" + searchWord);
        stringBuilder.append("&Sources=Web");

        stringBuilder.append("&Version=2.0");
        stringBuilder.append("&Market=en-us");
        stringBuilder.append("&Adult=Moderate");

        stringBuilder.append("&Web.Count=" + maxNumOfResults);
        stringBuilder.append("&Web.Offset=0");
        stringBuilder.append("&Web.Options=DisableHostCollapsing+DisableQueryAlterations");

        return stringBuilder.toString();
    }

    private Document getResponse(String requestURL) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        try {
        DocumentBuilder db = dbf.newDocumentBuilder();

            if (db != null)
            {
                doc = db.parse(requestURL);
            }
        }

        catch(Exception ex) {

        }
		return doc;
    }

    public ArrayList<ResponseResult> getResponseResults() {
        try
        {
            factory = XPathFactory.newInstance();
            xpath = factory.newXPath();
            xpath.setNamespaceContext(new APINameSpaceContext());
            NodeList errors = (NodeList) xpath.evaluate("//api:Error",doc,XPathConstants.NODESET);

            if(errors != null && errors.getLength() > 0 )
            {
                err = SearchError.ConnectionError;
            }

            else
            {
                NodeList results = (NodeList)xpath.evaluate("//web:Web/web:Results/web:WebResult",doc, XPathConstants.NODESET);

                for(int i = 0 ; i < results.getLength(); i++)
                {
                    NodeList resultNode = results.item(i).getChildNodes();
                    ResponseResult rs = new ResponseResult();
                    for (int j = 0; j < resultNode.getLength(); j++)
                    {
                        if(resultNode.item(j).getLocalName().equals("DisplayUrl"))
                        {
                            rs.setDisplayUrl(resultNode.item(j).getTextContent());
                        }

                        if(resultNode.item(j).getLocalName().equals("Url"))
                        {
                            rs.setUrl(resultNode.item(j).getTextContent());
                        }

                        if(resultNode.item(j).getLocalName().equals("Description"))
                        {
                            rs.setDescription(resultNode.item(j).getTextContent());
                        }

                        if(resultNode.item(j).getLocalName().equals("DateTime"))
                        {
                            rs.setLastCrawledDate(resultNode.item(j).getTextContent());
                        }

                        if(resultNode.item(j).getLocalName().equals("Title"))
                        {
                            rs.setTitle(resultNode.item(j).getTextContent());
                        }

                    }

                    responseResultsList.add(rs);
                }
            }
        }

        catch(XPathExpressionException ex) {
            err = SearchError.ConnectionError;
        }

        return responseResultsList;
	}

}