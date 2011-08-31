/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import ComparisonEngine.ShingleCloudAlgorithm;
import gui.form.ProgressBarManager;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Callable;
import paraphaseDetection.ParaphaseManage;

/**
 *
 * @author nuwan
 */
public class SingleSearchDownloadFileProcessor implements Callable {

    String[] downloadedFilesList;
    ProgressBarManager crossCheck;
    String preprocessTextOfTheComparisonFile;
     HashMap hm;
     String downloadedFolderPath;
     String documentToCompare;
     boolean paraphaseDetection;
     int iteration;
     HashMap<String,String[]> resultsMap= new HashMap<String,String[]>();


    public SingleSearchDownloadFileProcessor(){

    }

    SingleSearchDownloadFileProcessor(String[] downloadedFilesListTemp, ProgressBarManager crossCheckTemp, String preprocessTextOfTheComparisonFileTemp, HashMap hmTemp, String downloadedFolderPathTemp, String documentToCompareTemp, boolean paraphaseDetectionTemp,int iterationTemp,HashMap<String,String[]> resultsMapTemp) {
        downloadedFilesList=downloadedFilesListTemp;
     crossCheck=crossCheckTemp;
     preprocessTextOfTheComparisonFile=preprocessTextOfTheComparisonFileTemp;
      hm=hmTemp;
      downloadedFolderPath=downloadedFolderPathTemp;
     documentToCompare=documentToCompareTemp;
      paraphaseDetection=paraphaseDetectionTemp;
      iteration= iterationTemp;
      //resultsMap=resultsMapTemp;

    }

    public HashMap<String,String[]> call() throws Exception {


        String[] matchValue=new String[4];
             if(iteration==downloadedFilesList.length-1){
                crossCheck.runProgress(100);
             }
             else{
                  crossCheck.runProgress((iteration*100)/downloadedFilesList.length);
             }
            ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
            float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(downloadedFilesList[iteration]).toString());
            String match = sca.getList();
            String firstFile = documentToCompare;
            String secondFile = downloadedFolderPath + File.separator + downloadedFilesList[iteration];

            String[] matchedText=new String[2];

            float paraphasedValue = 0;
            
            if(paraphaseDetection){
                ParaphaseManage paramanager = new ParaphaseManage(firstFile,secondFile, downloadedFolderPath);
                matchedText = paramanager.getMatchList();
                paraphasedValue = paramanager.getPlagiarismValueForParaphraseDetect(match);
            }
            else{
                matchedText[0] = "";
                matchedText[1] = "";
                 paraphasedValue = 0;
            }

            System.out.println();
            System.out.println(firstFile);
            System.out.println(secondFile);
            System.out.println("match is " + match);
            System.out.println();



            if ((!match.isEmpty() &&  !(firstFile.equalsIgnoreCase(secondFile)))  || (!(firstFile.equalsIgnoreCase(secondFile)) && !matchedText[0].isEmpty() )) {

                matchValue[0] = match;
                matchValue[1] = String.valueOf(roundNumber(output,2)*100/2 + +paraphasedValue);
                matchValue[2] = matchedText[0];
                matchValue[3] = matchedText[1];
                resultsMap.put(secondFile, matchValue);
            }



return resultsMap;


    }



  public float roundNumber(float Rval, int Rpl) {
  float p = (float)Math.pow(10,Rpl);
  Rval = Rval * p;
  float tmp = Math.round(Rval);
  return (float)tmp/p;
  }

}
