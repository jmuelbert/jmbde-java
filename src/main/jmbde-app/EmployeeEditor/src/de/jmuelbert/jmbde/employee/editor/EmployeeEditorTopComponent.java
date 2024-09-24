/**
 *JMBDE - EmployeeTopEditor
 *
 * Created by Jürgen Mülbert on 07.12.2015
 * Copyright (c) 2015 Jürgen Mülbert. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the European Union Public Licence (EUPL),
 * version 1.1.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * European Union Public Licence for more details.
 *
 * You should have received a copy of the European Union Public Licence
 * along with this program. If not, see
 * https://tldrlegal.com/license/european-union-public-licence
 *
 */

package de.jmuelbert.jmbde.employee.editor;

import de.jmuelbert.jmbde.datamodel.AddressSet;
import de.jmuelbert.jmbde.datamodel.AddressSetEmployee;
import de.jmuelbert.jmbde.datamodel.ChipCardSet;
import de.jmuelbert.jmbde.employee.viewer.EmployeeViewerTopComponent;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.Icon;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.Confirmation;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.UndoRedo;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * The Employee Editor Topcomponent
 *
 * Edit the Employee Data
 *
 * @author Jürgen Mülbert
 * @version 0.2
 *
 * @see java.awt.event.ActionListener
 * @see org.openide.awt.ActionID
 * @see org.openide.awt.ActionReference
 * @see org.openide.awt.ActionRegistration
 * @see org.openide.util.NbBundle.Messages
 */
@ConvertAsProperties(
    dtd = "-//de.jmuelbert.jmbde.employee.editor//EmployeeEditor//EN",
    autostore = false)
@TopComponent.Description(preferredID = "EmployeeEditorTopComponent",
                          // iconBase="SET/PATH/TO/ICON/HERE",
                          persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window",
          id = "de.jmuelbert.jmbde.employee.editor.EmployeeEditorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_EmployeeEditorAction",
                                     preferredID = "EmployeeEditorTopComponent")
@Messages({"CTL_EmployeeEditorAction=EmployeeEditor",
           "CTL_EmployeeEditorTopComponent=EmployeeEditor Window",
           "HINT_EmployeeEditorTopComponent=This is a EmployeeEditor window"})

