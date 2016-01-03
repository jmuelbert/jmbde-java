/**
 * JMBDE - Datamodel - Department
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "DEPARTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findById", query = "SELECT d FROM Department d WHERE d.id = :id"),
    @NamedQuery(name = "Department.findByLastUpdate", query = "SELECT d FROM Department d WHERE d.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByPriority", query = "SELECT d FROM Department d WHERE d.priority = :priority")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRIORITY")
    private Integer priority;
    @JoinTable(name = "DEPARTMENT_PRINTER", joinColumns = {
        @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PRINTER_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Printer> printerCollection;
    @OneToMany(mappedBy = "departmentId")
    private Collection<Employee> employeeCollection;
    @OneToMany(mappedBy = "departmentId")
    private Collection<Computer> computerCollection;

    public Department() {
    }

    public Department(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @XmlTransient
    public Collection<Printer> getPrinterCollection() {
        return printerCollection;
    }

    public void setPrinterCollection(Collection<Printer> printerCollection) {
        this.printerCollection = printerCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jmuelbert.jmbde.db.Department[ id=" + id + " ]";
    }
    
}
