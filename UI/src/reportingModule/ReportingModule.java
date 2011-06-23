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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
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
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
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

    /** Creates new form NewJFrame */
    public ReportingModule() {



        this.setSize(500, 500);
        initComponents();
    }

    public DefaultPieDataset createPieDataset() {



        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", new Double(43.2));
        dataset.setValue("Two", new Double(10.0));
        dataset.setValue("Three", new Double(27.5));
        dataset.setValue("Four", new Double(17.5));
        dataset.setValue("Five", new Double(11.0));
        dataset.setValue("Six", new Double(19.4));
        return dataset;






    }

    private JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart3D(
                "Pie Chart Demo 1", // chart title
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
        //String content=m.textSetter("C:\\Users\\user\\Desktop\\Assignments - 100\\Assignments - 100\\070039N_SAD.txt");
        String content = m.textSetter(file.getAbsolutePath());
        String fileName = file.getAbsolutePath();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String time = sdf.format(cal.getTime());


        BufferedImage bf = this.createChart();

        hm.put("image", bf);
        hm.put("field", content);
        hm.put("time", time);
        hm.put("docName", fileName);


        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
            //jasperReport = JasperCompileManager.compileReport(
            //   "C:\\Users\\user\\Desktop\\jasper reporting\\report2.jrxml");


            jasperReport = JasperCompileManager.compileReport(
                    "jasper/report2.jrxml");

            jasperPrint = JasperFillManager.fillReport(
                    jasperReport, hm, new JREmptyDataSource());
            jrv = new JRViewer(jasperPrint);
            //JasperViewer.viewReport(jasperPrint);
            // jrv.setPreferredSize(new Dimension(600, 410));

            jScrollPane3.getViewport().add(jrv, null);


//JScrollPane reportScroll = new JScrollPane(jrv);
// add the scroll pane



            HashMap hm = new HashMap();

// add the scroll pane
//JPanel viewer = new JPanel();

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
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane(jrv);
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Configure.png"))); // NOI18N

        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1279, 1279, 1279))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(368, 368, 368))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Introduction", jPanel2);

        jLabel1.setText("Suspected File");

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setText("Previous");
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

        jLabel4.setText("jLabel4");

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextButton)
                                .addGap(53, 53, 53)
                                .addComponent(previousButton))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(419, 419, 419))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(611, 611, 611)))
                        .addComponent(jButton4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(572, 572, 572)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextButton)
                            .addComponent(jLabel1)
                            .addComponent(previousButton)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(204, 204, 204))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dynamic Cross Check", jPanel3);

        jPanel5.add(jScrollPane3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setLayout(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Final Report", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(684, 684, 684)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1242, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int index = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.setSelectedIndex(index + 1);

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

        this.highlighter(resultArray[0][2]);




    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        this.generateResults();
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jTabbedPane1.setSelectedIndex(2);
        this.generateResults(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    // End of variables declaration//GEN-END:variables
}
