/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingFrameWork.QueryBuilders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author isuru
 */
public class RandomExhautiveQueryBuilder extends QuerySelectionAlgorithm{

    private ArrayList<String> sentenceList = new ArrayList<String>();
    private int totalSentences = 0;
    private int numOfSelected = 0;
    private String inputText = "";
    private float randomSelectionRatio = 0.5f;

    public RandomExhautiveQueryBuilder() {
    }

    public float getRandomSelectionRatio() {
        return randomSelectionRatio;
    }

    public void setRandomSelectionRatio(float selectionRatio) {

        if (selectionRatio > 0.0f && selectionRatio < 1.0f) {
            this.randomSelectionRatio = selectionRatio;
        }
    }

    private void txtToString(String fileName) {
        BufferedReader myBufferedReader = null;
        File file = new File(fileName);
        inputText = "";

        try {
            if (file.exists() && file.isFile()) {
                FileReader myFileReader = new FileReader(file);
                myBufferedReader = new BufferedReader(myFileReader);

                StringBuffer fileAsText = new StringBuffer();
                String line = null;
                while ((line = myBufferedReader.readLine()) != null) {

                    line = line.replaceAll("[^\\p{ASCII}]", " ");
                    line = line + "\n";
                    fileAsText.append(line);

                }

                inputText = fileAsText.toString();
            } else {
                inputText = "";
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
@Override
    public ArrayList<String> getQueryList(String fileName) {
        this.txtToString(fileName);

        this.processText();

        
            //return this.selectRandomSentences();

            return sentenceList;
    }

    private void processText() {

        inputText = inputText.toLowerCase();

        String[] lineArray = inputText.split("[.:;.]");


        for (int i = 0; i < lineArray.length; i++) {
            String currentSentence = "";

            StringTokenizer tok = new StringTokenizer(lineArray[i], " \t(){}[]\n");

            while (tok.hasMoreTokens()) {
                String currentToken = tok.nextToken();

                if (!isWord(currentToken)) {
                    continue;
                }

                currentSentence += currentToken + " ";
            }

            if (!currentSentence.equals(null) && (currentSentence.trim() != "")) {
                sentenceList.add(currentSentence);
            }
        }
    }

    private boolean isWord(String input) {
        return (!isRomanNumeral(input) && hasAlphabeticChars(input) && !isNumber(input) && !isSingleCharacter(input));
    }

    private boolean isRomanNumeral(String word) {
        if (word.equals("I")) {
            return false;
        }

        int length = word.length();
        int lastIndex = length - 1;

        for (int i = 0; i < length - 1; i++) {
            if (word.charAt(i) != 'I'
                    && word.charAt(i) != 'V'
                    && word.charAt(i) != 'X'
                    && word.charAt(i) != 'L'
                    && word.charAt(i) != 'C'
                    && word.charAt(i) != 'D'
                    && word.charAt(i) != 'M') {
                return false;
            }
        }

        if (word.charAt(lastIndex) != 'I'
                && word.charAt(lastIndex) != 'V'
                && word.charAt(lastIndex) != 'X'
                && word.charAt(lastIndex) != 'L'
                && word.charAt(lastIndex) != 'C'
                && word.charAt(lastIndex) != 'D'
                && word.charAt(lastIndex) != 'M') {
            return false;
        }

        return true;

    }

    private boolean hasAlphabeticChars(String input) {

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private boolean isSingleCharacter(String input) {
        if (input.length() == 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isNumber(String input) {
        int lastCharInWord = input.length() - 1;

        if (input.length() == 1) {
            return Character.isDigit(input.charAt(0));
        }

        for (int i = 0; i < lastCharInWord; i++) {
            if (Character.isDigit(input.charAt(i)) == false) {
                return false;
            }
        }

        if (Character.isDigit(input.charAt(lastCharInWord))
                || isPunctuation(input.charAt(lastCharInWord))) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isPunctuation(char word) {

        if (word == '.' || word == '!' || word == '?' || word == ','
                || word == ';' || word == '-') {
            return true;
        }

        return false;
    }

    private ArrayList<String> selectRandomSentences() {

        ArrayList<String> selectedSentencesList = new ArrayList<String>();

        totalSentences = sentenceList.size();
        numOfSelected = 0;

        if (totalSentences > 20) {
            numOfSelected = (int) (totalSentences * randomSelectionRatio);
        } else {
            numOfSelected = totalSentences;
        }

        int currentNumOfSelected = 0;

        while (currentNumOfSelected < numOfSelected) {
            Random r = new Random();
            int nextIndex = r.nextInt(totalSentences);
            boolean isAlreadyExist = false;

            for (Iterator<String> it = selectedSentencesList.iterator(); it.hasNext();) {
                String string = it.next();
                if (string.equals(sentenceList.get(nextIndex))) {
                    isAlreadyExist = true;
                    break;
                }
            }

            if (!isAlreadyExist) {
                currentNumOfSelected++;
                selectedSentencesList.add(sentenceList.get(nextIndex));
            }
        }

        return selectedSentencesList;
    }
}
