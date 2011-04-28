/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocess;

/**
 *
 * @author Compaq
 */
public class NumberRemover {

    public String removeNumbersAndOtherChars(String input){
        String onlyText = input.replaceAll("[^a-zA-Z]", "");
        return onlyText;
    }

    public static void main(String[] args){
        String s = "yo-dude: like, ... []{}this is a string 123456";
        s = s.replaceAll("[^a-zA-Z]", "");
        System.out.println(s);
    }

}
