/**
 * JMBDE - Datamodel - Comuter
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
import javax.persistence.JoinTable;
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
@Table(name = "COMPUTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Computer.findAll", query = "SELECT c FROM Computer c"),
    @NamedQuery(name = "Computer.findById", query = "SELECT c FROM Computer c WHERE c.id = :id"),
    @NamedQuery(name = "Computer.findByActive", query = "SELECT c FROM Computer c WHERE c.active = :active"),
    @NamedQuery(name = "Computer.findByLastUpdate", query = "SELECT c FROM Computer c WHERE c.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Computer.findByMemory", query = "SELECT c FROM Computer c WHERE c.memory = :memory"),
    @NamedQuery(name = "Computer.findByName", query = "SELECT c FROM Computer c WHERE c.name = :name"),
    @NamedQuery(name = "Computer.findByNetwork", query = "SELECT c FROM Computer c WHERE c.network = :network"),
    @NamedQuery(name = "Computer.findBySerialnumber", query = "SELECT c FROM Computer c WHERE c.serialnumber = :serialnumber"),
    @NamedQuery(name = "Computer.findByServicenumber", query = "SELECT c FROM Computer c WHERE c.servicenumber = :servicenumber"),
    @NamedQuery(name = "Computer.findByServicetag", query = "SELECT c FROM Computer c WHERE c.servicetag = :servicetag"),
    @NamedQuery(name = "Computer.findBySreplace", query = "SELECT c FROM Computer c WHERE c.sreplace = :sreplace")})
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ACTIVE")
    private Short active;
    @Column(name = "LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "MEMORY")
    private Integer memory;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NETWORK")
    private String network;
    @Column(name = "SERIALNUMBER")
    private String serialnumber;
    @Column(name = "SERVICENUMBER")
    private String servicenumber;
    @Column(name = "SERVICETAG")
    private String servicetag;
    @Column(name = "SREPLACE")
    private Short sreplace;
    @JoinTable(name = "EMPLOYEE_COMPUTER", joinColumns = {
        @JoinColumn(name = "COMPUTER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Employee> employeeCollection;
    @JoinTable(name = "COMPUTER_PROGRAM", joinColumns = {
        @JoinColumn(name = "COMPUTER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PROGRAM_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Program> programCollection;
    @JoinTable(name = "COMPUTER_PRINTER", joinColumns = {
        @JoinColumn(name = "COMPUTER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PRINTER_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Printer> printerCollection;
    @OneToMany(mappedBy = "computerId")
    private Collection<Devicename> devicenameCollection;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Department departmentId;
    @JoinColumn(name = "INVENTORY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Inventory inventoryId;
    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Manufacturer manufacturerId;
    @JoinColumn(name = "OS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Os osId;
    @JoinColumn(name = "PLACE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Place placeId;
    @JoinColumn(name = "PROCESSOR_ID1", referencedColumnName = "ID1")
    @ManyToOne
    private Processor processorId1;
    @OneToMany(mappedBy = "computerId")
    private Collection<Devicetype> devicetypeCollection;

    public Computer() {
    }

    public Computer(Long id) {
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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
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

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getServicenumber() {
        return servicenumber;
    }

    public void setServicenumber(String servicenumber) {
        this.servicenumber = servicenumber;
    }

    public String getServicetag() {
        return servicetag;
    }

    public void setServicetag(String servicetag) {
        this.servicetag = servicetag;
    }

    public Short getSreplace() {
        return sreplace;
    }

    public void setSreplace(Short sreplace) {
        this.sreplace = sreplace;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlTransient
    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    @XmlTransient
    public Collection<Printer> getPrinterCollection() {
        return printerCollection;
    }

    public void setPrinterCollection(Collection<Printer> printerCollection) {
        this.printerCollection = printerCollection;
    }

    @XmlTransient
    public Collection<Devicename> getDevicenameCollection() {
        return devicenameCollection;
    }

    public void setDevicenameCollection(Collection<Devicename> devicenameCollection) {
        this.devicenameCollection = devicenameCollection;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Os getOsId() {
        return osId;
    }

    public void setOsId(Os osId) {
        this.osId = osId;
    }

    public Place getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Place placeId) {
        this.placeId = placeId;
    }

    public Processor getProcessorId1() {
        return processorId1;
    }

    public void setProcessorId1(Processor processorId1) {
        this.processorId1 = processorId1;
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
        if (!(object instanceof Computer)) {
            return false;
        }
        Computer other = (Computer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.db.Computer[ id=" + id + " ]";
    }
    
}
