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
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author Brave Heart
 */
public class AddDocumentsBackgroundWorker extends SwingWorker<Integer, Integer> {

    SolrServer server = null;
    ArrayList<String> fileList = null;
    JLabel currentMessageLable = null;

    public AddDocumentsBackgroundWorker(SolrServer server, ArrayList<String> fileList, JLabel messageLabel) {
        this.server = server;
        this.fileList = fileList;
        this.currentMessageLable = messageLabel;
    }

    @Override
    protected Integer doInBackground() {
        int count = 1;
        int numOfDocument = fileList.size();
        try {

            for (String fileName : fileList) {
                if (fileName.endsWith(".txt")) {
                    SolrInputDocument inputDoc = this.createSolrInputDocument(new File(fileName));
                    if (inputDoc != null) {
                        server.add(inputDoc);
                        server.commit();

                        // update progress
                        currentMessageLable.setText(fileName + "Added to the server");
                        publish(count);
                        this.setProgress(100 * (count + 1) / numOfDocument);
                        count++;
                        //solrInputDocumentList.add(inputDoc);
                    }
                }

                // Multiple documents commit at once : Leads to a Memory problem.
            /*if (solrInputDocumentList != null) {
                server.add(solrInputDocumentList);
                server.commit();
                }*/

            }
        } catch (UnsupportedOperationException ex) {
        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        } catch (SolrServerException ex) {
        }
        return count;
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

    @Override
    public void process(List<Integer> publishedVals) {
    }
}
