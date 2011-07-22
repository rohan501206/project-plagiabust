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

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import reportingModule.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator.Attribute;
import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;
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
import ui.Manager;

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
    Highlighter hilit3 = new DefaultHighlighter();
    final static Color HILIT_COLOR = new Color(255, 160, 122);
    Highlighter.HighlightPainter painter;
    ArrayList peerDocs = new ArrayList();
    //ArrayList peerDocs=new ArrayList();
    ArrayList urlListTemp = new ArrayList();
    HashMap<String, String> matchingToPreprocessed = new HashMap<String, String>();
    ArrayList<String> urlArray = new ArrayList<String>();
    HashMap<String, ArrayList<Integer>> indexHighligherMap = new HashMap<String, ArrayList<Integer>>();
    ArrayList peers = new ArrayList();
    HashMap<String, String> fileToUrlMap = new HashMap<String, String>();

    /** Creates new form NewJFrame */
    public ReportingModule() {


        this.setSize(500, 500);
        initComponents();
        PreviousButton.setEnabled(false);
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

    public void generateResults() {

        File file = new File(selectedDocumentPath);
        textSetter m = new textSetter();
        String content = m.textSetter(file.getAbsolutePath());
        String fileName = file.getAbsolutePath();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String time = sdf.format(cal.getTime());
        BufferedImage bf = this.createChart();


        for (int i = 0; i < resultArray.length; i++) {

            if (resultArray[i][1] != null) {
                peers.add(resultArray[i][1]);
            }

        }

        while (peers.size() != 10) {

            peers.add(" ");

        }




        for (int i = 0; i < urlListTemp.size(); i++) {

            peerDocs.add(urlListTemp.get(i));
        }

        while (peerDocs.size() != 10) {

            peerDocs.add(" ");

        }



        hm.put("image", bf);
        hm.put("field", content);
        hm.put("time", time);
        hm.put("docName", fileName);
        hm.put("peerDocs", peerDocs);
        hm.put("peers", peers);


        JasperReport jasperReport;
        JasperPrint jasperPrint;

        try {

            jasperReport = JasperCompileManager.compileReport(
                    "jasper/report2.jrxml");

            jasperPrint = JasperFillManager.fillReport(
                    jasperReport, hm, new JREmptyDataSource());
            jrv = new JRViewer(jasperPrint);


            jrv.addHyperlinkListener(new ReportHyperlinkListner());

            jasperReportScrollPane.getViewport().add(jrv);


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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedFileEditorPane = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        suspectedFileEditorPane = new javax.swing.JEditorPane();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fileListComboBox = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        selectedFileTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jasperReportScrollPane = new javax.swing.JScrollPane(jrv);
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        browser = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        showFileContentTextPane = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();

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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Introduction", jPanel2);

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

        jLabel7.setText("Select the file to see the comparison");

        fileListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        fileListComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fileListComboBoxItemStateChanged(evt);
            }
        });
        fileListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileListComboBoxActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        selectedFileTextField.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        selectedFileTextField.setEditable(false);
        selectedFileTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectedFileTextField.setToolTipText("");
        selectedFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedFileTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectedFileTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(502, 502, 502)
                                .addComponent(jLabel2)
                                .addGap(738, 738, 738)
                                .addComponent(jButton4))
                            .addComponent(jLabel6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(fileListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(selectedFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(234, 234, 234))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                        .addContainerGap())))
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

        jPanel5.add(jasperReportScrollPane);
        jasperReportScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel4.setLayout(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jasperReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(70, 70, 70)
                .addComponent(jasperReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Final Report", jPanel4);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Browser", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        browser.setContentType("text/html");
        jScrollPane7.setViewportView(browser);

        jButton1.setText("Show Selected File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("selected File"));

        jScrollPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane6MouseClicked(evt);
            }
        });

        showFileContentTextPane.setForeground(java.awt.Color.gray);
        showFileContentTextPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showFileContentTextPaneMouseClicked(evt);
            }
        });
        showFileContentTextPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                showFileContentTextPaneMouseMoved(evt);
            }
        });
        jScrollPane5.setViewportView(showFileContentTextPane);

        jScrollPane6.setViewportView(jScrollPane5);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Report", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next-icon.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        PreviousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous-icon.png"))); // NOI18N
        PreviousButton.setText("Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
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
                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        int index = jTabbedPane1.getSelectedIndex();
        jTabbedPane1.setSelectedIndex(index + 1);
        PreviousButton.setEnabled(true);
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setEnabledAt(2, true);


    }//GEN-LAST:event_nextButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(2);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        int index = jTabbedPane1.getSelectedIndex();
        if (index != 0) {
            jTabbedPane1.setSelectedIndex(index - 1);
        }
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void fileListComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fileListComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fileListComboBoxItemStateChanged

    private void fileListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileListComboBoxActionPerformed

        JComboBox cb = (JComboBox) evt.getSource();
        String fileName = (String) cb.getSelectedItem();
        try {

            updateTextBoxes(fileName);

        } catch (Exception ex) {
            Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fileListComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ArrayList<Integer> phraseIndexes = new ArrayList<Integer>();
        FileOperator setTextToTextAreas = new FileOperator();
        String appendedText = "";
        String texts = setTextToTextAreas.textSetter(selectedDocumentPath);
        AttributedString attributedString = new AttributedString(texts);
        showFileContentTextPane.setText(texts);

        showFileContentTextPane.setHighlighter(hilit3);

        StyledDocument doc = showFileContentTextPane.getStyledDocument();

        Iterator it = indexHighligherMap.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            String match = (String) pair.getKey();
            phraseIndexes = indexHighligherMap.get(match);

            for (int i = 0; i < phraseIndexes.size(); i++) {

                int startIndex = phraseIndexes.get(0);
                int endIndex = phraseIndexes.get(1);

                try {
                    doc.remove(startIndex, endIndex - startIndex);
                    Style style = showFileContentTextPane.addStyle("I'm a Style", null);
                    StyleConstants.setForeground(style, Color.red);
                    StyleConstants.setBold(style, true);
                    StyleConstants.setItalic(style, true);


                    doc.insertString(startIndex, match, style);
                } catch (BadLocationException e) {
                }




            }




        }







    }//GEN-LAST:event_jButton1ActionPerformed

    private void selectedFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedFileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedFileTextFieldActionPerformed

    private void jScrollPane6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane6MouseClicked

    private void showFileContentTextPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFileContentTextPaneMouseClicked


        ArrayList<Integer> phraseIndexes = new ArrayList<Integer>();
        Iterator it = indexHighligherMap.entrySet().iterator();
        String matchedFile = "";
        String content = "";

        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            String match = (String) pair.getKey();
            phraseIndexes = indexHighligherMap.get(match);



            int startIndex = phraseIndexes.get(0);
            int endIndex = phraseIndexes.get(1);

            int offset = showFileContentTextPane.viewToModel(evt.getPoint());
            try {
                int start = Utilities.getWordStart(showFileContentTextPane, offset);
                if ((start > startIndex) && start < endIndex) {
                    String word = showFileContentTextPane.getDocument().getText(startIndex, endIndex - startIndex);

                    String preprocessedText = matchingToPreprocessed.get(word.trim());

                    System.out.println("preprocessed text is " + preprocessedText);

                    for (int j = 0; j < resultArray.length; j++) {
                        if (resultArray[j][2] != null) {
                            //System.out.println(resultArray[j][2]);
                            String[] matchings = resultArray[j][2].split(":");
                            for (int k = 0; k < matchings.length; k++) {
                                //System.out.println(matchings[k]);
                                if (preprocessedText.equalsIgnoreCase(matchings[k])) {

                                    System.out.println("matching String found");
                                    System.out.println(resultArray[j][1]);
                                    matchedFile = resultArray[j][1];

                                }


                            }
                        }

                    }
                    content = "<p><b>The suspected File </b>  <font color='red'>" + matchedFile + "</font></p> ";


                    Iterator mapIterator = fileToUrlMap.entrySet().iterator();

                    while (mapIterator.hasNext()) {

                        Map.Entry fileUrlPair = (Map.Entry) mapIterator.next();
                        String downloadedFileName = (String) fileUrlPair.getKey();
                        System.err.println("key value is " + downloadedFileName);
                        System.err.println(" value is " + matchedFile);
                        if (matchedFile.equalsIgnoreCase(downloadedFileName)) {

                            matchedFile = (String) fileUrlPair.getValue();
                            content = "<p><b>The suspected Online Source </b><b><a href='" + matchedFile + "'>" + matchedFile + "</a></b></p> ";

                        }
                    }
                    //jTextPane1.setToolTipText(matchedFile);
                    String heading = "View Source";
                    new ExpandableToolTip(heading, content, showFileContentTextPane, browser);

                }
            } catch (Exception ex) {

                Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_showFileContentTextPaneMouseClicked

    private void showFileContentTextPaneMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFileContentTextPaneMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_showFileContentTextPaneMouseMoved

    public void setTemp(String[][] tempa) {
        resultArray = tempa;
    }

    public void setDocument(String doc) {
        selectedDocumentPath = doc;


    }

    public void highlighter(String queryTemp) {


        ArrayList<Color> colourArray = new ArrayList<Color>();
        colourArray.add(Color.cyan);
        colourArray.add(Color.yellow);
        colourArray.add(Color.gray);
        colourArray.add(Color.LIGHT_GRAY);
        colourArray.add(Color.MAGENTA);
        colourArray.add(Color.pink);
        colourArray.add(Color.ORANGE);

        selectedFileEditorPane.setHighlighter(hilit);
        suspectedFileEditorPane.setHighlighter(hilit2);
        hilit.removeAllHighlights();
        hilit2.removeAllHighlights();
        //entryBg = jTextField2.getBackground();
        String content = selectedFileEditorPane.getText();
        String content2 = suspectedFileEditorPane.getText();
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
            String[] highlightindexedInfoFirstFile = highlighterFirstFile.highlightTexts(content, searchQuery);
            String[] highlightindexedInfoSecondFile = highlighterSecondFile.highlightTexts(content2, searchQuery);
            int startIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[0]);
            int endIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[1]);
            int startIndexSecond = Integer.valueOf(highlightindexedInfoSecondFile[0]);
            int endIndexSecond = Integer.valueOf(highlightindexedInfoSecondFile[1]);
            //String match = highlightindexedInfoFirstFile[2];
            //ArrayList<Integer> arr = new ArrayList<Integer>();
            //arr.add(startIndexFirst);
            // arr.add(endIndexFirst);
            // indexHighligherMap.put(match, arr);
            // matchingToPreprocessed.put(highlightindexedInfoFirstFile[2], highlightindexedInfoFirstFile[3]);

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
    private javax.swing.JButton PreviousButton;
    private javax.swing.JEditorPane browser;
    private javax.swing.JComboBox fileListComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane jasperReportScrollPane;
    private javax.swing.JButton nextButton;
    private javax.swing.JEditorPane selectedFileEditorPane;
    private javax.swing.JTextField selectedFileTextField;
    private javax.swing.JTextPane showFileContentTextPane;
    private javax.swing.JEditorPane suspectedFileEditorPane;
    // End of variables declaration//GEN-END:variables

    public void setData() {



        for (int i = 0; i < resultArray.length; i++) {

            if (resultArray[i][1] != null) {
                fileListComboBox.addItem(resultArray[i][1]);
                this.setIndexDetails(resultArray[i][1]);
            }
        }

        selectedFileTextField.setText(selectedDocumentPath);
        selectedFileTextField.setToolTipText(selectedDocumentPath);
        this.generateResults();


    }

    public void setUrl(ArrayList<String> urlList) {
        for (int i = 0; i < urlList.size(); i++) {
            urlListTemp.add(urlList.get(i));
        }
    }

    private void updateTextBoxes(String fileName) {

        String fileName1 = selectedDocumentPath;
        String fileName2 = fileName;
        FileOperator setTextToTextAreas = new FileOperator();
        String[] texts = setTextToTextAreas.textSetter(fileName1, fileName2);
        String field1 = texts[0];
        String field2 = texts[1];
        selectedFileEditorPane.setText(field1.toLowerCase());
        suspectedFileEditorPane.setText(field2.toLowerCase());

        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i][1] != null) {
                if (resultArray[i][1].equalsIgnoreCase(fileName2)) {
                    jTextField1.setText(resultArray[i][2]);
                    this.highlighter(resultArray[i][2]);
                }
            }
        }

    }

    public void setIndexDetails(String fileName) {


        String fileName2 = fileName;
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i][1] != null) {
                if (resultArray[i][1].equalsIgnoreCase(fileName2)) {
                    jTextField1.setText(resultArray[i][2]);
                    this.highlighterDetails(resultArray[i][2], fileName);
                }
            }
        }


    }

    public void highlighterDetails(String queryTemp, String filename) {

        FileOperator setTextToTextAreas = new FileOperator();
        String[] texts = setTextToTextAreas.textSetter(selectedDocumentPath, filename);
        String content = texts[0].toLowerCase();
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
            String[] highlightindexedInfoFirstFile = highlighterFirstFile.highlightTexts(content, searchQuery);
            int startIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[0]);
            int endIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[1]);
            String match = highlightindexedInfoFirstFile[2];
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(startIndexFirst);
            arr.add(endIndexFirst);
            indexHighligherMap.put(match, arr);
            matchingToPreprocessed.put(highlightindexedInfoFirstFile[2], highlightindexedInfoFirstFile[3]);

        }

    }

    public void setMap(HashMap<String, String> fileUrlMap) {

        this.fileToUrlMap = fileUrlMap;
        if (fileUrlMap == null) {
            System.err.println("Fileurl map is null");
        }

    }
}
