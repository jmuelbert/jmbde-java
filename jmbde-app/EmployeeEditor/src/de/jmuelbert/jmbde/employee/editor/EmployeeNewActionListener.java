/**
 * JMBDE - EmployeeNewActionListener
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

/**
 * New Entry for the Employee's
 * Create an Action Listener
 * @author Jürgen Mülbert
 * @version 0.2
 * 
 * @see java.awt.event.ActionListener
 * @see org.openide.awt.ActionID
 * @see org.openide.awt.ActionReference
 * @see org.openide.awt.ActionRegistration
 * @see org.openide.util.NbBundle.Messages
 */
@ActionID(
        category = "File",
        id = "de.jmuelbert.jmbde.employee.editor.EmployeeNewActionListener"
)
@ActionRegistration(
        displayName = "#CTL_EmployeeNewActionListener"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 1300),
    @ActionReference(path = "Shortcuts", name = "M-N")
})
@Messages("CTL_EmployeeNewActionListener=New")
public final class EmployeeNewActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        EmployeeEditorTopComponent tc = (EmployeeEditorTopComponent) WindowManager.getDefault().findTopComponent("EmployeeEditorTopComponent");
        tc.resetFields();
        tc.open();
        tc.requestActive();
    }
    
}
