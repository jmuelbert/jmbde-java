 /**
 * JMBDE - Datamodel
 *
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

package de.jmuelbert.jmbde.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

 /**
 * The DocumentsSet Entity
 * 
 * 
 * @author Jürgen Mülbert
 * @version 0.4
 *
 */



@Entity
@Table(name = "DocumentsSet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentsSet.findAll", query = "SELECT d FROM DocumentsSet d"),
    @NamedQuery(name = "DocumentsSet.findById", query = "SELECT d FROM DocumentsSet d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentsSet.findByName", query = "SELECT d FROM DocumentsSet d WHERE d.name = :name"),
    @NamedQuery(name = "DocumentsSet.findByLastUpdate", query = "SELECT d FROM DocumentsSet d WHERE d.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "DocumentsSet.findByDescription", query = "SELECT d FROM DocumentsSet d WHERE d.description = :description")})
public class DocumentsSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Lob
    @Column(name = "Document")
    private byte[] document;
    @Basic(optional = false)
    @Column(name = "LastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "Employee_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private AddressSetEmployee employeeId;

    public DocumentsSet() {
    }

    public DocumentsSet(Integer id) {
        this.id = id;
    }

    public DocumentsSet(Integer id, String name, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddressSetEmployee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(AddressSetEmployee employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentsSet)) {
            return false;
        }
        DocumentsSet other = (DocumentsSet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.datamodel.DocumentsSet[ id=" + id + " ]";
    }
    
}
