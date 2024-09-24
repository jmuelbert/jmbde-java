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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The DeviceSetPhone Entity
 *
 *
 * @author Jürgen Mülbert
 * @version 0.4
 *
 * @see DeviceSet
 */

@Entity
@Table(name = "DeviceSet_Phone")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "DeviceSetPhone.findAll",
              query = "SELECT d FROM DeviceSetPhone d")
  ,
      @NamedQuery(name = "DeviceSetPhone.findByPin",
                  query = "SELECT d FROM DeviceSetPhone d WHERE d.pin = :pin"),
      @NamedQuery(name = "DeviceSetPhone.findByPuk",
                  query = "SELECT d FROM DeviceSetPhone d WHERE d.puk = :puk"),
      @NamedQuery(
          name = "DeviceSetPhone.findByCardNumber",
          query =
              "SELECT d FROM DeviceSetPhone d WHERE d.cardNumber = :cardNumber")
      ,
      @NamedQuery(name = "DeviceSetPhone.findById",
                  query = "SELECT d FROM DeviceSetPhone d WHERE d.id = :id")
})
public class DeviceSetPhone implements Serializable {

  private static final long serialVersionUID = 1L;
  @Column(name = "Pin") private String pin;
  @Column(name = "Puk") private String puk;
  @Column(name = "CardNumber") private String cardNumber;
  @Id @Basic(optional = false) @Column(name = "Id") private Integer id;
  @OneToMany(mappedBy = "phoneId")
  private Collection<InventorySet> inventorySetCollection;
  @JoinColumn(name = "Employee_Id", referencedColumnName = "Id")
  @ManyToOne
  private AddressSetEmployee employeeId;
  @JoinColumn(name = "Manufacturer_Id", referencedColumnName = "Id")
  @ManyToOne
  private AddressSetManufacturer manufacturerId;
  @JoinColumn(name = "Department_Id", referencedColumnName = "Id")
  @ManyToOne
  private DepartmentSet departmentId;
  @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false,
              updatable = false)
  @OneToOne(optional = false)
  private DeviceSet deviceSet;
  @JoinColumn(name = "DeviceType_Id", referencedColumnName = "Id")
  @ManyToOne
  private DeviceTypeSet deviceTypeId;
  @OneToMany(mappedBy = "phoneId")
  private Collection<PlaceSet> placeSetCollection;

  public DeviceSetPhone() {}

  public DeviceSetPhone(Integer id) { this.id = id; }

  public String getPin() { return pin; }

  public void setPin(String pin) { this.pin = pin; }

  public String getPuk() { return puk; }

  public void setPuk(String puk) { this.puk = puk; }

  public String getCardNumber() { return cardNumber; }

  public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  @XmlTransient
  public Collection<InventorySet> getInventorySetCollection() {
    return inventorySetCollection;
  }

  public void
  setInventorySetCollection(Collection<InventorySet> inventorySetCollection) {
    this.inventorySetCollection = inventorySetCollection;
  }

  public AddressSetEmployee getEmployeeId() { return employeeId; }

  public void setEmployeeId(AddressSetEmployee employeeId) {
    this.employeeId = employeeId;
  }

  public AddressSetManufacturer getManufacturerId() { return manufacturerId; }

  public void setManufacturerId(AddressSetManufacturer manufacturerId) {
    this.manufacturerId = manufacturerId;
  }

  public DepartmentSet getDepartmentId() { return departmentId; }

  public void setDepartmentId(DepartmentSet departmentId) {
    this.departmentId = departmentId;
  }

  public DeviceSet getDeviceSet() { return deviceSet; }

  public void setDeviceSet(DeviceSet deviceSet) { this.deviceSet = deviceSet; }

  public DeviceTypeSet getDeviceTypeId() { return deviceTypeId; }

  public void setDeviceTypeId(DeviceTypeSet deviceTypeId) {
    this.deviceTypeId = deviceTypeId;
  }

  @XmlTransient
  public Collection<PlaceSet> getPlaceSetCollection() {
    return placeSetCollection;
  }

  public void setPlaceSetCollection(Collection<PlaceSet> placeSetCollection) {
    this.placeSetCollection = placeSetCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not
    // set
    if (!(object instanceof DeviceSetPhone)) {
      return false;
    }
    DeviceSetPhone other = (DeviceSetPhone)object;
    if ((this.id == null && other.id != null) ||
        (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.DeviceSetPhone[ id=" + id + " ]";
  }
}
