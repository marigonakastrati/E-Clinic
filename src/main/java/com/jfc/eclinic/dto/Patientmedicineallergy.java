/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "patientmedicineallergy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientmedicineallergy.findAll", query = "SELECT p FROM Patientmedicineallergy p")
    , @NamedQuery(name = "Patientmedicineallergy.findByDateOfOnset", query = "SELECT p FROM Patientmedicineallergy p WHERE p.dateOfOnset = :dateOfOnset")
    , @NamedQuery(name = "Patientmedicineallergy.findByAlergieId", query = "SELECT p FROM Patientmedicineallergy p WHERE p.alergieId = :alergieId")})
public class Patientmedicineallergy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_onset")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfOnset;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alergie_id")
    private Integer alergieId;
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false)
    private Medicine medicineId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public Patientmedicineallergy() {
    }

    public Patientmedicineallergy(Integer alergieId) {
        this.alergieId = alergieId;
    }

    public Patientmedicineallergy(Integer alergieId, Date dateOfOnset) {
        this.alergieId = alergieId;
        this.dateOfOnset = dateOfOnset;
    }

    public Date getDateOfOnset() {
        return dateOfOnset;
    }

    public void setDateOfOnset(Date dateOfOnset) {
        this.dateOfOnset = dateOfOnset;
    }

    public Integer getAlergieId() {
        return alergieId;
    }

    public void setAlergieId(Integer alergieId) {
        this.alergieId = alergieId;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alergieId != null ? alergieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientmedicineallergy)) {
            return false;
        }
        Patientmedicineallergy other = (Patientmedicineallergy) object;
        if ((this.alergieId == null && other.alergieId != null) || (this.alergieId != null && !this.alergieId.equals(other.alergieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Patientmedicineallergy[ alergieId=" + alergieId + " ]";
    }
    
}
