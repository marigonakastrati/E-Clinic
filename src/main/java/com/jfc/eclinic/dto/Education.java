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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e")
    , @NamedQuery(name = "Education.findByInstitutionName", query = "SELECT e FROM Education e WHERE e.institutionName = :institutionName")
    , @NamedQuery(name = "Education.findByEducationId", query = "SELECT e FROM Education e WHERE e.educationId = :educationId")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "InstitutionName")
    private String institutionName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EducationId")
    private Integer educationId;
    @JoinColumn(name = "EducationProgramId", referencedColumnName = "EducationProgramId")
    @ManyToOne(optional = false)
    private Educationprogram educationProgramId;
    @JoinColumn(name = "EucationTypeId", referencedColumnName = "EducationTypeId")
    @ManyToOne(optional = false)
    private Educationtype eucationTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationId")
    private Collection<Personeducation> personeducationCollection;

    public Education() {
    }

    public Education(Integer educationId) {
        this.educationId = educationId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Educationprogram getEducationProgramId() {
        return educationProgramId;
    }

    public void setEducationProgramId(Educationprogram educationProgramId) {
        this.educationProgramId = educationProgramId;
    }

    public Educationtype getEucationTypeId() {
        return eucationTypeId;
    }

    public void setEucationTypeId(Educationtype eucationTypeId) {
        this.eucationTypeId = eucationTypeId;
    }

    @XmlTransient
    public Collection<Personeducation> getPersoneducationCollection() {
        return personeducationCollection;
    }

    public void setPersoneducationCollection(Collection<Personeducation> personeducationCollection) {
        this.personeducationCollection = personeducationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educationId != null ? educationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.educationId == null && other.educationId != null) || (this.educationId != null && !this.educationId.equals(other.educationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Education[ educationId=" + educationId + " ]";
    }
    
}
