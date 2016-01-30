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
import javax.persistence.CascadeType;
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
 * The ProcessorSet Entity
 * 
 * 
 * @author Jürgen Mülbert
 * @version 0.4
 *
 */

@Entity
@Table(name = "ProcessorSet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessorSet.findAll", query = "SELECT p FROM ProcessorSet p"),
    @NamedQuery(name = "ProcessorSet.findById", query = "SELECT p FROM ProcessorSet p WHERE p.id = :id"),
    @NamedQuery(name = "ProcessorSet.findByName", query = "SELECT p FROM ProcessorSet p WHERE p.name = :name"),
    @NamedQuery(name = "ProcessorSet.findByCores", query = "SELECT p FROM ProcessorSet p WHERE p.cores = :cores"),
    @NamedQuery(name = "ProcessorSet.findByTact", query = "SELECT p FROM ProcessorSet p WHERE p.tact = :tact"),
    @NamedQuery(name = "ProcessorSet.findByLastUpdate", query = "SELECT p FROM ProcessorSet p WHERE p.lastUpdate = :lastUpdate")})
public class ProcessorSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Cores")
    private Short cores;
    @Column(name = "Tact")
    private Long tact;
    @Column(name = "LastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processorId")
    private Collection<DeviceSetComputer> deviceSetComputerCollection;

    public ProcessorSet() {
    }

    public ProcessorSet(Integer id) {
        this.id = id;
    }

    public ProcessorSet(Integer id, String name) {
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

    public Short getCores() {
        return cores;
    }

    public void setCores(Short cores) {
        this.cores = cores;
    }

    public Long getTact() {
        return tact;
    }

    public void setTact(Long tact) {
        this.tact = tact;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<DeviceSetComputer> getDeviceSetComputerCollection() {
        return deviceSetComputerCollection;
    }

    public void setDeviceSetComputerCollection(Collection<DeviceSetComputer> deviceSetComputerCollection) {
        this.deviceSetComputerCollection = deviceSetComputerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessorSet)) {
            return false;
        }
        ProcessorSet other = (ProcessorSet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.datamodel.ProcessorSet[ id=" + id + " ]";
    }
    
}
