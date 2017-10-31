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
@Table(name = "PatientFoodAllergylHX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientFoodAllergylHX.findAll", query = "SELECT p FROM PatientFoodAllergylHX p")
    , @NamedQuery(name = "PatientFoodAllergylHX.findByPatientFoodAllergyId", query = "SELECT p FROM PatientFoodAllergylHX p WHERE p.patientFoodAllergyId = :patientFoodAllergyId")
    , @NamedQuery(name = "PatientFoodAllergylHX.findByDateTaken", query = "SELECT p FROM PatientFoodAllergylHX p WHERE p.dateTaken = :dateTaken")})
public class PatientFoodAllergylHX implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_food_allergy_id")
    private Integer patientFoodAllergyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Food foodId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;

    public PatientFoodAllergylHX() {
    }

    public PatientFoodAllergylHX(Integer patientFoodAllergyId) {
        this.patientFoodAllergyId = patientFoodAllergyId;
    }

    public PatientFoodAllergylHX(Integer patientFoodAllergyId, Date dateTaken) {
        this.patientFoodAllergyId = patientFoodAllergyId;
        this.dateTaken = dateTaken;
    }

    public Integer getPatientFoodAllergyId() {
        return patientFoodAllergyId;
    }

    public void setPatientFoodAllergyId(Integer patientFoodAllergyId) {
        this.patientFoodAllergyId = patientFoodAllergyId;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        this.foodId = foodId;
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
        hash += (patientFoodAllergyId != null ? patientFoodAllergyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientFoodAllergylHX)) {
            return false;
        }
        PatientFoodAllergylHX other = (PatientFoodAllergylHX) object;
        if ((this.patientFoodAllergyId == null && other.patientFoodAllergyId != null) || (this.patientFoodAllergyId != null && !this.patientFoodAllergyId.equals(other.patientFoodAllergyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PatientFoodAllergylHX[ patientFoodAllergyId=" + patientFoodAllergyId + " ]";
    }
    
}
