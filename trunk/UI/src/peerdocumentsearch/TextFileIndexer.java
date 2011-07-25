/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

import Helper.TextFileFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.*;
import java.util.ArrayList;

public class TextFileIndexer {

    private IndexWriter writer;
    private ArrayList<File> queue = new ArrayList<File>();

    public TextFileIndexer(String indexDir) throws IOException {

        FSDirectory dir = FSDirectory.open(new File(indexDir));
        writer = new IndexWriter(dir, new StandardAnalyzer(Version.LUCENE_29),
                true, IndexWriter.MaxFieldLength.LIMITED);
    }

    public void indexFileOrDirectory(String fileName) throws IOException {

        listFiles(new File(fileName));

        for (File f : queue) {
            FileReader fr = null;
            try {
                Document doc = new Document();

                fr = new FileReader(f);
                doc.add(new Field("contents", fr));

                doc.add(new Field("path", f.getAbsolutePath(),
                        Field.Store.YES,
                        Field.Index.NOT_ANALYZED));

                writer.addDocument(doc);
            } catch (Exception e) {
                System.out.println("Could not add: " + f);
            } finally {
                fr.close();
            }
        }

        queue.clear();
    }

    private void listFiles(File file) {
        if (!file.exists()) {
            System.out.println(file + " does not exist.");
        }
        if (file.isDirectory()) {
            for (File f : file.listFiles(new TextFileFilter())) {
                listFiles(f);
            }
        } else {
            String filename = file.getName().toLowerCase();

            if (filename.endsWith(".txt")) {
                queue.add(file);
            }
        }
    }

    public void closeIndex() throws IOException {
        writer.optimize();
        writer.close();
    }
}
