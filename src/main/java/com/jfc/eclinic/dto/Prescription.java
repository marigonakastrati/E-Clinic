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
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p")
    , @NamedQuery(name = "Prescription.findByDesc", query = "SELECT p FROM Prescription p WHERE p.desc = :desc")
    , @NamedQuery(name = "Prescription.findByPrescriptionId", query = "SELECT p FROM Prescription p WHERE p.prescriptionId = :prescriptionId")})
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "desc")
    private String desc;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescription_id")
    private Integer prescriptionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescriptionId")
    private Collection<Order1> order1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescriptionId")
    private Collection<PrescriptionMedicines> prescriptionMedicinesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescriptionID")
    private Collection<Visit> visitCollection;

    public Prescription() {
    }

    public Prescription(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Prescription(Integer prescriptionId, String desc) {
        this.prescriptionId = prescriptionId;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @XmlTransient
    public Collection<PrescriptionMedicines> getPrescriptionMedicinesCollection() {
        return prescriptionMedicinesCollection;
    }

    public void setPrescriptionMedicinesCollection(Collection<PrescriptionMedicines> prescriptionMedicinesCollection) {
        this.prescriptionMedicinesCollection = prescriptionMedicinesCollection;
    }

    @XmlTransient
    public Collection<Visit> getVisitCollection() {
        return visitCollection;
    }

    public void setVisitCollection(Collection<Visit> visitCollection) {
        this.visitCollection = visitCollection;
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
        return "com.ubt.healthcare.dto.Prescription[ prescriptionId=" + prescriptionId + " ]";
    }
    
}
