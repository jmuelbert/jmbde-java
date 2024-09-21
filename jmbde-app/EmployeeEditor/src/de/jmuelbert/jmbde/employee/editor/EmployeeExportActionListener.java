/*
 JMBDE - EmployeeNewActionListener

 Created by Jürgen Mülbert on 07.12.2015
 Copyright (c) 2015 Jürgen Mülbert. All rights reserved.

 This program is free software: you can redistribute it and/or modify
 it under the terms of the European Union Public Licence (EUPL),
 version 1.1.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 European Union Public Licence for more details.

 You should have received a copy of the European Union Public Licence
 along with this program. If not, see
 http://www.osor.eu/eupl/european-union-public-licence-eupl-v.1.1

*/

// TODO Check the Link to the license

package de.jmuelbert.jmbde.employee.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;
/**
 * A Entry for Export Employee-Data
 *
 * Create an Action Listener
 *
 * @author Jürgen Mülbert
 * @version 1.0
 *
 * @see ava.awt.event.ActionListener
 * @see org.openide.awt.ActionID
 * @see org.openide.awt.ActionReference
 * @see org.openide.awt.ActionRegistration
 * @see org.openide.util.NbBundle.Messages
 */
@ActionID(id =
              "de.jmuelbert.jmbde.employee.editor.EmployeeExportActionListener",
          category = "File")
@ActionRegistration(displayName = "#CTL_EmployeeExportActionListener")
@ActionReference(path = "Menu/File", position = 1100)
@Messages("CTL_EmployeeExportActionListener=Export")
public class EmployeeExportActionListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    EmployeeEditorTopComponent tc =
        (EmployeeEditorTopComponent)WindowManager.getDefault().findTopComponent(
            "EmployeeEditorTopComponent");
  }
}
