/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jmuelbert.jmbde.employee.viewer;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jurgenmulbert
 */
public class EmployeeRootRefreshActionListenerIT {

  public EmployeeRootRefreshActionListenerIT() {}

  @BeforeClass
  public static void setUpClass() {}

  @AfterClass
  public static void tearDownClass() {}

  @Before
  public void setUp() {}

  @After
  public void tearDown() {}

  /**
   * Test of actionPerformed method, of class EmployeeRootRefreshActionListener.
   */
  @Test
  public void testActionPerformed() {
    System.out.println("actionPerformed");
    ActionEvent e = null;
    EmployeeRootRefreshActionListener instance =
        new EmployeeRootRefreshActionListener();
    instance.actionPerformed(e);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
