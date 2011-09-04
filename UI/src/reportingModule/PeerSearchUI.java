/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PeerSearchUI.java
 *
 * Created on Jul 7, 2011, 8:27:33 PM
 */
package reportingModule;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.screencap.PNGDump;
import gui.form.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author nuwan
 */
public class PeerSearchUI extends javax.swing.JFrame {

    private JRViewer jasperReportViewer;
    private HashMap<String, HashMap<String, String[]>> peerSearchResult;
    private HashMap<String, HashMap<String, String[]>> globalSearchResult;
    private ArrayList<String> fileNamesArrayList = new ArrayList<String>();
    private ArrayList<String> urlarraylist = new ArrayList<String>();
    private String documentFolder;
    private HashMap<Integer, String> topResults = new HashMap<Integer, String>();
    private DefaultListModel listModelGraph = new DefaultListModel();
    private Graph<Integer, CustomEdge> connectivityGraph;
    private Layout<Integer, CustomEdge> layout;
    private VisualizationViewer<Integer, CustomEdge> visualizationViewer;
    private int edgecount;
    private ArrayList<FileMarkerGraph> fileSourceList = new ArrayList<FileMarkerGraph>();
    boolean deletefolder;
    private File projectFolder;
    private HashMap<String, String> fileToUrlMap;
    private HashMap<String, String> UrlToFileMap=new HashMap<String, String>();

