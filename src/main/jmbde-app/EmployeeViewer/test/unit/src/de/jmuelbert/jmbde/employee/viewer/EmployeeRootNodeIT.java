/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jmuelbert.jmbde.employee.viewer;

import static org.junit.Assert.*;

import javax.swing.Action;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jurgenmulbert
 */
public class EmployeeRootNodeIT {

  public EmployeeRootNodeIT() {}

  @BeforeClass
  public static void setUpClass() {}

  @AfterClass
  public static void tearDownClass() {}

  @Before
  public void setUp() {}

  @After
  public void tearDown() {}

  /** Test of getActions method, of class EmployeeRootNode. */
  @Test
  public void testGetActions() {
    System.out.println("getActions");
    boolean context = false;
    EmployeeRootNode instance = null;
    Action[] expResult = null;
    Action[] result = instance.getActions(context);
    assertArrayEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
