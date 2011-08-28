/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DataFetcherSingleSearch

{
private String documentName;
private String plagValue;
private ArrayList<InternetSourceStore> internetSource;
public DataFetcherSingleSearch(String docNameTemp, String percentage,ArrayList<InternetSourceStore> internetSourceTemp)
{

    setDocumentName(docNameTemp);
    setPlagValue(percentage);
    setInternetSource(internetSourceTemp);
    
}

public DataFetcherSingleSearch()
{
}


    /**
     * @return the docName
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * @param docName the docName to set
     */
    public void setDocumentName(String docName) {
        this.documentName = docName;
    }

    /**
     * @return the plagValue
     */
    public String getPlagValue() {
        return plagValue;
    }

    /**
     * @param plagValue the plagValue to set
     */
    public void setPlagValue(String plagValue) {
        this.plagValue = plagValue;
    }

    /**
     * @return the internetSource
     */
    public ArrayList<InternetSourceStore> getInternetSource() {
        return internetSource;
    }

    /**
     * @param internetSource the internetSource to set
     */
    public void setInternetSource(ArrayList<InternetSourceStore> internetSource) {
        this.internetSource = internetSource;
    }






}

