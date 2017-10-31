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
@Table(name = "patientfoodallergylhx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientfoodallergylhx.findAll", query = "SELECT p FROM Patientfoodallergylhx p")
    , @NamedQuery(name = "Patientfoodallergylhx.findByPatientFoodAllergyId", query = "SELECT p FROM Patientfoodallergylhx p WHERE p.patientFoodAllergyId = :patientFoodAllergyId")
    , @NamedQuery(name = "Patientfoodallergylhx.findByDateTaken", query = "SELECT p FROM Patientfoodallergylhx p WHERE p.dateTaken = :dateTaken")})
public class Patientfoodallergylhx implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_food_allergy_id")
    private Integer patientFoodAllergyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    @ManyToOne(optional = false)
    private Food foodId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public Patientfoodallergylhx() {
    }

    public Patientfoodallergylhx(Integer patientFoodAllergyId) {
        this.patientFoodAllergyId = patientFoodAllergyId;
    }

    public Patientfoodallergylhx(Integer patientFoodAllergyId, Date dateTaken) {
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
        if (!(object instanceof Patientfoodallergylhx)) {
            return false;
        }
        Patientfoodallergylhx other = (Patientfoodallergylhx) object;
        if ((this.patientFoodAllergyId == null && other.patientFoodAllergyId != null) || (this.patientFoodAllergyId != null && !this.patientFoodAllergyId.equals(other.patientFoodAllergyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Patientfoodallergylhx[ patientFoodAllergyId=" + patientFoodAllergyId + " ]";
    }
    
}
