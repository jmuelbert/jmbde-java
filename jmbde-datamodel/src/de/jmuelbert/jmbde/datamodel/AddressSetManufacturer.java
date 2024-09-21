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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The AddressSetManufacturer Entity
 *
 *
 * @author Jürgen Mülbert
 * @version 0.4
 *
 * @see AddressSet
 */

@Entity
@Table(name = "AddressSet_Manufacturer")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AddressSetManufacturer.findAll",
              query = "SELECT a FROM AddressSetManufacturer a")
  ,
      @NamedQuery(
          name = "AddressSetManufacturer.findByName",
          query =
              "SELECT a FROM AddressSetManufacturer a WHERE a.name = :name"),
      @NamedQuery(
          name = "AddressSetManufacturer.findByName2",
          query =
              "SELECT a FROM AddressSetManufacturer a WHERE a.name2 = :name2"),
      @NamedQuery(name = "AddressSetManufacturer.findBySupporter",
                  query = "SELECT a FROM AddressSetManufacturer a WHERE " +
                          "a.supporter = :supporter"),
      @NamedQuery(name = "AddressSetManufacturer.findByHotline",
                  query = "SELECT a FROM AddressSetManufacturer a WHERE " +
                          "a.hotline = :hotline"),
      @NamedQuery(name = "AddressSetManufacturer.findByLastUpdate",
                  query = "SELECT a FROM AddressSetManufacturer a WHERE " +
                          "a.lastUpdate = :lastUpdate"),
      @NamedQuery(name = "AddressSetManufacturer.findById",
                  query =
                      "SELECT a FROM AddressSetManufacturer a WHERE a.id = :id")
})
public class AddressSetManufacturer implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false) @Column(name = "Name") private String name;
  @Basic(optional = false) @Column(name = "Name2") private String name2;
  @Basic(optional = false) @Column(name = "Supporter") private String supporter;
  @Basic(optional = false) @Column(name = "Hotline") private String hotline;
  @Basic(optional = false)
  @Column(name = "LastUpdate")
  private String lastUpdate;
  @Id @Basic(optional = false) @Column(name = "Id") private Integer id;
  @OneToMany(mappedBy = "manufacturerId")
  private Collection<DeviceSetPrinter> deviceSetPrinterCollection;
  @OneToMany(mappedBy = "manufacturerId")
  private Collection<DeviceSetComputer> deviceSetComputerCollection;
  @OneToMany(mappedBy = "manufacturerId")
  private Collection<DeviceSetPhone> deviceSetPhoneCollection;
  @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false,
              updatable = false)
  @OneToOne(optional = false)
  private AddressSet addressSet;

  public AddressSetManufacturer() {}

  public AddressSetManufacturer(Integer id) { this.id = id; }

  public AddressSetManufacturer(Integer id, String name, String name2,
                                String supporter, String hotline,
                                String lastUpdate) {
    this.id = id;
    this.name = name;
    this.name2 = name2;
    this.supporter = supporter;
    this.hotline = hotline;
    this.lastUpdate = lastUpdate;
  }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getName2() { return name2; }

  public void setName2(String name2) { this.name2 = name2; }

  public String getSupporter() { return supporter; }

  public void setSupporter(String supporter) { this.supporter = supporter; }

  public String getHotline() { return hotline; }

  public void setHotline(String hotline) { this.hotline = hotline; }

  public String getLastUpdate() { return lastUpdate; }

  public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  @XmlTransient
  public Collection<DeviceSetPrinter> getDeviceSetPrinterCollection() {
    return deviceSetPrinterCollection;
  }

  public void setDeviceSetPrinterCollection(
      Collection<DeviceSetPrinter> deviceSetPrinterCollection) {
    this.deviceSetPrinterCollection = deviceSetPrinterCollection;
  }

  @XmlTransient
  public Collection<DeviceSetComputer> getDeviceSetComputerCollection() {
    return deviceSetComputerCollection;
  }

  public void setDeviceSetComputerCollection(
      Collection<DeviceSetComputer> deviceSetComputerCollection) {
    this.deviceSetComputerCollection = deviceSetComputerCollection;
  }

  @XmlTransient
  public Collection<DeviceSetPhone> getDeviceSetPhoneCollection() {
    return deviceSetPhoneCollection;
  }

  public void setDeviceSetPhoneCollection(
      Collection<DeviceSetPhone> deviceSetPhoneCollection) {
    this.deviceSetPhoneCollection = deviceSetPhoneCollection;
  }

  public AddressSet getAddressSet() { return addressSet; }

  public void setAddressSet(AddressSet addressSet) {
    this.addressSet = addressSet;
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
    if (!(object instanceof AddressSetManufacturer)) {
      return false;
    }
    AddressSetManufacturer other = (AddressSetManufacturer)object;
    if ((this.id == null && other.id != null) ||
        (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.AddressSetManufacturer[ id=" + id +
        " ]";
  }
}
