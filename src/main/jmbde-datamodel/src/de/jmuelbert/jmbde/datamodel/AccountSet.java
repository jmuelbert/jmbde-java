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
 *
 * @author Jürgen Mülbert
 * @version 0.4
 *
 */

@Entity
@Table(name = "AccountSet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AccountSet.findAll", query = "SELECT a FROM AccountSet a")
  ,
      @NamedQuery(name = "AccountSet.findById",
                  query = "SELECT a FROM AccountSet a WHERE a.id = :id"),
      @NamedQuery(name = "AccountSet.findByName",
                  query = "SELECT a FROM AccountSet a WHERE a.name = :name"),
      @NamedQuery(
          name = "AccountSet.findByPassword",
          query = "SELECT a FROM AccountSet a WHERE a.password = :password"),
      @NamedQuery(
          name = "AccountSet.findByLastUpdate",
          query =
              "SELECT a FROM AccountSet a WHERE a.lastUpdate = :lastUpdate"),
      @NamedQuery(name = "AccountSet.findByUserName",
                  query =
                      "SELECT a FROM AccountSet a WHERE a.userName = :userName")
})
public class AccountSet implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id @Basic(optional = false) @Column(name = "Id") private Integer id;
  @Basic(optional = false) @Column(name = "Name") private String name;
  @Column(name = "Password") private String password;
  @Column(name = "LastUpdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;
  @Basic(optional = false) @Column(name = "UserName") private String userName;
  @JoinTable(
      name = "AccountSystemData",
      joinColumns =
      { @JoinColumn(name = "Account_Id", referencedColumnName = "Id") },
      inverseJoinColumns =
      { @JoinColumn(name = "SystemData_Id", referencedColumnName = "Id") })
  @ManyToMany
  private Collection<SystemDataSet> systemDataSetCollection;
  @JoinColumn(name = "Employee_Id", referencedColumnName = "Id")
  @ManyToOne(optional = false)
  private AddressSetEmployee employeeId;

  public AccountSet() {}

  public AccountSet(Integer id) { this.id = id; }

  public AccountSet(Integer id, String name, String userName) {
    this.id = id;
    this.name = name;
    this.userName = userName;
  }

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getPassword() { return password; }

  public void setPassword(String password) { this.password = password; }

  public Date getLastUpdate() { return lastUpdate; }

  public void setLastUpdate(Date lastUpdate) { this.lastUpdate = lastUpdate; }

  public String getUserName() { return userName; }

  public void setUserName(String userName) { this.userName = userName; }

  @XmlTransient
  public Collection<SystemDataSet> getSystemDataSetCollection() {
    return systemDataSetCollection;
  }

  public void setSystemDataSetCollection(
      Collection<SystemDataSet> systemDataSetCollection) {
    this.systemDataSetCollection = systemDataSetCollection;
  }

  public AddressSetEmployee getEmployeeId() { return employeeId; }

  public void setEmployeeId(AddressSetEmployee employeeId) {
    this.employeeId = employeeId;
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
    if (!(object instanceof AccountSet)) {
      return false;
    }
    AccountSet other = (AccountSet)object;
    if ((this.id == null && other.id != null) ||
        (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.AccountSet[ id=" + id + " ]";
  }
}
