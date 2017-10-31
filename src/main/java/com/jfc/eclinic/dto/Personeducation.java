/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "personeducation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personeducation.findAll", query = "SELECT p FROM Personeducation p")
    , @NamedQuery(name = "Personeducation.findByDateStart", query = "SELECT p FROM Personeducation p WHERE p.dateStart = :dateStart")
    , @NamedQuery(name = "Personeducation.findByDateEnd", query = "SELECT p FROM Personeducation p WHERE p.dateEnd = :dateEnd")
    , @NamedQuery(name = "Personeducation.findByPersonEducationId", query = "SELECT p FROM Personeducation p WHERE p.personEducationId = :personEducationId")})
public class Personeducation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "DateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "DateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PersonEducationId")
    private Integer personEducationId;
    @JoinColumn(name = "EducationId", referencedColumnName = "EducationId")
    @ManyToOne(optional = false)
    private Education educationId;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;

    public Personeducation() {
    }

    public Personeducation(Integer personEducationId) {
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
        if (!(object instanceof Personeducation)) {
            return false;
        }
        Personeducation other = (Personeducation) object;
        if ((this.personEducationId == null && other.personEducationId != null) || (this.personEducationId != null && !this.personEducationId.equals(other.personEducationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Personeducation[ personEducationId=" + personEducationId + " ]";
    }
    
}
