/**
 * JMBDE - EmployeeRootNode
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
package de.jmuelbert.jmbde.employee.viewer;

import static de.jmuelbert.jmbde.employee.viewer.Bundle.*;

import java.util.List;
import javax.swing.Action;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;

/**
 * The Employee Root Node
 *
 * <p>Provide the data to view
 *
 * @author Jürgen Mülbert
 * @version 0.2
 * @see java.util.List
 * @see javax.swing.Action
 * @see org.openide.nodes.AbstractNode
 * @see org.openide.nodes.Children
 * @see org.openide.util.NbBundle.Messages
 * @see org.openide.util.Utilities
 * @see de.jmuelbert.jmbde.employee.viewer.Bundle
 */
public class EmployeeRootNode extends AbstractNode {

  @Messages("CTRL_RootName=Root")
  public EmployeeRootNode(Children kids) {
    super(kids);
    setDisplayName(CTRL_RootName());
  }

  @Override
  public Action[] getActions(boolean context) {
    List<? extends Action> actionsForEmployee = Utilities.actionsForPath("Actions/Employee");
    return actionsForEmployee.toArray(new Action[actionsForEmployee.size()]);
  }
}
