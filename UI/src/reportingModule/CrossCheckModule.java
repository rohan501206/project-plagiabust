/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import ui.FileOperator;

/**
 *
 * @author nuwan
 */
public class CrossCheckModule extends javax.swing.JFrame {

    String sourceFileName;
    String suspectedFileName;
    String matchStringShingleCloud;
    String matchStringfirstFile;
    String matchStringsecondFile;
    String selectedDocumentPath;
    int numberOfFiles;
    Highlighter hilit = new DefaultHighlighter();
    Highlighter hilit2 = new DefaultHighlighter();
    Highlighter hilit3 = new DefaultHighlighter();
    final static Color HILIT_COLOR = new Color(255, 160, 122);
    Highlighter.HighlightPainter painter;

    public CrossCheckModule(String sFile, String susFile, String match) {
        sourceFileName = sFile;
        suspectedFileName = susFile;
        matchStringShingleCloud = match;
        initComponents();
        testMatch.setVisible(false);

    }

    CrossCheckModule(String sourceFile, String suspectedFile, String matchstring, String matchstring1, String matchstring2) {

        sourceFileName = sourceFile;
        suspectedFileName = suspectedFile;
        matchStringShingleCloud = matchstring;
        matchStringfirstFile=matchstring1;
        matchStringsecondFile=matchstring2;
        initComponents();
        testMatch.setVisible(false);

   }

    public void setData() {
        FileOperator setTextToTextAreas = new FileOperator();
        String[] texts = setTextToTextAreas.textSetter(sourceFileName, suspectedFileName);
        String field1 = texts[0];
        String field2 = texts[1];
        selectedFileEditorPane.setText(field1.toLowerCase());
        suspectedFileEditorPane.setText(field2.toLowerCase());
        selectedFileTextField.setText(sourceFileName);
        suspectedFileTextField1.setText(suspectedFileName);
        selectedFileTextField.setEditable(false);
        suspectedFileTextField1.setEditable(false);
        selectedFileTextField.setToolTipText(sourceFileName);
        suspectedFileTextField1.setToolTipText(suspectedFileName);
        this.highlighter(matchStringShingleCloud,matchStringfirstFile,matchStringsecondFile);
    }

    public void highlighter(String queryTemp,String firstFileMatch,String secondFileMatch) {


        selectedFileEditorPane.setHighlighter(hilit);
        suspectedFileEditorPane.setHighlighter(hilit2);
        hilit.removeAllHighlights();
        hilit2.removeAllHighlights();
        String content = selectedFileEditorPane.getText();
        String content2 = suspectedFileEditorPane.getText();
        String queryString = queryTemp;
        String queryStringFirstFile = firstFileMatch;
        String queryStringSecondFile = secondFileMatch;
        String[] query = null;                  
        

        if ((queryString.length() <= 0) && (queryStringFirstFile.length() <= 0)) {
            return;
        }

        String[] queryforFirstFile = null;
        String[] queryforSecondFile = null;
        query = queryString.split("~");
        queryforFirstFile = queryStringFirstFile.split("~");
        queryforSecondFile = queryStringSecondFile.split("~");

        if (queryString.length() != 0) {
            ColourMap colourMap=new ColourMap();
            ArrayList<Color> colourArray = colourMap.getColourArray(query);
            highlighterForBothFields(query, content, content2, colourArray);
        }
        if (queryforFirstFile.length != 1) {
            ColourMap colourMap=new ColourMap();
            ArrayList<Color> colourArray = colourMap.getColourArray(queryforFirstFile);
            setHighlighterToFirstTextFile(queryforFirstFile, content, colourArray);
        }
        if (queryforSecondFile.length != 1) {
            ColourMap colourMap=new ColourMap();
            ArrayList<Color> colourArray = colourMap.getColourArray(queryforSecondFile);
            setHighlighterToSecondTextFile(queryforSecondFile, content2, colourArray);
        }


    }

    public void highlighterForBothFields(String[] query,String content,String content2,ArrayList<Color> colourArrayTemp){

        ArrayList<Color> colourArray = colourArrayTemp;
        for (int i = 0; i < query.length; i++) {
            String searchQuery = query[i];
            TextHighlighter highlighterFirstFile = new TextHighlighter();
            TextHighlighter highlighterSecondFile = new TextHighlighter();
            String[] highlightindexedInfoFirstFile = highlighterFirstFile.highlightTexts(content, searchQuery);
            String[] highlightindexedInfoSecondFile = highlighterSecondFile.highlightTexts(content2, searchQuery);
            int startIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[0]);
            int endIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[1]);
            int startIndexSecond = Integer.valueOf(highlightindexedInfoSecondFile[0]);
            int endIndexSecond = Integer.valueOf(highlightindexedInfoSecondFile[1]);
            
