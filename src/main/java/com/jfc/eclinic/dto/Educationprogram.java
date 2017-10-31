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
@Table(name = "educationprogram")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educationprogram.findAll", query = "SELECT e FROM Educationprogram e")
    , @NamedQuery(name = "Educationprogram.findByProgramName", query = "SELECT e FROM Educationprogram e WHERE e.programName = :programName")
    , @NamedQuery(name = "Educationprogram.findByEducationProgramId", query = "SELECT e FROM Educationprogram e WHERE e.educationProgramId = :educationProgramId")})
public class Educationprogram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ProgramName")
    private String programName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EducationProgramId")
    private Integer educationProgramId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationProgramId")
    private Collection<Education> educationCollection;

    public Educationprogram() {
    }

    public Educationprogram(Integer educationProgramId) {
        this.educationProgramId = educationProgramId;
    }

    public Educationprogram(Integer educationProgramId, String programName) {
        this.educationProgramId = educationProgramId;
        this.programName = programName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Integer getEducationProgramId() {
        return educationProgramId;
    }

    public void setEducationProgramId(Integer educationProgramId) {
        this.educationProgramId = educationProgramId;
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
        if (!(object instanceof Educationprogram)) {
            return false;
        }
        Educationprogram other = (Educationprogram) object;
        if ((this.educationProgramId == null && other.educationProgramId != null) || (this.educationProgramId != null && !this.educationProgramId.equals(other.educationProgramId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Educationprogram[ educationProgramId=" + educationProgramId + " ]";
    }
    
}
