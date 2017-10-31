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
@Table(name = "patientvitalhx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientvitalhx.findAll", query = "SELECT p FROM Patientvitalhx p")
    , @NamedQuery(name = "Patientvitalhx.findByPatientVitalHxId", query = "SELECT p FROM Patientvitalhx p WHERE p.patientVitalHxId = :patientVitalHxId")
    , @NamedQuery(name = "Patientvitalhx.findByDateTaken", query = "SELECT p FROM Patientvitalhx p WHERE p.dateTaken = :dateTaken")})
public class Patientvitalhx implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_vital_hx_id")
    private Integer patientVitalHxId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "vital_id", referencedColumnName = "vital_id")
    @ManyToOne(optional = false)
    private Vitals vitalId;

    public Patientvitalhx() {
    }

    public Patientvitalhx(Integer patientVitalHxId) {
        this.patientVitalHxId = patientVitalHxId;
    }

    public Patientvitalhx(Integer patientVitalHxId, Date dateTaken) {
        this.patientVitalHxId = patientVitalHxId;
        this.dateTaken = dateTaken;
    }

    public Integer getPatientVitalHxId() {
        return patientVitalHxId;
    }

    public void setPatientVitalHxId(Integer patientVitalHxId) {
        this.patientVitalHxId = patientVitalHxId;
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

    public Vitals getVitalId() {
        return vitalId;
    }

    public void setVitalId(Vitals vitalId) {
        this.vitalId = vitalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientVitalHxId != null ? patientVitalHxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientvitalhx)) {
            return false;
        }
        Patientvitalhx other = (Patientvitalhx) object;
        if ((this.patientVitalHxId == null && other.patientVitalHxId != null) || (this.patientVitalHxId != null && !this.patientVitalHxId.equals(other.patientVitalHxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Patientvitalhx[ patientVitalHxId=" + patientVitalHxId + " ]";
    }
    
}
