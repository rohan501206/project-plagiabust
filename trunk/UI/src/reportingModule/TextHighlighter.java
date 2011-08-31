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


public class TextHighlighter {

    public String[] highlightTexts(String contentOftheFile, String query) {

        String contenttemp = contentOftheFile;
        String contentModified = contenttemp.replaceAll("\n", " ");
        String content = contentModified.replaceAll("\t", " ");
        ArrayList<String> preprocessedModifiedArrayList = new ArrayList<String>();        
        String searchQuery = query;
        int startIndex = 0;
        int startIndexTemp = 0;
        int secondWordIndex = 0;
        int endIndex = 0;
        String match = "";
        ArrayList<Integer> indexArrayListforFirstWord = new ArrayList<Integer>();
        ArrayList<Integer> indexArrayListForSecondWord = new ArrayList<Integer>();
        ArrayList<Integer> selectedIndicesFirstWord = new ArrayList<Integer>();
        ArrayList<Integer> selectedIndicesSecondWord = new ArrayList<Integer>();
        String[] indexedInfo = new String[4];
        Pattern pattern = null;
        String[] preprocessedArray = searchQuery.split(" ");
        for (int i = 0; i < preprocessedArray.length; i++) {
            if ((content.indexOf(preprocessedArray[i])) != -1) {
                preprocessedModifiedArrayList.add(preprocessedArray[i]);
            }
        }
        String firstWord = preprocessedModifiedArrayList.get(0);
        String secondWord = preprocessedModifiedArrayList.get(1);
        
        String modifiedQueryPattern = "";
        modifiedQueryPattern=getSearchQueryPattern(preprocessedModifiedArrayList);
        pattern = Pattern.compile(modifiedQueryPattern);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            startIndex = matcher.start();
            endIndex = matcher.end();
            match = matcher.group();
        }
        startIndexTemp = content.indexOf(firstWord);
        indexArrayListforFirstWord.add(startIndexTemp);
        while (startIndexTemp != -1) {
            startIndexTemp = content.indexOf(firstWord, startIndexTemp + firstWord.length());
            if (startIndexTemp != -1) {
                indexArrayListforFirstWord.add(startIndexTemp);
            }
        }
        secondWordIndex = content.indexOf(secondWord);
        indexArrayListForSecondWord.add(secondWordIndex);
        while (secondWordIndex != -1) {
            secondWordIndex = content.indexOf(secondWord, secondWordIndex + secondWord.length());
            if (secondWordIndex != -1) {
                indexArrayListForSecondWord.add(secondWordIndex);
            }
        }

        for (int j = 0; j < indexArrayListforFirstWord.size(); j++) {
            int distance = endIndex - indexArrayListforFirstWord.get(j);
            if (distance > 0) {
                selectedIndicesFirstWord.add(indexArrayListforFirstWord.get(j));
            }
        }

        for (int j = 0; j < indexArrayListForSecondWord.size(); j++) {
            int distance = endIndex - indexArrayListForSecondWord.get(j);
            if (distance > 0) {
                selectedIndicesSecondWord.add(indexArrayListForSecondWord.get(j));
            }
        }

        try {
            startIndexTemp = this.getMaximum(selectedIndicesFirstWord);
            secondWordIndex = this.getMaximum(selectedIndicesSecondWord);
            if (secondWordIndex > startIndexTemp) {
                startIndex = startIndexTemp;
            } else {
                startIndexTemp = this.getSecondMaximum(selectedIndicesFirstWord);
                startIndex = startIndexTemp;
            }
        } catch (Exception ex) {
            System.out.println("Error in word indexing has occured");
        }

        match = content.substring(startIndex, endIndex);
        //SearchQuery=Pattern.quote(SearchQuery+"("+preprocessedModifiedArrayList.get(i)+")")+"[\\w\\s\\W]*?";
        //SearchQuery=Pattern.quote(SearchQuery+"("+preprocessedModifiedArrayList.get(i)+")");
        indexedInfo[0] = String.valueOf(startIndex);
        indexedInfo[1] = String.valueOf(endIndex);
        indexedInfo[2] = match;
        indexedInfo[3] = query;
        return indexedInfo;
    }


    
