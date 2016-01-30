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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
 
/**
 * The SoftwareSet Entity
 * 
 * 
 * @author Jürgen Mülbert
 * @version 0.4
 *
 */


@Entity
@Table(name = "SoftwareSet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoftwareSet.findAll", query = "SELECT s FROM SoftwareSet s"),
    @NamedQuery(name = "SoftwareSet.findById", query = "SELECT s FROM SoftwareSet s WHERE s.id = :id"),
    @NamedQuery(name = "SoftwareSet.findByName", query = "SELECT s FROM SoftwareSet s WHERE s.name = :name"),
    @NamedQuery(name = "SoftwareSet.findByVersion", query = "SELECT s FROM SoftwareSet s WHERE s.version = :version"),
    @NamedQuery(name = "SoftwareSet.findByRevision", query = "SELECT s FROM SoftwareSet s WHERE s.revision = :revision"),
    @NamedQuery(name = "SoftwareSet.findByFix", query = "SELECT s FROM SoftwareSet s WHERE s.fix = :fix"),
    @NamedQuery(name = "SoftwareSet.findByLastUpdate", query = "SELECT s FROM SoftwareSet s WHERE s.lastUpdate = :lastUpdate")})
public class SoftwareSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Version")
    private String version;
    @Column(name = "Revision")
    private String revision;
    @Column(name = "Fix")
    private String fix;
    @Column(name = "LastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "softwareSet")
    private SoftwareSetProgram softwareSetProgram;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "softwareSet")
    private SoftwareSetOperationSystem softwareSetOperationSystem;

    public SoftwareSet() {
    }

    public SoftwareSet(Integer id) {
        this.id = id;
    }

    public SoftwareSet(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public SoftwareSetProgram getSoftwareSetProgram() {
        return softwareSetProgram;
    }

    public void setSoftwareSetProgram(SoftwareSetProgram softwareSetProgram) {
        this.softwareSetProgram = softwareSetProgram;
    }

    public SoftwareSetOperationSystem getSoftwareSetOperationSystem() {
        return softwareSetOperationSystem;
    }

    public void setSoftwareSetOperationSystem(SoftwareSetOperationSystem softwareSetOperationSystem) {
        this.softwareSetOperationSystem = softwareSetOperationSystem;
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
        if (!(object instanceof SoftwareSet)) {
            return false;
        }
        SoftwareSet other = (SoftwareSet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.datamodel.SoftwareSet[ id=" + id + " ]";
    }
    
}
