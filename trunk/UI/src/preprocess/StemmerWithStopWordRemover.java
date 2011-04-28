/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocess;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.PorterStemFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.snowball.SnowballAnalyzer;

import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;;
/**
 *
 * @author Compaq
 */
public class StemmerWithStopWordRemover {
    private final Analyzer analyzers =  new SnowballAnalyzer(org.apache.lucene.util.Version.LUCENE_CURRENT,"English",StopAnalyzer.ENGLISH_STOP_WORDS);
	private final Analyzer analyzersnew =  new StopAnalyzer();


	// snaowball analyser

	public   ArrayList<String>  analyze(String text) throws IOException {
		ArrayList<String> tokenList = new ArrayList<String>();
        Analyzer analyzer = analyzers;
        TokenStream stream = analyzer.tokenStream("contents", new StringReader(text));
        while (true) {
        	Token token = stream.next();
            if (token == null) break;
            tokenList.add(token.termText());
        }

        return tokenList;
     }
}
