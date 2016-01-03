/**
 *  JMBDE - EmployeeRootRefreshActionListener
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

package de.jmuelbert.jmbde.employee.viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

/**
 * The Employee Root Refresh Listener
 * w
 * 
 * @author Jürgen Mülbert
 * @version 0.2
 *
 * @see java.awt.event.ActiveEvent
 * @see java.awt.event.ActionListener
 * @see org.openide.awt.ActionID
 * @see org.openide.awt.ActionRegistration
 * @see org.openide.util.NbBundle.Messages
 */
@ActionID(id="de.jmuelbert.jmbde.employee.viewer.EmployeeRootRefreshActionListener", category="Employee")
@ActionRegistration(displayName="#CTL_EmployeeRootRefreshActionListener")
@Messages("CTL_EmployeeRootRefreshActionListener=Refresh")
public class EmployeeRootRefreshActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
       EmployeeViewerTopComponent.refreshNode();
    }
    
}
