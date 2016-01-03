/**
 JMBDE - EmployeePrint

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

// TODO Check the Link to the license
package de.jmuelbert.jmbde.employee.editor;

import java.awt.Component;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.ErrorManager;

/**
 *
 * @author Jürgen Mülbert
 * @version 1.0
 */
public class EmployeePrint {
    
     Component view = null;
     RenderedImage bi = null;
     
    public void EmployeePrint() {
     
        JFileChooser chooser = new JFileChooser ();
        chooser.setDialogTitle ("Export Scene As ...");
        chooser.setDialogType (JFileChooser.SAVE_DIALOG);
        chooser.setMultiSelectionEnabled (false);
        chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
        chooser.setFileFilter (new FileFilter() {
        
            @Override
            public boolean accept (File file) {
                if (file.isDirectory ())
                    return true;
                return file.getName ().toLowerCase ().endsWith (".png"); // NOI18N
            }
        
            @Override
            public String getDescription () {
                return "Portable Network Graphics (.png)"; // NOI18N
            }
        });
       
   
        if (chooser.showSaveDialog (view) != JFileChooser.APPROVE_OPTION)
            return;

        File file = chooser.getSelectedFile ();
        if (! file.getName ().toLowerCase ().endsWith (".png")) // NOI18N
        file = new File (file.getParentFile (), file.getName () + ".png"); // NOI18N
        if (file.exists ()) {
            DialogDescriptor descriptor = new DialogDescriptor (
                "File (" + file.getAbsolutePath () + ") already exists. Do you want to overwrite it?",
                "File Exists", true, DialogDescriptor.YES_NO_OPTION, DialogDescriptor.NO_OPTION, null);
                DialogDisplayer.getDefault ().createDialog (descriptor).setVisible (true);
                if (descriptor.getValue () != DialogDescriptor.YES_OPTION)
                    return;
        }
            
        try {
           
            boolean write; // NOI18N
            write = ImageIO.write (bi, "png", file);
        } catch (IOException e) {
                ErrorManager.getDefault ().notify (e);
        }
    }
}
