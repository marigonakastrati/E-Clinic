/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author F
 */
@Entity
@Table(name = "Pharmacy_Manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PharmacyManager.findAll", query = "SELECT p FROM PharmacyManager p"),
    @NamedQuery(name = "PharmacyManager.findByPharmacyManagerId", query = "SELECT p FROM PharmacyManager p WHERE p.pharmacyManagerId = :pharmacyManagerId")})
public class PharmacyManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pharmacy_manager_id")
    private Integer pharmacyManagerId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @OneToOne(optional = false)
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pharmacyManagerId")
    private Collection<Medicine> medicineCollection;

    public PharmacyManager() {
    }

    public PharmacyManager(Integer pharmacyManagerId) {
        this.pharmacyManagerId = pharmacyManagerId;
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
    public Collection<Medicine> getMedicineCollection() {
        return medicineCollection;
    }

    public void setMedicineCollection(Collection<Medicine> medicineCollection) {
        this.medicineCollection = medicineCollection;
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
        return "com.ubt.healthcare.entity.PharmacyManager[ pharmacyManagerId=" + pharmacyManagerId + " ]";
    }
    
}
