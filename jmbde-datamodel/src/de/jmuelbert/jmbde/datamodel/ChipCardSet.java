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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The ChipCardSet Entity
 * 
 * 
 * @author Jürgen Mülbert
 * @version 0.4
 *
 * @see DoorSet
 * @see DoorSchemaSet
 * 
 */


@Entity
@Table(name = "ChipCardSet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChipCardSet.findAll", query = "SELECT c FROM ChipCardSet c"),
    @NamedQuery(name = "ChipCardSet.findById", query = "SELECT c FROM ChipCardSet c WHERE c.id = :id"),
    @NamedQuery(name = "ChipCardSet.findByName", query = "SELECT c FROM ChipCardSet c WHERE c.name = :name")})
public class ChipCardSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @JoinTable(name = "DoorSchemaChipCard", joinColumns = {
        @JoinColumn(name = "ChipCard_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "DoorSchema_Id", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<DoorSchemaSet> doorSchemaSetCollection;
    @JoinTable(name = "ChipCardDoor", joinColumns = {
        @JoinColumn(name = "ChipCard_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Door_Id", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<DoorSet> doorSetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chipCardId")
    private Collection<AddressSetEmployee> addressSetEmployeeCollection;

    public ChipCardSet() {
    }

    public ChipCardSet(Integer id) {
        this.id = id;
    }

    public ChipCardSet(Integer id, String name) {
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

    @XmlTransient
    public Collection<DoorSchemaSet> getDoorSchemaSetCollection() {
        return doorSchemaSetCollection;
    }

    public void setDoorSchemaSetCollection(Collection<DoorSchemaSet> doorSchemaSetCollection) {
        this.doorSchemaSetCollection = doorSchemaSetCollection;
    }

    @XmlTransient
    public Collection<DoorSet> getDoorSetCollection() {
        return doorSetCollection;
    }

    public void setDoorSetCollection(Collection<DoorSet> doorSetCollection) {
        this.doorSetCollection = doorSetCollection;
    }

    @XmlTransient
    public Collection<AddressSetEmployee> getAddressSetEmployeeCollection() {
        return addressSetEmployeeCollection;
    }

    public void setAddressSetEmployeeCollection(Collection<AddressSetEmployee> addressSetEmployeeCollection) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChipCardSet)) {
            return false;
        }
        ChipCardSet other = (ChipCardSet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.datamodel.ChipCardSet[ id=" + id + " ]";
    }
    
}
