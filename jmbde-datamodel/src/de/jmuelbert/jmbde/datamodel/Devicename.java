/**
 * JMBDE - Datamodel - Devicename
 *
 *
 * Created by Jürgen Mülbert on 03.01.2016
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jurgenmulbert
 */
@Entity
@Table(name = "DEVICENAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devicename.findAll", query = "SELECT d FROM Devicename d"),
    @NamedQuery(name = "Devicename.findById", query = "SELECT d FROM Devicename d WHERE d.id = :id"),
    @NamedQuery(name = "Devicename.findByLastUpdate", query = "SELECT d FROM Devicename d WHERE d.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Devicename.findByName", query = "SELECT d FROM Devicename d WHERE d.name = :name")})
public class Devicename implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "COMPUTER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Computer computerId;
    @JoinColumn(name = "PHONE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Phone phoneId;
    @JoinColumn(name = "PRINTER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Printer printerId;

    public Devicename() {
    }

    public Devicename(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer getComputerId() {
        return computerId;
    }

    public void setComputerId(Computer computerId) {
        this.computerId = computerId;
    }

    public Phone getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Phone phoneId) {
        this.phoneId = phoneId;
    }

    public Printer getPrinterId() {
        return printerId;
    }

    public void setPrinterId(Printer printerId) {
        this.printerId = printerId;
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
        if (!(object instanceof Devicename)) {
            return false;
        }
        Devicename other = (Devicename) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.db.Devicename[ id=" + id + " ]";
    }
    
}
