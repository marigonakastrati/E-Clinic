/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author F
 */
@Entity
@Table(name = "Address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByBuildingNumber", query = "SELECT a FROM Address a WHERE a.buildingNumber = :buildingNumber")
    , @NamedQuery(name = "Address.findByStreetName", query = "SELECT a FROM Address a WHERE a.streetName = :streetName")
    , @NamedQuery(name = "Address.findByAppartmentNumber", query = "SELECT a FROM Address a WHERE a.appartmentNumber = :appartmentNumber")
    , @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "building_number")
    private Integer buildingNumber;
    @Size(max = 256)
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "appartment_number")
    private Integer appartmentNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "address_id")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer addressId;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Person> personCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private Collection<Inventory> inventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<DrugManufacturer> drugManufacturerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private Collection<InventoryArchive> inventoryArchiveCollection;

    public Address() {
    }

    public Address(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(Integer appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
    }

    @XmlTransient
    public Collection<DrugManufacturer> getDrugManufacturerCollection() {
        return drugManufacturerCollection;
    }

    public void setDrugManufacturerCollection(Collection<DrugManufacturer> drugManufacturerCollection) {
        this.drugManufacturerCollection = drugManufacturerCollection;
    }

    @XmlTransient
    public Collection<InventoryArchive> getInventoryArchiveCollection() {
        return inventoryArchiveCollection;
    }

    public void setInventoryArchiveCollection(Collection<InventoryArchive> inventoryArchiveCollection) {
        this.inventoryArchiveCollection = inventoryArchiveCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.Address[ addressId=" + addressId + " ]";
    }
    
}
