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
@Table(name = "relativetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relativetype.findAll", query = "SELECT r FROM Relativetype r")
    , @NamedQuery(name = "Relativetype.findByRelativeTypeId", query = "SELECT r FROM Relativetype r WHERE r.relativeTypeId = :relativeTypeId")
    , @NamedQuery(name = "Relativetype.findByName", query = "SELECT r FROM Relativetype r WHERE r.name = :name")})
public class Relativetype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relative_type_id")
    private Integer relativeTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relativeTypeId")
    private Collection<Patientrelative> patientrelativeCollection;

    public Relativetype() {
    }

    public Relativetype(Integer relativeTypeId) {
        this.relativeTypeId = relativeTypeId;
    }

    public Relativetype(Integer relativeTypeId, String name) {
        this.relativeTypeId = relativeTypeId;
        this.name = name;
    }

    public Integer getRelativeTypeId() {
        return relativeTypeId;
    }

    public void setRelativeTypeId(Integer relativeTypeId) {
        this.relativeTypeId = relativeTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Patientrelative> getPatientrelativeCollection() {
        return patientrelativeCollection;
    }

    public void setPatientrelativeCollection(Collection<Patientrelative> patientrelativeCollection) {
        this.patientrelativeCollection = patientrelativeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relativeTypeId != null ? relativeTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relativetype)) {
            return false;
        }
        Relativetype other = (Relativetype) object;
        if ((this.relativeTypeId == null && other.relativeTypeId != null) || (this.relativeTypeId != null && !this.relativeTypeId.equals(other.relativeTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Relativetype[ relativeTypeId=" + relativeTypeId + " ]";
    }
    
}
