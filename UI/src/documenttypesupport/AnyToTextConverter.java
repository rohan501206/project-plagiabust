package documenttypesupport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;
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
        try {
            File f1 = new File(fileName);

            String moveFilePath = convertedFileFolder + File.separator + f1.getName();
            File f2 = new File(moveFilePath);

            InputStream in = new FileInputStream(f1);
            OutputStream out = new FileOutputStream(f2, false);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
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

    private String docxToString(String fileName) {

        String fileAsText = null;
        try {
            InputStream in = new FileInputStream(fileName);
            XWPFDocument doc = new XWPFDocument(in);
            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
            fileAsText = extractor.getText();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return fileAsText;
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
                        documentText = docxToString(fileName);
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


    public void convertSingleFile(String fileName) {
        File documentFolder = new File(fileName);
        String documentText = null;
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
                        documentText = docxToString(fileName);
                    } else if (fileName.endsWith(".odt")) {
                    }
                    // take file name without extension
                    File f = new File(fileName);
                    String fName = convertedFileFolder + File.separator
                            + this.getFileNameWithoutExtension(fileName) + ".txt";
                    this.writeTexttoFile(documentText, fName);
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
