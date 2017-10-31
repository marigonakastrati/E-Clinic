/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "medicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicine.findAll", query = "SELECT m FROM Medicine m")
    , @NamedQuery(name = "Medicine.findByMedicineName", query = "SELECT m FROM Medicine m WHERE m.medicineName = :medicineName")
    , @NamedQuery(name = "Medicine.findByWeight", query = "SELECT m FROM Medicine m WHERE m.weight = :weight")
    , @NamedQuery(name = "Medicine.findByPrice", query = "SELECT m FROM Medicine m WHERE m.price = :price")
    , @NamedQuery(name = "Medicine.findByMedicineId", query = "SELECT m FROM Medicine m WHERE m.medicineId = :medicineId")})
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "medicine_name")
    private String medicineName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private int weight;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicine_id")
    private Integer medicineId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId")
    private Collection<Prescriptionmedicines> prescriptionmedicinesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId")
    private Collection<Patientmedicineallergy> patientmedicineallergyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId")
    private Collection<Inventory> inventoryCollection;
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "drug_manufacturer_id")
    @ManyToOne(optional = false)
    private Drugmanufacturer manufacturerId;
    @JoinColumn(name = "package_type", referencedColumnName = "package_type_id")
    @ManyToOne(optional = false)
    private Packagetype packageType;

    public Medicine() {
    }

    public Medicine(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Medicine(Integer medicineId, String medicineName, int weight, BigDecimal price) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.weight = weight;
        this.price = price;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    @XmlTransient
    public Collection<Prescriptionmedicines> getPrescriptionmedicinesCollection() {
        return prescriptionmedicinesCollection;
    }

    public void setPrescriptionmedicinesCollection(Collection<Prescriptionmedicines> prescriptionmedicinesCollection) {
        this.prescriptionmedicinesCollection = prescriptionmedicinesCollection;
    }

    @XmlTransient
    public Collection<Patientmedicineallergy> getPatientmedicineallergyCollection() {
        return patientmedicineallergyCollection;
    }

    public void setPatientmedicineallergyCollection(Collection<Patientmedicineallergy> patientmedicineallergyCollection) {
        this.patientmedicineallergyCollection = patientmedicineallergyCollection;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
    }

    public Drugmanufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Drugmanufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Packagetype getPackageType() {
        return packageType;
    }

    public void setPackageType(Packagetype packageType) {
        this.packageType = packageType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicineId != null ? medicineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicine)) {
            return false;
        }
        Medicine other = (Medicine) object;
        if ((this.medicineId == null && other.medicineId != null) || (this.medicineId != null && !this.medicineId.equals(other.medicineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Medicine[ medicineId=" + medicineId + " ]";
    }
    
}
