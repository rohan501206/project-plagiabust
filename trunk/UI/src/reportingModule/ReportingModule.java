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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
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
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        browser = new javax.swing.JEditorPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fileComboBox = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        selectedFileTextField = new javax.swing.JTextField();
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

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Results", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButton1.setText("Show Selected File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        browser.setContentType("text/html");
        jScrollPane7.setViewportView(browser);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("selected File"));

        jScrollPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane6MouseClicked(evt);
            }
        });

        jTextPane1.setForeground(java.awt.Color.gray);
        jTextPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextPane1MouseClicked(evt);
            }
        });
        jTextPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextPane1MouseMoved(evt);
            }
        });
        jScrollPane5.setViewportView(jTextPane1);

        jScrollPane6.setViewportView(jScrollPane5);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Report", jPanel6);

        jScrollPane1.setViewportView(jEditorPane1);

        jScrollPane2.setViewportView(jEditorPane2);

        jButton4.setText("Next Step");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Selected File: ");

        jLabel6.setText("Suspected File");

        jLabel7.setText("Select the file to see the comparison");

        fileComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        fileComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fileComboBoxItemStateChanged(evt);
            }
        });
        fileComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileComboBoxActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        selectedFileTextField.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        selectedFileTextField.setFont(new java.awt.Font("Tahoma", 1, 11));
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
                                .addComponent(fileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(70, 70, 70)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Final Report", jPanel4);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
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

    private void mainPreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPreviousButtonActionPerformed
        int index = jTabbedPane1.getSelectedIndex();
        if (index != 0) {
            jTabbedPane1.setSelectedIndex(index - 1);
        }
    }//GEN-LAST:event_mainPreviousButtonActionPerformed

    private void fileComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fileComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fileComboBoxItemStateChanged

    private void fileComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileComboBoxActionPerformed

        JComboBox cb = (JComboBox) evt.getSource();
        String fileName = (String) cb.getSelectedItem();
        try {

            updateTextBoxes(fileName);

        } catch (Exception ex) {
            Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fileComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ArrayList<Integer> phraseIndexes = new ArrayList<Integer>();
        FileOperator setTextToTextAreas = new FileOperator();
        String appendedText = "";
        String texts = setTextToTextAreas.textSetter(selectedDocumentPath);
        AttributedString attributedString = new AttributedString(texts);
        jTextPane1.setText(texts);

        jTextPane1.setHighlighter(hilit3);

        StyledDocument doc = jTextPane1.getStyledDocument();

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
                    Style style = jTextPane1.addStyle("I'm a Style", null);
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

    private void jTextPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPane1MouseClicked


        ArrayList<Integer> phraseIndexes = new ArrayList<Integer>();
        Iterator it = indexHighligherMap.entrySet().iterator();
        String matchedFile = "";
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            String match = (String) pair.getKey();
            phraseIndexes = indexHighligherMap.get(match);



            int startIndex = phraseIndexes.get(0);
            int endIndex = phraseIndexes.get(1);

            int offset = jTextPane1.viewToModel(evt.getPoint());
            try {
                int start = Utilities.getWordStart(jTextPane1, offset);
                if ((start > startIndex) && start < endIndex) {
                    String word = jTextPane1.getDocument().getText(startIndex, endIndex - startIndex);

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

                    //jTextPane1.setToolTipText(matchedFile);
                    String t2 = "View Source";
                    String h2 = "<p><b>The suspected File </b>  <font color='red'>" + matchedFile + "</font><b><a href='http://www.google.com'>www.google.com</a></b></p> ";
                    new ExpandableToolTip(t2, h2, jTextPane1, browser);

                }
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_jTextPane1MouseClicked

    private void jTextPane1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPane1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPane1MouseMoved

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

        jEditorPane1.setHighlighter(hilit);
        jEditorPane2.setHighlighter(hilit2);
        hilit.removeAllHighlights();
        hilit2.removeAllHighlights();
        //entryBg = jTextField2.getBackground();
        String content = jEditorPane1.getText();
        String content2 = jEditorPane2.getText();
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
                    jEditorPane1.setCaretPosition(endIndexFirst);

                }
                if (startIndexSecond != -1) {

                    painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);

                    hilit2.addHighlight(startIndexSecond, endIndexSecond, painter);

                    jEditorPane2.setCaretPosition(endIndexSecond);

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
    private javax.swing.JEditorPane browser;
    private javax.swing.JComboBox fileComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane2;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton mainPreviousButton;
    private javax.swing.JTextField selectedFileTextField;
    // End of variables declaration//GEN-END:variables

    public void setData() {



        for (int i = 0; i < resultArray.length; i++) {

            if (resultArray[i][1] != null) {
                fileComboBox.addItem(resultArray[i][1]);
                this.setIndexDetails(resultArray[i][1]);
            }
        }

        selectedFileTextField.setText(selectedDocumentPath);
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
        jEditorPane1.setText(field1.toLowerCase());
        jEditorPane2.setText(field2.toLowerCase());

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
}
