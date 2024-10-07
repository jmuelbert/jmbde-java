/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jmuelbert.jmbde.employee.editor;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jurgenmulbert
 */
public class EmployeeNewActionListenerIT {

  public EmployeeNewActionListenerIT() {}

  @BeforeClass
  public static void setUpClass() {}

  @AfterClass
  public static void tearDownClass() {}

  @Before
  public void setUp() {}

  @After
  public void tearDown() {}

  /** Test of actionPerformed method, of class EmployeeNewActionListener. */
  @Test
  public void testActionPerformed() {
    System.out.println("actionPerformed");
    ActionEvent e = null;
    EmployeeNewActionListener instance = new EmployeeNewActionListener();
    instance.actionPerformed(e);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
