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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The Account Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 */
@Entity
@Table(name = "AccountSet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AccountSet.findAll", query = "SELECT a FROM AccountSet a"),
  @NamedQuery(name = "AccountSet.findById", query = "SELECT a FROM AccountSet a WHERE a.id = :id"),
  @NamedQuery(
      name = "AccountSet.findByName",
      query = "SELECT a FROM AccountSet a WHERE a.name = :name"),
  @NamedQuery(
      name = "AccountSet.findByPassword",
      query = "SELECT a FROM AccountSet a WHERE a.password = :password"),
  @NamedQuery(
      name = "AccountSet.findByLastUpdate",
      query = "SELECT a FROM AccountSet a WHERE a.lastUpdate = :lastUpdate"),
  @NamedQuery(
      name = "AccountSet.findByUserName",
      query = "SELECT a FROM AccountSet a WHERE a.userName = :userName")
})
public class AccountSet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @Basic(optional = false)
  @Column(name = "Name")
  private String name;

  @Column(name = "Password")
  private String password;

  @Column(name = "LastUpdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;

  @Basic(optional = false)
  @Column(name = "UserName")
  private String userName;

  @JoinTable(
      name = "AccountSystemData",
      joinColumns = {@JoinColumn(name = "Account_Id", referencedColumnName = "Id")},
      inverseJoinColumns = {@JoinColumn(name = "SystemData_Id", referencedColumnName = "Id")})
  @ManyToMany
  private Collection<SystemDataSet> systemDataSetCollection;

  @JoinColumn(name = "Employee_Id", referencedColumnName = "Id")
  @ManyToOne(optional = false)
  private AddressSetEmployee employeeId;

  /**
   * Constructs a new {@link AccountSet} instance with the specified ID.
   *
   * @param id the ID of the {@link AccountSet} instance
   */
  public AccountSet(Integer id) {
    this.id = id;
  }

  /**
   * Constructs a new {@link AccountSet} instance with the specified ID, name, and user name.
   *
   * @param id the ID of the {@link AccountSet} instance
   * @param name the name of the {@link AccountSet} instance
   * @param userName the user name of the {@link AccountSet} instance
   */
  public AccountSet(Integer id, String name, String userName) {
    this.id = id;
    this.name = name;
    this.userName = userName;
  }

  public Integer getId() {
    return id;
  }

  /**
   * Sets the ID of the {@link AccountSet} instance.
   *
   * @param id the ID to set for the {@link AccountSet} instance
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Sets the ID of the {@link AccountSet} instance.
   *
   * @param id the ID to set for the {@link AccountSet} instance
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Returns the name of the {@link AccountSet} instance.
   *
   * @return the name of the {@link AccountSet} instance
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @XmlTransient
  public Collection<SystemDataSet> getSystemDataSetCollection() {
    return systemDataSetCollection;
  }

  public void setSystemDataSetCollection(Collection<SystemDataSet> systemDataSetCollection) {
    this.systemDataSetCollection = systemDataSetCollection;
  }

  public AddressSetEmployee getEmployeeId() {
    return employeeId;
  }

  /**
   * Sets the {@link AddressSetEmployee} instance that is the ID of the {@link AccountSet} instance.
   *
   * @param employeeId the {@link AddressSetEmployee} ID to set for the {@link AccountSet} instance
   */
  public void setEmployeeId(AddressSetEmployee employeeId) {
    this.employeeId = employeeId;
  }

  /**
   * Computes a hash code for the {@link AccountSet} instance.
   *
   * <p>The hash code is computed using the ID of the {@link AccountSet} instance.
   *
   * @return the hash code for the {@link AccountSet} instance
   */
  @Override
  public int hashCode() {
    // Use a prime number multiplier to reduce collisions
    int prime = 31;
    int result = 1;
    result = prime * result + (id != null ? id.hashCode() : 0);
    return result;
  }

  /**
   * Checks if the given object is an instance of AccountSet and has the same id.
   *
   * @param object the object to check
   * @return true if the object is an instance of AccountSet and has the same id, false otherwise
   */
  @Override
  public boolean equals(Object object) {
    // Check if the object is an instance of AccountSet and has the same id
    return object instanceof AccountSet && Objects.equals(id, ((AccountSet) object).id);
  }

  /**
   * Returns the collection of {@link SystemDataSet} instances that are associated with this {@link
   * AccountSet} instance.
   *
   * @return the collection of {@link SystemDataSet} instances
   */
  @XmlTransient
  public Set<SystemDataSet> getSystemDataSetCollection() {
    return systemDataSetCollection;
  }

  /**
   * Returns a string representation of the {@link AccountSet} instance.
   *
   * <p>The string representation is of the form "AccountSet[id=<i>id</i>]", where <i>id</i> is the
   * ID of the {@link AccountSet} instance.
   *
   * @return a string representation of the {@link AccountSet} instance
   */
  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.AccountSet[ id=" + id + " ]";
  }
}
