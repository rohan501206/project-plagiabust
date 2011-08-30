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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    public ArrayList<String> removeStopwordInstopwordArray(String text,String[] stopwords ) throws IOException{
        List list = Arrays.asList(stopwords);
        Set ENGLISH_STOP_WORDS_SET =  new HashSet(list);
        ArrayList<String> tokenList = new ArrayList<String>();
        Analyzer analyzers = new StopAnalyzer(org.apache.lucene.util.Version.LUCENE_29, ENGLISH_STOP_WORDS_SET);
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