            try {
                Color HILIT_COLOR = colourArray.get(i);
                if (startIndexFirst != -1) {
                    painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
                    hilit.addHighlight(startIndexFirst, endIndexFirst, painter);
                    selectedFileEditorPane.setCaretPosition(endIndexFirst);
                }
                if (startIndexSecond != -1) {
                    painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);

                    hilit2.addHighlight(startIndexSecond, endIndexSecond, painter);

                    suspectedFileEditorPane.setCaretPosition(endIndexSecond);

                }

            } catch (BadLocationException ex) {
                Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedFileEditorPane = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        suspectedFileEditorPane = new javax.swing.JEditorPane();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selectedFileTextField = new javax.swing.JTextField();
        suspectedFileTextField1 = new javax.swing.JTextField();
        testMatch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        selectedFileEditorPane.setEditable(false);
        jScrollPane1.setViewportView(selectedFileEditorPane);

        suspectedFileEditorPane.setEditable(false);
        jScrollPane2.setViewportView(suspectedFileEditorPane);

        jButton4.setText("Next Step");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Selected File: ");

        jLabel6.setText("Suspected File");

        selectedFileTextField.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        selectedFileTextField.setFont(new java.awt.Font("Tahoma", 1, 11));
        selectedFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedFileTextFieldActionPerformed(evt);
            }
        });

        suspectedFileTextField1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        suspectedFileTextField1.setFont(new java.awt.Font("Tahoma", 1, 11));
        suspectedFileTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspectedFileTextField1ActionPerformed(evt);
            }
        });

        testMatch.setEditable(false);
        testMatch.setText("jTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(testMatch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suspectedFileTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(502, 502, 502)
                        .addComponent(jLabel2)
                        .addGap(738, 738, 738)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testMatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(selectedFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(suspectedFileTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(234, 234, 234))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1181, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    }//GEN-LAST:event_jButton4ActionPerformed

    private void selectedFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedFileTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_selectedFileTextFieldActionPerformed

    private void suspectedFileTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspectedFileTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suspectedFileTextField1ActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JEditorPane selectedFileEditorPane;
    private javax.swing.JTextField selectedFileTextField;
    private javax.swing.JEditorPane suspectedFileEditorPane;
    private javax.swing.JTextField suspectedFileTextField1;
    private javax.swing.JTextField testMatch;
    // End of variables declaration//GEN-END:variables

    private void setHighlighterToFirstTextFile(String[] queryforFirstFile, String content, ArrayList<Color> colourArrayTemp) {

        ArrayList<Color> colourArray = colourArrayTemp;
        for (int i = 0; i < queryforFirstFile.length; i++) {
            String searchQuery = queryforFirstFile[i];
            TextHighlighterParaphrase highlighterFirstFile = new TextHighlighterParaphrase();
            String[] highlightindexedInfoFirstFile = highlighterFirstFile.highlightTexts(content, searchQuery);
            int startIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[0]);
            int endIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[1]);

            try {

                Color HILIT_COLOR = colourArray.get(i);

                if (startIndexFirst != -1) {
                    painter = new UnderLineHIghlighter.UnderlineHighlightPainter(HILIT_COLOR);
                    hilit.addHighlight(startIndexFirst, endIndexFirst, painter);
                    selectedFileEditorPane.setCaretPosition(endIndexFirst);

                }


            } catch (BadLocationException ex) {
                Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }





    }

    private void setHighlighterToSecondTextFile(String[] queryforSecondFile, String content, ArrayList<Color> colourArrayTemp) {


        ArrayList<Color> colourArray = colourArrayTemp;
        for (int i = 0; i < queryforSecondFile.length; i++) {
            String searchQuery = queryforSecondFile[i];
            TextHighlighterParaphrase highlighterSecondFile = new TextHighlighterParaphrase();

            String[] highlightindexedInfoSecondFile = highlighterSecondFile.highlightTexts(content, searchQuery);

            int startIndexSecond = Integer.valueOf(highlightindexedInfoSecondFile[0]);
            int endIndexSecond = Integer.valueOf(highlightindexedInfoSecondFile[1]);

            try {

                Color HILIT_COLOR = colourArray.get(i);


                if (startIndexSecond != -1) {

                    painter = new UnderLineHIghlighter.UnderlineHighlightPainter(HILIT_COLOR);

                    hilit2.addHighlight(startIndexSecond, endIndexSecond, painter);

                    suspectedFileEditorPane.setCaretPosition(endIndexSecond);

                }

            } catch (BadLocationException ex) {
                Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }




    }
}
