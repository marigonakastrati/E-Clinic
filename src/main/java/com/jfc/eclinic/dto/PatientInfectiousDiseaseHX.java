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
@Table(name = "PatientInfectiousDiseaseHX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientInfectiousDiseaseHX.findAll", query = "SELECT p FROM PatientInfectiousDiseaseHX p")
    , @NamedQuery(name = "PatientInfectiousDiseaseHX.findByPatientInfectiousDiseaseId", query = "SELECT p FROM PatientInfectiousDiseaseHX p WHERE p.patientInfectiousDiseaseId = :patientInfectiousDiseaseId")
    , @NamedQuery(name = "PatientInfectiousDiseaseHX.findByDateTaken", query = "SELECT p FROM PatientInfectiousDiseaseHX p WHERE p.dateTaken = :dateTaken")})
public class PatientInfectiousDiseaseHX implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_infectious_disease_id")
    private Integer patientInfectiousDiseaseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "infectious_disease_id", referencedColumnName = "infectious_disease_id")
    @ManyToOne(optional = false)
    private InfectiousDisease infectiousDiseaseId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public PatientInfectiousDiseaseHX() {
    }

    public PatientInfectiousDiseaseHX(Integer patientInfectiousDiseaseId) {
        this.patientInfectiousDiseaseId = patientInfectiousDiseaseId;
    }

    public PatientInfectiousDiseaseHX(Integer patientInfectiousDiseaseId, Date dateTaken) {
        this.patientInfectiousDiseaseId = patientInfectiousDiseaseId;
        this.dateTaken = dateTaken;
    }

    public Integer getPatientInfectiousDiseaseId() {
        return patientInfectiousDiseaseId;
    }

    public void setPatientInfectiousDiseaseId(Integer patientInfectiousDiseaseId) {
        this.patientInfectiousDiseaseId = patientInfectiousDiseaseId;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public InfectiousDisease getInfectiousDiseaseId() {
        return infectiousDiseaseId;
    }

    public void setInfectiousDiseaseId(InfectiousDisease infectiousDiseaseId) {
        this.infectiousDiseaseId = infectiousDiseaseId;
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
        hash += (patientInfectiousDiseaseId != null ? patientInfectiousDiseaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientInfectiousDiseaseHX)) {
            return false;
        }
        PatientInfectiousDiseaseHX other = (PatientInfectiousDiseaseHX) object;
        if ((this.patientInfectiousDiseaseId == null && other.patientInfectiousDiseaseId != null) || (this.patientInfectiousDiseaseId != null && !this.patientInfectiousDiseaseId.equals(other.patientInfectiousDiseaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PatientInfectiousDiseaseHX[ patientInfectiousDiseaseId=" + patientInfectiousDiseaseId + " ]";
    }
    
}
