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
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
 
/**
 * The DepartmentSet Entity
 * 
 * 
 * @author Jürgen Mülbert
 * @version 0.4
 *
 */

@Entity
@Table(name = "DepartmentSet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartmentSet.findAll", query = "SELECT d FROM DepartmentSet d"),
    @NamedQuery(name = "DepartmentSet.findById", query = "SELECT d FROM DepartmentSet d WHERE d.id = :id"),
    @NamedQuery(name = "DepartmentSet.findByName", query = "SELECT d FROM DepartmentSet d WHERE d.name = :name"),
    @NamedQuery(name = "DepartmentSet.findByPriority", query = "SELECT d FROM DepartmentSet d WHERE d.priority = :priority"),
    @NamedQuery(name = "DepartmentSet.findByLastUpdate", query = "SELECT d FROM DepartmentSet d WHERE d.lastUpdate = :lastUpdate")})
public class DepartmentSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Priority")
    private Short priority;
    @Column(name = "LastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToMany(mappedBy = "departmentId")
    private Collection<AddressSetEmployee> addressSetEmployeeCollection;
    @OneToMany(mappedBy = "departmentId")
    private Collection<DeviceSetPrinter> deviceSetPrinterCollection;
    @OneToMany(mappedBy = "departmentId")
    private Collection<DeviceSetComputer> deviceSetComputerCollection;
    @OneToMany(mappedBy = "departmentId")
    private Collection<DeviceSetPhone> deviceSetPhoneCollection;

    public DepartmentSet() {
    }

    public DepartmentSet(Integer id) {
        this.id = id;
    }

    public DepartmentSet(Integer id, String name) {
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

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<AddressSetEmployee> getAddressSetEmployeeCollection() {
        return addressSetEmployeeCollection;
    }

    public void setAddressSetEmployeeCollection(Collection<AddressSetEmployee> addressSetEmployeeCollection) {
        this.addressSetEmployeeCollection = addressSetEmployeeCollection;
    }

    @XmlTransient
    public Collection<DeviceSetPrinter> getDeviceSetPrinterCollection() {
        return deviceSetPrinterCollection;
    }

    public void setDeviceSetPrinterCollection(Collection<DeviceSetPrinter> deviceSetPrinterCollection) {
        this.deviceSetPrinterCollection = deviceSetPrinterCollection;
    }

    @XmlTransient
    public Collection<DeviceSetComputer> getDeviceSetComputerCollection() {
        return deviceSetComputerCollection;
    }

    public void setDeviceSetComputerCollection(Collection<DeviceSetComputer> deviceSetComputerCollection) {
        this.deviceSetComputerCollection = deviceSetComputerCollection;
    }

    @XmlTransient
    public Collection<DeviceSetPhone> getDeviceSetPhoneCollection() {
        return deviceSetPhoneCollection;
    }

    public void setDeviceSetPhoneCollection(Collection<DeviceSetPhone> deviceSetPhoneCollection) {
        this.deviceSetPhoneCollection = deviceSetPhoneCollection;
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
        if (!(object instanceof DepartmentSet)) {
            return false;
        }
        DepartmentSet other = (DepartmentSet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.datamodel.DepartmentSet[ id=" + id + " ]";
    }
    
}
