/**
 * JMBDE - EmployeeChildFactory
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

import de.jmuelbert.jmbde.datamodel.AddressSetEmployee;
import java.beans.IntrospectionException;
import java.util.List;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.lookup.Lookups;

/**
 * The Employee Viewer EmployeeChildFactory 
 * 
 * @author Jürgen Mülbert
 * @version 0.2
 *
 * @see de.jmuelbert.jmbde.datamodel.Employee
 * @see java.beans.IntrospectionException
 * @see java.util.List
 * @see org.openide.nodes.BeanNode
 * @see org.openide.nodes.ChildFactory
 * @see org.openide.nodes.Children
 * @see org.openide.nodes.Node
 * @see org.openide.util.Exceptions
 * @see org.openide.util.lookup.Lookups
 */
public class EmployeeChildFactory extends ChildFactory<AddressSetEmployee> {
    
    private List<AddressSetEmployee> resultList;
    
   public EmployeeChildFactory() {
    }
   
    /**
     * The Construtor
     * @param resultList 
     */
    public EmployeeChildFactory(List<AddressSetEmployee> resultList) {
        this.resultList = resultList;
    }   


    
    /**
     * Create the Key
     * Create a List of Employee's for Display
     * @param list - the List to create
     * @return true if the list created correct.
     */
    @Override
    protected boolean createKeys(List<AddressSetEmployee> list) {
        for (AddressSetEmployee employee : resultList) {
            list.add(employee);
        }
        return true;
    }
    
    /**
     * Create a new BeanNode
     * @param e - the Employee
     * @return the BeanNode 
     * @exception IntrospectionException by Error return null
     */
    @Override
    protected Node createNodeForKey(AddressSetEmployee e) {
        try {
            return new EmployeeBeanNode(e);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
    
    /**
     *
     */
    private class EmployeeBeanNode extends BeanNode {
        public EmployeeBeanNode(AddressSetEmployee bean) throws IntrospectionException {
            super(bean, Children.LEAF, Lookups.singleton(bean));
        }
    }
}
