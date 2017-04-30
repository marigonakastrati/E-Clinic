/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "PersonEducation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonEducation.findAll", query = "SELECT p FROM PersonEducation p"),
    @NamedQuery(name = "PersonEducation.findByDateStart", query = "SELECT p FROM PersonEducation p WHERE p.dateStart = :dateStart"),
    @NamedQuery(name = "PersonEducation.findByDateEnd", query = "SELECT p FROM PersonEducation p WHERE p.dateEnd = :dateEnd"),
    @NamedQuery(name = "PersonEducation.findByPersonEducationId", query = "SELECT p FROM PersonEducation p WHERE p.personEducationId = :personEducationId")})
public class PersonEducation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "person_education_id")
    private Integer personEducationId;
    @JoinColumn(name = "education_id", referencedColumnName = "education_id")
    @ManyToOne(optional = false)
    private Education educationId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;

    public PersonEducation() {
    }

    public PersonEducation(Integer personEducationId) {
        this.personEducationId = personEducationId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getPersonEducationId() {
        return personEducationId;
    }

    public void setPersonEducationId(Integer personEducationId) {
        this.personEducationId = personEducationId;
    }

    public Education getEducationId() {
        return educationId;
    }

    public void setEducationId(Education educationId) {
        this.educationId = educationId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personEducationId != null ? personEducationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonEducation)) {
            return false;
        }
        PersonEducation other = (PersonEducation) object;
        if ((this.personEducationId == null && other.personEducationId != null) || (this.personEducationId != null && !this.personEducationId.equals(other.personEducationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.PersonEducation[ personEducationId=" + personEducationId + " ]";
    }
    
}
