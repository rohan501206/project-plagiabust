/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author nuwan
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;



import ComparisonEngine.ShingleCloudAlgorithm;
import gui.form.ProgressBarManager;
import gui.form.WizardForm;
import java.util.HashMap;
import java.util.concurrent.Callable;
import paraphaseDetection.ParaphaseManage;

/**
 *
 * @author nuwan
 */
public class SingleSearchIndexedFileProcessor implements Callable {

    private ArrayList<String> preIndexedFiles;
    private ProgressBarManager crossCheck;
    private String preprocessTextOfTheComparisonFile;
    private HashMap hm;
    private String downloadedFolderPath;
    private String documentToCompare;
    private boolean paraphaseDetection;
    private int iteration;
    private HashMap<String, String[]> resultsMap = new HashMap<String, String[]>();
    String Text = "";

    public SingleSearchIndexedFileProcessor() {
    }

    public SingleSearchIndexedFileProcessor(ArrayList<String> preIndexedFilesTemp, ProgressBarManager crossCheckTemp, String preprocessTextOfTheComparisonFileTemp, HashMap hmTemp, String downloadedFolderPathTemp, String documentToCompareTemp, boolean paraphaseDetectionTemp, int iterationTemp, HashMap<String, String[]> resultsMapTemp,String text) {
        preIndexedFiles = preIndexedFilesTemp;
        crossCheck = crossCheckTemp;
        preprocessTextOfTheComparisonFile = preprocessTextOfTheComparisonFileTemp;
        hm = hmTemp;
        downloadedFolderPath = downloadedFolderPathTemp;
        documentToCompare = documentToCompareTemp;
        paraphaseDetection = paraphaseDetectionTemp;
        iteration = iterationTemp;
        this.Text = text;

    }

    public HashMap<String, String[]> call() throws Exception {

        WizardForm.crosscheckLabel.setText(Text);
        String[] matchValue = new String[4];

        if (iteration == preIndexedFiles.size() - 1) {
            crossCheck.runProgress(100);
        } else {
            crossCheck.runProgress((iteration * 100) / preIndexedFiles.size());
        }

        ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
        float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(preIndexedFiles.get(iteration)).toString());
        String match = sca.getList();

        String[] matchedText = new String[2];
        // Paraphased added
        float paraphasedValue = 0;

        //use paraphase detection
        if (paraphaseDetection) {
            ParaphaseManage paramanager = new ParaphaseManage(documentToCompare, preIndexedFiles.get(iteration), downloadedFolderPath);
            matchedText = paramanager.getMatchList();
            paraphasedValue = paramanager.getPlagiarismValueForParaphraseDetect(match);
        } else {
            matchedText[0] = "";
            matchedText[1] = "";
            paraphasedValue = 0;

        }
        String firstFile = documentToCompare;
        String secondFile = preIndexedFiles.get(iteration);
        System.out.println();
        System.out.println(firstFile);
        System.out.println(secondFile);
        if (match.length() > 0) {
            System.out.println("match is " + match);
        } else {
            System.out.println("There is no match between the above two files");
        }
        System.out.println();
        if ((!match.isEmpty() && !(firstFile.equalsIgnoreCase(secondFile))) || (!(firstFile.equalsIgnoreCase(secondFile)) && !matchedText[0].isEmpty())) {
            //////////////// just for testing purposes
            matchValue[0] = match;
            if(roundNumber(output, 2) * 100 / 2 + paraphasedValue > 100){
                matchValue[1] = "100";
            }
            else{
                matchValue[1] = String.valueOf(roundNumber(output, 2) * 100 / 2 + paraphasedValue);
            }
            matchValue[2] = matchedText[0];
            matchValue[3] = matchedText[1];
            resultsMap.put(secondFile, matchValue);
            // fileNo++;


        }


        return resultsMap;


    }

    public float roundNumber(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float) tmp / p;
    }
}
