/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocess;

import java.io.File;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Token;


import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;

;

/**
 *
 * @author Compaq
 */
public class StopWordRemover {

    File file = new File("src" + File.separatorChar + "preprocess" + File.separatorChar + "StopWordList");
    // stop analyser
    public ArrayList<String> analyze(String text) throws IOException {
        Analyzer analyzers = new StopAnalyzer(org.apache.lucene.util.Version.LUCENE_29, file);
        ArrayList<String> tokenList = new ArrayList<String>();
        TokenStream stream = analyzers.tokenStream("contents", new StringReader(text));
        while (stream.incrementToken()) {
            Token token = stream.next();
            if (token == null) {
                break;
            }
            tokenList.add(token.termText());
        }
        return tokenList;
    }
    
}
