package Helper;


import java.io.File;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brave Heart
 */
public class FileHelper {
    
    private static ArrayList<String> queue = new ArrayList<String>();
    
    public static ArrayList<String> listFilesInFolder(File file){
        if(!queue.isEmpty()){
            queue.clear();
        }
        
        listFiles(file);
        
        return queue;
    }
    
    private static void listFiles(File file) {
        if (!file.exists()) {
            System.out.println(file + " does not exist.");
        }
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                listFiles(f);
            }
        } else {
            String filename = file.getName().toLowerCase();

            if (filename.endsWith(".txt")) {
                queue.add(file.getPath());
            }
        }
    }
    
}
