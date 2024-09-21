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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The WorkfunctionSet Entity
 *
 *
 * @author Jürgen Mülbert
 * @version 0.4
 *
 */

@Entity
@Table(name = "WorkfunctionSet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "WorkfunctionSet.findAll",
              query = "SELECT w FROM WorkfunctionSet w")
  ,
      @NamedQuery(name = "WorkfunctionSet.findById",
                  query = "SELECT w FROM WorkfunctionSet w WHERE w.id = :id"),
      @NamedQuery(name = "WorkfunctionSet.findByName",
                  query =
                      "SELECT w FROM WorkfunctionSet w WHERE w.name = :name"),
      @NamedQuery(
          name = "WorkfunctionSet.findByPriority",
          query =
              "SELECT w FROM WorkfunctionSet w WHERE w.priority = :priority"),
      @NamedQuery(name = "WorkfunctionSet.findByLastUpdate",
                  query = "SELECT w FROM WorkfunctionSet w WHERE " +
                          "w.lastUpdate = :lastUpdate")
})
public class WorkfunctionSet implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id @Basic(optional = false) @Column(name = "Id") private Integer id;
  @Basic(optional = false) @Column(name = "Name") private String name;
  @Column(name = "Priority") private Short priority;
  @Column(name = "LastUpdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;
  @OneToMany(mappedBy = "workfunctionId")
  private Collection<AddressSetEmployee> addressSetEmployeeCollection;

  public WorkfunctionSet() {}

  public WorkfunctionSet(Integer id) { this.id = id; }

  public WorkfunctionSet(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public Short getPriority() { return priority; }

  public void setPriority(Short priority) { this.priority = priority; }

  public Date getLastUpdate() { return lastUpdate; }

  public void setLastUpdate(Date lastUpdate) { this.lastUpdate = lastUpdate; }

  @XmlTransient
  public Collection<AddressSetEmployee> getAddressSetEmployeeCollection() {
    return addressSetEmployeeCollection;
  }

  public void setAddressSetEmployeeCollection(
      Collection<AddressSetEmployee> addressSetEmployeeCollection) {
    this.addressSetEmployeeCollection = addressSetEmployeeCollection;
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
    if (!(object instanceof WorkfunctionSet)) {
      return false;
    }
    WorkfunctionSet other = (WorkfunctionSet)object;
    if ((this.id == null && other.id != null) ||
        (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.WorkfunctionSet[ id=" + id + " ]";
  }
}
