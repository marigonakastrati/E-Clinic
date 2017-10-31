/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "PrescriptionMedicines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrescriptionMedicines.findAll", query = "SELECT p FROM PrescriptionMedicines p")
    , @NamedQuery(name = "PrescriptionMedicines.findByDaysToUse", query = "SELECT p FROM PrescriptionMedicines p WHERE p.daysToUse = :daysToUse")
    , @NamedQuery(name = "PrescriptionMedicines.findByTimesPerDay", query = "SELECT p FROM PrescriptionMedicines p WHERE p.timesPerDay = :timesPerDay")
    , @NamedQuery(name = "PrescriptionMedicines.findByComment", query = "SELECT p FROM PrescriptionMedicines p WHERE p.comment = :comment")
    , @NamedQuery(name = "PrescriptionMedicines.findByPrescribedMedicineId", query = "SELECT p FROM PrescriptionMedicines p WHERE p.prescribedMedicineId = :prescribedMedicineId")})
public class PrescriptionMedicines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DaysToUse")
    private int daysToUse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "times_per_day")
    private int timesPerDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comment")
    private String comment;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescribed_medicine_id")
    private Integer prescribedMedicineId;
    @JoinColumn(name = "MedicineId", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false)
    private Medicine medicineId;
    @JoinColumn(name = "PrescriptionId", referencedColumnName = "prescription_id")
    @ManyToOne(optional = false)
    private Prescription prescriptionId;

    public PrescriptionMedicines() {
    }

    public PrescriptionMedicines(Integer prescribedMedicineId) {
        this.prescribedMedicineId = prescribedMedicineId;
    }

    public PrescriptionMedicines(Integer prescribedMedicineId, int daysToUse, int timesPerDay, String comment) {
        this.prescribedMedicineId = prescribedMedicineId;
        this.daysToUse = daysToUse;
        this.timesPerDay = timesPerDay;
        this.comment = comment;
    }

    public int getDaysToUse() {
        return daysToUse;
    }

    public void setDaysToUse(int daysToUse) {
        this.daysToUse = daysToUse;
    }

    public int getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(int timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getPrescribedMedicineId() {
        return prescribedMedicineId;
    }

    public void setPrescribedMedicineId(Integer prescribedMedicineId) {
        this.prescribedMedicineId = prescribedMedicineId;
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
        return "com.ubt.healthcare.dto.PrescriptionMedicines[ prescribedMedicineId=" + prescribedMedicineId + " ]";
    }
    
}
