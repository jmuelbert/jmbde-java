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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The DoorSchemaSet Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 */
@Entity
@Table(name = "DoorSchemaSet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "DoorSchemaSet.findAll", query = "SELECT d FROM DoorSchemaSet d"),
  @NamedQuery(
      name = "DoorSchemaSet.findById",
      query = "SELECT d FROM DoorSchemaSet d WHERE d.id = :id"),
  @NamedQuery(
      name = "DoorSchemaSet.findByName",
      query = "SELECT d FROM DoorSchemaSet d WHERE d.name = :name"),
  @NamedQuery(
      name = "DoorSchemaSet.findByLastUpdate",
      query = "SELECT d FROM DoorSchemaSet d WHERE d.lastUpdate = :lastUpdate")
})
public class DoorSchemaSet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @Basic(optional = false)
  @Column(name = "Name")
  private String name;

  @Column(name = "LastUpdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;

  @JoinTable(
      name = "EmployeeDoorSchema",
      joinColumns = {@JoinColumn(name = "DoorSchema_Id", referencedColumnName = "Id")},
      inverseJoinColumns = {@JoinColumn(name = "Employee_Id", referencedColumnName = "Id")})
  @ManyToMany
  private Collection<AddressSetEmployee> addressSetEmployeeCollection;

  @ManyToMany(mappedBy = "doorSchemaSetCollection")
  private Collection<ChipCardSet> chipCardSetCollection;

  @ManyToMany(mappedBy = "doorSchemaSetCollection")
  private Collection<DoorSet> doorSetCollection;

  public DoorSchemaSet() {}

  public DoorSchemaSet(Integer id) {
    this.id = id;
  }

  public DoorSchemaSet(Integer id, String name) {
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

  @XmlTransient
  public Collection<ChipCardSet> getChipCardSetCollection() {
    return chipCardSetCollection;
  }

  public void setChipCardSetCollection(Collection<ChipCardSet> chipCardSetCollection) {
    this.chipCardSetCollection = chipCardSetCollection;
  }

  @XmlTransient
  public Collection<DoorSet> getDoorSetCollection() {
    return doorSetCollection;
  }

  public void setDoorSetCollection(Collection<DoorSet> doorSetCollection) {
    this.doorSetCollection = doorSetCollection;
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
    if (!(object instanceof DoorSchemaSet)) {
      return false;
    }
    DoorSchemaSet other = (DoorSchemaSet) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.DoorSchemaSet[ id=" + id + " ]";
  }
}
