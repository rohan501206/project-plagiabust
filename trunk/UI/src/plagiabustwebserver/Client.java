/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiabustwebserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author Brave Heart
 */
public class Client {

    private String localhost;
    private SolrServer server = null;
    private Collection<SolrInputDocument> solrInputDocumentList = new ArrayList<SolrInputDocument>();

    public Client(String localhost) {
        this.localhost = localhost;
    }

    public void commitDocumentsToSolrServer(boolean deleteExistingDocs, ArrayList<String> fileList) {

        try {
            server = new CommonsHttpSolrServer(localhost);

            if (deleteExistingDocs) {
                server.deleteByQuery("*:*");
            }

            for (String fileName : fileList) {
                if (fileName.endsWith(".txt")) {
                    SolrInputDocument inputDoc = this.createSolrInputDocument(new File(fileName));
                    if (inputDoc != null) {
                        solrInputDocumentList.add(inputDoc);
                    }
                }
            }

            if (solrInputDocumentList != null) {
                server.add(solrInputDocumentList);
                server.commit();
            }

        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        } catch (SolrServerException ex) {
        }
    }

    public SolrInputDocument createSolrInputDocument(File file) {
        SolrInputDocument solrInputDocument = null;
        FileInputStream stream = null;

        try {
            FileReader fr = new FileReader(file);
            stream = new FileInputStream(file);

            BufferedReader bufferedReader = new BufferedReader(fr);
            StringBuilder stringBuilder = new StringBuilder();
            String nextLine = null;
            while ((nextLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(nextLine + "\n");
            }

            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("url", file.getAbsolutePath());
            doc.addField("content", stringBuilder.toString());
            solrInputDocument = doc;

            stream.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return solrInputDocument;
    }

    public void getQueryResponse(String query) {

        try {
            server = new CommonsHttpSolrServer(localhost);
            SolrQuery solrQuery = new SolrQuery().setQuery(query);

            QueryResponse queryResponse = server.query(solrQuery);

            Iterator<SolrDocument> iter = queryResponse.getResults().iterator();
            while (iter.hasNext()) {
                SolrDocument resultDoc = iter.next();
                String url = (String) resultDoc.getFieldValue("url"); //id is the uniqueKey field
                System.out.println(url);
            }

        } catch (SolrServerException ex) {
        } catch (MalformedURLException ex) {
        }

    }
}
