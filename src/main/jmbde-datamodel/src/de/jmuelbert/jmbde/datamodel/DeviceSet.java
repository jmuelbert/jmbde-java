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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The DeviceSet Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 */
@Entity
@Table(name = "DeviceSet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "DeviceSet.findAll", query = "SELECT d FROM DeviceSet d"),
  @NamedQuery(name = "DeviceSet.findById", query = "SELECT d FROM DeviceSet d WHERE d.id = :id"),
  @NamedQuery(
      name = "DeviceSet.findByName",
      query = "SELECT d FROM DeviceSet d WHERE d.name = :name"),
  @NamedQuery(
      name = "DeviceSet.findBySerialNumber",
      query = "SELECT d FROM DeviceSet d WHERE d.serialNumber = :serialNumber"),
  @NamedQuery(
      name = "DeviceSet.findBySince",
      query = "SELECT d FROM DeviceSet d WHERE d.since = :since"),
  @NamedQuery(
      name = "DeviceSet.findByActive",
      query = "SELECT d FROM DeviceSet d WHERE d.active = :active"),
  @NamedQuery(
      name = "DeviceSet.findByShouldReplace",
      query = "SELECT d FROM DeviceSet d WHERE d.shouldReplace = " + ":shouldReplace"),
  @NamedQuery(
      name = "DeviceSet.findByLastUpdate",
      query = "SELECT d FROM DeviceSet d WHERE d.lastUpdate = :lastUpdate")
})
public class DeviceSet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @Basic(optional = false)
  @Column(name = "Name")
  private String name;

  @Column(name = "SerialNumber")
  private String serialNumber;

  @Column(name = "Since")
  @Temporal(TemporalType.TIMESTAMP)
  private Date since;

  @Column(name = "Active")
  private Boolean active;

  @Column(name = "ShouldReplace")
  private Boolean shouldReplace;

  @Column(name = "LastUpdate")
  private Boolean lastUpdate;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "deviceSet")
  private DeviceSetPrinter deviceSetPrinter;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "deviceSet")
  private DeviceSetComputer deviceSetComputer;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "deviceSet")
  private DeviceSetPhone deviceSetPhone;

  public DeviceSet() {}

  public DeviceSet(Integer id) {
    this.id = id;
  }

  public DeviceSet(Integer id, String name) {
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

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Date getSince() {
    return since;
  }

  public void setSince(Date since) {
    this.since = since;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Boolean getShouldReplace() {
    return shouldReplace;
  }

  public void setShouldReplace(Boolean shouldReplace) {
    this.shouldReplace = shouldReplace;
  }

  public Boolean getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Boolean lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public DeviceSetPrinter getDeviceSetPrinter() {
    return deviceSetPrinter;
  }

  public void setDeviceSetPrinter(DeviceSetPrinter deviceSetPrinter) {
    this.deviceSetPrinter = deviceSetPrinter;
  }

  public DeviceSetComputer getDeviceSetComputer() {
    return deviceSetComputer;
  }

  public void setDeviceSetComputer(DeviceSetComputer deviceSetComputer) {
    this.deviceSetComputer = deviceSetComputer;
  }

  public DeviceSetPhone getDeviceSetPhone() {
    return deviceSetPhone;
  }

  public void setDeviceSetPhone(DeviceSetPhone deviceSetPhone) {
    this.deviceSetPhone = deviceSetPhone;
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
    if (!(object instanceof DeviceSet)) {
      return false;
    }
    DeviceSet other = (DeviceSet) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.DeviceSet[ id=" + id + " ]";
  }
}
