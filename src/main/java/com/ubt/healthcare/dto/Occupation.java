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
@Table(name = "Occupation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Occupation.findAll", query = "SELECT o FROM Occupation o"),
    @NamedQuery(name = "Occupation.findByOccupationId", query = "SELECT o FROM Occupation o WHERE o.occupationId = :occupationId"),
    @NamedQuery(name = "Occupation.findByOccupationName", query = "SELECT o FROM Occupation o WHERE o.occupationName = :occupationName")})
public class Occupation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "occupation_id")
    private Integer occupationId;
    @Size(max = 30)
    @Column(name = "occupation_name")
    private String occupationName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupationId")
    private Collection<Patient> patientCollection;

    public Occupation() {
    }

    public Occupation(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public Integer getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (occupationId != null ? occupationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Occupation)) {
            return false;
        }
        Occupation other = (Occupation) object;
        if ((this.occupationId == null && other.occupationId != null) || (this.occupationId != null && !this.occupationId.equals(other.occupationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Occupation[ occupationId=" + occupationId + " ]";
    }
    
}
