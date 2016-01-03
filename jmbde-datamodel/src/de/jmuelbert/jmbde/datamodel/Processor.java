/**
 * JMBDE - Datamodel - Processor
 *
 *
 * Created by Jürgen Mülbert on 03.01.2016
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
 *
 * @author jurgenmulbert
 */
@Entity
@Table(name = "PROCESSOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processor.findAll", query = "SELECT p FROM Processor p"),
    @NamedQuery(name = "Processor.findById1", query = "SELECT p FROM Processor p WHERE p.id1 = :id1"),
    @NamedQuery(name = "Processor.findByCores", query = "SELECT p FROM Processor p WHERE p.cores = :cores"),
    @NamedQuery(name = "Processor.findByGhz", query = "SELECT p FROM Processor p WHERE p.ghz = :ghz"),
    @NamedQuery(name = "Processor.findByLastUpdate", query = "SELECT p FROM Processor p WHERE p.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Processor.findByName", query = "SELECT p FROM Processor p WHERE p.name = :name")})
public class Processor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID1")
    private Long id1;
    @Column(name = "CORES")
    private String cores;
    @Column(name = "GHZ")
    private String ghz;
    @Column(name = "LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "processorId1")
    private Collection<Computer> computerCollection;

    public Processor() {
    }

    public Processor(Long id1) {
        this.id1 = id1;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public String getCores() {
        return cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getGhz() {
        return ghz;
    }

    public void setGhz(String ghz) {
        this.ghz = ghz;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Computer> getComputerCollection() {
        return computerCollection;
    }

    public void setComputerCollection(Collection<Computer> computerCollection) {
        this.computerCollection = computerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id1 != null ? id1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processor)) {
            return false;
        }
        Processor other = (Processor) object;
        if ((this.id1 == null && other.id1 != null) || (this.id1 != null && !this.id1.equals(other.id1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.db.Processor[ id1=" + id1 + " ]";
    }
    
}
