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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The AddressSet Entity
 *
 * @author Jürgen Mülbert
 * @version 0.4
 */
@Entity
@Table(name = "AddressSet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AddressSet.findAll", query = "SELECT a FROM AddressSet a"),
  @NamedQuery(name = "AddressSet.findById", query = "SELECT a FROM AddressSet a WHERE a.id = :id"),
  @NamedQuery(
      name = "AddressSet.findByStreet",
      query = "SELECT a FROM AddressSet a WHERE a.street = :street"),
  @NamedQuery(
      name = "AddressSet.findByZip",
      query = "SELECT a FROM AddressSet a WHERE a.zip = :zip"),
  @NamedQuery(
      name = "AddressSet.findByCity",
      query = "SELECT a FROM AddressSet a WHERE a.city = :city"),
  @NamedQuery(
      name = "AddressSet.findByPhone",
      query = "SELECT a FROM AddressSet a WHERE a.phone = :phone"),
  @NamedQuery(
      name = "AddressSet.findByMobile",
      query = "SELECT a FROM AddressSet a WHERE a.mobile = :mobile"),
  @NamedQuery(
      name = "AddressSet.findByFax",
      query = "SELECT a FROM AddressSet a WHERE a.fax = :fax"),
  @NamedQuery(
      name = "AddressSet.findByMail",
      query = "SELECT a FROM AddressSet a WHERE a.mail = :mail")
})
public class AddressSet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;

  @Column(name = "Street")
  private String street;

  @Column(name = "Zip")
  private String zip;

  @Column(name = "City")
  private String city;

  @Column(name = "Phone")
  private String phone;

  @Column(name = "Mobile")
  private String mobile;

  @Column(name = "Fax")
  private String fax;

  @Column(name = "Mail")
  private String mail;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "addressSet")
  private AddressSetEmployee addressSetEmployee;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "addressSet")
  private AddressSetManufacturer addressSetManufacturer;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "addressSet")
  private AddressSetCompany addressSetCompany;

  /**
   * Constructs a new {@link AddressSet} instance with the specified ID.
   *
   * @param id the ID to set for the new {@link AddressSet} instance
   */
  public AddressSet(Integer id) {
    this.id = id;
  }

  /**
   * Returns the ID of the {@link AddressSet} instance.
   *
   * @return the ID of the {@link AddressSet} instance
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets the ID of the {@link AddressSet} instance.
   *
   * @param id the ID to set for the {@link AddressSet} instance
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Returns the street address.
   *
   * @return the street address
   */
  public String getStreet() {
    return street;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public AddressSetEmployee getAddressSetEmployee() {
    return addressSetEmployee;
  }

  /**
   * Sets the {@link AddressSetEmployee} associated with the {@link AddressSet}.
   *
   * @param addressSetEmployee the {@link AddressSetEmployee} to set
   */
  public void setAddressSetEmployee(AddressSetEmployee addressSetEmployee) {
    this.addressSetEmployee = addressSetEmployee;
  }

  public AddressSetManufacturer getAddressSetManufacturer() {
    return addressSetManufacturer;
  }

  public void setAddressSetManufacturer(AddressSetManufacturer addressSetManufacturer) {
    this.addressSetManufacturer = addressSetManufacturer;
  }

  public AddressSetCompany getAddressSetCompany() {
    return addressSetCompany;
  }

  public void setAddressSetCompany(AddressSetCompany addressSetCompany) {
    this.addressSetCompany = addressSetCompany;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof AddressSet)) {
      return false;
    }
    AddressSet other = (AddressSet) object;
    return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
  }

  @Override
  public String toString() {
    return "de.jmuelbert.jmbde.datamodel.AddressSet[ id=" + id + " ]";
  }
}
