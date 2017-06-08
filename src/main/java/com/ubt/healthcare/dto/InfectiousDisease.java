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
@Table(name = "InfectiousDisease")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfectiousDisease.findAll", query = "SELECT i FROM InfectiousDisease i")
    , @NamedQuery(name = "InfectiousDisease.findByInfectiousDiseaseId", query = "SELECT i FROM InfectiousDisease i WHERE i.infectiousDiseaseId = :infectiousDiseaseId")
    , @NamedQuery(name = "InfectiousDisease.findByName", query = "SELECT i FROM InfectiousDisease i WHERE i.name = :name")})
public class InfectiousDisease implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "infectious_disease_id")
    private Integer infectiousDiseaseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infectiousDiseaseId")
    private Collection<PatientInfectiousDiseaseHX> patientInfectiousDiseaseHXCollection;

    public InfectiousDisease() {
    }

    public InfectiousDisease(Integer infectiousDiseaseId) {
        this.infectiousDiseaseId = infectiousDiseaseId;
    }

    public InfectiousDisease(Integer infectiousDiseaseId, String name) {
        this.infectiousDiseaseId = infectiousDiseaseId;
        this.name = name;
    }

    public Integer getInfectiousDiseaseId() {
        return infectiousDiseaseId;
    }

    public void setInfectiousDiseaseId(Integer infectiousDiseaseId) {
        this.infectiousDiseaseId = infectiousDiseaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<PatientInfectiousDiseaseHX> getPatientInfectiousDiseaseHXCollection() {
        return patientInfectiousDiseaseHXCollection;
    }

    public void setPatientInfectiousDiseaseHXCollection(Collection<PatientInfectiousDiseaseHX> patientInfectiousDiseaseHXCollection) {
        this.patientInfectiousDiseaseHXCollection = patientInfectiousDiseaseHXCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infectiousDiseaseId != null ? infectiousDiseaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfectiousDisease)) {
            return false;
        }
        InfectiousDisease other = (InfectiousDisease) object;
        if ((this.infectiousDiseaseId == null && other.infectiousDiseaseId != null) || (this.infectiousDiseaseId != null && !this.infectiousDiseaseId.equals(other.infectiousDiseaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.InfectiousDisease[ infectiousDiseaseId=" + infectiousDiseaseId + " ]";
    }
    
}
