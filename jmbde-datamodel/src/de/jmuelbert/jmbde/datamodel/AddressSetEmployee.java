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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The AddressSetEmployee Entity
 * 
 * 
 * @author Jürgen Mülbert
 * @version 0.4
 *
 * @see AddressSet
 */


@Entity
@Table(name = "AddressSet_Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressSetEmployee.findAll", query = "SELECT a FROM AddressSetEmployee a"),
    @NamedQuery(name = "AddressSetEmployee.findByFirstName", query = "SELECT a FROM AddressSetEmployee a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "AddressSetEmployee.findByMiddleName", query = "SELECT a FROM AddressSetEmployee a WHERE a.middleName = :middleName"),
    @NamedQuery(name = "AddressSetEmployee.findByName", query = "SELECT a FROM AddressSetEmployee a WHERE a.name = :name"),
    @NamedQuery(name = "AddressSetEmployee.findByBirthday", query = "SELECT a FROM AddressSetEmployee a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "AddressSetEmployee.findByBusinessMail", query = "SELECT a FROM AddressSetEmployee a WHERE a.businessMail = :businessMail"),
    @NamedQuery(name = "AddressSetEmployee.findByStartDate", query = "SELECT a FROM AddressSetEmployee a WHERE a.startDate = :startDate"),
    @NamedQuery(name = "AddressSetEmployee.findByEndDate", query = "SELECT a FROM AddressSetEmployee a WHERE a.endDate = :endDate"),
    @NamedQuery(name = "AddressSetEmployee.findByActive", query = "SELECT a FROM AddressSetEmployee a WHERE a.active = :active"),
    @NamedQuery(name = "AddressSetEmployee.findByDataCare", query = "SELECT a FROM AddressSetEmployee a WHERE a.dataCare = :dataCare"),
    @NamedQuery(name = "AddressSetEmployee.findByNotes", query = "SELECT a FROM AddressSetEmployee a WHERE a.notes = :notes"),
    @NamedQuery(name = "AddressSetEmployee.findByEmployeeNumber", query = "SELECT a FROM AddressSetEmployee a WHERE a.employeeNumber = :employeeNumber"),
    @NamedQuery(name = "AddressSetEmployee.findById", query = "SELECT a FROM AddressSetEmployee a WHERE a.id = :id")})
public class AddressSetEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "MiddleName")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Lob
    @Column(name = "Photo")
    private byte[] photo;
    @Column(name = "BusinessMail")
    private String businessMail;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "Active")
    private Boolean active;
    @Basic(optional = false)
    @Column(name = "DataCare")
    private boolean dataCare;
    @Column(name = "Notes")
    private String notes;
    @Column(name = "EmployeeNumber")
    private String employeeNumber;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @ManyToMany(mappedBy = "addressSetEmployeeCollection")
    private Collection<DoorSchemaSet> doorSchemaSetCollection;
    @ManyToMany(mappedBy = "addressSetEmployeeCollection")
    private Collection<DoorSet> doorSetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<DocumentsSet> documentsSetCollection;
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AddressSet addressSet;
    @JoinColumn(name = "Company_Id", referencedColumnName = "Id")
    @ManyToOne
    private AddressSetCompany companyId;
    @JoinColumn(name = "ChipCard_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private ChipCardSet chipCardId;
    @JoinColumn(name = "Department_Id", referencedColumnName = "Id")
    @ManyToOne
    private DepartmentSet departmentId;
    @JoinColumn(name = "Place_Id", referencedColumnName = "Id")
    @ManyToOne
    private PlaceSet placeId;
    @JoinColumn(name = "Workfunction_Id", referencedColumnName = "Id")
    @ManyToOne
    private WorkfunctionSet workfunctionId;
    @OneToMany(mappedBy = "employeeId")
    private Collection<DeviceSetPrinter> deviceSetPrinterCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<DeviceSetComputer> deviceSetComputerCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<DeviceSetPhone> deviceSetPhoneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<AccountSet> accountSetCollection;

    public AddressSetEmployee() {
    }

    public AddressSetEmployee(Integer id) {
        this.id = id;
    }

    public AddressSetEmployee(Integer id, String name, boolean dataCare) {
        this.id = id;
        this.name = name;
        this.dataCare = dataCare;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getBusinessMail() {
        return businessMail;
    }

    public void setBusinessMail(String businessMail) {
        this.businessMail = businessMail;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public boolean getDataCare() {
        return dataCare;
    }

    public void setDataCare(boolean dataCare) {
        this.dataCare = dataCare;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<DoorSchemaSet> getDoorSchemaSetCollection() {
        return doorSchemaSetCollection;
    }

    public void setDoorSchemaSetCollection(Collection<DoorSchemaSet> doorSchemaSetCollection) {
        this.doorSchemaSetCollection = doorSchemaSetCollection;
    }

    @XmlTransient
    public Collection<DoorSet> getDoorSetCollection() {
        return doorSetCollection;
    }

    public void setDoorSetCollection(Collection<DoorSet> doorSetCollection) {
        this.doorSetCollection = doorSetCollection;
    }

    @XmlTransient
    public Collection<DocumentsSet> getDocumentsSetCollection() {
        return documentsSetCollection;
    }

    public void setDocumentsSetCollection(Collection<DocumentsSet> documentsSetCollection) {
        this.documentsSetCollection = documentsSetCollection;
    }

    public AddressSet getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(AddressSet addressSet) {
        this.addressSet = addressSet;
    }

    public AddressSetCompany getCompanyId() {
        return companyId;
    }

    public void setCompanyId(AddressSetCompany companyId) {
        this.companyId = companyId;
    }

    public ChipCardSet getChipCardId() {
        return chipCardId;
    }

    public void setChipCardId(ChipCardSet chipCardId) {
        this.chipCardId = chipCardId;
    }

    public DepartmentSet getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentSet departmentId) {
        this.departmentId = departmentId;
    }

    public PlaceSet getPlaceId() {
        return placeId;
    }

    public void setPlaceId(PlaceSet placeId) {
        this.placeId = placeId;
    }

    public WorkfunctionSet getWorkfunctionId() {
        return workfunctionId;
    }

    public void setWorkfunctionId(WorkfunctionSet workfunctionId) {
        this.workfunctionId = workfunctionId;
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

    @XmlTransient
    public Collection<AccountSet> getAccountSetCollection() {
        return accountSetCollection;
    }

    public void setAccountSetCollection(Collection<AccountSet> accountSetCollection) {
        this.accountSetCollection = accountSetCollection;
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
        if (!(object instanceof AddressSetEmployee)) {
            return false;
        }
        AddressSetEmployee other = (AddressSetEmployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.datamodel.AddressSetEmployee[ id=" + id + " ]";
    }
    
}