public final class EmployeeEditorTopComponent
    extends TopComponent implements LookupListener {

  private Lookup.Result result = null;
  private InstanceContent instanceContent = new InstanceContent();
  private UndoRedo.Manager manager = new UndoRedo.Manager();
  private AddressSetEmployee employee;
  protected static final Icon ICON = ImageUtilities.loadImageIcon(
      "de/jmuelbert/jmbde/employee/editor/blue.png", true); // NOI18N
  // TODO Add Property Change Listener
  private static String dbConnectionString = "JMBDE_PU";

  public EmployeeEditorTopComponent() {

    initComponents();
    setName(Bundle.CTL_EmployeeEditorTopComponent());
    setToolTipText(Bundle.HINT_EmployeeEditorTopComponent());

    addressTextField.getDocument().addUndoableEditListener(manager);
    addressTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    chipcardTextField.getDocument().addUndoableEditListener(manager);
    chipcardTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    cityTextField.getDocument().addUndoableEditListener(manager);
    cityTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    empnumberTextField.getDocument().addUndoableEditListener(manager);
    empnumberTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    enddateTextField.getDocument().addUndoableEditListener(manager);
    enddateTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    firstnameTextField.getDocument().addUndoableEditListener(manager);
    firstnameTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    mailTextField.getDocument().addUndoableEditListener(manager);
    mailTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    nameTextField.getDocument().addUndoableEditListener(manager);
    nameTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    notesTextArea.getDocument().addUndoableEditListener(manager);
    notesTextArea.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    startdateTextField.getDocument().addUndoableEditListener(manager);
    startdateTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
    zipcodeTextField.getDocument().addUndoableEditListener(manager);
    zipcodeTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        modify();
      }
    });
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    firstnameTextField = new javax.swing.JTextField();
    nameTextField = new javax.swing.JTextField();
    addressTextField = new javax.swing.JTextField();
    zipcodeTextField = new javax.swing.JTextField();
    cityTextField = new javax.swing.JTextField();
    empnumberTextField = new javax.swing.JTextField();
    activeCheckBox = new javax.swing.JCheckBox();
    datacareCheckBox = new javax.swing.JCheckBox();
    jLabel7 = new javax.swing.JLabel();
    mailTextField = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    startdateTextField = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    enddateTextField = new javax.swing.JTextField();
    jLabel10 = new javax.swing.JLabel();
    chipcardTextField = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    notesTextArea = new javax.swing.JTextArea();
    jLabel11 = new javax.swing.JLabel();

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel1, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel1.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel2, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel2.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel3, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel3.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel4, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel4.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel5, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel5.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel6, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel6.text")); // NOI18N

    firstnameTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.firstnameTextField.text")); // NOI18N

    nameTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.nameTextField.text")); // NOI18N

    addressTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.addressTextField.text")); // NOI18N

    zipcodeTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.zipcodeTextField.text")); // NOI18N
    zipcodeTextField.setMinimumSize(new java.awt.Dimension(50, 26));

    cityTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.cityTextField.text")); // NOI18N

    empnumberTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.empnumberTextField.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        activeCheckBox,
        org.openide.util.NbBundle.getMessage(
            EmployeeEditorTopComponent.class,
            "EmployeeEditorTopComponent.activeCheckBox.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        datacareCheckBox,
        org.openide.util.NbBundle.getMessage(
            EmployeeEditorTopComponent.class,
            "EmployeeEditorTopComponent.datacareCheckBox.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel7, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel7.text")); // NOI18N

    mailTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.mailTextField.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel8, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel8.text")); // NOI18N

    startdateTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.startdateTextField.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel9, org.openide.util.NbBundle.getMessage(
                     EmployeeEditorTopComponent.class,
                     "EmployeeEditorTopComponent.jLabel9.text")); // NOI18N

    enddateTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.enddateTextField.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel10, org.openide.util.NbBundle.getMessage(
                      EmployeeEditorTopComponent.class,
                      "EmployeeEditorTopComponent.jLabel10.text")); // NOI18N

    chipcardTextField.setText(org.openide.util.NbBundle.getMessage(
        EmployeeEditorTopComponent.class,
        "EmployeeEditorTopComponent.chipcardTextField.text")); // NOI18N

    notesTextArea.setColumns(20);
    notesTextArea.setRows(5);
    jScrollPane1.setViewportView(notesTextArea);

    org.openide.awt.Mnemonics.setLocalizedText(
        jLabel11, org.openide.util.NbBundle.getMessage(
                      EmployeeEditorTopComponent.class,
                      "EmployeeEditorTopComponent.jLabel11.text")); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout.createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addComponent(jScrollPane1))
                            .addGroup(
                                layout.createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout
                                                    .Alignment.LEADING)
                                            .addGroup(
                                                layout.createSequentialGroup()
                                                    .addGap(16, 16, 16)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing
                                                                    .GroupLayout
                                                                    .Alignment
                                                                    .LEADING)
                                                            .addComponent(
                                                                jLabel1)
                                                            .addComponent(
                                                                jLabel2)
                                                            .addComponent(
                                                                jLabel7)
                                                            .addComponent(
                                                                jLabel6)
                                                            .addComponent(
                                                                jLabel8)
                                                            .addComponent(
                                                                jLabel11)
                                                            .addComponent(
                                                                jLabel9)
                                                            .addComponent(
                                                                jLabel4)
                                                            .addComponent(
                                                                jLabel3)))
                                            .addGroup(
                                                layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(jLabel10)))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle
                                            .ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout
                                                    .Alignment.LEADING)
                                            .addComponent(firstnameTextField)
                                            .addComponent(nameTextField)
                                            .addComponent(addressTextField)
                                            .addComponent(mailTextField)
                                            .addComponent(startdateTextField)
                                            .addComponent(enddateTextField)
                                            .addGroup(
                                                layout.createSequentialGroup()
                                                    .addComponent(
                                                        chipcardTextField,
                                                        javax.swing.GroupLayout
                                                            .PREFERRED_SIZE,
                                                        50,
                                                        javax.swing.GroupLayout
                                                            .PREFERRED_SIZE)
                                                    .addGap(0, 0,
                                                            Short.MAX_VALUE))
                                            .addGroup(
                                                layout.createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing
                                                                    .GroupLayout
                                                                    .Alignment
                                                                    .TRAILING,
                                                                false)
                                                            .addComponent(
                                                                empnumberTextField,
                                                                javax.swing
                                                                    .GroupLayout
                                                                    .DEFAULT_SIZE,
                                                                50,
                                                                Short.MAX_VALUE)
                                                            .addComponent(
                                                                zipcodeTextField,
                                                                javax.swing
                                                                    .GroupLayout
                                                                    .DEFAULT_SIZE,
                                                                javax.swing
                                                                    .GroupLayout
                                                                    .DEFAULT_SIZE,
                                                                Short
                                                                    .MAX_VALUE))
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing
                                                                    .GroupLayout
                                                                    .Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addPreferredGap(
                                                                        javax
                                                                            .swing
                                                                            .LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(
                                                                        jLabel5,
                                                                        javax
                                                                            .swing
                                                                            .GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        36,
                                                                        javax
                                                                            .swing
                                                                            .GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addPreferredGap(
                                                                        javax
                                                                            .swing
                                                                            .LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(
                                                                        cityTextField))
                                                            .addGroup(
                                                                javax.swing
                                                                    .GroupLayout
                                                                    .Alignment
                                                                    .TRAILING,
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGap(115,
                                                                            115,
                                                                            115)
                                                                    .addComponent(
                                                                        activeCheckBox)
                                                                    .addPreferredGap(
                                                                        javax
                                                                            .swing
                                                                            .LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(
                                                                        datacareCheckBox)))))))
                    .addContainerGap()));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(
                                firstnameTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(
                                nameTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(
                                addressTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(
                                zipcodeTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                cityTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(
                                empnumberTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activeCheckBox)
                            .addComponent(datacareCheckBox))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(
                                mailTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(
                                startdateTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(
                                enddateTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(
                                chipcardTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addComponent(jLabel11)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1,
                                  javax.swing.GroupLayout.PREFERRED_SIZE,
                                  javax.swing.GroupLayout.DEFAULT_SIZE,
                                  javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()));
  } // </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox activeCheckBox;
  private javax.swing.JTextField addressTextField;
  private javax.swing.JTextField chipcardTextField;
  private javax.swing.JTextField cityTextField;
  private javax.swing.JCheckBox datacareCheckBox;
  private javax.swing.JTextField empnumberTextField;
  private javax.swing.JTextField enddateTextField;
  private javax.swing.JTextField firstnameTextField;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField mailTextField;
  private javax.swing.JTextField nameTextField;
  private javax.swing.JTextArea notesTextArea;
  private javax.swing.JTextField startdateTextField;
  private javax.swing.JTextField zipcodeTextField;
  // End of variables declaration//GEN-END:variables
  @Override
  public void componentOpened() {
    dbConnectionString =
        NbPreferences.forModule(EmployeeViewerTopComponent.class)
            .get("datamodel", "jmbde_derby_PU"); // NOI18N
    result = WindowManager.getDefault()
                 .findTopComponent("EmployeeViewerTopComponent")
                 .getLookup()
                 .lookupResult(AddressSetEmployee.class);
    result.addLookupListener(this);
    resultChanged(new LookupEvent(result));
  }

  @Override
  public void componentClosed() {
    result.removeLookupListener(this);
    result = null;
  }

  void writeProperties(java.util.Properties p) {
    // better to version settings since initial version as advocated at
    // http://wiki.apidesign.org/wiki/PropertyFiles
    p.setProperty("version", "1.0"); // NOI18N
    // TODO store your settings
  }

  void readProperties(java.util.Properties p) {
    String version = p.getProperty("version"); // NOI18N
    // TODO read your settings according to their version
  }

  @Override
  public void resultChanged(LookupEvent le) {
    Lookup.Result r = (Lookup.Result)le.getSource();
    Collection<AddressSetEmployee> coll = r.allInstances();
    if (!coll.isEmpty()) {
      for (AddressSetEmployee emp : coll) {
        employee = emp;
        activeCheckBox.setEnabled(true);
        datacareCheckBox.setEnabled(true);
        firstnameTextField.setText(employee.getFirstName());
        nameTextField.setText(employee.getName());
        AddressSet adrSet = new AddressSet();
        adrSet = employee.getAddressSet();
        addressTextField.setText(adrSet.getStreet());
        zipcodeTextField.setText(adrSet.getZip());
        cityTextField.setText(adrSet.getCity());
        empnumberTextField.setText(employee.getEmployeeNumber());
        mailTextField.setText(employee.getBusinessMail());
        startdateTextField.setText(employee.getStartDate().toString());
        enddateTextField.setText(employee.getEndDate().toString());
        ChipCardSet ccs = new ChipCardSet();
        ccs = employee.getChipCardId();
        if (ccs != null) {
          chipcardTextField.setText(ccs.getName());
        } else {
          chipcardTextField.setText(
              java.util.ResourceBundle
                  .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
                  .getString("[NO CHIP CARD]"));
        }
        notesTextArea.setText(employee.getNotes());
        activeCheckBox.setSelected(employee.getActive());
        datacareCheckBox.setSelected(employee.getDataCare());
      }
    } else {
      activeCheckBox.setEnabled(true);
      datacareCheckBox.setEnabled(true);
      firstnameTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO NAME]"));
      nameTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO NAME]"));
      addressTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO STREET]"));
      zipcodeTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO ZIPCODE]"));
      cityTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO CITY]"));
      empnumberTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO NUMBER]"));
      mailTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO MAIL ADDRESS]"));
      startdateTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO STARTDATE]"));
      enddateTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO ENDDATE]"));
      chipcardTextField.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO CHIP CARD]"));
      notesTextArea.setText(
          java.util.ResourceBundle
              .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
              .getString("[NO NOTES]"));
      activeCheckBox.setSelected(false);
      datacareCheckBox.setSelected(false);
    }
  }

  /**
   * modify function
   */
  private void modify() {
    if (getLookup().lookup(MySavable.class) == null) {
      instanceContent.add(new MySavable());
    }
  }

  void resetFields() {
    employee = new AddressSetEmployee();
    activeCheckBox.setEnabled(true);
    datacareCheckBox.setEnabled(true);
    firstnameTextField.setText(""); // NOI18N
    nameTextField.setText("");      // NOI18N
    addressTextField.setText("");   // NOI18N
    zipcodeTextField.setText("");   // NOI18N
    cityTextField.setText("");      // NOI18N
    empnumberTextField.setText(""); // NOI18N
    mailTextField.setText("");      // NOI18N
    startdateTextField.setText(""); // NOI18N
    enddateTextField.setText("");   // NOI18N
    chipcardTextField.setText("");  // NOI18N
    notesTextArea.setText("");      // NOI18N
    activeCheckBox.setSelected(false);
    datacareCheckBox.setSelected(false);
  }

  void deleteEntry() {
    Confirmation message = new NotifyDescriptor.Confirmation(
        "Do you want delete \"" + firstnameTextField.getText() + " " +
            nameTextField.getText() + " ("      // NOI18N
            + cityTextField.getText() + ")\"?", // NOI18N
        NotifyDescriptor.OK_CANCEL_OPTION, NotifyDescriptor.QUESTION_MESSAGE);
    Object result = DialogDisplayer.getDefault().notify(message);
    // When user clicks "Yes", indicating they really want to save,
    // we need to disable the Save action,
    // so that it will only be usable when the next change is made
    // to the JTextArea: - See more at:
    // https://platform.netbeans.org/tutorials/nbm-crud.html#sthash.lmx5ztsl.dpuf
    if (NotifyDescriptor.YES_OPTION.equals(result)) {
      EntityManagerFactory factory;
      try {
        factory = Persistence.createEntityManagerFactory(dbConnectionString);
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        AddressSetEmployee emp =
            entityManager.find(AddressSetEmployee.class, employee.getId());
        entityManager.remove(emp);
        entityManager.getTransaction().commit();
      } catch (PersistenceException pe) {
        // TODO Handle with Exception and Dialog!
        System.err.println("Connection to " + dbConnectionString +
                           " not open!");
        pe.printStackTrace();
      }
    }
  }

  private class MySavable extends AbstractSavable implements Icon {

    public MySavable() { register(); }

    @Override
    protected String findDisplayName() {
      String firstName = firstnameTextField.getText();
      String name = nameTextField.getText();
      String city = cityTextField.getText();
      return firstName +
          java.text.MessageFormat.format(
              java.util.ResourceBundle
                  .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
                  .getString(" {0} FROM {1}"),
              new Object[] {name, city});
    }

    @Override
    protected void handleSave() throws IOException {
      Confirmation message = new NotifyDescriptor.Confirmation(
          java.util.ResourceBundle
                  .getBundle("de/jmuelbert/jmbde/employee/editor/Bundle")
                  .getString("DO YOU WANT TO SAVE") +
              firstnameTextField.getText() + " " + nameTextField.getText() +
              " ("                              // NOI18N
              + cityTextField.getText() + ")\"?", // NOI18N
          NotifyDescriptor.OK_CANCEL_OPTION, NotifyDescriptor.QUESTION_MESSAGE);
      Object result = DialogDisplayer.getDefault().notify(message);
      // When user clicks "Yes", indicating they really want to save,
      // we need to disable the Save action,
      // so that it will only be usable when the next change is made
      // to the JTextArea:
      if (NotifyDescriptor.YES_OPTION.equals(result)) {
        tc().instanceContent.remove(this);
        unregister();

        EntityManagerFactory factory;
        try {
          factory = Persistence.createEntityManagerFactory(dbConnectionString);
          EntityManager entityManager = factory.createEntityManager();
          entityManager.getTransaction().begin();
          if (employee.getId() != null) {
            AddressSetEmployee c;
            c = (AddressSetEmployee)entityManager.find(AddressSetEmployee.class,
                                                       employee.getId());
            AddressSet addrSet = new AddressSet();
            addrSet = c.getAddressSet();
            c.setFirstName(firstnameTextField.getText());
            c.setName(nameTextField.getText());
            addrSet.setStreet(addressTextField.getText());
            addrSet.setCity(cityTextField.getText());
            addrSet.setZip(zipcodeTextField.getText());
            c.setEmployeeNumber(empnumberTextField.getText());
            c.setBusinessMail(mailTextField.getText());
            String startDateStr = startdateTextField.getText();
            Date startDate = Date.valueOf(startDateStr);
            c.setStartDate(new java.sql.Date(startDate.getTime()));
            String endDateStr = enddateTextField.getText();
            Date endDate = Date.valueOf(endDateStr);
            c.setEndDate(new java.sql.Date(endDate.getTime()));
            // TODO: Handle ChipCard
            // c.setChipCard(chipcardTextField.getText());
            c.setNotes(notesTextArea.getText());
            c.setActive(activeCheckBox.isSelected());
            c.setDataCare(datacareCheckBox.isSelected());
            c.setAddressSet(addrSet);
            entityManager.getTransaction().commit();
          } else {
            Query query = entityManager.createNamedQuery(
                "AddressSetEmployee.findAll"); // NOI18N
            List<AddressSetEmployee> resultList = query.getResultList();

            // TODO: Check Address (exists)
            Query addrQuery =
                entityManager.createNamedQuery("AddressSet.findAll"); // NOI18N
            List<AddressSet> resultListAddr = addrQuery.getResultList();

            AddressSet addrSet = new AddressSet();
            employee.setId(resultList.size() + 1);
            addrSet.setId(resultListAddr.size() + 1);
            employee.setFirstName(firstnameTextField.getText());
            employee.setName(nameTextField.getText());
            addrSet.setStreet(addressTextField.getText());
            addrSet.setCity(cityTextField.getText());
            addrSet.setZip(zipcodeTextField.getText());
            // employee.setNumber(empnumberTextField.getText());
            employee.setBusinessMail(mailTextField.getText());
            //  TODO Handle with Exception
            String startDateStr = startdateTextField.getText();
            if (startDateStr.isEmpty()) {
              // TODO Set Date of Today
              startDateStr = "1901-01-01"; // NOI18N
            }
            Date startDate = Date.valueOf(startDateStr);
            employee.setStartDate(new java.sql.Date(startDate.getTime()));
            String endDateStr = enddateTextField.getText();
            //  TODO Handle with Exception
            if (endDateStr.isEmpty()) {
              // TODO Set Date of tomorrow
              endDateStr = "1901-01-02"; // NOI18N
            }
            Date endDate = Date.valueOf(endDateStr);
            employee.setEndDate(new java.sql.Date(endDate.getTime()));
            // TODO: Handle ChipCard
            // employee.setChipCard(chipcardTextField.getText());
            employee.setNotes(notesTextArea.getText());
            employee.setActive(activeCheckBox.isSelected());
            employee.setDataCare(datacareCheckBox.isSelected());
            employee.setAddressSet(addrSet);
            entityManager.persist(addrSet);
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
          }
        } catch (PersistenceException pe) {
          // TODO Handle with Exception and Dialog!
          System.err.println("Connection to " + dbConnectionString +
                             " not open!");
          pe.printStackTrace();
        }
      }
    }

    EmployeeEditorTopComponent tc() { return EmployeeEditorTopComponent.this; }

    @Override
    public boolean equals(Object o) {
      if (o instanceof MySavable) {
        MySavable m = (MySavable)o;
        return tc() == m.tc();
      }
      return false;
    }

    @Override
    public int hashCode() {
      return tc().hashCode();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
      ICON.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
      return ICON.getIconWidth();
    }

    @Override
    public int getIconHeight() {
      return ICON.getIconHeight();
    }
  }
}
