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
@Table(name = "EducationProgram")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationProgram.findAll", query = "SELECT e FROM EducationProgram e"),
    @NamedQuery(name = "EducationProgram.findByEducationProgramId", query = "SELECT e FROM EducationProgram e WHERE e.educationProgramId = :educationProgramId"),
    @NamedQuery(name = "EducationProgram.findByProgramName", query = "SELECT e FROM EducationProgram e WHERE e.programName = :programName")})
public class EducationProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "education_program_id")
    private Integer educationProgramId;
    @Size(max = 50)
    @Column(name = "program_name")
    private String programName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationProgramId")
    private Collection<Education> educationCollection;

    public EducationProgram() {
    }

    public EducationProgram(Integer educationProgramId) {
        this.educationProgramId = educationProgramId;
    }

    public Integer getEducationProgramId() {
        return educationProgramId;
    }

    public void setEducationProgramId(Integer educationProgramId) {
        this.educationProgramId = educationProgramId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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
        hash += (educationProgramId != null ? educationProgramId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationProgram)) {
            return false;
        }
        EducationProgram other = (EducationProgram) object;
        if ((this.educationProgramId == null && other.educationProgramId != null) || (this.educationProgramId != null && !this.educationProgramId.equals(other.educationProgramId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.EducationProgram[ educationProgramId=" + educationProgramId + " ]";
    }
    
}
