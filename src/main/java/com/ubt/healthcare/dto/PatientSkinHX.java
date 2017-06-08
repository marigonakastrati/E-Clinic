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
@Table(name = "PatientSkinHX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientSkinHX.findAll", query = "SELECT p FROM PatientSkinHX p")
    , @NamedQuery(name = "PatientSkinHX.findByPatientSkinId", query = "SELECT p FROM PatientSkinHX p WHERE p.patientSkinId = :patientSkinId")
    , @NamedQuery(name = "PatientSkinHX.findByDateTaken", query = "SELECT p FROM PatientSkinHX p WHERE p.dateTaken = :dateTaken")})
public class PatientSkinHX implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_skin_id")
    private Integer patientSkinId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "skin_id", referencedColumnName = "skin_id")
    @ManyToOne(optional = false)
    private Skin skinId;

    public PatientSkinHX() {
    }

    public PatientSkinHX(Integer patientSkinId) {
        this.patientSkinId = patientSkinId;
    }

    public PatientSkinHX(Integer patientSkinId, Date dateTaken) {
        this.patientSkinId = patientSkinId;
        this.dateTaken = dateTaken;
    }

    public Integer getPatientSkinId() {
        return patientSkinId;
    }

    public void setPatientSkinId(Integer patientSkinId) {
        this.patientSkinId = patientSkinId;
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

    public Skin getSkinId() {
        return skinId;
    }

    public void setSkinId(Skin skinId) {
        this.skinId = skinId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientSkinId != null ? patientSkinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientSkinHX)) {
            return false;
        }
        PatientSkinHX other = (PatientSkinHX) object;
        if ((this.patientSkinId == null && other.patientSkinId != null) || (this.patientSkinId != null && !this.patientSkinId.equals(other.patientSkinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PatientSkinHX[ patientSkinId=" + patientSkinId + " ]";
    }
    
}
