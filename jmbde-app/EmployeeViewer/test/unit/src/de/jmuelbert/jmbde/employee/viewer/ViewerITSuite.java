/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jmuelbert.jmbde.employee.viewer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jurgenmulbert
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
    {de.jmuelbert.jmbde.employee.viewer.EmployeeRootRefreshActionListenerIT
         .class,
     de.jmuelbert.jmbde.employee.viewer.EmployeeRootNodeIT.class,
     de.jmuelbert.jmbde.employee.viewer.EmployeeViewerTopComponentIT.class,
     de.jmuelbert.jmbde.employee.viewer.EmployeeChildFactoryIT.class})
public class ViewerITSuite {

  @BeforeClass
  public static void setUpClass() throws Exception {}

  @AfterClass
  public static void tearDownClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}
}