    /** Creates new form PeerSearchUI */
    public PeerSearchUI() {
        initComponents();
        prevButton.setEnabled(false);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, false);
        jTabbedPane1.setEnabledAt(4, false);
        this.setIconImage(Main.getPlagiabustImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prevButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        folderNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        documentNumberTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        possiblePlagiarizedTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        topPlagList = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        topInternetList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileNameList = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        suspectedFileList = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        internetSourcesList = new javax.swing.JList();
        viewResultsButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        graphScrollPane = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        graphverticesNames = new javax.swing.JList();
        jPanel13 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jasperReportScrollPane = new javax.swing.JScrollPane(jasperReportViewer);
        nextButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Plagiarism Check Results Viewer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                fileClosedhandler(evt);
            }
        });

        prevButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous-icon.png"))); // NOI18N
        prevButton.setText("Previous");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        jScrollPane6.setBorder(null);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("DejaVu Sans", 1, 11));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("\n\n\nThis Wizard will guide you to view the Plagiarism check results of the selected single Document. \nFeatues include\n\n1. Results Stats\nIn the Report OnScreen View of the plagiarism Check results, you can view the overall plagiarism results statistics icluding the top plagiarized sources and top plgiarized internet Sources\n\n2. Dynamic Results Viewer\nYou can select the file you want to compare from the file list and the prefferd file to view the cross check GUI of the plagiarism Resuls\n\n3. Final Report\nAll the Details of the plagiarism Check will be displayed in a single report, Including the possible plagiarized sources and the possible internet Sources. Document Statictics will be displayed in a graphical chart.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Welcome"));
        jScrollPane6.setViewportView(jTextArea1);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18));
        jLabel6.setText("Welcome to the Plagiarism Results Viewer");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/welcome-icon.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/welcome-icon.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reportingimage1.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel7)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1102, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Introduction", jPanel8);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Result Statistics"));

        jLabel1.setText("Selected Document Folder");

        folderNameTextField.setEditable(false);
        folderNameTextField.setText("jTextField1");

        jLabel2.setText("Number of Documents");

        documentNumberTextField.setEditable(false);
        documentNumberTextField.setText("jTextField2");

        jLabel3.setText("Number of Possible Plagiarized Documents");

        possiblePlagiarizedTextField.setEditable(false);
        possiblePlagiarizedTextField.setText("jTextField3");

        jLabel4.setText("Top possible Plagiarized Documents");

        jScrollPane4.setViewportView(topPlagList);

        jLabel5.setText("Top Possible Plagiarized External Sources");

        jScrollPane5.setViewportView(topInternetList);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane5)
                        .addComponent(possiblePlagiarizedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(folderNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
                    .addComponent(documentNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(folderNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(documentNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(possiblePlagiarizedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Result Stats", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("File Name"));

        fileNameList.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        fileNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                fileNameListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(fileNameList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Suspected Files"));

        suspectedFileList.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        suspectedFileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                suspectedFileListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(suspectedFileList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Possible External Sources"));

        internetSourcesList.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        internetSourcesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                internetSourcesListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(internetSourcesList);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewResultsButton.setText("View the comparison results Betweeen Selected Documents");
        viewResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(683, 683, 683)
                        .addComponent(viewResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(viewResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Dynamic Result Viewer", jPanel1);

        jScrollPane7.setViewportView(graphverticesNames);

        jButton5.setBackground(java.awt.Color.red);
        jButton5.setForeground(java.awt.Color.red);

        jLabel27.setFont(new java.awt.Font("DejaVu Sans", 0, 10));
        jLabel27.setText("Plagiarism Percentage");

        jLabel28.setFont(new java.awt.Font("DejaVu Sans", 0, 7));
        jLabel28.setText("0% -10 %");

        jLabel29.setFont(new java.awt.Font("DejaVu Sans", 0, 7));
        jLabel29.setText("10%-20%");

        jLabel30.setFont(new java.awt.Font("DejaVu Sans", 0, 7));
        jLabel30.setText(">20%");

        jLabel31.setBackground(java.awt.Color.green);
        jLabel31.setOpaque(true);

        jLabel32.setBackground(java.awt.Color.yellow);
        jLabel32.setOpaque(true);

        jLabel33.setBackground(java.awt.Color.red);
        jLabel33.setOpaque(true);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(graphScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(graphScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Connectivity Graph", jPanel10);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Final Report Viewer"));

        jPanel5.add(jasperReportScrollPane);
        jasperReportScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jasperReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jasperReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report Viewer", jPanel3);

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next-icon.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(654, Short.MAX_VALUE)
                .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevButton)
                    .addComponent(nextButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action Listener for the fileSelection List
     * @param evt
     */
    private void fileNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_fileNameListValueChanged
        String selectedval = null;
        DefaultListModel fileModel = new DefaultListModel();
        DefaultListModel intenetFileModel = new DefaultListModel();
        suspectedFileList.setModel(fileModel);
        internetSourcesList.setModel(intenetFileModel);
        if (!evt.getValueIsAdjusting()) {
            JList list = (JList) evt.getSource();
            selectedval = (String) list.getSelectedValue();
        }
        if (selectedval != null) {
            HashMap<String, String[]> fileResultDetail = peerSearchResult.get(selectedval);
            HashMap<String, String[]> globalSourceResultDetail = globalSearchResult.get(selectedval);
            if (globalSourceResultDetail == null) {
                HashMap<String, String[]> globalSourceResultDetailTemp = new HashMap<String, String[]>();
                Iterator peerserac = peerSearchResult.entrySet().iterator();
                while (peerserac.hasNext()) {
                    Map.Entry pair = (Map.Entry) peerserac.next();
                    String fileName = (String) pair.getKey();
                    String match = "";
                    String[] matchvaluepair = new String[2];
                    matchvaluepair[0] = fileName;
                    matchvaluepair[1] = match;
                    globalSourceResultDetailTemp.put("", matchvaluepair);
                }
                globalSourceResultDetail = globalSourceResultDetailTemp;
            }
            if (fileResultDetail == null) {
                HashMap<String, String[]> peerDetailTemp = new HashMap<String, String[]>();
                Iterator peerserac =globalSearchResult.entrySet().iterator();
                while (peerserac.hasNext()) {
                    Map.Entry pair = (Map.Entry) peerserac.next();
                    String fileName = (String) pair.getKey();
                    String match = "";
                    String[] matchvaluepair = new String[2];
                    matchvaluepair[0] = fileName;
                    matchvaluepair[1] = match;
                    peerDetailTemp.put("", matchvaluepair);
                }
                fileResultDetail = peerDetailTemp;
            }

            Iterator fileIterator = fileResultDetail.entrySet().iterator();
            Iterator globalSourceIterator = globalSourceResultDetail.entrySet().iterator();
            int count = 0;
            while (fileIterator.hasNext()) {
                Map.Entry pair = (Map.Entry) fileIterator.next();
                String fileName = (String) pair.getKey();
                fileModel.add(count, fileName);
                count++;
            }
            count = 0;
            while (globalSourceIterator.hasNext()) {
                Map.Entry pair = (Map.Entry) globalSourceIterator.next();
                String sourceName = (String) pair.getKey();
                if (fileToUrlMap != null) {
                    intenetFileModel.add(count, (String) fileToUrlMap.get(sourceName));
                } else {
                    intenetFileModel.add(count, sourceName);
                }
                count++;
            }
        }
    }//GEN-LAST:event_fileNameListValueChanged

    /**
     * TabbedPane Previous button action listener
     * @param evt
     */
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        nextButton.setEnabled(true);
        int index = jTabbedPane1.getSelectedIndex();
        int prevIndex = index - 1;
        if (index != 0) {
            jTabbedPane1.setSelectedIndex(prevIndex);
        }
        if (prevIndex == 0) {
            prevButton.setEnabled(false);
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    /**
     * View the comparison results between the selected documents
     * @param evt
     */
    private void viewResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultsButtonActionPerformed

        if ((((String) fileNameList.getSelectedValue()) != null) && (((String) suspectedFileList.getSelectedValue()) != null)) {
            String sourceFile = ((String) fileNameList.getSelectedValue());
            String suspectedFile = ((String) suspectedFileList.getSelectedValue());
            HashMap<String, String[]> comparisonIfo = peerSearchResult.get(sourceFile);
            Iterator sourceIterator = comparisonIfo.entrySet().iterator();
            String[] matchString = new String[4];
            while (sourceIterator.hasNext()) {
                Map.Entry pair = (Map.Entry) sourceIterator.next();
                String fileName = (String) pair.getKey();
                if (fileName.equalsIgnoreCase(suspectedFile)) {
                    matchString = (String[]) pair.getValue();
                }
            }
            CrossCheckModule crossCheck = new CrossCheckModule(sourceFile, suspectedFile, matchString[0], matchString[2], matchString[3]);
            crossCheck.setData();
            crossCheck.setVisible(true);
        } else if ((((String) fileNameList.getSelectedValue()) != null) && (((String) internetSourcesList.getSelectedValue()) != null)) {
            String sourceFile = ((String) fileNameList.getSelectedValue());
            String suspectedInternetFile =(String) internetSourcesList.getSelectedValue();
            if(UrlToFileMap!=null){
            suspectedInternetFile = UrlToFileMap.get((String) internetSourcesList.getSelectedValue());
                       }
            String[] matchString = new String[4];
            HashMap<String, String[]> comparisonIfoInternet = globalSearchResult.get(sourceFile);
            Iterator globleSourceIterator = comparisonIfoInternet.entrySet().iterator();
            while (globleSourceIterator.hasNext()) {
                Map.Entry pair = (Map.Entry) globleSourceIterator.next();
                String fileName = (String) pair.getKey();
                if (fileName.equalsIgnoreCase(suspectedInternetFile)) {
                    matchString = (String[]) pair.getValue();

                }
            }
            
            CrossCheckModule crossCheck = new CrossCheckModule(sourceFile, suspectedInternetFile,matchString[0], matchString[2], matchString[3]);
            crossCheck.setData();
            crossCheck.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "please select a document from suspected file list to view the comparison");
        }
    }//GEN-LAST:event_viewResultsButtonActionPerformed

    /**
     * TabbedPane Next button action listener
     * @param evt
     */
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        int index = jTabbedPane1.getSelectedIndex();
        int nextIndex = index + 1;
        if (nextIndex != 5) {
            jTabbedPane1.setSelectedIndex(nextIndex);
            prevButton.setEnabled(true);
            jTabbedPane1.setEnabledAt(index, true);
            jTabbedPane1.setEnabledAt(index + 1, true);
        }
        if (nextIndex == 4) {
            nextButton.setEnabled(false);
        }


    }//GEN-LAST:event_nextButtonActionPerformed

    /****
     * Action Listener for the internet source List
     * @param evt
     */
    private void internetSourcesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_internetSourcesListValueChanged
        suspectedFileList.clearSelection();
    }//GEN-LAST:event_internetSourcesListValueChanged

    /**
     * Action Listener for the suspected source List
     * @param evt
     */
    private void suspectedFileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_suspectedFileListValueChanged

        internetSourcesList.clearSelection();
    }//GEN-LAST:event_suspectedFileListValueChanged

    /**
     * Delete the project related sources
     * @param evt
     */
    private void fileClosedhandler(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fileClosedhandler

        if (this.deletefolder) {
            this.deleteDir(projectFolder);
        }
    }//GEN-LAST:event_fileClosedhandler

    /**
     * delete the project folder
     * @param dir
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * process the plagiarism results and set the details to relevant places in the GUI
     */
    public void processResults() {
        HashSet filenames=new HashSet();
        Iterator it = peerSearchResult.entrySet().iterator();
        Iterator globalit = globalSearchResult.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String fileName = (String) pair.getKey();
            filenames.add(fileName);
            HashMap<String, String> hm = (HashMap<String, String>) pair.getValue();
            String fName = (String) topResults.get(hm.size());
            if (fName != null) {
                fName = fName + "~" + fileName;
                topResults.put(hm.size(), fName);
            } else {
                topResults.put(hm.size(), fileName);
            }
        }
        while (globalit.hasNext()) {
            Map.Entry pair = (Map.Entry) globalit.next();
            String fileName=(String) pair.getKey();
            filenames.add(fileName);
            HashMap<String, String[]> hm = (HashMap<String, String[]>) pair.getValue();
            Iterator globalittemp = hm.entrySet().iterator();
            while (globalittemp.hasNext()) {
                Map.Entry pair2 = (Map.Entry) globalittemp.next();
                urlarraylist.add((String) pair2.getKey());
            }
        }
        HashSet set = new HashSet(urlarraylist);
        urlarraylist.clear();
        urlarraylist.addAll(set);
        Iterator hashSetIterator=filenames.iterator();
        while(hashSetIterator.hasNext()){
            fileNamesArrayList.add((String)hashSetIterator.next());
        }
        setValuestoJLists(fileNamesArrayList);
    }

    /**
     * set values to the Dynamic Results Viewer
     * @param contents
     */
    public void setValuestoJLists(ArrayList<String> contents) {
        DefaultListModel model = new DefaultListModel();
        fileNameList.setModel(model);
        for (int i = 0; i < contents.size(); i++) {
            model.add(i, contents.get(i));
        }
        fileNameList.setSelectedIndex(0);
    }

    /**
     * Set the source folder name
     * @param sourceFolderName
     */
    public void setFolder(String sourceFolderName) {
        documentFolder = sourceFolderName;
    }

    /**
     * Set the results details for relevant areas in the GUI
     */
    public void setResultDetails() {
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        int topFileCount = 0;
        folderNameTextField.setText(documentFolder);
        folderNameTextField.setToolTipText(documentFolder);
        File f = new File(documentFolder);
        int noOfFiles = f.listFiles().length;
        documentNumberTextField.setText(String.valueOf(noOfFiles));
        possiblePlagiarizedTextField.setText(String.valueOf(fileNamesArrayList.size()));
        DefaultListModel model = new DefaultListModel();
        topPlagList.setModel(model);
        SortedSet<Integer> sortedset = new TreeSet<Integer>(topResults.keySet());
        Iterator<Integer> it = sortedset.iterator();
        int count = 0;
        while (it.hasNext() && count < 10) {
            sortedList.add(it.next());
            count++;
        }
        Collections.reverse(sortedList);
        for (Integer number : sortedList) {
            String list = topResults.get(number);
            if (list.split("~") != null) {
                String[] fileNameArray = list.split("~");
                for (int j = 0; j < fileNameArray.length; j++) {
                    model.add(topFileCount, fileNameArray[j]);
                    topFileCount++;
                }
            } else {
                model.add(topFileCount, topResults.get(number));
                topFileCount++;
            }
        }

        DefaultListModel model2 = new DefaultListModel();
        topInternetList.setModel(model2);

        for (int i = 0; i < urlarraylist.size(); i++) {
            if(fileToUrlMap!=null){
            model2.add(i, (String)fileToUrlMap.get(urlarraylist.get(i)));
            }
         else{
                model2.add(i, (String)urlarraylist.get(i));
        }
        }
        visualizationViewer();
        generateFinalReport();
    }

    /**
     * Generate the final report using Jasper Library
     */
    public void generateFinalReport() {
        HashMap hm = new HashMap();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String time = sdf.format(cal.getTime());
        String nodeList = "";
        for (int i = 0; i < listModelGraph.size(); i++) {
            String node = (String) listModelGraph.get(i);
            fileSourceList.add(new FileMarkerGraph(node));
        }
        hm.put("field", nodeList);
        hm.put("time", time);
        hm.put("docName", documentFolder);
        hm.put("fileSourceList", fileSourceList);
        hm.put("SUBREPORT_DIR", "jasper/");
        JRDataSource dataSource = createReportDataSource();
        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(
                    "jasper/peerfinalReport.jasper", hm, dataSource);
            jasperReportViewer = new JRViewer(jasperPrint);
            jasperReportViewer.addHyperlinkListener(new ReportHyperlinkListner());
            jasperReportScrollPane.getViewport().add(jasperReportViewer);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    /**
     * Create Data Source for the jasper report
     * @return
     */
    public JRDataSource createReportDataSource() {
        JRBeanCollectionDataSource dataSource;
        ArrayList<DataFetcherPeerSearch> reportRows = initializeResultsArray();
        dataSource = new JRBeanCollectionDataSource(reportRows);
        return dataSource;

    }

    /**
     * put the results details to ArrayList which contains plagiarism details
     * @return
     */
    public ArrayList<DataFetcherPeerSearch> initializeResultsArray() {

        ArrayList<DataFetcherPeerSearch> reportRows = new ArrayList<DataFetcherPeerSearch>();
        Iterator peerit = peerSearchResult.entrySet().iterator();
        int count = 0;
        while (peerit.hasNext()) {
            Map.Entry pair = (Map.Entry) peerit.next();
            String fileName = (String) pair.getKey();
            HashMap<String, String[]> hm = (HashMap<String, String[]>) pair.getValue();
            Iterator resultIterator = hm.entrySet().iterator();
            while (resultIterator.hasNext()) {
                Map.Entry pair2 = (Map.Entry) resultIterator.next();
                String suspectedFile = (String) pair2.getKey();
                String[] matchdetails = (String[]) pair2.getValue();
                String plagValue = matchdetails[1] + "%";
                reportRows.add(new DataFetcherPeerSearch(fileName, suspectedFile, plagValue));
                count++;
            }
        }
        return reportRows;
    }

    /**
     * Generate the connectivity Graph
     */
    private void visualizationViewer() {
        connectivityGraph = new SparseMultigraph<Integer, CustomEdge>();
        Iterator peerit = peerSearchResult.entrySet().iterator();
        Iterator peerit2 = peerSearchResult.entrySet().iterator();        
        HashMap<String, Integer> docToIntegerMap = new HashMap<String, Integer>();
        HashSet<String> docList = new HashSet<String>();
        while (peerit.hasNext()) {
            Map.Entry pair = (Map.Entry) peerit.next();
            String fileName = (String) pair.getKey();
            docList.add(fileName);
            HashMap<String, String[]> hm = (HashMap<String, String[]>) pair.getValue();
            Iterator resultIterator = hm.entrySet().iterator();
            while (resultIterator.hasNext()) {
                Map.Entry pair2 = (Map.Entry) resultIterator.next();
                String suspectedFile = (String) pair2.getKey();
                docList.add(suspectedFile);
            }
        }
        
        Iterator iter = docList.iterator();
        int verCount = 0;
        graphverticesNames.setModel(listModelGraph);
        while (iter.hasNext()) {
            String name = (String) iter.next();
            int countNo = ++verCount;
            listModelGraph.add(verCount - 1, String.valueOf(countNo) + " -- " + name);
            docToIntegerMap.put(name, countNo);
            connectivityGraph.addVertex((Integer) countNo);
        }
        HashSet ha = new HashSet();
        while (peerit2.hasNext()) {
            Map.Entry peerIt = (Map.Entry) peerit2.next();
            String oriFileName = (String) peerIt.getKey();
            HashMap<String, String[]> hm2 = (HashMap<String, String[]>) peerIt.getValue();
            Iterator valueIterator = hm2.entrySet().iterator();
            while (valueIterator.hasNext()) {
                edgecount++;
                Map.Entry matchPairs = (Map.Entry) valueIterator.next();
                String suspectedFileName = (String) matchPairs.getKey();
                String[] matchValuePair = (String[]) matchPairs.getValue();
                String value = matchValuePair[1] + "%";
                ArrayList lsi = new ArrayList(connectivityGraph.getEdges());
                for (int i = 0; i < lsi.size(); i++) {
                    ha.add(lsi.get(i));
                }
                if ((connectivityGraph.findEdge(docToIntegerMap.get(suspectedFileName), docToIntegerMap.get(oriFileName))) == null) {
                    connectivityGraph.addEdge(new CustomEdge(value), docToIntegerMap.get(oriFileName), docToIntegerMap.get(suspectedFileName));
                }
            }
        }        

        layout = new CircleLayout(connectivityGraph);
        layout.setSize(new Dimension(600, 600));
        Transformer<CustomEdge, Paint> edgesPaint = new Transformer<CustomEdge, Paint>() {

            private final Color[] palette = {Color.GREEN,
                Color.YELLOW, Color.RED};

            public Paint transform(CustomEdge edgeValue) {
                String stringvalue = edgeValue.toString();
                stringvalue = stringvalue.replaceAll("%", "");
                Double value = Double.valueOf(stringvalue);
                int intval = value.intValue();
                if (intval <= 10) {
                    return palette[0];
                }
                if (intval > 10 && intval <= 20) {
                    return palette[1];
                } else {
                    return palette[2];
                }
            }
        };

        Transformer<Integer, Paint> vertexPaint = new Transformer<Integer, Paint>() {

            public Paint transform(Integer i) {
                return Color.WHITE;
            }
        };
        visualizationViewer = new VisualizationViewer<Integer, CustomEdge>(layout);
        visualizationViewer.setPreferredSize(new Dimension(600, 600));
        visualizationViewer.setSize(new Dimension(600, 600));
        visualizationViewer.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        visualizationViewer.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        visualizationViewer.getRenderContext().setEdgeFillPaintTransformer(edgesPaint);
        visualizationViewer.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        visualizationViewer.setGraphMouse(gm);
        graphScrollPane.setViewportView(visualizationViewer);
        saveGraph(visualizationViewer);
    }

    /**
     * Set values to class variables
     * @param peerFilesReportData
     * @param internetFilesReportData
     * @param deleteFolder
     * @param projectFolderTemp
     * @param peerUrlList
     */
    public void setData(HashMap<String, HashMap<String, String[]>> peerFilesReportData, HashMap<String, HashMap<String, String[]>> internetFilesReportData, boolean deleteFolder, File projectFolderTemp, HashMap<String, String> peerUrlList) {
        this.deletefolder = deleteFolder;
        this.projectFolder = projectFolderTemp;
        peerSearchResult = peerFilesReportData;
        globalSearchResult = internetFilesReportData;
        if(peerUrlList!=null){
        this.fileToUrlMap = peerUrlList;
        createUrlToFileMap(peerUrlList);
        }
 else{
            System.err.println("**********************map is null");
 }
    }

    /**
     * Save the connectivity graph as a .png File
     * @param visualizationViewer
     */
    public void saveGraph(VisualizationViewer<Integer, CustomEdge> visualizationViewer) {
        PNGDump dumper = new PNGDump();
        try {
            dumper.dumpComponent(new File("jasper/reportImages/test.png"), visualizationViewer);
        } catch (IOException e) {
            System.err.println("dump failed");
        }
    }

    /**
     * Create a url name to downloaded file name map
     * @param peerUrlList
     */
    private void createUrlToFileMap(HashMap<String, String> peerUrlList) {
        Iterator globalIterator = peerUrlList.entrySet().iterator();
        while (globalIterator.hasNext()) {
            Map.Entry pair = (Map.Entry) globalIterator.next();
            String fileName = (String) pair.getKey();
            String url=(String) pair.getValue();
            UrlToFileMap.put(url, fileName);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PeerSearchUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField documentNumberTextField;
    private javax.swing.JList fileNameList;
    private javax.swing.JTextField folderNameTextField;
    private javax.swing.JScrollPane graphScrollPane;
    private javax.swing.JList graphverticesNames;
    private javax.swing.JList internetSourcesList;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JScrollPane jasperReportScrollPane;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField possiblePlagiarizedTextField;
    private javax.swing.JButton prevButton;
    private javax.swing.JList suspectedFileList;
    private javax.swing.JList topInternetList;
    private javax.swing.JList topPlagList;
    private javax.swing.JButton viewResultsButton;
    // End of variables declaration//GEN-END:variables


}
