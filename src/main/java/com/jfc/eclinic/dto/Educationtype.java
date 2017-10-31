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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "educationtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educationtype.findAll", query = "SELECT e FROM Educationtype e")
    , @NamedQuery(name = "Educationtype.findByEducationName", query = "SELECT e FROM Educationtype e WHERE e.educationName = :educationName")
    , @NamedQuery(name = "Educationtype.findByEducationTypeId", query = "SELECT e FROM Educationtype e WHERE e.educationTypeId = :educationTypeId")})
public class Educationtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "EducationName")
    private String educationName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EducationTypeId")
    private Integer educationTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eucationTypeId")
    private Collection<Education> educationCollection;

    public Educationtype() {
    }

    public Educationtype(Integer educationTypeId) {
        this.educationTypeId = educationTypeId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public Integer getEducationTypeId() {
        return educationTypeId;
    }

    public void setEducationTypeId(Integer educationTypeId) {
        this.educationTypeId = educationTypeId;
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
        if (!(object instanceof Educationtype)) {
            return false;
        }
        Educationtype other = (Educationtype) object;
        if ((this.educationTypeId == null && other.educationTypeId != null) || (this.educationTypeId != null && !this.educationTypeId.equals(other.educationTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Educationtype[ educationTypeId=" + educationTypeId + " ]";
    }
    
}
