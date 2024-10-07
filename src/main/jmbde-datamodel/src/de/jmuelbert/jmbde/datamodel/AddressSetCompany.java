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

import java.util.Collection;
import java.util.Date;

/**
 * The AddressSetComany Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 * @see AddressSet
 */

/**
 * The AddressSetCompany entity represents a company in the address set. It is mapped to the
 * "AddressSet_Company" table in the database. This entity provides methods to manage the company's
 * name, name2, last update date, and ID. It also has a one-to-one relationship with the AddressSet
 * entity and a one-to-many relationship with the AddressSetEmployee entity.
 */
@Entity
@Table(name = "AddressSet_Company")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AddressSetCompany.findAll", query = "SELECT a FROM AddressSetCompany a"),
  @NamedQuery(
      name = "AddressSetCompany.findByName",
      query = "SELECT a FROM AddressSetCompany a WHERE a.name = :name"),
  @NamedQuery(
      name = "AddressSetCompany.findByName2",
      query = "SELECT a FROM AddressSetCompany a WHERE a.name2 = :name2"),
  @NamedQuery(
      name = "AddressSetCompany.findByLastUpdate",
      query = "SELECT a FROM AddressSetCompany a WHERE " + "a.lastUpdate = :lastUpdate"),
  @NamedQuery(
      name = "AddressSetCompany.findById",
      query = "SELECT a FROM AddressSetCompany a WHERE a.id = :id")
})
public class AddressSetCompany implements Serializable {

  private static final long serialVersionUID = 1L;

  @Basic(optional = false)
  @Column(name = "Name")
  private String name;

  @Column(name = "Name2")
  private String name2;

  @Column(name = "LastUpdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @OneToMany(mappedBy = "companyId")
  private Collection<AddressSetEmployee> addressSetEmployeeCollection;

  @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
  @OneToOne(optional = false)
  private AddressSet addressSet;

  /**
   * Constructs a new instance of the {@link AddressSetCompany} class with the specified ID.
   *
   * @param id the ID of the AddressSetCompany instance
   */
  public AddressSetCompany(Integer id) {
    this.id = id;
  }

  public AddressSetCompany(Integer id) {
    this.id = id;
  }

  public AddressSetCompany(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName2() {
    return name2;
  }

  public void setName2(String name2) {
    this.name2 = name2;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @XmlTransient
  public Collection<AddressSetEmployee> getAddressSetEmployeeCollection() {
    return addressSetEmployeeCollection;
  }

  public void setAddressSetEmployeeCollection(
      Collection<AddressSetEmployee> addressSetEmployeeCollection) {
    this.addressSetEmployeeCollection = addressSetEmployeeCollection;
  }

  public AddressSet getAddressSet() {
    return addressSet;
  }

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
    if (!(object instanceof AddressSetCompany)) {
      return false;
    }
    AddressSetCompany other = (AddressSetCompany) object;
    return !((this.id == null && other.id != null)
        || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.AddressSetCompany[ id=" + id + " ]";
  }
}
