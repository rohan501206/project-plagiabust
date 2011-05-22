/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 *
 * @author kasun
 */
public class FleshKincaidLogic {

    /*the number of syllables found in the entire file*/
    private int syllablesInFile = 0;

    /*the number of syllables found in the entire file, but not including the words
    found in sentence fragments*/
    private int syllablesInFileNotIncludingFragments = 0;

    /*the number of words found in the entire file*/
    private int wordsInFile = 0;

    /*the number of words found in the entire file, but not including the words
    found in sentence fragments*/
    private int wordsInFileNotIncludingFragments = 0;

    /*the number of sentences found in the entire file*/
    private int sentencesInFile = 0;

    /*A list of abbreviations stored in AbbreviationList.java*/
    private ArrayList abbreviationList = new ArrayList();

    /*A list of words that are commonly assigned an incorrect syllable count.
    They are in CommonMistakes.java */
    private Hashtable commonMistakes = new Hashtable();

    /*values are stored in this based on what the user chooses in the GUI*/
    private ArrayList punctuationThatEndSentences = new ArrayList();

    /*true if the user desires to store occurances of each word in the input
    file, its number of occurances, and its number of syllables in wordList*/
    private boolean runStoreResults = false;

    /*a list containing all the words found, the number of times they have been
    found and their syllable count.  It is kept in order by word occurances
    It is only used if runStoreResults is set to true*/
    private WordList wordList = new WordList();

    /*In MS Word, a series of 1 character 'non-word' sentences are counted as only 1 sentence*/
    private int wordCountForOneWordSentenceTracking = 0;
    private boolean inOneCharacterSentenceChain = false;

    /*In MS Word, for every 2 '#punctuation' pair, 1 sentence is counted:
    1. 1. 2. 2. = 4 words, 2 sentences
    every other consecutive sentence only containing one number is counted as a sentence in MS Word*/
    private boolean countOneNumberSentences = true;

    /* Individually track the words/syllables from the current sentence so if you can never determine
     * the end of the sentence, you don't have to use the information from that sentence
     */
    private int syllablesFromCurrentSentence = 0;
    private int wordsFromCurrentSentence = 0;
    private boolean justFoundEndOfSentence = false;
    private boolean countingFragments = false;

    /**
     * Kick-off the file processing procedure by zeroing out necessary variables and getting everything
     * ready to run.
     **/
    public FleshKincaidLogic() {
        buildCommonMistakes(); //build list of words whose syllable counts are commonly miscalculated
        buildAbbreviations(); //build list of abbreviations, used to better track when sentences end

        addPunctuationThatEndsASentence(".");
        addPunctuationThatEndsASentence("?");
        addPunctuationThatEndsASentence("!");
        addPunctuationThatEndsASentence(";");

        //reset public variables for re-use
        wordsInFileNotIncludingFragments = 0;
        syllablesInFileNotIncludingFragments = 0;

        wordsInFile = 0;
        syllablesInFile = 0;
        sentencesInFile = 0;
    }

