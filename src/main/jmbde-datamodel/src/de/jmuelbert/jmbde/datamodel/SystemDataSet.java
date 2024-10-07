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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The SystemDataSet Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 * @see AccountSet
 */
@Entity
@Table(name = "SystemDataSet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "SystemDataSet.findAll", query = "SELECT s FROM SystemDataSet s"),
  @NamedQuery(
      name = "SystemDataSet.findById",
      query = "SELECT s FROM SystemDataSet s WHERE s.id = :id"),
  @NamedQuery(
      name = "SystemDataSet.findByName",
      query = "SELECT s FROM SystemDataSet s WHERE s.name = :name"),
  @NamedQuery(
      name = "SystemDataSet.findByLocal",
      query = "SELECT s FROM SystemDataSet s WHERE s.local = :local"),
  @NamedQuery(
      name = "SystemDataSet.findByLastUpdate",
      query = "SELECT s FROM SystemDataSet s WHERE s.lastUpdate = :lastUpdate")
})
public class SystemDataSet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @Basic(optional = false)
  @Column(name = "Name")
  private String name;

  @Column(name = "Local")
  private Boolean local;

  @Column(name = "LastUpdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;

  @ManyToMany(mappedBy = "systemDataSetCollection")
  private Collection<AccountSet> accountSetCollection;

  public SystemDataSet() {}

  public SystemDataSet(Integer id) {
    this.id = id;
  }

  public SystemDataSet(Integer id, String name) {
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

  public Boolean getLocal() {
    return local;
  }

  public void setLocal(Boolean local) {
    this.local = local;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
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
    // TODO: Warning - this method won't work in the case the id fields are not
    // set
    if (!(object instanceof SystemDataSet)) {
      return false;
    }
    SystemDataSet other = (SystemDataSet) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.SystemDataSet[ id=" + id + " ]";
  }
}
