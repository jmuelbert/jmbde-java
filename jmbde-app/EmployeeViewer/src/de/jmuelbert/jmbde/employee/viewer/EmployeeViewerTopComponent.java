/**
 * JMBDE - EmployeeViewerTopComponent
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

import de.jmuelbert.jmbde.datamodel.Employee;
import java.awt.BorderLayout;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.Children;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;
import org.openide.windows.TopComponent;

/**
 * The Employee Viewer Topcomponent
 * 
 * View Employee Data
 * 
 * @author Jürgen Mülbert
 * @version 0.2
 *
 * @see java.awt.event.ActionListener
 * @see org.openide.awt.ActionID
 * @see org.openide.awt.ActionReference
 * @see org.openide.awt.ActionRegistration
 * @see org.openide.util.NbBundle.Messages
 */
@ConvertAsProperties(
        dtd = "-//de.jmuelbert.jmbde.employee.viewer/EmployeeViewer//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "EmployeeViewerTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "de.jmuelbert.jmbde.employee.viewer.EmployeeViewerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_EmployeeViewerAction",
        preferredID = "EmployeeViewerTopComponent"
)
@Messages({
    "CTL_EmployeeViewerAction=EmployeeViewer",
    "CTL_EmployeeViewerTopComponent=EmployeeViewer Window",
    "HINT_EmployeeViewerTopComponent=This is a EmployeeViewer window"
})
public final class EmployeeViewerTopComponent extends TopComponent implements ExplorerManager.Provider {

    private static final long serialVersionUID = 1L;
    private static ExplorerManager em = new ExplorerManager();
    
    // TODO Add Property Change Listener
    private static String dbConnectionString = null;

    public EmployeeViewerTopComponent() {
        initComponents();
        setName(Bundle.CTL_EmployeeViewerTopComponent());
        setToolTipText(Bundle.HINT_EmployeeViewerTopComponent());

        dbConnectionString = NbPreferences.forModule(EmployeeViewerTopComponent.class).get("datamodel", "jmbde_derby_PU"); //NOI18N
        
        BeanTreeView beanTreeView = new BeanTreeView();
        add(beanTreeView, BorderLayout.CENTER);
        refreshNode();
        associateLookup(ExplorerUtils.createLookup(em, getActionMap()));
    }
    
      public static void refreshNode() {
        EntityManagerFactory factory;
        try {
            factory = Persistence.createEntityManagerFactory(dbConnectionString);
            EntityManager entityManager = factory.createEntityManager();
            Query query = entityManager.createNamedQuery("Employee.findAll"); //NOI18N
            List<Employee> resultList = query.getResultList();
            em.setRootContext(new EmployeeRootNode(Children.create(new EmployeeChildFactory(resultList), true)));
        } catch(PersistenceException pe) {
            // TODO Handle with Exception and Dialog!
            System.err.println("Connection to " + dbConnectionString + " not open!");
            pe.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    /**
     * Get the Explorer Manager.
     * @return em
     * @see ExporerManager
     */
    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
}
