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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "Alergis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alergis.findAll", query = "SELECT a FROM Alergis a"),
    @NamedQuery(name = "Alergis.findBySeverity", query = "SELECT a FROM Alergis a WHERE a.severity = :severity"),
    @NamedQuery(name = "Alergis.findByReaction", query = "SELECT a FROM Alergis a WHERE a.reaction = :reaction"),
    @NamedQuery(name = "Alergis.findByDateOfOnset", query = "SELECT a FROM Alergis a WHERE a.dateOfOnset = :dateOfOnset"),
    @NamedQuery(name = "Alergis.findByAlergieId", query = "SELECT a FROM Alergis a WHERE a.alergieId = :alergieId")})
public class Alergis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "severity")
    private String severity;
    @Size(max = 255)
    @Column(name = "reaction")
    private String reaction;
    @Column(name = "date_of_onset")
    @Temporal(TemporalType.DATE)
    private Date dateOfOnset;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alergie_id")
    private Integer alergieId;
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false)
    private Medicine medicineId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public Alergis() {
    }

    public Alergis(Integer alergieId) {
        this.alergieId = alergieId;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public Date getDateOfOnset() {
        return dateOfOnset;
    }

    public void setDateOfOnset(Date dateOfOnset) {
        this.dateOfOnset = dateOfOnset;
    }

    public Integer getAlergieId() {
        return alergieId;
    }

    public void setAlergieId(Integer alergieId) {
        this.alergieId = alergieId;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
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
        hash += (alergieId != null ? alergieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alergis)) {
            return false;
        }
        Alergis other = (Alergis) object;
        if ((this.alergieId == null && other.alergieId != null) || (this.alergieId != null && !this.alergieId.equals(other.alergieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Alergis[ alergieId=" + alergieId + " ]";
    }
    
}
