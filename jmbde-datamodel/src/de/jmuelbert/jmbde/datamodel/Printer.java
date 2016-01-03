/**
 * JMBDE - Datamodel - Printer
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
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jurgenmulbert
 */
@Entity
@Table(name = "PRINTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Printer.findAll", query = "SELECT p FROM Printer p"),
    @NamedQuery(name = "Printer.findById", query = "SELECT p FROM Printer p WHERE p.id = :id"),
    @NamedQuery(name = "Printer.findByActive", query = "SELECT p FROM Printer p WHERE p.active = :active"),
    @NamedQuery(name = "Printer.findByColor", query = "SELECT p FROM Printer p WHERE p.color = :color"),
    @NamedQuery(name = "Printer.findByIpaddress", query = "SELECT p FROM Printer p WHERE p.ipaddress = :ipaddress"),
    @NamedQuery(name = "Printer.findByLastUpdate", query = "SELECT p FROM Printer p WHERE p.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Printer.findByName", query = "SELECT p FROM Printer p WHERE p.name = :name"),
    @NamedQuery(name = "Printer.findByNetwork", query = "SELECT p FROM Printer p WHERE p.network = :network"),
    @NamedQuery(name = "Printer.findByNumber", query = "SELECT p FROM Printer p WHERE p.number = :number"),
    @NamedQuery(name = "Printer.findByPapersizeMax", query = "SELECT p FROM Printer p WHERE p.papersizeMax = :papersizeMax"),
    @NamedQuery(name = "Printer.findByPin", query = "SELECT p FROM Printer p WHERE p.pin = :pin"),
    @NamedQuery(name = "Printer.findByResources", query = "SELECT p FROM Printer p WHERE p.resources = :resources"),
    @NamedQuery(name = "Printer.findBySerialnumber", query = "SELECT p FROM Printer p WHERE p.serialnumber = :serialnumber"),
    @NamedQuery(name = "Printer.findBySreplace", query = "SELECT p FROM Printer p WHERE p.sreplace = :sreplace")})
public class Printer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ACTIVE")
    private Short active;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "IPADDRESS")
    private String ipaddress;
    @Column(name = "LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NETWORK")
    private String network;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "PAPERSIZE_MAX")
    private String papersizeMax;
    @Column(name = "PIN")
    private String pin;
    @Column(name = "RESOURCES")
    private String resources;
    @Column(name = "SERIALNUMBER")
    private String serialnumber;
    @Column(name = "SREPLACE")
    private Short sreplace;
    @ManyToMany(mappedBy = "printerCollection")
    private Collection<Department> departmentCollection;
    @ManyToMany(mappedBy = "printerCollection")
    private Collection<Computer> computerCollection;
    @OneToMany(mappedBy = "printerId")
    private Collection<Devicename> devicenameCollection;
    @OneToMany(mappedBy = "printerId")
    private Collection<Employee> employeeCollection;
    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Manufacturer manufacturerId;
    @OneToMany(mappedBy = "printerId")
    private Collection<Devicetype> devicetypeCollection;

    public Printer() {
    }

    public Printer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
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

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPapersizeMax() {
        return papersizeMax;
    }

    public void setPapersizeMax(String papersizeMax) {
        this.papersizeMax = papersizeMax;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Short getSreplace() {
        return sreplace;
    }

    public void setSreplace(Short sreplace) {
        this.sreplace = sreplace;
    }

    @XmlTransient
    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    @XmlTransient
    public Collection<Computer> getComputerCollection() {
        return computerCollection;
    }

    public void setComputerCollection(Collection<Computer> computerCollection) {
        this.computerCollection = computerCollection;
    }

    @XmlTransient
    public Collection<Devicename> getDevicenameCollection() {
        return devicenameCollection;
    }

    public void setDevicenameCollection(Collection<Devicename> devicenameCollection) {
        this.devicenameCollection = devicenameCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @XmlTransient
    public Collection<Devicetype> getDevicetypeCollection() {
        return devicetypeCollection;
    }

    public void setDevicetypeCollection(Collection<Devicetype> devicetypeCollection) {
        this.devicetypeCollection = devicetypeCollection;
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
        if (!(object instanceof Printer)) {
            return false;
        }
        Printer other = (Printer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.db.Printer[ id=" + id + " ]";
    }
    
}
