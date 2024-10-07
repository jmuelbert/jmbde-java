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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The DeviceSetComputer Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 * @see DeviceSet
 */
@Entity
@Table(name = "DeviceSet_Computer")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "DeviceSetComputer.findAll", query = "SELECT d FROM DeviceSetComputer d"),
  @NamedQuery(
      name = "DeviceSetComputer.findByServiceNumber",
      query = "SELECT d FROM DeviceSetComputer d WHERE " + "d.serviceNumber = :serviceNumber"),
  @NamedQuery(
      name = "DeviceSetComputer.findByServiceTag",
      query = "SELECT d FROM DeviceSetComputer d WHERE " + "d.serviceTag = :serviceTag"),
  @NamedQuery(
      name = "DeviceSetComputer.findByNetwork",
      query = "SELECT d FROM DeviceSetComputer d WHERE d.network = :network"),
  @NamedQuery(
      name = "DeviceSetComputer.findByMemory",
      query = "SELECT d FROM DeviceSetComputer d WHERE d.memory = :memory"),
  @NamedQuery(
      name = "DeviceSetComputer.findById",
      query = "SELECT d FROM DeviceSetComputer d WHERE d.id = :id")
})
public class DeviceSetComputer implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "ServiceNumber")
  private String serviceNumber;

  @Column(name = "ServiceTag")
  private String serviceTag;

  @Column(name = "Network")
  private String network;

  @Column(name = "Memory")
  private String memory;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @JoinTable(
      name = "ProgramComputer",
      joinColumns = {@JoinColumn(name = "Computer_Id", referencedColumnName = "Id")},
      inverseJoinColumns = {@JoinColumn(name = "Program_Id", referencedColumnName = "Id")})
  @ManyToMany
  private Collection<SoftwareSetProgram> softwareSetProgramCollection;

  @OneToMany(mappedBy = "computerId")
  private Collection<InventorySet> inventorySetCollection;

  @JoinColumn(name = "Employee_Id", referencedColumnName = "Id")
  @ManyToOne
  private AddressSetEmployee employeeId;

  @JoinColumn(name = "Manufacturer_Id", referencedColumnName = "Id")
  @ManyToOne
  private AddressSetManufacturer manufacturerId;

  @JoinColumn(name = "Department_Id", referencedColumnName = "Id")
  @ManyToOne
  private DepartmentSet departmentId;

  @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
  @OneToOne(optional = false)
  private DeviceSet deviceSet;

  @JoinColumn(name = "DeviceType_Id", referencedColumnName = "Id")
  @ManyToOne
  private DeviceTypeSet deviceTypeId;

  @JoinColumn(name = "Processor_Id", referencedColumnName = "Id")
  @ManyToOne(optional = false)
  private ProcessorSet processorId;

  @JoinColumn(name = "OperationSystem_Id", referencedColumnName = "Id")
  @ManyToOne
  private SoftwareSetOperationSystem operationSystemId;

  @OneToMany(mappedBy = "computerId")
  private Collection<PlaceSet> placeSetCollection;

  public DeviceSetComputer() {}

  public DeviceSetComputer(Integer id) {
    this.id = id;
  }

  public String getServiceNumber() {
    return serviceNumber;
  }

  public void setServiceNumber(String serviceNumber) {
    this.serviceNumber = serviceNumber;
  }

  public String getServiceTag() {
    return serviceTag;
  }

  public void setServiceTag(String serviceTag) {
    this.serviceTag = serviceTag;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public String getMemory() {
    return memory;
  }

  public void setMemory(String memory) {
    this.memory = memory;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @XmlTransient
  public Collection<SoftwareSetProgram> getSoftwareSetProgramCollection() {
    return softwareSetProgramCollection;
  }

  public void setSoftwareSetProgramCollection(
      Collection<SoftwareSetProgram> softwareSetProgramCollection) {
    this.softwareSetProgramCollection = softwareSetProgramCollection;
  }

  @XmlTransient
  public Collection<InventorySet> getInventorySetCollection() {
    return inventorySetCollection;
  }

  public void setInventorySetCollection(Collection<InventorySet> inventorySetCollection) {
    this.inventorySetCollection = inventorySetCollection;
  }

  public AddressSetEmployee getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(AddressSetEmployee employeeId) {
    this.employeeId = employeeId;
  }

  public AddressSetManufacturer getManufacturerId() {
    return manufacturerId;
  }

  public void setManufacturerId(AddressSetManufacturer manufacturerId) {
    this.manufacturerId = manufacturerId;
  }

  public DepartmentSet getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(DepartmentSet departmentId) {
    this.departmentId = departmentId;
  }

  public DeviceSet getDeviceSet() {
    return deviceSet;
  }

  public void setDeviceSet(DeviceSet deviceSet) {
    this.deviceSet = deviceSet;
  }

  public DeviceTypeSet getDeviceTypeId() {
    return deviceTypeId;
  }

  public void setDeviceTypeId(DeviceTypeSet deviceTypeId) {
    this.deviceTypeId = deviceTypeId;
  }

  public ProcessorSet getProcessorId() {
    return processorId;
  }

  public void setProcessorId(ProcessorSet processorId) {
    this.processorId = processorId;
  }

  public SoftwareSetOperationSystem getOperationSystemId() {
    return operationSystemId;
  }

  public void setOperationSystemId(SoftwareSetOperationSystem operationSystemId) {
    this.operationSystemId = operationSystemId;
  }

  @XmlTransient
  public Collection<PlaceSet> getPlaceSetCollection() {
    return placeSetCollection;
  }

  public void setPlaceSetCollection(Collection<PlaceSet> placeSetCollection) {
    this.placeSetCollection = placeSetCollection;
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
    if (!(object instanceof DeviceSetComputer)) {
      return false;
    }
    DeviceSetComputer other = (DeviceSetComputer) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.DeviceSetComputer[ id=" + id + " ]";
  }
}
