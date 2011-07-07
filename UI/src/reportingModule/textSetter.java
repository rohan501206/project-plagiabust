/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class textSetter {
    

    public static void main(String[] args) {

    HashMap hm=new HashMap();



   // File file=new File("C:\\Users\\user\\Desktop\\Assignments - 100\\Assignments - 100\\070039N_SAD.txt");
    

    textSetter m=new textSetter();
    //String content=m.textSetter("C:\\Users\\user\\DesktopC:\\Users\\user\\Desktop\\Assignments - 100\\Assignments - 100\\070039N_SAD.txt\\Assignments - 100\\Assignments - 100\\070039N_SAD.txt");
     String content=m.textSetter("/home/nuwan/Desktop/Assignments - 100/new/new/070166B_SWArchitectureDoc.txt");
    hm.put("field", content );
        JasperReport jasperReport;
    JasperPrint jasperPrint;
    try
    {
      //jasperReport = JasperCompileManager.compileReport(
       //   "C:\\Users\\user\\Desktop\\jasper reporting\\report2.jrxml");
      jasperReport = JasperCompileManager.compileReport(
          "/media/0CF0A659F0A64932/Users/user/Desktop/jasper reporting/report2.jrxml");

      ///media/0CF0A659F0A64932/Users/user/Desktop/jasper reporting
      jasperPrint = JasperFillManager.fillReport(
          jasperReport, hm, new JREmptyDataSource());
      //JasperViewer.viewReport(jasperPrint);


      JFrame frame = new JFrame("Report");
frame.getContentPane().add(new JRViewer(jasperPrint));
frame.pack();
frame.setVisible(true);

    }



    catch (JRException e)
    {
      e.printStackTrace();
    }

}



    public String textSetter(String fileName1) {

        String text="";
        File testFile1 = new File(fileName1);
       // File testFile2 = new File(fileName2);
        String field1 = "";
        //String field2 = "";
        try {
            FileReader fr = new FileReader(testFile1);
          //  FileReader fr2 = new FileReader(testFile2);

            BufferedReader br = new BufferedReader(fr);
            //BufferedReader br2 = new BufferedReader(fr2);
            System.out.println("testing phase");


            field1 = this.bufferedReaderToString(br);
           // field2 = this.bufferedReaderToString(br2);
        } catch (IOException ex) {
           // Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        text= field1;
        //text[1] = field2;
        return text;
    }

    private String bufferedReaderToString(BufferedReader inputBufferedReader) {
        StringBuffer fileAsText = new StringBuffer();

        try {
            String line = null;
            while ((line = inputBufferedReader.readLine()) != null) {

                line = line.replaceAll("[^\\p{ASCII}]", " ");
                line = line + "\n";
                fileAsText.append(line);
            }
        } catch (Exception e) {
        }

        return fileAsText.toString();
    }
}






