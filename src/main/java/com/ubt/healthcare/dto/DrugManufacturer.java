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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "DrugManufacturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrugManufacturer.findAll", query = "SELECT d FROM DrugManufacturer d")
    , @NamedQuery(name = "DrugManufacturer.findByName", query = "SELECT d FROM DrugManufacturer d WHERE d.name = :name")
    , @NamedQuery(name = "DrugManufacturer.findByDrugManufacturerId", query = "SELECT d FROM DrugManufacturer d WHERE d.drugManufacturerId = :drugManufacturerId")})
public class DrugManufacturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "drug_manufacturer_id")
    private Integer drugManufacturerId;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address addressId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturerId")
    private Collection<Medicine> medicineCollection;

    public DrugManufacturer() {
    }

    public DrugManufacturer(Integer drugManufacturerId) {
        this.drugManufacturerId = drugManufacturerId;
    }

    public DrugManufacturer(Integer drugManufacturerId, String name) {
        this.drugManufacturerId = drugManufacturerId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDrugManufacturerId() {
        return drugManufacturerId;
    }

    public void setDrugManufacturerId(Integer drugManufacturerId) {
        this.drugManufacturerId = drugManufacturerId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @XmlTransient
    public Collection<Medicine> getMedicineCollection() {
        return medicineCollection;
    }

    public void setMedicineCollection(Collection<Medicine> medicineCollection) {
        this.medicineCollection = medicineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drugManufacturerId != null ? drugManufacturerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrugManufacturer)) {
            return false;
        }
        DrugManufacturer other = (DrugManufacturer) object;
        if ((this.drugManufacturerId == null && other.drugManufacturerId != null) || (this.drugManufacturerId != null && !this.drugManufacturerId.equals(other.drugManufacturerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.DrugManufacturer[ drugManufacturerId=" + drugManufacturerId + " ]";
    }
    
}
