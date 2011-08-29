/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingFrameWork.QueryBuilders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Token;

import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Brave Heart
 */
public class MyQueryBuilder extends QuerySelectionAlgorithm{

    private File stopWordListFile = new File("src" + File.separatorChar + "preprocess" + File.separatorChar + "StopWordList");
    private ArrayList<String> queryList;

    private ArrayList<String> analyze(String text) {
        ArrayList<String> tokenList = new ArrayList<String>();
        try {
            Analyzer analyzers = new StopAnalyzer(org.apache.lucene.util.Version.LUCENE_29, stopWordListFile);

            TokenStream stream = analyzers.tokenStream("contents", new StringReader(text));
            while (stream.incrementToken()) {
                Token token = stream.next();
                if (token == null) {
                    break;
                }
                tokenList.add(token.termText());
            }
        } catch (IOException ex) {
        }

        return tokenList;
    }

    public ArrayList<String> getQueryList(String filePath) {
        queryList = new ArrayList<String>();
        try {
            File file =
                    new File(filePath);
            FileReader filereader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(filereader);

            String nextLine = bufferedReader.readLine();

            ArrayList<String> paragraphWordList = new ArrayList<String>();


            while (nextLine != null) {
                //nextLine = nextLine.replaceAll("[`|~|@|#|$|%|^|&|*|(|)|_|-|+|=|\"|'|,|.|?|\\|/|<|>|[|]|{|}|:|;]", " ");
                ArrayList<String> wordList = analyze(nextLine);
                if (wordList.size() > 0) {
                    for (Iterator<String> it = wordList.iterator(); it.hasNext();) {
                        paragraphWordList.add(it.next());
                    }
                } else {
                    if (paragraphWordList.size() > 0) {
                        createQueryFromParagraph(paragraphWordList);
                        paragraphWordList = new ArrayList<String>();
                    }
                }

                nextLine = bufferedReader.readLine();
                if(nextLine == null){
                    if (paragraphWordList.size() > 0) {
                        createQueryFromParagraph(paragraphWordList);
                    }
                    break;
                }
            }
        } catch (IOException ex) {
        }

        return queryList;
    }

    private void createQueryFromParagraph(ArrayList<String> paragraphWordList) {
        if (paragraphWordList.size() > 4 && paragraphWordList.size() < 8) {
            String query = "";
            for (Iterator<String> it = paragraphWordList.iterator(); it.hasNext();) {
                query += it.next() + " ";
            }
            queryList.add(query.trim());
        } else if (paragraphWordList.size() >= 8) {
            int wordCount = 0;
            String query = "";
            for (Iterator<String> it = paragraphWordList.iterator(); it.hasNext();) {
                query += it.next() + " ";
                wordCount++;
                if (wordCount == 7) {
                    queryList.add(query.trim());
                    query = "";
                    wordCount = 0;
                }
            }
        }
    }
}
