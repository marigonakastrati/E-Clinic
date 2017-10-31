/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author jfc
 */
@Entity
@Table(name = "pharmacy_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PharmacyManager.findAll", query = "SELECT p FROM PharmacyManager p")
    , @NamedQuery(name = "PharmacyManager.findByPassCode", query = "SELECT p FROM PharmacyManager p WHERE p.passCode = :passCode")
    , @NamedQuery(name = "PharmacyManager.findByPharmacyManagerId", query = "SELECT p FROM PharmacyManager p WHERE p.pharmacyManagerId = :pharmacyManagerId")})
public class PharmacyManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "pass_code")
    private String passCode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pharmacy_manager_id")
    private Integer pharmacyManagerId;
    @JoinColumn(name = "person_id", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<Inventoryarchive> inventoryarchiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<Inventory> inventoryCollection;

    public PharmacyManager() {
    }

    public PharmacyManager(Integer pharmacyManagerId) {
        this.pharmacyManagerId = pharmacyManagerId;
    }

    public PharmacyManager(Integer pharmacyManagerId, String passCode) {
        this.pharmacyManagerId = pharmacyManagerId;
        this.passCode = passCode;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Integer getPharmacyManagerId() {
        return pharmacyManagerId;
    }

    public void setPharmacyManagerId(Integer pharmacyManagerId) {
        this.pharmacyManagerId = pharmacyManagerId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Collection<Inventoryarchive> getInventoryarchiveCollection() {
        return inventoryarchiveCollection;
    }

    public void setInventoryarchiveCollection(Collection<Inventoryarchive> inventoryarchiveCollection) {
        this.inventoryarchiveCollection = inventoryarchiveCollection;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pharmacyManagerId != null ? pharmacyManagerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PharmacyManager)) {
            return false;
        }
        PharmacyManager other = (PharmacyManager) object;
        if ((this.pharmacyManagerId == null && other.pharmacyManagerId != null) || (this.pharmacyManagerId != null && !this.pharmacyManagerId.equals(other.pharmacyManagerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.PharmacyManager[ pharmacyManagerId=" + pharmacyManagerId + " ]";
    }
    
}
