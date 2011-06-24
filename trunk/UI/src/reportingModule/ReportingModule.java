/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Jun 9, 2011, 8:44:05 PM
 */
package reportingModule;

import java.util.logging.Level;
import java.util.logging.Logger;
import reportingModule.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import ui.FileOperator;
import ui.textSetter;

/**
 *
 * @author user
 */
public class ReportingModule extends javax.swing.JFrame {

    JRViewer jrv;
    HashMap hm = new HashMap();
    String[][] resultArray;
    String selectedDocumentPath;
    int numberOfFiles;
    Highlighter hilit = new DefaultHighlighter();
    Highlighter hilit2 = new DefaultHighlighter();
    final static Color HILIT_COLOR = Color.LIGHT_GRAY;
    Highlighter.HighlightPainter painter;
    ArrayList peerDocs=new ArrayList();
    //ArrayList peerDocs=new ArrayList();
    ArrayList urlListTemp=new ArrayList();

    ArrayList<String> urlArray=new ArrayList<String>();


    /** Creates new form NewJFrame */
    public ReportingModule() {


        this.setSize(500, 500);
        initComponents();
        mainPreviousButton.setEnabled(false);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);

    }

    public DefaultPieDataset createPieDataset() {



        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Original", new Double(43.2));
        dataset.setValue("Plagarizm Suspected", new Double(10.0));
        dataset.setValue("Refereenced", new Double(27.5));
        
        return dataset;


    }


    private JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart3D(
                "Plagiarism Statistics", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;

    }

    public BufferedImage createChart() {

        DefaultPieDataset pie = this.createPieDataset();
        JFreeChart jf = this.createChart(pie);
        return jf.createBufferedImage(500, 500);



    }

    public void setresult() {
    }

    public void generateResults() {

        File file = new File(selectedDocumentPath);
        textSetter m = new textSetter();       
        String content = m.textSetter(file.getAbsolutePath());
        String fileName = file.getAbsolutePath();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String time = sdf.format(cal.getTime());
        BufferedImage bf = this.createChart();


        /**for(int i=0;i<resultArray.length;i++){

           if(resultArray[i][1]!=null)
            peerDocs.add(resultArray[i][1]);
            

        }  **/

        for(int i=0;i<urlListTemp.size();i++){

            peerDocs.add(urlListTemp.get(i));
        }

        while(peerDocs.size()==10){

            peerDocs.add(" ");

                    }



        hm.put("image", bf);
        hm.put("field", content);
        hm.put("time", time);
        hm.put("docName", fileName);       
        hm.put("peerDocs", peerDocs);
        

        JasperReport jasperReport;
        JasperPrint jasperPrint;

        try {
           
            jasperReport = JasperCompileManager.compileReport(
                    "jasper/report2.jrxml");

            jasperPrint = JasperFillManager.fillReport(
            jasperReport, hm, new JREmptyDataSource());
            jrv = new JRViewer(jasperPrint);


            jrv.addHyperlinkListener(new ReportHyperlinkListner());
            
            jScrollPane3.getViewport().add(jrv);
        

        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane(jrv);
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        mainPreviousButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea3.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("This wizard will Help you to view the Plagiarism Results in adynamically generated module. ");
        jTextArea3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane4.setViewportView(jTextArea3);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/main_icon.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Introduction", jPanel2);

        jLabel1.setText("Suspected File");

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next-icon.png"))); // NOI18N
        nextButton.setText("Next Match");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous-icon.png"))); // NOI18N
        previousButton.setText("Previous Match");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton4.setText("Next Step");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("jLabel4");

        jLabel5.setText("Selected File");

        jLabel6.setText("Suspected File");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(previousButton)
                        .addGap(40, 40, 40)
                        .addComponent(nextButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1055, 1055, 1055)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(nextButton)
                        .addComponent(previousButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(234, 234, 234))))
        );

        jTabbedPane1.addTab("Dynamic Cross Check", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1176, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        jPanel5.add(jScrollPane3);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel4.setLayout(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Final Report", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next-icon.png"))); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        mainPreviousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous-icon.png"))); // NOI18N
        mainPreviousButton.setText("Previous");
        mainPreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainPreviousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(684, 684, 684)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(680, 680, 680)
                        .addComponent(mainPreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int index = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.setSelectedIndex(index + 1);
        mainPreviousButton.setEnabled(true);
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setEnabledAt(2, true);

       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        FileOperator foperator = new FileOperator();
        try {
            if (!(numberOfFiles < 0)) {
                numberOfFiles--;
                String fileName1 = resultArray[numberOfFiles][0];
                String fileName2 = resultArray[numberOfFiles][1];
                //jTextField3.setText(resultArray[numberOfFiles][0]);
                jLabel4.setText(resultArray[numberOfFiles][1]);
                // jTextField2.setText(resultArray[numberOfFiles][2]);
                String[] texts = foperator.textSetter(fileName1, fileName2);
                String field1 = texts[0];
                String field2 = texts[1];
                jTextArea1.setText(field1.toLowerCase());
                jTextArea2.setText(field2.toLowerCase());
                this.highlighter(resultArray[numberOfFiles][2]);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        FileOperator foperator = new FileOperator();
        numberOfFiles++;
        try {
            String fileName1 = resultArray[numberOfFiles][0];
            String fileName2 = resultArray[numberOfFiles][1];
            //jTextField3.setText(resultArray[numberOfFiles][0]);
            jLabel4.setText(resultArray[numberOfFiles][1]);
            //jTextField2.setText(resultArray[numberOfFiles][2]);
            String[] texts = foperator.textSetter(fileName1, fileName2);
            String field1 = texts[0];
            String field2 = texts[1];
            jTextArea1.setText(field1.toLowerCase());
            jTextArea2.setText(field2.toLowerCase());
            this.highlighter(resultArray[numberOfFiles][2]);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void mainPreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPreviousButtonActionPerformed
       int index = jTabbedPane1.getSelectedIndex();
       if(index!=0)
        jTabbedPane1.setSelectedIndex(index - 1);
    }//GEN-LAST:event_mainPreviousButtonActionPerformed

    public void setTemp(String[][] tempa) {
        resultArray = tempa;
    }

    public void setDocument(String doc) {
        selectedDocumentPath = doc;
    }

    public void highlighter(String queryTemp) {

        painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
        jTextArea1.setHighlighter(hilit);
        jTextArea2.setHighlighter(hilit2);
        hilit.removeAllHighlights();
        hilit2.removeAllHighlights();
        //entryBg = jTextField2.getBackground();
        String content = jTextArea1.getText();
        String content2 = jTextArea2.getText();
        String queryString = queryTemp;
        String[] query = null;
        if (queryString.length() <= 0) {
            return;
        }
        if (queryString.contains(":")) {

            query = queryString.split(":");

        } else {
            query = new String[1];
            query[0] = queryString;
        }
        for (int i = 0; i < query.length; i++) {
            String searchQuery = query[i];
            TextHighlighter highlighterFirstFile = new TextHighlighter();
            TextHighlighter highlighterSecondFile = new TextHighlighter();
            Integer[] highlightindexedInfoFirstFile = highlighterFirstFile.highlightTexts(content, searchQuery);
            Integer[] highlightindexedInfoSecondFile = highlighterSecondFile.highlightTexts(content2, searchQuery);
            int startIndexFirst = highlightindexedInfoFirstFile[0];
            int endIndexFirst = highlightindexedInfoFirstFile[1];
            int startIndexSecond = highlightindexedInfoSecondFile[0];
            int endIndexSecond = highlightindexedInfoSecondFile[1];
            try {
                if (startIndexFirst != -1) {
                    hilit.addHighlight(startIndexFirst, endIndexFirst, painter);
                    jTextArea1.setCaretPosition(endIndexFirst);
                //jTextField2.setBackground(entryBg);
                }
                if (startIndexSecond != -1) {

                    hilit2.addHighlight(startIndexSecond, endIndexSecond, painter);

                    jTextArea2.setCaretPosition(endIndexSecond);
                //jTextField2.setBackground(entryBg);
                }

            } catch (BadLocationException ex) {
                Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReportingModule().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JButton mainPreviousButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    // End of variables declaration//GEN-END:variables

    public void setData() {
        //jTextField3.setText(temp[0][0]);
        jLabel4.setText(resultArray[0][1]);
        //jTextField2.setText(temp[0][2]);
        if (!(jLabel4.getText().equalsIgnoreCase("") || selectedDocumentPath.equalsIgnoreCase(""))) {

            String fileName1 = selectedDocumentPath;
            String fileName2 = jLabel4.getText();
            //jTabbedPane2.setSelectedIndex(1);
            FileOperator setTextToTextAreas = new FileOperator();
            String[] texts = setTextToTextAreas.textSetter(fileName1, fileName2);
            String field1 = texts[0];
            String field2 = texts[1];
            jTextArea1.setText(field1.toLowerCase());
            jTextArea2.setText(field2.toLowerCase());
        }

        // painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
        try{
            this.highlighter(resultArray[0][2]);
        }
        catch(Exception e){
            
        }
        this.generateResults();
    }

    public void setUrl(ArrayList<String> urlList) {
        for(int i=0;i<urlList.size();i++){
            urlListTemp.add(urlList.get(i));
            
        }

    }
}
