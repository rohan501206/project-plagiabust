/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

import java.util.ArrayList;
import java.util.LinkedList;
import reportingModule.DiffMatch.Diff;

/**
 *
 * @author nuwan
 */
public class TextHighlighter {




    public Integer[] highlightTexts(String contentOftheFile, String query){


        String content= contentOftheFile;
        String searchQuery=query;
        int index=0;
        int length=0;
        int startIndex=0;
        int endIndex=0;
        int count=0;
        ArrayList<Integer> indexArrayList=new ArrayList<Integer>();
        ArrayList<Integer> sortedArrayList=new ArrayList<Integer>();
        Integer[] indexedInfo=new Integer[2];
        String[] preprocessedArray=searchQuery.split(" ");
        String firstWord=preprocessedArray[0].trim();



        startIndex=content.indexOf(firstWord);
        indexArrayList.add(startIndex);
        while(startIndex!=-1){
            startIndex=content.indexOf(firstWord,startIndex+firstWord.length());
            if(startIndex!=-1)
            indexArrayList.add(startIndex);
        }

        for(int indexes=0;indexes<indexArrayList.size();indexes++){
           System.out.println(indexArrayList.get(indexes));

        }

       ArrayList< StringDiffer> arrayDiffer=new ArrayList<StringDiffer>();
       DiffMatch test2= new DiffMatch();


        LinkedList<Diff> a=test2.diff_main(content,searchQuery);

        for (int j = 0; j < a.size(); j++){

        String token=""+ a.get(j);
        String processedToken= token.trim();
        System.out.println("token is "+ processedToken);
        String[] splitter=processedToken.split("~");


        if(splitter.length==2){
        StringDiffer differ=new StringDiffer(splitter[0],splitter[1]);
        arrayDiffer.add(differ);
            }

              }

        for(int j=0;j<arrayDiffer.size();j++){

            String state=arrayDiffer.get(j).getState();
            String preprocessedString=arrayDiffer.get(j).getProcessedString();



            if(state.equalsIgnoreCase("EQUAL")){


                if(count==0){
                    //startIndex=s.indexOf(preprocessedString);

                }
                count++;

                if(j==arrayDiffer.size()-1){

                    index=content.indexOf(preprocessedString);
                    endIndex=index +preprocessedString.length();

                }

            else{



                index=content.indexOf(preprocessedString);

                }


            }

            if(state.equalsIgnoreCase("DELETE")){




                if(j==arrayDiffer.size()-1){

                    index=content.indexOf(preprocessedString);
                    length=preprocessedString.length();
                    endIndex=index ;

                }

 else{
                length=preprocessedString.length();
                index=index+length;
                }

                     }


        }

        startIndex=this.getMaximum(indexArrayList);
        System.out.println("The maximum start index is "+ startIndex );



         System.out.println("Start index is "+ startIndex);
         System.out.println("End index is "+ endIndex);


for(int j=0;j<indexArrayList.size();j++){

            int distance=endIndex-indexArrayList.get(j);
            System.out.println("distance of "+indexArrayList.get(j));
            if(distance > 0){
                System.out.println("Adding");
                sortedArrayList.add(indexArrayList.get(j));
            }


       }

         for(int j=0;j<sortedArrayList.size();j++){

           System.out.println("sorted Array list is"+sortedArrayList.get(j));

        }


        startIndex= this.getMaximum(sortedArrayList);





        indexedInfo[0]=startIndex;
        indexedInfo[1]=endIndex;




        return indexedInfo;


    }



     public int getMaximum(ArrayList<Integer> array){

        int  mnm = array.get(0);
for (int i=0; i<array.size(); i++) {
if (array.get(i)>mnm) {
mnm = array.get(i);
}

}
return mnm;


    }



}
