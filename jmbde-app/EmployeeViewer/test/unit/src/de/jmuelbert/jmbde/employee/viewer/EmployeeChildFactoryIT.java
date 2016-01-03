/*
 JMBDE - EmployeeChildFactoryIT

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

package de.jmuelbert.jmbde.employee.viewer;

import de.jmuelbert.jmbde.datamodel.Employee;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openide.nodes.Node;

/**
 *
 * @author Jürgen Mülbert
 * @version 1.0
 */
public class EmployeeChildFactoryIT {

    public EmployeeChildFactoryIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createKeys method, of class EmployeeChildFactory.
     */
    @Test
    public void testCreateKeys() {
        System.out.println("createKeys");
        List<Employee> list = null;
        EmployeeChildFactory instance = new EmployeeChildFactory();
        boolean expResult = false;
        boolean result = instance.createKeys(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNodeForKey method, of class EmployeeChildFactory.
     */
    @Test
    public void testCreateNodeForKey() {
        System.out.println("createNodeForKey");
        Employee e = null;
        EmployeeChildFactory instance = new EmployeeChildFactory();
        Node expResult = null;
        Node result = instance.createNodeForKey(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
