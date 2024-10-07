/**
 * JMBDE - EmployeeDeleteActionListener
 *
 * <p>Created by Jürgen Mülbert on 07.12.2015 Copyright (c) 2015 Jürgen Mülbert. All rights
 * reserved.
 *
 * <p>This program is free software: you can redistribute it and/or modify it under the terms of the
 * European Union Public Licence (EUPL), version 1.1.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * European Union Public Licence for more details.
 *
 * <p>You should have received a copy of the European Union Public Licence along with this program.
 * If not, see https://tldrlegal.com/license/european-union-public-licence
 */
package de.jmuelbert.jmbde.employee.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

/**
 * A Entry for Delete Employee-Data
 *
 * <p>Create an Action Listener
 *
 * @author Jürgen Mülbert
 * @version 1.0
 * @see ava.awt.event.ActionListener
 * @see org.openide.awt.ActionID
 * @see org.openide.awt.ActionReference
 * @see org.openide.awt.ActionRegistration
 * @see org.openide.util.NbBundle.Messages
 */
@ActionID(category = "File", id = "de.jmuelbert.jmbde.employee.editor.EmployeeDeleteActionListener")
@ActionRegistration(displayName = "#CTL_EmployeeDeleteActionListener")
@ActionReference(path = "Menu/File", position = 1300)
@Messages("CTL_EmployeeDeleteActionListener=Delete")
public class EmployeeDeleteActionListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    EmployeeEditorTopComponent tc =
        (EmployeeEditorTopComponent)
            WindowManager.getDefault().findTopComponent("EmployeeEditorTopComponent");
    tc.deleteEntry();
  }
}
