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
@Table(name = "PatientMentalHealthHX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientMentalHealthHX.findAll", query = "SELECT p FROM PatientMentalHealthHX p")
    , @NamedQuery(name = "PatientMentalHealthHX.findByPatientMentalHealthId", query = "SELECT p FROM PatientMentalHealthHX p WHERE p.patientMentalHealthId = :patientMentalHealthId")
    , @NamedQuery(name = "PatientMentalHealthHX.findByDateTaken", query = "SELECT p FROM PatientMentalHealthHX p WHERE p.dateTaken = :dateTaken")})
public class PatientMentalHealthHX implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_mental_health_id")
    private Integer patientMentalHealthId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "mental_health_id", referencedColumnName = "mental_health_id")
    @ManyToOne(optional = false)
    private MentalHealth mentalHealthId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public PatientMentalHealthHX() {
    }

    public PatientMentalHealthHX(Integer patientMentalHealthId) {
        this.patientMentalHealthId = patientMentalHealthId;
    }

    public PatientMentalHealthHX(Integer patientMentalHealthId, Date dateTaken) {
        this.patientMentalHealthId = patientMentalHealthId;
        this.dateTaken = dateTaken;
    }

    public Integer getPatientMentalHealthId() {
        return patientMentalHealthId;
    }

    public void setPatientMentalHealthId(Integer patientMentalHealthId) {
        this.patientMentalHealthId = patientMentalHealthId;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public MentalHealth getMentalHealthId() {
        return mentalHealthId;
    }

    public void setMentalHealthId(MentalHealth mentalHealthId) {
        this.mentalHealthId = mentalHealthId;
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
        hash += (patientMentalHealthId != null ? patientMentalHealthId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientMentalHealthHX)) {
            return false;
        }
        PatientMentalHealthHX other = (PatientMentalHealthHX) object;
        if ((this.patientMentalHealthId == null && other.patientMentalHealthId != null) || (this.patientMentalHealthId != null && !this.patientMentalHealthId.equals(other.patientMentalHealthId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PatientMentalHealthHX[ patientMentalHealthId=" + patientMentalHealthId + " ]";
    }
    
}
