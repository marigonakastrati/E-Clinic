/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Medicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicine.findAll", query = "SELECT m FROM Medicine m"),
    @NamedQuery(name = "Medicine.findByMedicineId", query = "SELECT m FROM Medicine m WHERE m.medicineId = :medicineId"),
    @NamedQuery(name = "Medicine.findByMedicineName", query = "SELECT m FROM Medicine m WHERE m.medicineName = :medicineName"),
    @NamedQuery(name = "Medicine.findByPackageType", query = "SELECT m FROM Medicine m WHERE m.packageType = :packageType"),
    @NamedQuery(name = "Medicine.findByWeight", query = "SELECT m FROM Medicine m WHERE m.weight = :weight"),
    @NamedQuery(name = "Medicine.findByPrice", query = "SELECT m FROM Medicine m WHERE m.price = :price")})
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "medicine_id")
    private Integer medicineId;
    @Size(max = 20)
    @Column(name = "medicine_name")
    private String medicineName;
    @Size(max = 20)
    @Column(name = "package_type")
    private String packageType;
    @Column(name = "weight")
    private Integer weight;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId")
    private Collection<Alergis> alergisCollection;
    @JoinColumn(name = "pharmacy_manager_id", referencedColumnName = "pharmacy_manager_id")
    @ManyToOne(optional = false)
    private PharmacyManager pharmacyManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId")
    private Collection<PrescriptionMedicines> prescriptionMedicinesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId")
    private Collection<OrderItem> orderItemCollection;

    public Medicine() {
    }

    public Medicine(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Alergis> getAlergisCollection() {
        return alergisCollection;
    }

    public void setAlergisCollection(Collection<Alergis> alergisCollection) {
        this.alergisCollection = alergisCollection;
    }

    public PharmacyManager getPharmacyManagerId() {
        return pharmacyManagerId;
    }

    public void setPharmacyManagerId(PharmacyManager pharmacyManagerId) {
        this.pharmacyManagerId = pharmacyManagerId;
    }

    @XmlTransient
    public Collection<PrescriptionMedicines> getPrescriptionMedicinesCollection() {
        return prescriptionMedicinesCollection;
    }

    public void setPrescriptionMedicinesCollection(Collection<PrescriptionMedicines> prescriptionMedicinesCollection) {
        this.prescriptionMedicinesCollection = prescriptionMedicinesCollection;
    }

    @XmlTransient
    public Collection<OrderItem> getOrderItemCollection() {
        return orderItemCollection;
    }

    public void setOrderItemCollection(Collection<OrderItem> orderItemCollection) {
        this.orderItemCollection = orderItemCollection;
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
        return "com.ubt.healthcare.entity.Medicine[ medicineId=" + medicineId + " ]";
    }
    
}
