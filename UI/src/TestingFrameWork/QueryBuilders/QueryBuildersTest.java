/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingFrameWork.QueryBuilders;

import Helper.FileHelper;
import Helper.SortingHelper;
import internetsearch.ResponseResult;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Brave Heart
 */
public final class QueryBuildersTest {

    private final File testDataFolder;
    private final QuerySelectionAlgorithm algo;
    private final InternetSearchAPI internetSearchAPI;
    private ArrayList<String> preferedWebsitesList;
    private final int retrievedDocument = 10;
    private final int releventDocument = 5;
    private Desktop desktop = null;

    // Constructer - set the test data path
    public QueryBuildersTest(File testDataFolder, QuerySelectionAlgorithm algo, InternetSearchAPI internetSearchAPI) {
        this.testDataFolder = testDataFolder;
        this.algo = algo;
        this.internetSearchAPI = internetSearchAPI;

        preferedWebsitesList = new ArrayList<String>();
        this.addPreferedWebsite("http://en.wikipedia.org/");
        this.addPreferedWebsite("http://www.encyclopedia.com/");

        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
    }

    public void addPreferedWebsite(String website) {
        preferedWebsitesList.add(website);
    }

    public void generateReport() {
        // list files in the test data folder and extract the informations
        ArrayList<String> fileList = FileHelper.listFilesInFolder(testDataFolder);
        ArrayList<TestResult> testResultList = new ArrayList<TestResult>();
        for (Iterator<String> it = fileList.iterator(); it.hasNext();) {
            String testFile = it.next();
            System.err.println(testFile);
            // Store list of sources appear most
            HashMap<String, Integer> sources = new HashMap<String, Integer>();
            HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();

            // 
            int numOfActualSourceOccurences = 0;

            // Get query list from current file
            ArrayList<String> queryList = algo.getQueryList(testFile);
            int numOfQuery = queryList.size();

            // search internet for each query and get responses
            for (Iterator<String> it1 = queryList.iterator(); it1.hasNext();) {
                String query = it1.next();
                System.out.println(query);
                if (query.trim() != "") {
                    ArrayList<ResponseResult> responseList = internetSearchAPI.searchInternet(query);

                    if (!responseList.isEmpty()) {
                        for (Iterator<ResponseResult> it2 = responseList.iterator(); it2.hasNext();) {
                            ResponseResult responseResult = it2.next();
                            // if url already exist
                            String result = responseResult.getUrl();
                            int increment = 1;

                            // check weather prefered website
                            boolean isPreferedWebsite = false;
                            for (Iterator<String> it3 = preferedWebsitesList.iterator(); it3.hasNext();) {
                                String website = it3.next();
                                if (result.startsWith(website)) {
                                    isPreferedWebsite = true;
                                }
                            }

                            if (isPreferedWebsite) {
                                increment = 2;
                            }

                            if (sources.get(result) != null) {
                                int num = sources.get(result) + increment;
                                sources.put(result, num);
                            } // if url doesnt exist in hashmap
                            else {
                                sources.put(result, increment);
                            }
                        }
                    }
                }
            }

            // Sorting hashmap
            HashMap<String, Integer> sortedSources = (HashMap<String, Integer>) SortingHelper.sortByValue(sources);
            Iterator sortedSourceIterator = sortedSources.entrySet().iterator();
            int numberOfSelectedDoc = 1;
            while (sortedSourceIterator.hasNext() && numberOfSelectedDoc <= retrievedDocument) {
                Map.Entry pair = (Map.Entry) sortedSourceIterator.next();
                String key = (String) pair.getKey();
                int value = (Integer) pair.getValue();
                selectedSources.put(key, value);
                numberOfSelectedDoc++;
                try {
                    try {
                        desktop.browse(new URI(key));
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(QueryBuildersTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(QueryBuildersTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (JOptionPane.showConfirmDialog(null, key, "Is this a relevent source ??", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    numOfActualSourceOccurences++;
                    //  System.out.println(numOfActualSourceOccurences);
                }
            }
            int unretrievedNum = 0;
            unretrievedNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Relevent data " + releventDocument, "Enter num of unretrieved data:", JOptionPane.QUESTION_MESSAGE));

            TestResult testResult = new TestResult();
            testResult.precision = this.getPrecision(numOfActualSourceOccurences);
            testResult.recall = this.getRecall(unretrievedNum);
            testResult.fmeasure = this.getFMeasure(testResult.precision, testResult.recall);
            testResultList.add(testResult);
            //System.out.println(testFile + " : " + "Number of queries : " + numOfQuery);
        }
        //for each file - search internet and get the sources for the document
        for (Iterator<TestResult> it = testResultList.iterator(); it.hasNext();) {
            TestResult testResult = it.next();
            System.out.println(testResult.precision + " " + testResult.recall + " " + testResult.fmeasure);
        }
        // analyze the outcome and present documen
    }

    public float AvarageNumberOfQueried() {
        float avargeNumberOfQueries = 0.0f;
        ArrayList<String> fileList = FileHelper.listFilesInFolder(testDataFolder);
        int numOfFiles = fileList.size();
        int numOfQueries = 0;
        for (Iterator<String> it = fileList.iterator(); it.hasNext();) {
            String filePath = it.next();
            numOfQueries += algo.getQueryList(filePath).size();
            System.out.println(filePath + " : " + numOfQueries);
        }
        avargeNumberOfQueries = (float) numOfQueries / numOfFiles;
        return avargeNumberOfQueries;
    }

    private float getPrecision(int truePositive) {
        return (float) truePositive / retrievedDocument;
    }

    private float getRecall(int unretrievedDocuments) {
        return (float) (releventDocument - unretrievedDocuments) / releventDocument;
    }

    private float getFMeasure(float precision, float recall) {
        return 2 * (precision * recall) / (precision + recall);
    }

    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser(System.getProperty("user.home") + File.separatorChar + "Desktop");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File rootFolder = fc.getSelectedFile();
            QueryBuildersTest test = new QueryBuildersTest(rootFolder,
                    new MyQueryBuilder(),
                    new BingSearchAPI());
            test.generateReport();
            //JOptionPane.showMessageDialog(null, "Avg : " + test.AvarageNumberOfQueried());
        }
    }
}

class TestResult {

    public float precision;
    public float recall;
    public float fmeasure;
}
