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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author F
 */
@Entity
@Table(name = "PrescriptionMedicines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrescriptionMedicines.findAll", query = "SELECT p FROM PrescriptionMedicines p"),
    @NamedQuery(name = "PrescriptionMedicines.findByPrescribedMedicineId", query = "SELECT p FROM PrescriptionMedicines p WHERE p.prescribedMedicineId = :prescribedMedicineId")})
public class PrescriptionMedicines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescribed_medicine_id")
    private Integer prescribedMedicineId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescriptionId")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false)
    private Medicine medicineId;
    @JoinColumn(name = "prescription_id", referencedColumnName = "prescription_id")
    @ManyToOne(optional = false)
    private Prescription prescriptionId;

    public PrescriptionMedicines() {
    }

    public PrescriptionMedicines(Integer prescribedMedicineId) {
        this.prescribedMedicineId = prescribedMedicineId;
    }

    public Integer getPrescribedMedicineId() {
        return prescribedMedicineId;
    }

    public void setPrescribedMedicineId(Integer prescribedMedicineId) {
        this.prescribedMedicineId = prescribedMedicineId;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    public Prescription getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Prescription prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescribedMedicineId != null ? prescribedMedicineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrescriptionMedicines)) {
            return false;
        }
        PrescriptionMedicines other = (PrescriptionMedicines) object;
        if ((this.prescribedMedicineId == null && other.prescribedMedicineId != null) || (this.prescribedMedicineId != null && !this.prescribedMedicineId.equals(other.prescribedMedicineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.PrescriptionMedicines[ prescribedMedicineId=" + prescribedMedicineId + " ]";
    }
    
}
