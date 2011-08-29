/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingFrameWork.QueryBuilders;

import ch.randelshofer.quaqua.ext.base64.Base64.InputStream;
import ch.randelshofer.quaqua.ext.base64.Base64.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.jfree.ui.ExtensionFileFilter;

/**
 *
 * @author Brave Heart
 */
public class ExtractCorpus {

    private File folder;
    private File xlsSheet;
    private ArrayList<String> heavilyCopiedList;
    private ArrayList<String> nearCopiedList;
    private ArrayList<String> lightCopiedList;

    public ExtractCorpus(File folder, File xlsSheet) {
        this.folder = folder;
        this.xlsSheet = xlsSheet;

        heavilyCopiedList = new ArrayList<String>();
        nearCopiedList = new ArrayList<String>();
        lightCopiedList = new ArrayList<String>();
    }

    public void createCorpus() {
        File hevilyCopiedFolder = new File(folder.getAbsolutePath() + File.separatorChar + "HeavyCopied");
        File lightCopiedFolder = new File(folder.getAbsolutePath() + File.separatorChar + "LightCopied");
        File nearCopiedFolder = new File(folder.getAbsolutePath() + File.separatorChar + "NearCopied");

        hevilyCopiedFolder.mkdir();
        lightCopiedFolder.mkdir();
        nearCopiedFolder.mkdir();

        readExcelSheet();

        int documentSize = 19;
        for (int i = 0; i < documentSize; i++) {
            this.copyFile(new File(folder.getAbsolutePath() + File.separatorChar + heavilyCopiedList.get(i)),
                    new File(hevilyCopiedFolder.getAbsolutePath() + File.separatorChar + heavilyCopiedList.get(i)));

            this.copyFile(new File(folder.getAbsolutePath() + File.separatorChar + nearCopiedList.get(i)),
                    new File(nearCopiedFolder.getAbsolutePath() + File.separatorChar + nearCopiedList.get(i)));

            this.copyFile(new File(folder.getAbsolutePath() + File.separatorChar + lightCopiedList.get(i)),
                    new File(lightCopiedFolder.getAbsolutePath() + File.separatorChar + lightCopiedList.get(i)));

        }

        System.out.println();
        for (Iterator<String> it = heavilyCopiedList.iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println(string);
        }

        System.out.println();
        for (Iterator<String> it = lightCopiedList.iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println(string);
        }

        System.out.println();
        for (Iterator<String> it = nearCopiedList.iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println(string);
        }

    }

    private void readExcelSheet() {
        try {
            FileInputStream fileInputStream = new FileInputStream(xlsSheet);

            POIFSFileSystem fileSystem = new POIFSFileSystem(fileInputStream);

            HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
            HSSFSheet sheet = workBook.getSheetAt(1);

            Iterator rowIterator = sheet.rowIterator();
            rowIterator.next();

            while (rowIterator.hasNext()) {
                HSSFRow row = (HSSFRow) rowIterator.next();
                Iterator cellIterator = row.cellIterator();

                String file = cellIterator.next().toString();
                String category = cellIterator.next().toString();
                System.out.println(file + " : " + category);
                if (category.equals("cut")) {
                    nearCopiedList.add(file);
                } else if (category.equals("heavy")) {
                    heavilyCopiedList.add(file);
                } else if (category.equals("light")) {
                    lightCopiedList.add(file);
                }
            }

            fileInputStream.close();
        } catch (Exception ex) {
        }

    }

    private void copyFile(File source, File dest) {
        try {
            FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(dest, false);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();

        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File folder = fc.getSelectedFile();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.setFileFilter(new ExtensionFileFilter("Excel sheet", "xls"));
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File xlsSheet = fc.getSelectedFile();
                ExtractCorpus ec = new ExtractCorpus(folder, xlsSheet);
                ec.createCorpus();
            }
        }

    }
}
