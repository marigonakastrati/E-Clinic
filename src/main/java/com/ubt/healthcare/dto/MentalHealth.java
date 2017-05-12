/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author F
 */
@Entity
@Table(name = "MentalHealth")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MentalHealth.findAll", query = "SELECT m FROM MentalHealth m")
    , @NamedQuery(name = "MentalHealth.findByMentalHealthId", query = "SELECT m FROM MentalHealth m WHERE m.mentalHealthId = :mentalHealthId")
    , @NamedQuery(name = "MentalHealth.findByName", query = "SELECT m FROM MentalHealth m WHERE m.name = :name")})
public class MentalHealth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mental_health_id")
    private Integer mentalHealthId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mentalHealthId")
    private Collection<PatientMentalHealthHX> patientMentalHealthHXCollection;

    public MentalHealth() {
    }

    public MentalHealth(Integer mentalHealthId) {
        this.mentalHealthId = mentalHealthId;
    }

    public MentalHealth(Integer mentalHealthId, String name) {
        this.mentalHealthId = mentalHealthId;
        this.name = name;
    }

    public Integer getMentalHealthId() {
        return mentalHealthId;
    }

    public void setMentalHealthId(Integer mentalHealthId) {
        this.mentalHealthId = mentalHealthId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<PatientMentalHealthHX> getPatientMentalHealthHXCollection() {
        return patientMentalHealthHXCollection;
    }

    public void setPatientMentalHealthHXCollection(Collection<PatientMentalHealthHX> patientMentalHealthHXCollection) {
        this.patientMentalHealthHXCollection = patientMentalHealthHXCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mentalHealthId != null ? mentalHealthId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MentalHealth)) {
            return false;
        }
        MentalHealth other = (MentalHealth) object;
        if ((this.mentalHealthId == null && other.mentalHealthId != null) || (this.mentalHealthId != null && !this.mentalHealthId.equals(other.mentalHealthId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.MentalHealth[ mentalHealthId=" + mentalHealthId + " ]";
    }
    
}
