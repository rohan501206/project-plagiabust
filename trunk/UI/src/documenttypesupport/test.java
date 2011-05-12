/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documenttypesupport;

import java.io.File;

/**
 *
 * @author Brave Heart
 */
public class test {

    public static void main(String[] args) {
        String folder = "C:/Users/Brave Heart/Desktop/New folder";
        File souceFolder = new File(folder);
        if(souceFolder.isDirectory()){
            String destFolderPath = souceFolder.getAbsolutePath() + File.separator + souceFolder.getName();
            boolean destFolderCreated = new File(destFolderPath).mkdir();
            if(destFolderCreated){
                    AnyToTextConverter tc = new AnyToTextConverter(destFolderPath);
                    tc.convertFilesInFolder(folder);
            }
        }



    }
}
