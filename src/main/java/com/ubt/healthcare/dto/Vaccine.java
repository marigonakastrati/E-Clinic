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
@Table(name = "Vaccine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vaccine.findAll", query = "SELECT v FROM Vaccine v")
    , @NamedQuery(name = "Vaccine.findByVaccineId", query = "SELECT v FROM Vaccine v WHERE v.vaccineId = :vaccineId")
    , @NamedQuery(name = "Vaccine.findByName", query = "SELECT v FROM Vaccine v WHERE v.name = :name")})
public class Vaccine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vaccine_id")
    private Integer vaccineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccineId")
    private Collection<PatientVaccineHX> patientVaccineHXCollection;

    public Vaccine() {
    }

    public Vaccine(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Vaccine(Integer vaccineId, String name) {
        this.vaccineId = vaccineId;
        this.name = name;
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<PatientVaccineHX> getPatientVaccineHXCollection() {
        return patientVaccineHXCollection;
    }

    public void setPatientVaccineHXCollection(Collection<PatientVaccineHX> patientVaccineHXCollection) {
        this.patientVaccineHXCollection = patientVaccineHXCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vaccineId != null ? vaccineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vaccine)) {
            return false;
        }
        Vaccine other = (Vaccine) object;
        if ((this.vaccineId == null && other.vaccineId != null) || (this.vaccineId != null && !this.vaccineId.equals(other.vaccineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.Vaccine[ vaccineId=" + vaccineId + " ]";
    }
    
}
