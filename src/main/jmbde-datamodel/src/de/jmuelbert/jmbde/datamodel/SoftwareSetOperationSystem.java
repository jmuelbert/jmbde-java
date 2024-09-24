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
 * The SoftwareSetOperationSystem Entity
 *
 *
 * @author Jürgen Mülbert
 * @version 0.4
 *
 * @see SoftwareSet
 */

@Entity
@Table(name = "SoftwareSet_OperationSystem")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "SoftwareSetOperationSystem.findAll",
              query = "SELECT s FROM SoftwareSetOperationSystem s")
  ,
      @NamedQuery(
          name = "SoftwareSetOperationSystem.findById",
          query = "SELECT s FROM SoftwareSetOperationSystem s WHERE s.id = :id")
})
public class SoftwareSetOperationSystem implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id @Basic(optional = false) @Column(name = "Id") private Integer id;
  @OneToMany(mappedBy = "operationSystemId")
  private Collection<DeviceSetComputer> deviceSetComputerCollection;
  @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false,
              updatable = false)
  @OneToOne(optional = false)
  private SoftwareSet softwareSet;

  public SoftwareSetOperationSystem() {}

  public SoftwareSetOperationSystem(Integer id) { this.id = id; }

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  @XmlTransient
  public Collection<DeviceSetComputer> getDeviceSetComputerCollection() {
    return deviceSetComputerCollection;
  }

  public void setDeviceSetComputerCollection(
      Collection<DeviceSetComputer> deviceSetComputerCollection) {
    this.deviceSetComputerCollection = deviceSetComputerCollection;
  }

  public SoftwareSet getSoftwareSet() { return softwareSet; }

  public void setSoftwareSet(SoftwareSet softwareSet) {
    this.softwareSet = softwareSet;
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
    if (!(object instanceof SoftwareSetOperationSystem)) {
      return false;
    }
    SoftwareSetOperationSystem other = (SoftwareSetOperationSystem)object;
    if ((this.id == null && other.id != null) ||
        (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.SoftwareSetOperationSystem[ id=" + id +
        " ]";
  }
}
