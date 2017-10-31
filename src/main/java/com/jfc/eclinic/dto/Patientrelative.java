/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "patientrelative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientrelative.findAll", query = "SELECT p FROM Patientrelative p")
    , @NamedQuery(name = "Patientrelative.findByPatientRelativeId", query = "SELECT p FROM Patientrelative p WHERE p.patientRelativeId = :patientRelativeId")})
public class Patientrelative implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_relative_id")
    private Integer patientRelativeId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "relative_type_id", referencedColumnName = "relative_type_id")
    @ManyToOne(optional = false)
    private Relativetype relativeTypeId;
    @JoinColumn(name = "relative_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient relativeId;

    public Patientrelative() {
    }

    public Patientrelative(Integer patientRelativeId) {
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

    public Relativetype getRelativeTypeId() {
        return relativeTypeId;
    }

    public void setRelativeTypeId(Relativetype relativeTypeId) {
        this.relativeTypeId = relativeTypeId;
    }

    public Patient getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Patient relativeId) {
        this.relativeId = relativeId;
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
        if (!(object instanceof Patientrelative)) {
            return false;
        }
        Patientrelative other = (Patientrelative) object;
        if ((this.patientRelativeId == null && other.patientRelativeId != null) || (this.patientRelativeId != null && !this.patientRelativeId.equals(other.patientRelativeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Patientrelative[ patientRelativeId=" + patientRelativeId + " ]";
    }
    
}
