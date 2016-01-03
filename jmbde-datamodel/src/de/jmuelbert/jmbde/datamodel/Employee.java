/**
 * JMBDE - Datamodel - Employee
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByActive", query = "SELECT e FROM Employee e WHERE e.active = :active"),
    @NamedQuery(name = "Employee.findByBirthday", query = "SELECT e FROM Employee e WHERE e.birthday = :birthday"),
    @NamedQuery(name = "Employee.findByChipcard", query = "SELECT e FROM Employee e WHERE e.chipcard = :chipcard"),
    @NamedQuery(name = "Employee.findByCity", query = "SELECT e FROM Employee e WHERE e.city = :city"),
    @NamedQuery(name = "Employee.findByDatacare", query = "SELECT e FROM Employee e WHERE e.datacare = :datacare"),
    @NamedQuery(name = "Employee.findByEnddate", query = "SELECT e FROM Employee e WHERE e.enddate = :enddate"),
    @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Employee.findByLastUpdate", query = "SELECT e FROM Employee e WHERE e.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Employee.findByMail", query = "SELECT e FROM Employee e WHERE e.mail = :mail"),
    @NamedQuery(name = "Employee.findByMailHome", query = "SELECT e FROM Employee e WHERE e.mailHome = :mailHome"),
    @NamedQuery(name = "Employee.findByMiddlename", query = "SELECT e FROM Employee e WHERE e.middlename = :middlename"),
    @NamedQuery(name = "Employee.findByMobileHome", query = "SELECT e FROM Employee e WHERE e.mobileHome = :mobileHome"),
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findByNotes", query = "SELECT e FROM Employee e WHERE e.notes = :notes"),
    @NamedQuery(name = "Employee.findByNumber", query = "SELECT e FROM Employee e WHERE e.number = :number"),
    @NamedQuery(name = "Employee.findByPhoneHome", query = "SELECT e FROM Employee e WHERE e.phoneHome = :phoneHome"),
    @NamedQuery(name = "Employee.findByStartdate", query = "SELECT e FROM Employee e WHERE e.startdate = :startdate"),
    @NamedQuery(name = "Employee.findByStreet", query = "SELECT e FROM Employee e WHERE e.street = :street"),
    @NamedQuery(name = "Employee.findByZipcode", query = "SELECT e FROM Employee e WHERE e.zipcode = :zipcode")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ACTIVE")
    private Short active;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "CHIPCARD")
    private String chipcard;
    @Column(name = "CITY")
    private String city;
    @Column(name = "DATACARE")
    private Short datacare;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "MAIL_HOME")
    private String mailHome;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Column(name = "MOBILE_HOME")
    private String mobileHome;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "PHONE_HOME")
    private String phoneHome;
    @Lob
    @Column(name = "PHOTO")
    private Serializable photo;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIPCODE")
    private String zipcode;
    @ManyToMany(mappedBy = "employeeCollection")
    private Collection<Computer> computerCollection;
    @ManyToMany(mappedBy = "employeeCollection")
    private Collection<Phone> phoneCollection;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account accountId;
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Company companyId;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Department departmentId;
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Document documentId;
    @JoinColumn(name = "DOOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Door doorId;
    @JoinColumn(name = "DOORSCHEMA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Doorschema doorschemaId;
    @JoinColumn(name = "PRINTER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Printer printerId;
    @JoinColumn(name = "WORKFUNCTION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Workfunction workfunctionId;

    public Employee() {
    }

    public Employee(Long id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getChipcard() {
        return chipcard;
    }

    public void setChipcard(String chipcard) {
        this.chipcard = chipcard;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Short getDatacare() {
        return datacare;
    }

    public void setDatacare(Short datacare) {
        this.datacare = datacare;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailHome() {
        return mailHome;
    }

    public void setMailHome(String mailHome) {
        this.mailHome = mailHome;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getMobileHome() {
        return mobileHome;
    }

    public void setMobileHome(String mobileHome) {
        this.mobileHome = mobileHome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public Serializable getPhoto() {
        return photo;
    }

    public void setPhoto(Serializable photo) {
        this.photo = photo;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @XmlTransient
    public Collection<Computer> getComputerCollection() {
        return computerCollection;
    }

    public void setComputerCollection(Collection<Computer> computerCollection) {
        this.computerCollection = computerCollection;
    }

    @XmlTransient
    public Collection<Phone> getPhoneCollection() {
        return phoneCollection;
    }

    public void setPhoneCollection(Collection<Phone> phoneCollection) {
        this.phoneCollection = phoneCollection;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Document getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Document documentId) {
        this.documentId = documentId;
    }

    public Door getDoorId() {
        return doorId;
    }

    public void setDoorId(Door doorId) {
        this.doorId = doorId;
    }

    public Doorschema getDoorschemaId() {
        return doorschemaId;
    }

    public void setDoorschemaId(Doorschema doorschemaId) {
        this.doorschemaId = doorschemaId;
    }

    public Printer getPrinterId() {
        return printerId;
    }

    public void setPrinterId(Printer printerId) {
        this.printerId = printerId;
    }

    public Workfunction getWorkfunctionId() {
        return workfunctionId;
    }

    public void setWorkfunctionId(Workfunction workfunctionId) {
        this.workfunctionId = workfunctionId;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.db.Employee[ id=" + id + " ]";
    }
    
}
