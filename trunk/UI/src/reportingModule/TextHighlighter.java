/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import reportingModule.DiffMatch.Diff;

/**
 *
 * @author nuwan
 */
public class TextHighlighter {


    public String[] highlightTexts(String contentOftheFile, String query)  {


        String contenttemp = contentOftheFile;
        String contentModified = contenttemp.replaceAll("\n", " ");
        ArrayList<String> preprocessedModifiedArrayList=new ArrayList<String>();
        //contentModified = contentModified.replaceAll("[^a-zA-Z ]", "");
        String content = contentModified.replaceAll("\t", " ");
        //s = s.replaceAll("[^a-zA-Z ]", "");
        String searchQuery = query;
        int index = 0;
        int length = 0;
        int startIndex = 0;
        int startIndexTemp=0;
        int secondWordIndex=0;
        int endIndex = 0;
        int count = 0;
        String match="";
        ArrayList<Integer> indexArrayList = new ArrayList<Integer>();
        ArrayList<Integer> indexArrayList2 = new ArrayList<Integer>();
        ArrayList<Integer> sortedArrayList = new ArrayList<Integer>();
        ArrayList<Integer> sortedArrayList2 = new ArrayList<Integer>();


        String[] indexedInfo = new String[4];
        String[] preprocessedArray = searchQuery.split(" ");       
       

        for(int i=0;i<preprocessedArray.length;i++){

            if((content.indexOf(preprocessedArray[i]))!=-1){

                preprocessedModifiedArrayList.add(preprocessedArray[i]);

            }

        }

        String firstWord =  preprocessedModifiedArrayList.get(0);
        String secondWord =  preprocessedModifiedArrayList.get(1);

         String EXAMPLE_TEST = content;
         String SearchQuery="";
         Pattern pattern=null;
         for(int i=0;i<preprocessedModifiedArrayList.size();i++){


             if(i!=preprocessedModifiedArrayList.size()-1){
             SearchQuery=SearchQuery+"("+preprocessedModifiedArrayList.get(i)+")"+"[\\w\\s\\W]*?";
             }
            if(i==preprocessedModifiedArrayList.size()-1){
             SearchQuery=SearchQuery+"("+preprocessedModifiedArrayList.get(i)+")";
             }

                              }
         pattern = Pattern.compile(SearchQuery);
         Matcher matcher = pattern.matcher(EXAMPLE_TEST);

        while (matcher.find()) {

                        startIndex= matcher.start();
                        endIndex= matcher.end();
                        match=matcher.group();
                    		
		}


        startIndexTemp = content.indexOf(firstWord);
        indexArrayList.add(startIndexTemp);

        while (startIndexTemp != -1) {
            startIndexTemp = content.indexOf(firstWord, startIndexTemp + firstWord.length());
            if (startIndexTemp != -1) {
                indexArrayList.add(startIndexTemp);
            }
        }

        secondWordIndex = content.indexOf(secondWord);
        indexArrayList2.add(secondWordIndex);

        while (secondWordIndex!= -1) {
            secondWordIndex = content.indexOf(secondWord, secondWordIndex + secondWord.length());
            if (secondWordIndex != -1) {
                indexArrayList2.add(secondWordIndex);
            }
        }



        for (int j = 0; j < indexArrayList.size(); j++) {

            int distance = endIndex - indexArrayList.get(j);

            if(distance>0){
                sortedArrayList.add(indexArrayList.get(j));
            }

        }


        for (int j = 0; j < indexArrayList2.size(); j++) {

            int distance = endIndex - indexArrayList2.get(j);

            if(distance>0){
                sortedArrayList2.add(indexArrayList2.get(j));
            }

        }




        try {
            startIndexTemp = this.getMaximum(sortedArrayList);
            secondWordIndex=this.getMaximum(sortedArrayList2);

            if(secondWordIndex>startIndexTemp){

            startIndex=startIndexTemp;

            }

            
        else{

            startIndexTemp = this.getSecondMaximum(sortedArrayList);
            startIndex=startIndexTemp;
                
        }



        } catch (Exception ex) {
            System.out.println("Error in word indexing has occured");
        }

        match=EXAMPLE_TEST.substring(startIndex, endIndex);


/**
        startIndex = content.indexOf(firstWord);
        indexArrayList.add(startIndex);
        while (startIndex != -1) {
            startIndex = content.indexOf(firstWord, startIndex + firstWord.length());
            if (startIndex != -1) {
                indexArrayList.add(startIndex);
            }
        }

        ArrayList<StringDiffer> arrayDiffer = new ArrayList<StringDiffer>();
        DiffMatch test2 = new DiffMatch();


        LinkedList<Diff> a = test2.diff_main(content, searchQuery);

        for (int j = 0; j < a.size(); j++) {

            String token = "" + a.get(j);
            String processedToken = token.trim();
            System.out.println("token is " + processedToken);
            String[] splitter = processedToken.split("~");


            if (splitter.length == 2) {
                StringDiffer differ = new StringDiffer(splitter[0], splitter[1]);
                arrayDiffer.add(differ);
            }

        }

        for (int j = 0; j < arrayDiffer.size(); j++) {

            String state = arrayDiffer.get(j).getState();
            String preprocessedString = arrayDiffer.get(j).getProcessedString();



            if (state.equalsIgnoreCase("EQUAL")) {


                if (count == 0) {
                    //startIndex=s.indexOf(preprocessedString);
                }
                count++;

                if (j == arrayDiffer.size() - 1) {

                    index = content.indexOf(preprocessedString);
                    endIndex = index + preprocessedString.length();

                }
                else {
                    index = content.indexOf(preprocessedString);
                }


            }

            if (state.equalsIgnoreCase("DELETE")) {

                if (j == arrayDiffer.size() - 1) {

                    index = content.indexOf(preprocessedString);
                    length = preprocessedString.length();
                    endIndex = index;

                } else {
                    length = preprocessedString.length();
                    index = index + length;
                }

            }
        }
      
          
            startIndex = this.getMaximum(indexArrayList);
        

        for (int j = 0; j < indexArrayList.size(); j++) {

            int distance = endIndex - indexArrayList.get(j);

            if(distance>0)
                sortedArrayList.add(indexArrayList.get(j));
           
           
        }



        startIndex = this.getMaximum(sortedArrayList);
        

           
**/

        indexedInfo[0] = String.valueOf(startIndex);
        indexedInfo[1] = String.valueOf(endIndex);
        indexedInfo[2] = match;
        indexedInfo[3] = query;

        

        return indexedInfo;


    }

    public int getMaximum(ArrayList<Integer> array) throws Exception  {

        int mxm = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > mxm) {
                mxm = array.get(i);
            }

        }
        return mxm;

    }

    public int getSecondMaximum(ArrayList<Integer> array) throws Exception  {

        int mxm = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if ((array.get(i) > mxm) && i!=array.size()-1)  {
                mxm = array.get(i);
            }

        }
        return mxm;

    }

}
