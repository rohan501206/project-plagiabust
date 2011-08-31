/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nuwan
 */
public class TextHighlighterParaphrase {


    public String[] highlightTexts(String contentOftheFile, String query) {

        String[] indexedInfo= new String[4];
        int startIndex=0;
        int endIndex=0;
        String match="";
        String searchQuery = query;

        Pattern pattern = Pattern.compile(Pattern.quote(searchQuery));
        Matcher matcher = pattern.matcher(contentOftheFile);
        while (matcher.find()) {
            startIndex = matcher.start();
            endIndex = matcher.end();
            match = matcher.group();
        }


        indexedInfo[0] = String.valueOf(startIndex);
        indexedInfo[1] = String.valueOf(endIndex);
        indexedInfo[2] = match;
        indexedInfo[3] = query;



        return indexedInfo;


    }



}
