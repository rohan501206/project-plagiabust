/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class Test {


    public static void main(String[] args){



    TextHighlighter th=new TextHighlighter();
    // thss=new TestHighlighter();
    textSetter tx=new textSetter();
    //String s=tx.textSetter("C:\\Users\\user\\Desktop\\PlagiarismCheckProject\\homework4\\Assignment4_080350T.txt");
     String s=tx.textSetter("/home/nuwan/Desktop/dem/Homework_04_080083C_.txt");
    
    //String s = "sprint, planning during which the team pulls a small chunk from the top of backlog, a sprint backlog, and decides how to ";

    System.out.println(s);

       String searchQuery= "driven increment develop number method softwar part allianc blend cohes driven functionality perspect purpos tangibl softwar timely";
    //String searchQuery= "sprint team small top decide";
        String[] preprocessedArray = searchQuery.split(" ");
        String firstWord = preprocessedArray[0].trim();
        String endWord = preprocessedArray[preprocessedArray.length - 1].trim();


         String EXAMPLE_TEST = s;
         String SearchQuery="";
         Pattern pattern=null;
         for(int i=0;i<preprocessedArray.length;i++){


             if(i!=preprocessedArray.length-1){
             SearchQuery=SearchQuery+"("+preprocessedArray[i]+")"+"[\\w*\\s\\W]*?";
             }
            if(i==preprocessedArray.length-1){
             SearchQuery=SearchQuery+"("+preprocessedArray[i]+")";
             }

                              }

        System.out.println(SearchQuery);
        pattern = Pattern.compile(SearchQuery,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);

        while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
                        System.out.println(matcher.group());
		}




    }







}
