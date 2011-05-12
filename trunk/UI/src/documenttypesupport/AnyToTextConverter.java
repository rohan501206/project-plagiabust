package documenttypesupport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

/**
 *
 * @author isuru
 */
public class AnyToTextConverter {

    private FileConvertionError err = FileConvertionError.None;
    private final String convertedFileFolder;
    private ArrayList<String> queueOfFiles = new ArrayList<String>();

    public AnyToTextConverter(String tempFolder) {
        convertedFileFolder = tempFolder;
    }

    // move text file to temp folder
    private void moveTextFile(String fileName) {
    }

    private String pdfToString(String fileName) {
        String fileAsText = null;
        PDDocument pdfDoc = null;

        try {
            PDFTextStripper myPDFTextStripper = new PDFTextStripper();

            pdfDoc = PDDocument.load(fileName);
            myPDFTextStripper.setStartPage(1);
            fileAsText = myPDFTextStripper.getText(pdfDoc);

            pdfDoc.close();
        } catch (Exception e) {
        } finally {
            try {
                if (pdfDoc != null) {
                    pdfDoc.close();
                }
            } catch (Exception e) {
            }
        }

        return fileAsText;
    }

    private String rtfToString(String fileName) {
        String rtfContents = null;

        try {
            FileInputStream stream = new FileInputStream(fileName);
            RTFEditorKit kit = new RTFEditorKit();
            Document doc = kit.createDefaultDocument();
            kit.read(stream, doc, 0);

            rtfContents = doc.getText(0, doc.getLength());
        } catch (Exception e) {
        }

        return rtfContents;
    }

    private String docToString(String fileName) {
        String fileAsText = null;

        try {
            InputStream in = new FileInputStream(fileName);
            WordExtractor extractor = new WordExtractor(in);
            fileAsText = extractor.getText();
        } catch (Exception e) {
        }

        return fileAsText;
    }

    // convert docx to text and move to temp folder
    private void convertDocxToTxtFile(String fileName) {
    }

    private void listFiles(File file) {
        if (!file.exists()) {
            System.out.println(file + " does not exist.");
        }
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                listFiles(f);
            }
        } else {
            queueOfFiles.add(file.getAbsolutePath());
        }
    }

    public void convertFilesInFolder(String folderPath) {
        File documentFolder = new File(folderPath);
        String documentText = null;
        if (documentFolder.isDirectory()) {
            this.listFiles(documentFolder);
            for (String fileName : queueOfFiles) {
                if (fileName.endsWith(".txt")) {
                    moveTextFile(fileName);
                } else {
                    if (fileName.endsWith(".pdf")) {
                        documentText = pdfToString(fileName);
                    } else if (fileName.endsWith(".rtf")) {
                        documentText = rtfToString(fileName);
                    } else if (fileName.endsWith(".doc")) {
                        documentText = docToString(fileName);
                    } else if (fileName.endsWith(".docx")) {
                    } else if (fileName.endsWith(".odt")) {
                    }
                    // take file name without extension
                    File f = new File(fileName);
                    String fName = convertedFileFolder + File.separator
                            + this.getFileNameWithoutExtension(fileName) + ".txt";
                    this.writeTexttoFile(documentText, fName);
                }
            }

        }

    }

    private String getFileNameWithoutExtension(String fileName) {

        File file = new File(fileName);
        String nameWithoutExt = null;
        int index = file.getName().lastIndexOf('.');
        if (index > 0 && index <= file.getName().length() - 2) {
            nameWithoutExt = file.getName().substring(0, index);
        }
        return nameWithoutExt;
    }

    private FileConvertionError getpreprocessingError() {
        return err;
    }

    private void writeTexttoFile(String text, String fileName) {

        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.print(text);
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

    }
}