    public void processString(String inputText) {
        try {
            inputText = inputText.replaceAll("[^\\p{ASCII}]", " "); // convert non-ascii to spaces (but what about "cafŽ"?)
            inputText = inputText.replaceAll("\\r\\n?", "\n");     // convert all linebreaks to unix
            this.processText(inputText);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * This method is used each time a line from a file is processed.  Here is where the syllables,
     * sentences and other good things are counted.
     *
     * This method ignores words and syllables found in titles (a line of text not ended by a sentence,
     * seperated from the next line of text by a blank line) by default.
     *
     * @param textToProcess - the line of text that is being processed
     **/
    public void processText(String inputText) {
        //reset variables that won't be zero if another file was just processed
        wordsInFile = 0;
        syllablesInFile = 0;
        sentencesInFile = 0;
        wordsInFileNotIncludingFragments = 0;
        syllablesInFileNotIncludingFragments = 0;

        inputText = inputText.toLowerCase(); // might as well do this once, up front

        int syllablesInCurentToken = 0;

        String[] lineArray = inputText.split("\\n");

        for (int i = 0; i < lineArray.length; i++) {

            // blank lines probably follow headings
            // so reset the per-sentence counts and move to the next sentence
            if (lineArray[i].equals("")) {
                syllablesFromCurrentSentence = 0;
                wordsFromCurrentSentence = 0;
                justFoundEndOfSentence = false;
                continue;
            }

            StringTokenizer tok = new StringTokenizer(lineArray[i], " \t");

            while (tok.hasMoreTokens()) {
                String currentToken = tok.nextToken();
                //check to see if the token should be processed as a word
                //if not, it cannot count as a syllable, word, or end of a sentence
                if (!isWord(currentToken)) {
                    continue;
                }

                // keeps track of how many words are in the current sentence --
                // kept in its own variable so it can be reset as needed
                wordCountForOneWordSentenceTracking++;

                //tokens of length 1 cannot be the end of a sentence, as periods and other punctuation
                //are attacked to words (such as 'example.').  This avoids haveing a string of
                //punctuation marks (such as '. . .') counting as 3 sentences
                if (currentToken.length() != 1 && isEndOfSentence(currentToken)) {
                    justFoundEndOfSentence = true;
                    sentencesInFile++;

                    //reset since you are starting a new sentence
                    wordCountForOneWordSentenceTracking = 0;
                }

                //remove punctuation now that setences have been counted to simplify syllable counting
                currentToken = removePunctuationFromWord(currentToken);

                //get the number of syllables in the current token
                syllablesInCurentToken = countSyllables(currentToken);

                //track the number of syllables found in the current sentence
                syllablesFromCurrentSentence += syllablesInCurentToken;
                //System.out.println(currentToken + ": " + syllablesInCurentToken);

                //include the syllables for the current word in the overall count
                syllablesInFile += syllablesInCurentToken;
                wordsInFile++; //track the number of words found in the entire file
                wordsFromCurrentSentence++; //track the number of words found in the current sentence

                if (justFoundEndOfSentence == true) {
                    //update the words and syllables found they way they would be counted by MS Word
                    syllablesInFileNotIncludingFragments += syllablesFromCurrentSentence;
                    wordsInFileNotIncludingFragments += wordsFromCurrentSentence;
                    //starting a new sentence so reset the *fromCurrentSentence variables
                    syllablesFromCurrentSentence = 0;
                    wordsFromCurrentSentence = 0;
                    justFoundEndOfSentence = false;
                }

                //after the word has been processed, store the it
                //including the syllable count and the number
                //of times it has occured
                if (runStoreResults) {
                    wordList.storeResults(currentToken, syllablesInCurentToken);
                }
            }
        }

    }

    /**
     * Store characters (passed as Strings for convenience) that will be used
     * to determine the ends of sentences.  These values are gathered from user
     * choices made in the GUI.
     * @param String - punctuation that will mark the end of a sentence
     */
    public void addPunctuationThatEndsASentence(String punctuation) {
        //characters should only be 1 in length
        if (punctuation.length() != 1) {
            return;
        }
        if (punctuationThatEndSentences.contains(punctuation) == false) {
            punctuationThatEndSentences.add(punctuation);
        }
    }

    /**
     * Remove characters (passed as Strings for convenience) that will be used
     * to determine the ends of sentences.  These values are gathered from user
     * choices made in the GUI.
     * @param String - punctuation that will not mark the end of a sentence
     */
    public void removePunctuationThatEndsASentence(String punctuation) {
        //characters should only be 1 in length
        if (punctuation.length() != 1) {
            return;
        }
        if (punctuationThatEndSentences.contains(punctuation)) {
            punctuationThatEndSentences.remove(punctuation);
        }
    }

    /**
     * Take a token just gathered from the file being processsed and remove any punctuation or
     * other symbols from the beginning or end of the token to speed the syllable counting process.
     * @param String  - input which will have any leading or trailing punctuation symbols removed
     * @return String with leading or trailing punctuation removed
     **/
    private String removePunctuationFromWord(String input) {
        int wordLength = input.length();

        if (wordLength == 1) {
            return input;
        }

        int firstLetterIndex = 0;
        int lastLetterIndex = wordLength - 1;

        while (!Character.isLetterOrDigit(input.charAt(firstLetterIndex))) {
            firstLetterIndex++;
        }

        while (!Character.isLetterOrDigit(input.charAt(lastLetterIndex))) {
            lastLetterIndex--;
        }

        return input.substring(firstLetterIndex, lastLetterIndex + 1);
    }

    /**
     * If a token ends in a punctuation mark, a new sentence is considered to have been started.
     * If the length of the current token is not 1 then it is likely a word rather than
     * a punctuation mark.
     *
     * @param String The current word being processed
     * @return true if the end of a sentence has been found, else false
     **/
    private boolean isEndOfSentence(String word) {
        String currentPunctuation = "";

        //if you are in a one word sentence
        if (wordCountForOneWordSentenceTracking == 1 && punctuationThatEndSentences.contains(
                word.subSequence(word.length() - 1, word.length()))) {
            //this must be reset or the next sentence will apear to have an extra word
            wordCountForOneWordSentenceTracking = 0;
            //check for one number sentence chains -- 2 of them count for one sentence (in MS Word)
            // so every other one number sentence found consecutively is counted as a sentence
            if (isNumber(word)) { //if the one word sentence only contains a number
                if (countOneNumberSentences == true) {
                    countOneNumberSentences = false; //so the next one isn't counted..
                    return true;
                } else {
                    countOneNumberSentences = true; //now the next one found is counted
                }
            } //check for 1 character sentence chains
            // they only count for one sentence combined (in MS Word)
            else if (word.length() == 2) {
                if (inOneCharacterSentenceChain == true) {
                    return false; //when you 1st start a one word sentence chain a sentence is counted
                //another sentence is not counted until you find a 'real' sentence
                } else { //else inOneCharacterSentenceChain == false
                    inOneCharacterSentenceChain = true;
                }
            } //else you are not in a one character sentence chain
            else {
                inOneCharacterSentenceChain = false;
                return true;
            }
        } //else check for the word being a roman numeral or an abbreviation
        //if it is not one of those and the 1st punctuation mark encountered
        // is at the end of the word, then a sentence has ended
        //
        //to handle situations where someone puts their punctuation inside of quotes ("example.")
        // first remove an ending quote if there is one
        else {
            if (word.endsWith("\"")) {
                word = word.substring(0, word.length() - 1);
            }

            for (int i = 0; i < punctuationThatEndSentences.size(); i++) {
                currentPunctuation = String.valueOf(punctuationThatEndSentences.get(i));
                if (currentPunctuation.equals(".")) {
                    if (word.indexOf(".") == word.length() - 1) {
                        //roman numerals do not end sentences and abbreviations
                        //like Dr. or Ms. should not be counted as the ends of sentences
                        if (isRomanNumeral(word) == true || isAbbreviation(word) == true) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                } else {
                    if (word.indexOf(currentPunctuation) == word.length() - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Words cannot be Roman Numerals and must have at least one alphabetic character
     * unless it is a number.
     * @param String input
     * @return true if the String is a word, else false
     **/
    private boolean isWord(String input) {
        return (!isRomanNumeral(input) && (hasAlphabeticChars(input) || isNumber(input)));
    }

    /**
     * A number contains all digits, possibly ending with a punctuation mark.
     * @param String input
     * @return true if the String is a word, else false
     **/
    private boolean isNumber(String input) {
        int lastCharInWord = input.length() - 1;

        if (input.length() == 1) {
            return Character.isDigit(input.charAt(0));
        }

        //for input > 1 character long -- check and see if all but the last character is a digit
        for (int i = 0; i < lastCharInWord; i++) {
            if (Character.isDigit(input.charAt(i)) == false) {
                return false;
            }
        }

        //then check if the last character is either a digit or a punctuation mark
        if (Character.isDigit(input.charAt(lastCharInWord)) || isPunctuation(input.charAt(lastCharInWord))) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Retrieve the list of abbreviations stored in AbbreviationList.java
     **/
    private void buildAbbreviations() {
        abbreviationList = AbbreviationList.getAbbreviationList();
    }

    /**
     * Sentences end in periods but common abbreviations do also, so you need to check that a word
     * that ends with a period is not an abbreviation before assuming that it ends a sentence.
     * @param String the word being checked to see if it is an abbreviation
     * @return boolean true if the word is an abbreviation, else false
     */
    private boolean isAbbreviation(String word) {
        //only working with abbreviations that end in a period at this point
        if (word.charAt(word.length() - 1) != '.') {
            return false;
        }

        //check the current word to see if it is an abbreviation
        return abbreviationList.contains(word);
    }

    /**
     * In MS Word, Roman Numerals do not count as words so they do not mark the start
     * of sentences nor do they recieve syllable count.
     * @param String a candidate roman numeral
     * @return true if Roman Numeral, else false
     */
    private boolean isRomanNumeral(String word) {
        //I by itself will be assumed to be the pronoun; but setences don't end with I.
        if (word.equals("I")) {
            return false;
        }

        int length = word.length();
        int lastIndex = length - 1;

        for (int i = 0; i < length - 1; i++) {
            if (word.charAt(i) != 'I' &&
                    word.charAt(i) != 'V' &&
                    word.charAt(i) != 'X' &&
                    word.charAt(i) != 'L' &&
                    word.charAt(i) != 'C' &&
                    word.charAt(i) != 'D' &&
                    word.charAt(i) != 'M') {
                return false;
            }
        }

        //allow the last character to be another numeral or a period
        if (word.charAt(lastIndex) != 'I' &&
                word.charAt(lastIndex) != 'V' &&
                word.charAt(lastIndex) != 'X' &&
                word.charAt(lastIndex) != 'L' &&
                word.charAt(lastIndex) != 'C' &&
                word.charAt(lastIndex) != 'D' &&
                word.charAt(lastIndex) != 'M') {
            return false;
        }

        //checked everything, all is valid so roman numeral
        return true;

    }

    /**
     * Check and see if an item is a punctuation mark
     * @param char - candidate punctuation mark
     * @return true if punctuation mark, else false
     */
    private boolean isPunctuation(char word) {

        if (word == '.' || word == '!' || word == '?' || word == ',' || word == ';' || word == '-') {
            return true;
        }

        return false;
    }

    /**
     * Check a word and see how many characters it has in the alphabet
     * @param String input
     * @return Boolean whether the word has alphabetic characters
     */
    private boolean hasAlphabeticChars(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get the commonMistakes array, stored in CommonMistakes.java
     */
    private void buildCommonMistakes() {
        commonMistakes = CommonMistakes.getCommonMistakes();
    }

    /**
     * Check a word for the number of syllables.  A syllable is found when you find a vowel
     * followed by a constanent.  Words that end in 'e' do not get an extra syllable
     * (such as 'able' is only one syllable) but words that end in other vowels do get an
     * extra syllable. Words that end in 'le' get an extra syllable for the 'le' as that is
     * pronouced like 'el'.
     * @param String representing the word to be examined
     * @return int syllableCount
     */
    private int countSyllables(String word) {
        word = word.toLowerCase(); //to make character comparisons easier
        int wordLength = word.length();

        //if the word is a common mistake (i.e., the below logic commonly assigns the wrong syllable
        // count to it) then return the value stored in the commonMistakes hash, which
        // was created in the buildCommonMistakes() method.
        if (commonMistakes.containsKey(word)) {
            return Integer.parseInt(String.valueOf(commonMistakes.get(word))); // can't cast to int. is looseness with int/Integer sloppy here?
        }

        //'words' that are web addresses (like www.ncsu.edu/students/reg_records/tracks_link" should
        //not be counted to have something like 15 syllables, as this can really inflate
        //the score of a document. So words that seem to be web addresses are counted as 1 syllable,
        //as are email addresses (as many of those will reciev a syllable count > 10 syllables)
        if (word.indexOf("www") > 0 || word.indexOf("http") > 0 || word.indexOf("@") > 0 || word.indexOf(".co") > 0) {
            return 1;
        }

        int syllableCount = 0;
        char stringArray[] = word.toCharArray(); //process the input as a char array

        for (int i = 0; i < wordLength; i++) {

            if (isVowel(stringArray[i])) {
                //if you find and 'e' and
                //	the last two characters are 'ly' then only add
                //	one additional vowel ('effectively' or 'collectively')
                //or
                //  the last character is a an 's' treat it like a word ending in e,
                //	which is silent
                if (stringArray[i] == 'e') {
                    if (i + 3 == wordLength && word.substring(i).equals("ely")) {
                        syllableCount++;
                        return syllableCount;
                    }
                }

                //if you are on the last character and have just
                //found a vowel and it is not an e then add a syllable
                //(e at the end is silent)
                if (i + 1 == wordLength) {
                    if (stringArray[i] != 'e') {
                        syllableCount++;
                    } //else if you find a vowel and you are on the
                    //last character and  the previous character
                    //was an l, add a syllable
                    //Ex: apple has 2 syllables even though it ends in an usually silent e
                    else {
                        if (wordLength > 1) {
                            if (stringArray[i - 1] == 'l') {
                                syllableCount++;
                            }
                        }
                    }
                } //else if you have found a vowel but the next
                //character is a constanent
                else {
                    //as words are generally vowels sepearted by constanents,
                    //keep checking until you find a constanent as then you
                    //have found another syllable
                    while (i < wordLength - 1) {
                        i++; //you have already checked the character i is pointing to
                        //so increment it to check the next one
                        if (isVowel(stringArray[i]) == false && (Character.isLetter(stringArray[i]) == true)) {
                            syllableCount++;
                            break; //found a syllable, so return
                        //to the main loop to look for another
                        }
                    }
                }
            }
        }

        if (syllableCount == 0) {
            syllableCount = 1; //all words have at least one syllable
        }
        return syllableCount;
    }

    /**
     * Check a character and determine if it is a vowel. Ys are always counted as vowels.
     * @param char to check to see if it is a vowel
     * @return boolean true if vowel, else false
     */
    private boolean isVowel(char input) {
        if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u' || input == 'y') {

            return true;
        }
        return false;
    }

    /**
     * Toggle whether or not the Flesch results returned include words and syllables
     * found in framgments
     * @param inputBoolean
     */
    public void setCountingFragment(boolean inputBoolean) {
        countingFragments = inputBoolean;
    }

    public boolean getCountingFragments() {
        return countingFragments;
    }

    /**
     * Simple getter method to retrieve number of the number of words in the input file.
     * For this method, sentence fragments such as titles or setences that have a hard line break
     * (like the start of a new paragraph) before ending punctuation are not included if countingFragments
     * is false. If it is true, they are included.
     * @return int the number of words in the file
     */
    public int getWordsInFile() {
        if (countingFragments) {
            return wordsInFile;
        } else {
            return wordsInFileNotIncludingFragments;
        }
    }

    /**
     * Simple getter method to retrieve number of the number of sentences in the input file.
     * @return int the number of setences in the file
     */
    public int getSentencesInFile() {
        return sentencesInFile;
    }

    /**
     * Simple getter method to retrieve number of the number of syllables in the input file.
     * For this method, syllables found in sentence fragments such as titles or setences that have a hard line break
     * (like the start of a new paragraph) before ending punctuation are not included if countingFragments
     * is false. If it is true, they are included.
     * @return int the number of words in the file
     */
    public int getSyllablesInFile() {
        if (countingFragments) {
            return syllablesInFile;
        } else {
            return syllablesInFileNotIncludingFragments;
        }
    }

    /**
     * Calculates and returns the number of the average number of syllables per
     * word in the input file. For this method, sentence fragments such as titles or
     * setences that have a hard line break (like the start of a  new paragraph) before
     * ending punctuation are not included if countingFragments
     * is false. If it is true, they are included.
     * @return double the number of syllables per words in the file
     */
    public double getSyllablesPerWordInFile() {
        if (countingFragments) {
            return ((double) syllablesInFile / (double) wordsInFile);
        } else {
            return ((double) syllablesInFileNotIncludingFragments / (double) wordsInFileNotIncludingFragments);
        }
    }

    public double getFleschKincaidGradeLevel() {
        if (countingFragments) {
            return getFleschKincaidGradelLevelIncludingFragments();
        } else {
            return getFleschKincaidGradelLevelNotIncludingFragments();
        }
    }

    public double getFleschReadingEaseScore() {
        if (countingFragments) {
            return getFleschReadingEaseIncludingFragments();
        } else {
            return getFleschReadingEaseNotIncludingFragments();
        }
    }

    /**
     * Calculates and returns the file's Flesch readability ease score, including
     * words and syllables found in fragments/titles/section headings.
     * @return double the files Flesch reading ease score, ranging from 0 to 100
     */
    private double getFleschReadingEaseIncludingFragments() {
        double fleschReadingEase = 0.0;

        fleschReadingEase = 206.835 - (1.015 * ((double) wordsInFile / (double) sentencesInFile)) - (84.6 * getSyllablesPerWordInFile());

        if (fleschReadingEase < 0) {
            fleschReadingEase = 0;
        }
        if (fleschReadingEase > 100) {
            fleschReadingEase = 100;
        }

        return fleschReadingEase;
    }

    /**
     * Calculates and returns the file's Flesch readability ease score.
     * For this method, sentence fragments such as titles or setences that have a hard line break
     * (like the start of a new paragraph) before ending punctuation are not included.
     * @return double the files Flesch reading ease score, ranging from 0 to 100
     */
    private double getFleschReadingEaseNotIncludingFragments() {
        double fleschReadingEase = 0.0;

        fleschReadingEase = 206.835 - (1.015 * ((double) wordsInFileNotIncludingFragments / (double) sentencesInFile)) - (84.6 * getSyllablesPerWordInFile());

        if (fleschReadingEase < 0) {
            fleschReadingEase = 0;
        }
        if (fleschReadingEase > 100) {
            fleschReadingEase = 100;
        }

        return fleschReadingEase;
    }

    /**
     * Calculate and return the files Flesch-Kincaid grade level score, including
     * words and syllables found in fragments/titles/section headings.
     * @return double the files Flesch-Kincaid grade level score, ranging from 0 to ?
     */
    private double getFleschKincaidGradelLevelIncludingFragments() {
        double fleschKincaidGradeLevel = 0.0;

        fleschKincaidGradeLevel = ((0.39 * ((double) wordsInFile / (double) sentencesInFile)) + (11.8 * getSyllablesPerWordInFile())) - 15.59;

        if (fleschKincaidGradeLevel < 0) {
            fleschKincaidGradeLevel = 0;
        }
        return fleschKincaidGradeLevel;
    }

    /**
     * Calculate and return the files Flesch-Kincaid grade level score. For this method,
     * sentence fragments such as titles or setences that have a hard line break (like the start of a
     * new paragraph) before ending punctuation are not included.
     * @return double the files Flesch-Kincaid grade level score, ranging from 0 to ?
     */
    private double getFleschKincaidGradelLevelNotIncludingFragments() {
        double fleschKincaidGradeLevel = 0.0;

        fleschKincaidGradeLevel = ((0.39 * ((double) wordsInFileNotIncludingFragments / (double) sentencesInFile)) + (11.8 * getSyllablesPerWordInFile())) - 15.59;

        if (fleschKincaidGradeLevel < 0) {
            fleschKincaidGradeLevel = 0;
        }
        return fleschKincaidGradeLevel;
    }

    public double getAverageWordsPerSentence() {
        if (countingFragments) {
            return getAverageWordsPerSentenceIncludingFragments();
        } else {
            return getAverageWordsPerSentenceNotIncludingFragments();
        }
    }

    /**
     * Return the average words per sentence, including any titles or fragments in the file
     * @return the average words per sentence in the text just processed
     */
    private double getAverageWordsPerSentenceIncludingFragments() {

        if (wordsInFile > 0 && sentencesInFile > 0) {
            return (((double) wordsInFile / (double) sentencesInFile));
        } else {
            return 0.0;
        }
    }

    /**
     * Return the average words per sentence, NOT including any titles or fragments in the file
     * @return the average words per sentence in the text just processed
     */
    private double getAverageWordsPerSentenceNotIncludingFragments() {

        if (wordsInFile > 0 && sentencesInFile > 0) {
            return (((double) wordsInFileNotIncludingFragments / (double) sentencesInFile));
        } else {
            return 0.0;
        }
    }

    /**
     * Set runStoreResults to either true or false
     * @param boolean - true to store each word in the input files number of occurances
     * and syllable count in the ArrayList wordList, else false
     */
    public void setStoreResults(boolean newValue) {
        runStoreResults = newValue;
    }

    /**
     * Tell if information about each word in the input file is going to be stored in the ArrayList wordList
     * @return boolean - true if storing results, else false
     */
    public boolean getStoreResults() {
        return runStoreResults;
    }

    /**
     * Return the WordList wordList
     * @return WordList of Word Objects.
     */
    public WordList getWordList() {
        return wordList;
    }

    public boolean isSentenceValid(String sentence) {
        if (this.isAbbreviation(sentence)) {
            return false;
        }
        
        if (this.isNumber(sentence)) {
            return false;
        }

        if (this.isRomanNumeral(sentence)) {
            return false;
        }

        if (!this.hasAlphabeticChars(sentence)) {
            return false;
        }

        return true;
    }
}
