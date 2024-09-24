/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jmuelbert.jmbde.employee.viewer;

import static org.junit.Assert.*;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openide.explorer.ExplorerManager;

/**
 *
 * @author jurgenmulbert
 */
public class EmployeeViewerTopComponentIT {

  public EmployeeViewerTopComponentIT() {}

  @BeforeClass
  public static void setUpClass() {}

  @AfterClass
  public static void tearDownClass() {}

  @Before
  public void setUp() {}

  @After
  public void tearDown() {}

  /**
   * Test of refreshNode method, of class EmployeeViewerTopComponent.
   */
  @Test
  public void testRefreshNode() {
    System.out.println("refreshNode");
    EmployeeViewerTopComponent.refreshNode();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of componentOpened method, of class EmployeeViewerTopComponent.
   */
  @Test
  public void testComponentOpened() {
    System.out.println("componentOpened");
    EmployeeViewerTopComponent instance = new EmployeeViewerTopComponent();
    instance.componentOpened();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of componentClosed method, of class EmployeeViewerTopComponent.
   */
  @Test
  public void testComponentClosed() {
    System.out.println("componentClosed");
    EmployeeViewerTopComponent instance = new EmployeeViewerTopComponent();
    instance.componentClosed();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of writeProperties method, of class EmployeeViewerTopComponent.
   */
  @Test
  public void testWriteProperties() {
    System.out.println("writeProperties");
    Properties p = null;
    EmployeeViewerTopComponent instance = new EmployeeViewerTopComponent();
    instance.writeProperties(p);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of readProperties method, of class EmployeeViewerTopComponent.
   */
  @Test
  public void testReadProperties() {
    System.out.println("readProperties");
    Properties p = null;
    EmployeeViewerTopComponent instance = new EmployeeViewerTopComponent();
    instance.readProperties(p);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getExplorerManager method, of class EmployeeViewerTopComponent.
   */
  @Test
  public void testGetExplorerManager() {
    System.out.println("getExplorerManager");
    EmployeeViewerTopComponent instance = new EmployeeViewerTopComponent();
    ExplorerManager expResult = null;
    ExplorerManager result = instance.getExplorerManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
