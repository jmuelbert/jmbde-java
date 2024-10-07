/**
 * JMBDE - Datamodel
 *
 * <p>Created by Jürgen Mülbert on 07.12.2015 Copyright (c) 2015 Jürgen Mülbert. All rights
 * reserved.
 *
 * <p>This program is free software: you can redistribute it and/or modify it under the terms of the
 * European Union Public Licence (EUPL), version 1.1.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * European Union Public Licence for more details.
 *
 * <p>You should have received a copy of the European Union Public Licence along with this program.
 * If not, see https://tldrlegal.com/license/european-union-public-licence
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
 * The DeviceSetPrinter Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 * @see DeviceSet
 */
@Entity
@Table(name = "DeviceSet_Printer")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "DeviceSetPrinter.findAll", query = "SELECT d FROM DeviceSetPrinter d"),
  @NamedQuery(
      name = "DeviceSetPrinter.findByPaperSizeMax",
      query = "SELECT d FROM DeviceSetPrinter d WHERE " + "d.paperSizeMax = :paperSizeMax"),
  @NamedQuery(
      name = "DeviceSetPrinter.findByColor",
      query = "SELECT d FROM DeviceSetPrinter d WHERE d.color = :color"),
  @NamedQuery(
      name = "DeviceSetPrinter.findByNumber",
      query = "SELECT d FROM DeviceSetPrinter d WHERE d.number = :number"),
  @NamedQuery(
      name = "DeviceSetPrinter.findByPin",
      query = "SELECT d FROM DeviceSetPrinter d WHERE d.pin = :pin"),
  @NamedQuery(
      name = "DeviceSetPrinter.findByNetwork",
      query = "SELECT d FROM DeviceSetPrinter d WHERE d.network = :network"),
  @NamedQuery(
      name = "DeviceSetPrinter.findByIPAddress",
      query = "SELECT d FROM DeviceSetPrinter d WHERE d.iPAddress = :iPAddress"),
  @NamedQuery(
      name = "DeviceSetPrinter.findById",
      query = "SELECT d FROM DeviceSetPrinter d WHERE d.id = :id")
})
public class DeviceSetPrinter implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "PaperSizeMax")
  private String paperSizeMax;

  @Column(name = "Color")
  private Boolean color;

  @Column(name = "Number")
  private String number;

  @Column(name = "Pin")
  private String pin;

  @Column(name = "Network")
  private String network;

  @Column(name = "IPAddress")
  private String iPAddress;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @OneToMany(mappedBy = "printerId")
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

  @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
  @OneToOne(optional = false)
  private DeviceSet deviceSet;

  @JoinColumn(name = "DeviceType_Id", referencedColumnName = "Id")
  @ManyToOne
  private DeviceTypeSet deviceTypeId;

  @OneToMany(mappedBy = "printerId")
  private Collection<PlaceSet> placeSetCollection;

  public DeviceSetPrinter() {}

  public DeviceSetPrinter(Integer id) {
    this.id = id;
  }

  public String getPaperSizeMax() {
    return paperSizeMax;
  }

  public void setPaperSizeMax(String paperSizeMax) {
    this.paperSizeMax = paperSizeMax;
  }

  public Boolean getColor() {
    return color;
  }

  public void setColor(Boolean color) {
    this.color = color;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public String getIPAddress() {
    return iPAddress;
  }

  public void setIPAddress(String iPAddress) {
    this.iPAddress = iPAddress;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @XmlTransient
  public Collection<InventorySet> getInventorySetCollection() {
    return inventorySetCollection;
  }

  public void setInventorySetCollection(Collection<InventorySet> inventorySetCollection) {
    this.inventorySetCollection = inventorySetCollection;
  }

  public AddressSetEmployee getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(AddressSetEmployee employeeId) {
    this.employeeId = employeeId;
  }

  public AddressSetManufacturer getManufacturerId() {
    return manufacturerId;
  }

  public void setManufacturerId(AddressSetManufacturer manufacturerId) {
    this.manufacturerId = manufacturerId;
  }

  public DepartmentSet getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(DepartmentSet departmentId) {
    this.departmentId = departmentId;
  }

  public DeviceSet getDeviceSet() {
    return deviceSet;
  }

  public void setDeviceSet(DeviceSet deviceSet) {
    this.deviceSet = deviceSet;
  }

  public DeviceTypeSet getDeviceTypeId() {
    return deviceTypeId;
  }

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
    if (!(object instanceof DeviceSetPrinter)) {
      return false;
    }
    DeviceSetPrinter other = (DeviceSetPrinter) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.DeviceSetPrinter[ id=" + id + " ]";
  }
}
