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
import javax.persistence.Lob;
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
@Table(name = "Prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
    @NamedQuery(name = "Prescription.findByPrescriptionId", query = "SELECT p FROM Prescription p WHERE p.prescriptionId = :prescriptionId"),
    @NamedQuery(name = "Prescription.findByDaysToUse", query = "SELECT p FROM Prescription p WHERE p.daysToUse = :daysToUse"),
    @NamedQuery(name = "Prescription.findByTimesPerDay", query = "SELECT p FROM Prescription p WHERE p.timesPerDay = :timesPerDay")})
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescription_id")
    private Integer prescriptionId;
    @Column(name = "days_to_use")
    private Integer daysToUse;
    @Column(name = "times_per_day")
    private Integer timesPerDay;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "desc")
    private String desc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescriptionId")
    private Collection<Visit> visitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescriptionId")
    private Collection<PrescriptionMedicines> prescriptionMedicinesCollection;

    public Prescription() {
    }

    public Prescription(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getDaysToUse() {
        return daysToUse;
    }

    public void setDaysToUse(Integer daysToUse) {
        this.daysToUse = daysToUse;
    }

    public Integer getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(Integer timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @XmlTransient
    public Collection<Visit> getVisitCollection() {
        return visitCollection;
    }

    public void setVisitCollection(Collection<Visit> visitCollection) {
        this.visitCollection = visitCollection;
    }

    @XmlTransient
    public Collection<PrescriptionMedicines> getPrescriptionMedicinesCollection() {
        return prescriptionMedicinesCollection;
    }

    public void setPrescriptionMedicinesCollection(Collection<PrescriptionMedicines> prescriptionMedicinesCollection) {
        this.prescriptionMedicinesCollection = prescriptionMedicinesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescriptionId != null ? prescriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.prescriptionId == null && other.prescriptionId != null) || (this.prescriptionId != null && !this.prescriptionId.equals(other.prescriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Prescription[ prescriptionId=" + prescriptionId + " ]";
    }
    
}