/**
     public String[] highlightTexts(String contentOftheFile, String query) {

        String contenttemp = contentOftheFile;
        String contentModified = contenttemp.replaceAll("\n", " ");
        String content = contentModified.replaceAll("\t", " ");
        ArrayList<String> preprocessedModifiedArrayList = new ArrayList<String>();
        String searchQuery = query;
        int startIndex = 0;
        int startIndexTemp = 0;
        int secondWordIndex = 0;
        int thirdWordIndex=0;
        int endIndex = 0;
        String match = "";
        ArrayList<Integer> indexArrayListforFirstWord = new ArrayList<Integer>();
        ArrayList<Integer> indexArrayListForSecondWord = new ArrayList<Integer>();
        ArrayList<Integer> indexArrayListForThirdWord = new ArrayList<Integer>();
        ArrayList<Integer> selectedIndicesFirstWord = new ArrayList<Integer>();
        ArrayList<Integer> selectedIndicesSecondWord = new ArrayList<Integer>();
        ArrayList<Integer> selectedIndicesThirdWord = new ArrayList<Integer>();
        String[] indexedInfo = new String[4];
        Pattern pattern = null;
        String[] preprocessedArray = searchQuery.split(" ");
        for (int i = 0; i < preprocessedArray.length; i++) {
            if ((content.indexOf(preprocessedArray[i])) != -1) {
                preprocessedModifiedArrayList.add(preprocessedArray[i]);
            }
        }
        String firstWord = preprocessedModifiedArrayList.get(0);
        String secondWord = preprocessedModifiedArrayList.get(1);
        String thirdWord = preprocessedModifiedArrayList.get(2);

        String modifiedQueryPattern = "";
        modifiedQueryPattern=getSearchQueryPattern(preprocessedModifiedArrayList);
        pattern = Pattern.compile(modifiedQueryPattern);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            startIndex = matcher.start();
            endIndex = matcher.end();
            match = matcher.group();
        }
        startIndexTemp = content.indexOf(firstWord);
        indexArrayListforFirstWord.add(startIndexTemp);
        while (startIndexTemp != -1) {
            startIndexTemp = content.indexOf(firstWord, startIndexTemp + firstWord.length());
            if (startIndexTemp != -1) {
                indexArrayListforFirstWord.add(startIndexTemp);
            }
        }
        secondWordIndex = content.indexOf(secondWord);
        indexArrayListForSecondWord.add(secondWordIndex);
        while (secondWordIndex != -1) {
            secondWordIndex = content.indexOf(secondWord, secondWordIndex + secondWord.length());
            if (secondWordIndex != -1) {
                indexArrayListForSecondWord.add(secondWordIndex);
            }
        }
        thirdWordIndex = content.indexOf(thirdWord);
        indexArrayListForThirdWord.add(thirdWordIndex);
        while (thirdWordIndex != -1) {
            thirdWordIndex = content.indexOf(thirdWord, thirdWordIndex + thirdWord.length());
            if (thirdWordIndex != -1) {
                indexArrayListForThirdWord.add(thirdWordIndex);
            }
        }


        for (int j = 0; j < indexArrayListforFirstWord.size(); j++) {
            int distance = endIndex - indexArrayListforFirstWord.get(j);
            if (distance > 0) {
                selectedIndicesFirstWord.add(indexArrayListforFirstWord.get(j));
            }
        }

        for (int j = 0; j < indexArrayListForSecondWord.size(); j++) {
            int distance = endIndex - indexArrayListForSecondWord.get(j);
            if (distance > 0) {
                selectedIndicesSecondWord.add(indexArrayListForSecondWord.get(j));
            }
        }

        for (int j = 0; j < indexArrayListForThirdWord.size(); j++) {
            int distance = endIndex - indexArrayListForThirdWord.get(j);
            if (distance > 0) {
                selectedIndicesThirdWord.add(indexArrayListForThirdWord.get(j));
            }
        }



        try {
            startIndexTemp = this.getMaximum(selectedIndicesFirstWord);
            secondWordIndex = this.getMaximum(selectedIndicesSecondWord);
            thirdWordIndex = this.getMaximum(selectedIndicesSecondWord);
            if ((secondWordIndex > startIndexTemp) && (thirdWordIndex>startIndexTemp)  ) {
                startIndex = startIndexTemp;
            } else {
                startIndexTemp = secondWordIndex;
                startIndex = startIndexTemp;
            }
        } catch (Exception ex) {
            System.out.println("Error in word indexing has occured");
        }

        match = content.substring(startIndex, endIndex);
        //SearchQuery=Pattern.quote(SearchQuery+"("+preprocessedModifiedArrayList.get(i)+")")+"[\\w\\s\\W]*?";
        //SearchQuery=Pattern.quote(SearchQuery+"("+preprocessedModifiedArrayList.get(i)+")");
        indexedInfo[0] = String.valueOf(startIndex);
        indexedInfo[1] = String.valueOf(endIndex);
        indexedInfo[2] = match;
        indexedInfo[3] = query;
        return indexedInfo;
    }





    public String getSearchQueryPattern(ArrayList<String> preprocessedModifiedArrayList) {

        String SearchQuery="";
        for (int i = 0; i < preprocessedModifiedArrayList.size(); i++) {
             String quotedString= Pattern.quote(preprocessedModifiedArrayList.get(i));
            if (i != preprocessedModifiedArrayList.size() - 1) {

                SearchQuery=SearchQuery+"("+quotedString+")"+"[\\w\\s\\W]*?";
                //SearchQuery = SearchQuery + "(" + preprocessedModifiedArrayList.get(i) + ")" + "[\\w\\s\\W]*?";
            }
            if (i == preprocessedModifiedArrayList.size() - 1) {
                SearchQuery=SearchQuery+"("+quotedString+")";

                //SearchQuery = SearchQuery + "(" + preprocessedModifiedArrayList.get(i) + ")";
            }
        }
        return SearchQuery;

**/

    



    public int getMaximum(ArrayList<Integer> array) throws Exception {

        int mxm = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > mxm) {
                mxm = array.get(i);
            }

        }
        return mxm;

    }

    public int getSecondMaximum(ArrayList<Integer> array) throws Exception {

        int mxm = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if ((array.get(i) > mxm) && i != array.size() - 1) {
                mxm = array.get(i);
            }

        }
        return mxm;

    }


}
