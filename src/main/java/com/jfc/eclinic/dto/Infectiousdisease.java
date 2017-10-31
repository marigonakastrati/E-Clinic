/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author jfc
 */
@Entity
@Table(name = "infectiousdisease")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infectiousdisease.findAll", query = "SELECT i FROM Infectiousdisease i")
    , @NamedQuery(name = "Infectiousdisease.findByInfectiousDiseaseId", query = "SELECT i FROM Infectiousdisease i WHERE i.infectiousDiseaseId = :infectiousDiseaseId")
    , @NamedQuery(name = "Infectiousdisease.findByName", query = "SELECT i FROM Infectiousdisease i WHERE i.name = :name")})
public class Infectiousdisease implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "infectious_disease_id")
    private Integer infectiousDiseaseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infectiousDiseaseId")
    private Collection<Patientinfectiousdiseasehx> patientinfectiousdiseasehxCollection;

    public Infectiousdisease() {
    }

    public Infectiousdisease(Integer infectiousDiseaseId) {
        this.infectiousDiseaseId = infectiousDiseaseId;
    }

    public Infectiousdisease(Integer infectiousDiseaseId, String name) {
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
    public Collection<Patientinfectiousdiseasehx> getPatientinfectiousdiseasehxCollection() {
        return patientinfectiousdiseasehxCollection;
    }

    public void setPatientinfectiousdiseasehxCollection(Collection<Patientinfectiousdiseasehx> patientinfectiousdiseasehxCollection) {
        this.patientinfectiousdiseasehxCollection = patientinfectiousdiseasehxCollection;
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
        if (!(object instanceof Infectiousdisease)) {
            return false;
        }
        Infectiousdisease other = (Infectiousdisease) object;
        if ((this.infectiousDiseaseId == null && other.infectiousDiseaseId != null) || (this.infectiousDiseaseId != null && !this.infectiousDiseaseId.equals(other.infectiousDiseaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Infectiousdisease[ infectiousDiseaseId=" + infectiousDiseaseId + " ]";
    }
    
}
