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
import javax.persistence.FetchType;
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
@Table(name = "PatientSurgicalHX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientSurgicalHX.findAll", query = "SELECT p FROM PatientSurgicalHX p")
    , @NamedQuery(name = "PatientSurgicalHX.findByPatientSurgicalId", query = "SELECT p FROM PatientSurgicalHX p WHERE p.patientSurgicalId = :patientSurgicalId")
    , @NamedQuery(name = "PatientSurgicalHX.findByDateTaken", query = "SELECT p FROM PatientSurgicalHX p WHERE p.dateTaken = :dateTaken")})
public class PatientSurgicalHX implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_surgical_id")
    private Integer patientSurgicalId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;
    @JoinColumn(name = "surgical_id", referencedColumnName = "surgical_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Surgical surgicalId;

    public PatientSurgicalHX() {
    }

    public PatientSurgicalHX(Integer patientSurgicalId) {
        this.patientSurgicalId = patientSurgicalId;
    }

    public PatientSurgicalHX(Integer patientSurgicalId, Date dateTaken) {
        this.patientSurgicalId = patientSurgicalId;
        this.dateTaken = dateTaken;
    }

    public Integer getPatientSurgicalId() {
        return patientSurgicalId;
    }

    public void setPatientSurgicalId(Integer patientSurgicalId) {
        this.patientSurgicalId = patientSurgicalId;
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

    public Surgical getSurgicalId() {
        return surgicalId;
    }

    public void setSurgicalId(Surgical surgicalId) {
        this.surgicalId = surgicalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientSurgicalId != null ? patientSurgicalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientSurgicalHX)) {
            return false;
        }
        PatientSurgicalHX other = (PatientSurgicalHX) object;
        if ((this.patientSurgicalId == null && other.patientSurgicalId != null) || (this.patientSurgicalId != null && !this.patientSurgicalId.equals(other.patientSurgicalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PatientSurgicalHX[ patientSurgicalId=" + patientSurgicalId + " ]";
    }
    
}
