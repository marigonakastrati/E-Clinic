/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e"),
    @NamedQuery(name = "Education.findByEducationId", query = "SELECT e FROM Education e WHERE e.educationId = :educationId"),
    @NamedQuery(name = "Education.findByInstitutionName", query = "SELECT e FROM Education e WHERE e.institutionName = :institutionName")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "education_id")
    private Integer educationId;
    @Size(max = 25)
    @Column(name = "institution_name")
    private String institutionName;
    @JoinColumn(name = "education_program_id", referencedColumnName = "education_program_id")
    @ManyToOne(optional = false)
    private EducationProgram educationProgramId;
    @JoinColumn(name = "education_type_id", referencedColumnName = "education_type_id")
    @ManyToOne(optional = false)
    private EducationType educationTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationId")
    private Collection<PersonEducation> personEducationCollection;

    public Education() {
    }

    public Education(Integer educationId) {
        this.educationId = educationId;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public EducationProgram getEducationProgramId() {
        return educationProgramId;
    }

    public void setEducationProgramId(EducationProgram educationProgramId) {
        this.educationProgramId = educationProgramId;
    }

    public EducationType getEducationTypeId() {
        return educationTypeId;
    }

    public void setEducationTypeId(EducationType educationTypeId) {
        this.educationTypeId = educationTypeId;
    }

    @XmlTransient
    public Collection<PersonEducation> getPersonEducationCollection() {
        return personEducationCollection;
    }

    public void setPersonEducationCollection(Collection<PersonEducation> personEducationCollection) {
        this.personEducationCollection = personEducationCollection;
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
        return "com.ubt.healthcare.entity.Education[ educationId=" + educationId + " ]";
    }
    
}
