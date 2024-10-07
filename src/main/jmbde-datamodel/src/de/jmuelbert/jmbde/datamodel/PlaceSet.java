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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * The PlaceSet Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 */
@Entity
@Table(name = "PlaceSet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "PlaceSet.findAll", query = "SELECT p FROM PlaceSet p"),
  @NamedQuery(name = "PlaceSet.findById", query = "SELECT p FROM PlaceSet p WHERE p.id = :id"),
  @NamedQuery(
      name = "PlaceSet.findByName",
      query = "SELECT p FROM PlaceSet p WHERE p.name = :name"),
  @NamedQuery(
      name = "PlaceSet.findByRoom",
      query = "SELECT p FROM PlaceSet p WHERE p.room = :room"),
  @NamedQuery(
      name = "PlaceSet.findByDesk",
      query = "SELECT p FROM PlaceSet p WHERE p.desk = :desk"),
  @NamedQuery(
      name = "PlaceSet.findByLastUpdate",
      query = "SELECT p FROM PlaceSet p WHERE p.lastUpdate = :lastUpdate")
})
public class PlaceSet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @Basic(optional = false)
  @Column(name = "Name")
  private String name;

  @Column(name = "Room")
  private String room;

  @Column(name = "Desk")
  private String desk;

  @Column(name = "LastUpdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;

  @OneToMany(mappedBy = "placeId")
  private Collection<AddressSetEmployee> addressSetEmployeeCollection;

  @JoinColumn(name = "Computer_Id", referencedColumnName = "Id")
  @ManyToOne
  private DeviceSetComputer computerId;

  @JoinColumn(name = "Phone_Id", referencedColumnName = "Id")
  @ManyToOne
  private DeviceSetPhone phoneId;

  @JoinColumn(name = "Printer_Id", referencedColumnName = "Id")
  @ManyToOne
  private DeviceSetPrinter printerId;

  public PlaceSet() {}

  public PlaceSet(Integer id) {
    this.id = id;
  }

  public PlaceSet(Integer id, String name) {
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

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public String getDesk() {
    return desk;
  }

  public void setDesk(String desk) {
    this.desk = desk;
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

  public void setAddressSetEmployeeCollection(
      Collection<AddressSetEmployee> addressSetEmployeeCollection) {
    this.addressSetEmployeeCollection = addressSetEmployeeCollection;
  }

  public DeviceSetComputer getComputerId() {
    return computerId;
  }

  public void setComputerId(DeviceSetComputer computerId) {
    this.computerId = computerId;
  }

  public DeviceSetPhone getPhoneId() {
    return phoneId;
  }

  public void setPhoneId(DeviceSetPhone phoneId) {
    this.phoneId = phoneId;
  }

  public DeviceSetPrinter getPrinterId() {
    return printerId;
  }

  public void setPrinterId(DeviceSetPrinter printerId) {
    this.printerId = printerId;
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
    if (!(object instanceof PlaceSet)) {
      return false;
    }
    PlaceSet other = (PlaceSet) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.PlaceSet[ id=" + id + " ]";
  }
}
