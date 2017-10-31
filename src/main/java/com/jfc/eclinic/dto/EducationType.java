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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "EducationType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationType.findAll", query = "SELECT e FROM EducationType e")
    , @NamedQuery(name = "EducationType.findByEducationTypeId", query = "SELECT e FROM EducationType e WHERE e.educationTypeId = :educationTypeId")
    , @NamedQuery(name = "EducationType.findByEducationName", query = "SELECT e FROM EducationType e WHERE e.educationName = :educationName")})
public class EducationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EducationTypeId")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer educationTypeId;
    @Size(max = 25)
    @Column(name = "EducationName")
    private String educationName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eucationTypeId")
    private Collection<Education> educationCollection;

    public EducationType() {
    }

    public EducationType(Integer educationTypeId) {
        this.educationTypeId = educationTypeId;
    }

    public Integer getEducationTypeId() {
        return educationTypeId;
    }

    public void setEducationTypeId(Integer educationTypeId) {
        this.educationTypeId = educationTypeId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    @XmlTransient
    public Collection<Education> getEducationCollection() {
        return educationCollection;
    }

    public void setEducationCollection(Collection<Education> educationCollection) {
        this.educationCollection = educationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educationTypeId != null ? educationTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationType)) {
            return false;
        }
        EducationType other = (EducationType) object;
        if ((this.educationTypeId == null && other.educationTypeId != null) || (this.educationTypeId != null && !this.educationTypeId.equals(other.educationTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.EducationType[ educationTypeId=" + educationTypeId + " ]";
    }

}
