/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jmuelbert.jmbde.employee.editor;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openide.util.LookupEvent;

/**
 *
 * @author jurgenmulbert
 */
public class EmployeeEditorTopComponentIT {
    
    public EmployeeEditorTopComponentIT() {
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

    /**
     * Test of componentOpened method, of class EmployeeEditorTopComponent.
     */
    @Test
    public void testComponentOpened() {
        System.out.println("componentOpened");
        EmployeeEditorTopComponent instance = new EmployeeEditorTopComponent();
        instance.componentOpened();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of componentClosed method, of class EmployeeEditorTopComponent.
     */
    @Test
    public void testComponentClosed() {
        System.out.println("componentClosed");
        EmployeeEditorTopComponent instance = new EmployeeEditorTopComponent();
        instance.componentClosed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeProperties method, of class EmployeeEditorTopComponent.
     */
    @Test
    public void testWriteProperties() {
        System.out.println("writeProperties");
        Properties p = null;
        EmployeeEditorTopComponent instance = new EmployeeEditorTopComponent();
        instance.writeProperties(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readProperties method, of class EmployeeEditorTopComponent.
     */
    @Test
    public void testReadProperties() {
        System.out.println("readProperties");
        Properties p = null;
        EmployeeEditorTopComponent instance = new EmployeeEditorTopComponent();
        instance.readProperties(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resultChanged method, of class EmployeeEditorTopComponent.
     */
    @Test
    public void testResultChanged() {
        System.out.println("resultChanged");
        LookupEvent le = null;
        EmployeeEditorTopComponent instance = new EmployeeEditorTopComponent();
        instance.resultChanged(le);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetFields method, of class EmployeeEditorTopComponent.
     */
    @Test
    public void testResetFields() {
        System.out.println("resetFields");
        EmployeeEditorTopComponent instance = new EmployeeEditorTopComponent();
        instance.resetFields();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
