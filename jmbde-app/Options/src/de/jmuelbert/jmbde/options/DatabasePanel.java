/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jmuelbert.jmbde.options;

import de.jmuelbert.jmbde.employee.editor.EmployeeEditorTopComponent;
import de.jmuelbert.jmbde.employee.viewer.EmployeeViewerTopComponent;

import org.openide.util.NbPreferences;


final class DatabasePanel extends javax.swing.JPanel {

    private final DatabaseOptionsPanelController controller;

    DatabasePanel(DatabaseOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        buttonGroup1.add(jRadioButton1);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton1, org.openide.util.NbBundle.getMessage(DatabasePanel.class, "DatabasePanel.jRadioButton1.text")); // NOI18N

        buttonGroup1.add(jRadioButton2);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton2, org.openide.util.NbBundle.getMessage(DatabasePanel.class, "DatabasePanel.jRadioButton2.text")); // NOI18N

        buttonGroup1.add(jRadioButton3);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton3, org.openide.util.NbBundle.getMessage(DatabasePanel.class, "DatabasePanel.jRadioButton3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    void load() {
        // TODO read settings and initialize GUI
        // Example:     
        String dbConnectionString = NbPreferences.forModule(EmployeeEditorTopComponent.class).get("datamodel", "jmbde_derby_PU");
        switch (dbConnectionString) {
            case "jmbde_derby_PU":
                jRadioButton1.setSelected(true);
                break;
        // someCheckBox.setSelected(Preferences.userNodeForPackage(DatabasePanel.class).getBoolean("someFlag", false));
        // or for org.openide.util with API spec. version >= 7.4:
        // someCheckBox.setSelected(NbPreferences.forModule(DatabasePanel.class).getBoolean("someFlag", false));
        // or:
        // someTextField.setText(SomeSystemOption.getDefault().getSomeStringProperty());
            case "jmbde_mysql_PU":
                jRadioButton2.setSelected(true);
                break;
            case "jmbde_mssql_PU":
                jRadioButton3.setSelected(true);
                break;
            default:
                jRadioButton1.setSelected(true);
                break;
        }
    }

    void store() {
        // TODO store modified settings
        // Example:
        // Preferences.userNodeForPackage(DatabasePanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or for org.openide.util with API spec. version >= 7.4:
        // NbPreferences.forModule(DatabasePanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or:
        // SomeSystemOption.getDefault().setSomeStringProperty(someTextField.getText());
        String dbConnectionString;
        
        if (jRadioButton1.isSelected()) {
            dbConnectionString = "jmbde_derby_PU";
        } else if (jRadioButton2.isSelected()) {
            dbConnectionString = "jmbde_mysql_PU";
        } else if (jRadioButton3.isSelected()) {
            dbConnectionString = "jmbde_mssql_PU";
        } else {
            dbConnectionString = "jmbde_derby_PU";
        }
        NbPreferences.forModule(EmployeeViewerTopComponent.class).put("datamodel", dbConnectionString);
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables
}
