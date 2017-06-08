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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "PatientRelative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientRelative.findAll", query = "SELECT p FROM PatientRelative p")
    , @NamedQuery(name = "PatientRelative.findByPatientRelativeId", query = "SELECT p FROM PatientRelative p WHERE p.patientRelativeId = :patientRelativeId")})
public class PatientRelative implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_relative_id")
    private Integer patientRelativeId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;
    @JoinColumn(name = "relative_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient relativeId;
    @JoinColumn(name = "relative_type_id", referencedColumnName = "relative_type_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RelativeType relativeTypeId;

    public PatientRelative() {
    }

    public PatientRelative(Integer patientRelativeId) {
        this.patientRelativeId = patientRelativeId;
    }

    public Integer getPatientRelativeId() {
        return patientRelativeId;
    }

    public void setPatientRelativeId(Integer patientRelativeId) {
        this.patientRelativeId = patientRelativeId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Patient getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Patient relativeId) {
        this.relativeId = relativeId;
    }

    public RelativeType getRelativeTypeId() {
        return relativeTypeId;
    }

    public void setRelativeTypeId(RelativeType relativeTypeId) {
        this.relativeTypeId = relativeTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientRelativeId != null ? patientRelativeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientRelative)) {
            return false;
        }
        PatientRelative other = (PatientRelative) object;
        if ((this.patientRelativeId == null && other.patientRelativeId != null) || (this.patientRelativeId != null && !this.patientRelativeId.equals(other.patientRelativeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PatientRelative[ patientRelativeId=" + patientRelativeId + " ]";
    }
    
}
