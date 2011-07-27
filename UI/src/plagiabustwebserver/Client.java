/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiabustwebserver;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import java.util.UUID;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author Brave Heart
 */
public class Client {

    private String localhost;
    private SolrServer server = null;
    private Collection<SolrInputDocument> solrInputDocumentList = new ArrayList<SolrInputDocument>();
    private int FirstElementIndex = 0;

    public Client(String localhost) {
        this.localhost = localhost;

        try {
            server = new CommonsHttpSolrServer(localhost);
        } catch (MalformedURLException ex) {
            System.out.println("Error while connecting to Plagiabust Server");
        }

    }

    // set the default local host
    public Client() {
        this("http://localhost:8983/solr");
    }

    // Delete all documents form Solr server
    public void deleteAllDocumentFromServer() {
        try {
            server.deleteByQuery("*:*");
        } catch (SolrServerException ex) {
        } catch (IOException ex) {
        }
    }

    public void commitDocumentAsBackGroundWork(final JProgressBar progressBar, JLabel label, ArrayList<String> fileList, JTextArea textArea) {
        AddDocumentsBackgroundWorker addDocumentsBackGorundWorker =
                new AddDocumentsBackgroundWorker(server, fileList, label, textArea);

        addDocumentsBackGorundWorker.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                                        // update the progress bar
                        if ( evt.getPropertyName().equals( "progress" ) )
                        {
                           int newValue = ( Integer ) evt.getNewValue();
                           progressBar.setValue( newValue );
                        }
            }
        });

        addDocumentsBackGorundWorker.execute();
    }

    // Commit documents in the array list to the solr server
    // Commit all documents or dont commit any
    public void commitDocumentsToSolrServer(ArrayList<String> fileList) {

        try {
            for (String fileName : fileList) {
                if (fileName.endsWith(".txt")) {
                    SolrInputDocument inputDoc = this.createSolrInputDocument(new File(fileName));
                    if (inputDoc != null) {
                        System.out.println(fileName + " added to the server.");
                        server.add(inputDoc);
                        server.commit();
                        //solrInputDocumentList.add(inputDoc);
                    }
                }
            }

            // Multiple documents commit at once : Leads to a Memory problem.
            /*if (solrInputDocumentList != null) {
            server.add(solrInputDocumentList);
            server.commit();
            }*/

        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        } catch (SolrServerException ex) {
        }
    }

    // Create a solr input document to be add to solr server
    private SolrInputDocument createSolrInputDocument(File file) {
        SolrInputDocument doc = new SolrInputDocument();
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

            // id is the unique identifier for documents
            doc.addField("id", UUID.randomUUID());
            doc.addField("url", file.getAbsolutePath());
            doc.addField("title", file.getName());
            doc.addField("content", stringBuilder.toString());

            stream.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return doc;
    }

    // get content from the specified url
    // url is a unique key so only one file per url
    public String getContentById(String id) {
        String content = "";

        try {
            SolrQuery solrQuery = new SolrQuery().setQuery("id:" + id);

            QueryResponse queryResponse = server.query(solrQuery);
            if (!queryResponse.getResults().isEmpty()) {
                SolrDocument resultDoc = queryResponse.getResults().get(FirstElementIndex);
                content = resultDoc.getFirstValue("content").toString();
            }
        } catch (SolrServerException ex) {
        }
        return content;
    }

    // Return
    public ArrayList<PlagiabustServerResponse> getQueryResponse(String query) {

        ArrayList<PlagiabustServerResponse> serverResponses = new ArrayList<PlagiabustServerResponse>();
        try {
            SolrQuery solrQuery = new SolrQuery().setQuery("content:" + query);


            QueryResponse queryResponse = server.query(solrQuery);

            SolrDocumentList docList = queryResponse.getResults();
            for (Iterator<SolrDocument> it = docList.iterator(); it.hasNext();) {
                SolrDocument resultDoc = it.next();
                PlagiabustServerResponse response = new PlagiabustServerResponse();

                response.setID(resultDoc.getFirstValue("id").toString());
                response.setUrl(resultDoc.getFirstValue("url").toString());
                response.setContent(resultDoc.getFirstValue("content").toString());
                response.setTitle(resultDoc.getFirstValue("title").toString());

                serverResponses.add(response);
            }

            Iterator<SolrDocument> iter = queryResponse.getResults().iterator();

        } catch (SolrServerException ex) {
        }
        return serverResponses;
    }
}
