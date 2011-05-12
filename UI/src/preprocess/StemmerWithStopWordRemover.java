package preprocess;



import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.StopAnalyzer;

import org.apache.lucene.analysis.PorterStemFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.LowerCaseTokenizer;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.snowball.SnowballAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;



import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;;

public class StemmerWithStopWordRemover {

	private final Analyzer analyzers =  new SnowballAnalyzer(org.apache.lucene.util.Version.LUCENE_CURRENT,"English",StopAnalyzer.ENGLISH_STOP_WORDS);
	private final Analyzer analyzersnew =  new StopAnalyzer();



	public  ArrayList<String>  analyze(String text) throws IOException {
		ArrayList<String> tokenList = new ArrayList<String>();
        System.out.println("Analzying \"" + text + "\"");
        Analyzer analyzer = analyzers;
        TokenStream stream = analyzer.tokenStream("contents", new StringReader(text));
        while (true) {
        	Token token = stream.next();
            if (token == null) break;
            tokenList.add(token.termText());
        }

        return tokenList;
     }




	public  ArrayList<String>  analyzenew(String text) throws IOException {
		ArrayList<String> tokenList = new ArrayList<String>();
        System.out.println("Analzying \"" + text + "\"");
        Analyzer analyzer = analyzersnew;
        TokenStream stream = analyzersnew.tokenStream("contents", new StringReader(text));
        PorterStemFilter analyzersnew =  new PorterStemFilter(stream);

        while (true) {
        	Token token = analyzersnew.next();
            if (token == null) break;
            tokenList.add(token.termText());
        }

        return tokenList;
     }







}








