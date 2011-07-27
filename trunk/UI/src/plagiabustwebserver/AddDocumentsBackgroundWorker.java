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
import javax.swing.JTextArea;
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
    JLabel progressLable = null;
    JTextArea textArea = null;

    public AddDocumentsBackgroundWorker(SolrServer server, ArrayList<String> fileList, JLabel messageLabel, JTextArea textArea) {
        this.server = server;
        this.fileList = fileList;
        this.progressLable = messageLabel;
        this.textArea = textArea;
    }

    @Override
    protected Integer doInBackground() {
        int count = 1;
        int numOfDocument = fileList.size();
        try {

            for (String fileName : fileList) {
                if (fileName.endsWith(".txt")) {
                    // clear the text are for information on new document
                    textArea.setText("");
                    SolrInputDocument inputDoc = this.createSolrInputDocument(new File(fileName));
                    if (inputDoc != null) {
                        server.add(inputDoc);
                        server.commit();

                        // update progress
                        int currentProgress = 100 * (count + 1) / numOfDocument;
                        progressLable.setText("" + currentProgress + " %");
                        publish(count);
                        this.setProgress(currentProgress);
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
            textArea.setText("Unsopported operation.");
        } catch (MalformedURLException ex) {
            textArea.setText("A Malformed URL");
        } catch (IOException ex) {
            textArea.setText("Error processing file.");
        } catch (SolrServerException ex) {
            textArea.setText("Error connecting to Plagiabust Web Server.");
        }
        return count;
    }

    // Create a solr input document to be add to solr server
    private SolrInputDocument createSolrInputDocument(File file) {
        SolrInputDocument doc = new SolrInputDocument();
        FileInputStream stream = null;

        try {
            textArea.append("Source Folder : " + file.getParent() + "\n");
            textArea.append("File Name : " + file.getName() + "\n");
            textArea.append("Size : " + ((float)file.getTotalSpace()/1024.0f) + "KB" + "\n");

            FileReader fr = new FileReader(file);
            stream = new FileInputStream(file);

            BufferedReader bufferedReader = new BufferedReader(fr);
            StringBuilder stringBuilder = new StringBuilder();
            String nextLine = null;
            while ((nextLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(nextLine + "\n");
            }

            String uniqueDocId = UUID.randomUUID().toString();
            textArea.append("Unique Id : " + uniqueDocId + "\n");
            // id is the unique identifier for documents
            doc.addField("id", file.getName() + ":" + uniqueDocId );
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
