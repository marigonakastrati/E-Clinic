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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "Emergency_Information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmergencyInformation.findAll", query = "SELECT e FROM EmergencyInformation e")
    , @NamedQuery(name = "EmergencyInformation.findByEmergencyInfoId", query = "SELECT e FROM EmergencyInformation e WHERE e.emergencyInfoId = :emergencyInfoId")})
public class EmergencyInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "emergency_info_id")
    private Integer emergencyInfoId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "person_id", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;

    public EmergencyInformation() {
    }

    public EmergencyInformation(Integer emergencyInfoId) {
        this.emergencyInfoId = emergencyInfoId;
    }

    public Integer getEmergencyInfoId() {
        return emergencyInfoId;
    }

    public void setEmergencyInfoId(Integer emergencyInfoId) {
        this.emergencyInfoId = emergencyInfoId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emergencyInfoId != null ? emergencyInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmergencyInformation)) {
            return false;
        }
        EmergencyInformation other = (EmergencyInformation) object;
        if ((this.emergencyInfoId == null && other.emergencyInfoId != null) || (this.emergencyInfoId != null && !this.emergencyInfoId.equals(other.emergencyInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.EmergencyInformation[ emergencyInfoId=" + emergencyInfoId + " ]";
    }
    
}
