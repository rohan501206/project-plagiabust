/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import preprocess.StopWordRemover;

/**
 *
 * @author isuru
 */
public class QueryCreator {

    private ArrayList<String> sentenceList = new ArrayList<String>();
    private ArrayList<SentenceResult> sentenceResultList = new ArrayList<SentenceResult>();
    private Double flechKincaidGradeLevel;
    String[] newSentenceList;
    private int totalSentences = 0;
    private int numOfSelected = 0;
    private String inputText = "";
    private float randomSelectionRatio = 0.5f;

    public QueryCreator() {
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

    public ArrayList<String> getQueryList(String fileName, QuerySelectionAlgorithm querySelectionAlgo) {
        this.txtToString(fileName);

        this.processText();
        if (querySelectionAlgo == QuerySelectionAlgorithm.Random) {
            return this.selectRandomSentences();
        } else {
            return sentenceList;
        }
    }

    private void processText() {
        inputText = inputText.toLowerCase();
        String[] lineArray = inputText.split("[.:;.]");
        newSentenceList = inputText.split("[.:;.]");
    }

    private ArrayList<String> selectRandomSentences() {
        ArrayList<String> selectedSentencesList = new ArrayList<String>();

        FleshKincaidLogic fkl = new FleshKincaidLogic();
        fkl.processString(inputText);
        flechKincaidGradeLevel = fkl.getFleschKincaidGradeLevel();
        System.out.println("Flesh Kincaid Grade Level:    " + fkl.getFleschKincaidGradeLevel());

        for (int j = 0; j < newSentenceList.length; j++) {
            FleshKincaidLogic fklnew = new FleshKincaidLogic();

            if (fklnew.isSentenceValid(newSentenceList[j] + ".")) {

                fklnew.processString(newSentenceList[j] + ".");
                Double sentenceGradeLevel = fklnew.getFleschKincaidGradeLevel();

                System.out.println
                           ("Flesh Kincaid Grade Level of " + j + fklnew.getFleschKincaidGradeLevel());

                if (!sentenceGradeLevel.isNaN()) {
                    SentenceResult sentenceResult = new SentenceResult();
                    sentenceResult.sentence = newSentenceList[j];
                    sentenceResult.score = fklnew.getFleschKincaidGradeLevel();

                    sentenceResultList.add(sentenceResult);
                }
            }
        }

        selectedSentencesList = this.getSelectedSentenceList();
        return selectedSentencesList;
    }

    private ArrayList<String> getSelectedSentenceList() {
        ArrayList<String> filteredSentenceList = new ArrayList<String>();
        ArrayList<String> suspiciousSentenceList = new ArrayList<String>();

        int totalSentences = newSentenceList.length;
        Float estimatedNumberOfSentences = totalSentences * randomSelectionRatio;
        int roundedNumberOfSentences = estimatedNumberOfSentences.intValue();

        for (int i = 0; i < sentenceResultList.size(); i++) {
            
            if (sentenceResultList.get(i).score < 10) {
                StopWordRemover stopWordRemover = new StopWordRemover();
                ArrayList<String> stopWordsRemovedList;
                String stopWordsRemovedSentence = "";

                try {
                    stopWordsRemovedList = stopWordRemover.analyze(sentenceResultList.get(i).sentence);
                    stopWordsRemovedSentence = this.arraylistToSting(stopWordsRemovedList);
                } catch (IOException ex) {
                    Logger.getLogger(QueryCreator.class.getName()).log(Level.SEVERE, null, ex);
                }

                filteredSentenceList.add(stopWordsRemovedSentence);
            }
        }

        if (filteredSentenceList.size() < 20) {
            suspiciousSentenceList = filteredSentenceList;
        } else {
            if (roundedNumberOfSentences < 20) {
                int count = 0;
                while (count < 20) {
                    boolean isExist = false;
                    Random random = new Random();
                    int nextValue = random.nextInt(filteredSentenceList.size());

                    for (Iterator<String> it = suspiciousSentenceList.iterator(); it.hasNext();) {
                        String string = it.next();
                        if (string.equals(filteredSentenceList.get(nextValue))) {
                            isExist = true;
                        }
                    }

                    if (!isExist) {
                        suspiciousSentenceList.add(filteredSentenceList.get(nextValue));
                        count++;
                    }
                }
            } else {
                int count = 0;
                while (count < roundedNumberOfSentences) {
                    boolean isExist = false;
                    Random random = new Random();
                    int nextValue = random.nextInt(filteredSentenceList.size());

                    for (Iterator<String> it = suspiciousSentenceList.iterator(); it.hasNext();) {
                        String string = it.next();
                        if (string.equals(filteredSentenceList.get(nextValue))) {
                            isExist = true;
                        }
                    }

                    if (!isExist) {
                        suspiciousSentenceList.add(filteredSentenceList.get(nextValue));
                        count++;
                    }
                }
            }
        }

        return suspiciousSentenceList;
    }

    private String arraylistToSting(ArrayList<String> token) {
        StringBuilder out = new StringBuilder();
        for (Object o : token) {
            out.append(o.toString());
            out.append(" ");
        }
        return out.toString();
    }

    public ArrayList<String> selectSentencesExhaustively() {
        return sentenceList;
    }
}
