/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

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
 * @author F
 */
@Entity
@Table(name = "PatientVaccineHX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientVaccineHX.findAll", query = "SELECT p FROM PatientVaccineHX p")
    , @NamedQuery(name = "PatientVaccineHX.findByPatientVaccineHxId", query = "SELECT p FROM PatientVaccineHX p WHERE p.patientVaccineHxId = :patientVaccineHxId")
    , @NamedQuery(name = "PatientVaccineHX.findByDateTaken", query = "SELECT p FROM PatientVaccineHX p WHERE p.dateTaken = :dateTaken")})
public class PatientVaccineHX implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_vaccine_hx_id")
    private Integer patientVaccineHxId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "vaccine_id", referencedColumnName = "vaccine_id")
    @ManyToOne(optional = false)
    private Vaccine vaccineId;

    public PatientVaccineHX() {
    }

    public PatientVaccineHX(Integer patientVaccineHxId) {
        this.patientVaccineHxId = patientVaccineHxId;
    }

    public PatientVaccineHX(Integer patientVaccineHxId, Date dateTaken) {
        this.patientVaccineHxId = patientVaccineHxId;
        this.dateTaken = dateTaken;
    }

    public Integer getPatientVaccineHxId() {
        return patientVaccineHxId;
    }

    public void setPatientVaccineHxId(Integer patientVaccineHxId) {
        this.patientVaccineHxId = patientVaccineHxId;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Vaccine getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Vaccine vaccineId) {
        this.vaccineId = vaccineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientVaccineHxId != null ? patientVaccineHxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientVaccineHX)) {
            return false;
        }
        PatientVaccineHX other = (PatientVaccineHX) object;
        if ((this.patientVaccineHxId == null && other.patientVaccineHxId != null) || (this.patientVaccineHxId != null && !this.patientVaccineHxId.equals(other.patientVaccineHxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PatientVaccineHX[ patientVaccineHxId=" + patientVaccineHxId + " ]";
    }
    
}
