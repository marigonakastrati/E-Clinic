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
import javax.persistence.FetchType;
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
@Table(name = "Surgical")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surgical.findAll", query = "SELECT s FROM Surgical s")
    , @NamedQuery(name = "Surgical.findBySurgicalId", query = "SELECT s FROM Surgical s WHERE s.surgicalId = :surgicalId")
    , @NamedQuery(name = "Surgical.findByName", query = "SELECT s FROM Surgical s WHERE s.name = :name")})
public class Surgical implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "surgical_id")
    private Integer surgicalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surgicalId", fetch = FetchType.EAGER)
    private Collection<PatientSurgicalHX> patientSurgicalHXCollection;

    public Surgical() {
    }

    public Surgical(Integer surgicalId) {
        this.surgicalId = surgicalId;
    }

    public Surgical(Integer surgicalId, String name) {
        this.surgicalId = surgicalId;
        this.name = name;
    }

    public Integer getSurgicalId() {
        return surgicalId;
    }

    public void setSurgicalId(Integer surgicalId) {
        this.surgicalId = surgicalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<PatientSurgicalHX> getPatientSurgicalHXCollection() {
        return patientSurgicalHXCollection;
    }

    public void setPatientSurgicalHXCollection(Collection<PatientSurgicalHX> patientSurgicalHXCollection) {
        this.patientSurgicalHXCollection = patientSurgicalHXCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surgicalId != null ? surgicalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surgical)) {
            return false;
        }
        Surgical other = (Surgical) object;
        if ((this.surgicalId == null && other.surgicalId != null) || (this.surgicalId != null && !this.surgicalId.equals(other.surgicalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.Surgical[ surgicalId=" + surgicalId + " ]";
    }
    
}
