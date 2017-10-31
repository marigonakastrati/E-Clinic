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
@Table(name = "patientinfectiousdiseasehx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientinfectiousdiseasehx.findAll", query = "SELECT p FROM Patientinfectiousdiseasehx p")
    , @NamedQuery(name = "Patientinfectiousdiseasehx.findByPatientInfectiousDiseaseId", query = "SELECT p FROM Patientinfectiousdiseasehx p WHERE p.patientInfectiousDiseaseId = :patientInfectiousDiseaseId")
    , @NamedQuery(name = "Patientinfectiousdiseasehx.findByDateTaken", query = "SELECT p FROM Patientinfectiousdiseasehx p WHERE p.dateTaken = :dateTaken")})
public class Patientinfectiousdiseasehx implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_infectious_disease_id")
    private Integer patientInfectiousDiseaseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "infectious_disease_id", referencedColumnName = "infectious_disease_id")
    @ManyToOne(optional = false)
    private Infectiousdisease infectiousDiseaseId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public Patientinfectiousdiseasehx() {
    }

    public Patientinfectiousdiseasehx(Integer patientInfectiousDiseaseId) {
        this.patientInfectiousDiseaseId = patientInfectiousDiseaseId;
    }

    public Patientinfectiousdiseasehx(Integer patientInfectiousDiseaseId, Date dateTaken) {
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

    public Infectiousdisease getInfectiousDiseaseId() {
        return infectiousDiseaseId;
    }

    public void setInfectiousDiseaseId(Infectiousdisease infectiousDiseaseId) {
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
        if (!(object instanceof Patientinfectiousdiseasehx)) {
            return false;
        }
        Patientinfectiousdiseasehx other = (Patientinfectiousdiseasehx) object;
        if ((this.patientInfectiousDiseaseId == null && other.patientInfectiousDiseaseId != null) || (this.patientInfectiousDiseaseId != null && !this.patientInfectiousDiseaseId.equals(other.patientInfectiousDiseaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Patientinfectiousdiseasehx[ patientInfectiousDiseaseId=" + patientInfectiousDiseaseId + " ]";
    }
    
}
