/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainForm.java
 *
 * Created on Jun 3, 2011, 7:14:37 PM
 */
package gui.form;

import java.awt.Toolkit;

/**
 *
 * @author Brave Heart
 */
public class MainForm extends javax.swing.JFrame {

    public static MainForm mainForm;
    PlagiabustServerManager plagiabustServerManager = new PlagiabustServerManager();
    /** Creates new form MainForm */
    private MainForm() {
        initComponents();
        java.awt.Image image = Toolkit.getDefaultToolkit().getImage("D:/Project/Codes/Development/UI/src/Images/logo new.png");
        this.setIconImage(image);
    }

    public static MainForm getInstance(){
        if(mainForm == null){
            mainForm = new MainForm();
        }
        return mainForm;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewWizardPanel = new javax.swing.JPanel();
        NewCheckButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        KBManagerPanel = new javax.swing.JPanel();
        AdminToolsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AdministrativeToolPanel = new javax.swing.JPanel();
        KBManagerButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        HelpSupportPanel = new javax.swing.JPanel();
        HelpSupportButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PlagiaBust Plagiarism Detector");
        setResizable(false);

        NewWizardPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        NewCheckButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        NewCheckButton.setText("New Plagirism Check");
        NewCheckButton.setPreferredSize(new java.awt.Dimension(180, 40));
        NewCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewCheckButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plag check icon.png"))); // NOI18N

        javax.swing.GroupLayout NewWizardPanelLayout = new javax.swing.GroupLayout(NewWizardPanel);
        NewWizardPanel.setLayout(NewWizardPanelLayout);
        NewWizardPanelLayout.setHorizontalGroup(
            NewWizardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewWizardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewCheckButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewWizardPanelLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        NewWizardPanelLayout.setVerticalGroup(
            NewWizardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewWizardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewCheckButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        KBManagerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        AdminToolsButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        AdminToolsButton.setText("Adminitrative Tools");
        AdminToolsButton.setPreferredSize(new java.awt.Dimension(180, 40));
        AdminToolsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminToolsButtonActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings icon.png"))); // NOI18N

        javax.swing.GroupLayout KBManagerPanelLayout = new javax.swing.GroupLayout(KBManagerPanel);
        KBManagerPanel.setLayout(KBManagerPanelLayout);
        KBManagerPanelLayout.setHorizontalGroup(
            KBManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KBManagerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AdminToolsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KBManagerPanelLayout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(49, 49, 49))
        );
        KBManagerPanelLayout.setVerticalGroup(
            KBManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KBManagerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AdminToolsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(21, 21, 21))
        );

        AdministrativeToolPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        KBManagerButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        KBManagerButton.setText("Knowledge Base Manager");
        KBManagerButton.setPreferredSize(new java.awt.Dimension(180, 40));
        KBManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KBManagerButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/knowlegde_base_icon.png"))); // NOI18N

        javax.swing.GroupLayout AdministrativeToolPanelLayout = new javax.swing.GroupLayout(AdministrativeToolPanel);
        AdministrativeToolPanel.setLayout(AdministrativeToolPanelLayout);
        AdministrativeToolPanelLayout.setHorizontalGroup(
            AdministrativeToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministrativeToolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KBManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdministrativeToolPanelLayout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(46, 46, 46))
        );
        AdministrativeToolPanelLayout.setVerticalGroup(
            AdministrativeToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministrativeToolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KBManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27))
        );

        HelpSupportPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        HelpSupportButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        HelpSupportButton.setText("Help & Support");
        HelpSupportButton.setPreferredSize(new java.awt.Dimension(180, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document-help-icon.png"))); // NOI18N

        javax.swing.GroupLayout HelpSupportPanelLayout = new javax.swing.GroupLayout(HelpSupportPanel);
        HelpSupportPanel.setLayout(HelpSupportPanelLayout);
        HelpSupportPanelLayout.setHorizontalGroup(
            HelpSupportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HelpSupportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HelpSupportButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HelpSupportPanelLayout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(80, 80, 80))
        );
        HelpSupportPanelLayout.setVerticalGroup(
            HelpSupportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HelpSupportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HelpSupportButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(KBManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NewWizardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AdministrativeToolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HelpSupportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdministrativeToolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NewWizardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HelpSupportPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KBManagerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(60, 60, 912, 536);
    }// </editor-fold>//GEN-END:initComponents

    private void NewCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewCheckButtonActionPerformed
        WizardForm wizardForm = new WizardForm();
        wizardForm.setVisible(true);
    }//GEN-LAST:event_NewCheckButtonActionPerformed

    private void KBManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KBManagerButtonActionPerformed
        KBManagerForm.getInstance().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_KBManagerButtonActionPerformed

    private void AdminToolsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminToolsButtonActionPerformed
        plagiabustServerManager.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminToolsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminToolsButton;
    private javax.swing.JPanel AdministrativeToolPanel;
    private javax.swing.JButton HelpSupportButton;
    private javax.swing.JPanel HelpSupportPanel;
    private javax.swing.JButton KBManagerButton;
    private javax.swing.JPanel KBManagerPanel;
    private javax.swing.JButton NewCheckButton;
    private javax.swing.JPanel NewWizardPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
