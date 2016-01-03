/**
 * JMBDE - Datamodel - Phone
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
@Table(name = "PHONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p"),
    @NamedQuery(name = "Phone.findById", query = "SELECT p FROM Phone p WHERE p.id = :id"),
    @NamedQuery(name = "Phone.findByActive", query = "SELECT p FROM Phone p WHERE p.active = :active"),
    @NamedQuery(name = "Phone.findByCardnumber", query = "SELECT p FROM Phone p WHERE p.cardnumber = :cardnumber"),
    @NamedQuery(name = "Phone.findByLastUpdate", query = "SELECT p FROM Phone p WHERE p.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Phone.findByName", query = "SELECT p FROM Phone p WHERE p.name = :name"),
    @NamedQuery(name = "Phone.findByPin", query = "SELECT p FROM Phone p WHERE p.pin = :pin"),
    @NamedQuery(name = "Phone.findByPuk", query = "SELECT p FROM Phone p WHERE p.puk = :puk"),
    @NamedQuery(name = "Phone.findBySerialnumber", query = "SELECT p FROM Phone p WHERE p.serialnumber = :serialnumber"),
    @NamedQuery(name = "Phone.findBySreplace", query = "SELECT p FROM Phone p WHERE p.sreplace = :sreplace")})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ACTIVE")
    private Short active;
    @Column(name = "CARDNUMBER")
    private String cardnumber;
    @Column(name = "LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PIN")
    private String pin;
    @Column(name = "PUK")
    private String puk;
    @Column(name = "SERIALNUMBER")
    private String serialnumber;
    @Column(name = "SREPLACE")
    private Short sreplace;
    @JoinTable(name = "EMPLOYEE_PHONE", joinColumns = {
        @JoinColumn(name = "PHONE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Employee> employeeCollection;
    @OneToMany(mappedBy = "phoneId")
    private Collection<Devicename> devicenameCollection;
    @JoinColumn(name = "PLACE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Place placeId;
    @OneToMany(mappedBy = "phone1Id")
    private Collection<Manufacturer> manufacturerCollection;
    @OneToMany(mappedBy = "phoneId")
    private Collection<Devicetype> devicetypeCollection;

    public Phone() {
    }

    public Phone(Long id) {
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

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPuk() {
        return puk;
    }

    public void setPuk(String puk) {
        this.puk = puk;
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
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlTransient
    public Collection<Devicename> getDevicenameCollection() {
        return devicenameCollection;
    }

    public void setDevicenameCollection(Collection<Devicename> devicenameCollection) {
        this.devicenameCollection = devicenameCollection;
    }

    public Place getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Place placeId) {
        this.placeId = placeId;
    }

    @XmlTransient
    public Collection<Manufacturer> getManufacturerCollection() {
        return manufacturerCollection;
    }

    public void setManufacturerCollection(Collection<Manufacturer> manufacturerCollection) {
        this.manufacturerCollection = manufacturerCollection;
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
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.db.Phone[ id=" + id + " ]";
    }
    
}
