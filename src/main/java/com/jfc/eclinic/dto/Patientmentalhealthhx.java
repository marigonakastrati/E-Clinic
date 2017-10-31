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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "patientmentalhealthhx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientmentalhealthhx.findAll", query = "SELECT p FROM Patientmentalhealthhx p")
    , @NamedQuery(name = "Patientmentalhealthhx.findByPatientMentalHealthId", query = "SELECT p FROM Patientmentalhealthhx p WHERE p.patientMentalHealthId = :patientMentalHealthId")
    , @NamedQuery(name = "Patientmentalhealthhx.findByDateTaken", query = "SELECT p FROM Patientmentalhealthhx p WHERE p.dateTaken = :dateTaken")})
public class Patientmentalhealthhx implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_mental_health_id")
    private Integer patientMentalHealthId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "mental_health_id", referencedColumnName = "mental_health_id")
    @ManyToOne(optional = false)
    private Mentalhealth mentalHealthId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public Patientmentalhealthhx() {
    }

    public Patientmentalhealthhx(Integer patientMentalHealthId) {
        this.patientMentalHealthId = patientMentalHealthId;
    }

    public Patientmentalhealthhx(Integer patientMentalHealthId, Date dateTaken) {
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

    public Mentalhealth getMentalHealthId() {
        return mentalHealthId;
    }

    public void setMentalHealthId(Mentalhealth mentalHealthId) {
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
        if (!(object instanceof Patientmentalhealthhx)) {
            return false;
        }
        Patientmentalhealthhx other = (Patientmentalhealthhx) object;
        if ((this.patientMentalHealthId == null && other.patientMentalHealthId != null) || (this.patientMentalHealthId != null && !this.patientMentalHealthId.equals(other.patientMentalHealthId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Patientmentalhealthhx[ patientMentalHealthId=" + patientMentalHealthId + " ]";
    }
    
}
