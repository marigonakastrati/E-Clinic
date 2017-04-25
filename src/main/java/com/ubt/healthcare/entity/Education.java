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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "Education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e"),
    @NamedQuery(name = "Education.findBySchoolOfGrad", query = "SELECT e FROM Education e WHERE e.schoolOfGrad = :schoolOfGrad"),
    @NamedQuery(name = "Education.findByBachelorS", query = "SELECT e FROM Education e WHERE e.bachelorS = :bachelorS"),
    @NamedQuery(name = "Education.findByMasterS", query = "SELECT e FROM Education e WHERE e.masterS = :masterS"),
    @NamedQuery(name = "Education.findByCertificate", query = "SELECT e FROM Education e WHERE e.certificate = :certificate"),
    @NamedQuery(name = "Education.findByDoctoral", query = "SELECT e FROM Education e WHERE e.doctoral = :doctoral"),
    @NamedQuery(name = "Education.findBySpecialization", query = "SELECT e FROM Education e WHERE e.specialization = :specialization"),
    @NamedQuery(name = "Education.findByCurentPosition", query = "SELECT e FROM Education e WHERE e.curentPosition = :curentPosition"),
    @NamedQuery(name = "Education.findByDegree", query = "SELECT e FROM Education e WHERE e.degree = :degree"),
    @NamedQuery(name = "Education.findByDateStart", query = "SELECT e FROM Education e WHERE e.dateStart = :dateStart"),
    @NamedQuery(name = "Education.findByDateEnd", query = "SELECT e FROM Education e WHERE e.dateEnd = :dateEnd"),
    @NamedQuery(name = "Education.findByEducationId", query = "SELECT e FROM Education e WHERE e.educationId = :educationId")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "school_of_grad")
    private String schoolOfGrad;
    @Size(max = 20)
    @Column(name = "bachelor's")
    private String bachelorS;
    @Size(max = 20)
    @Column(name = "master's")
    private String masterS;
    @Size(max = 20)
    @Column(name = "certificate")
    private String certificate;
    @Size(max = 20)
    @Column(name = "doctoral")
    private String doctoral;
    @Size(max = 20)
    @Column(name = "specialization")
    private String specialization;
    @Size(max = 20)
    @Column(name = "curent_position")
    private String curentPosition;
    @Size(max = 20)
    @Column(name = "degree")
    private String degree;
    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "education_id")
    private Integer educationId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person personId;

    public Education() {
    }

    public Education(Integer educationId) {
        this.educationId = educationId;
    }

    public String getSchoolOfGrad() {
        return schoolOfGrad;
    }

    public void setSchoolOfGrad(String schoolOfGrad) {
        this.schoolOfGrad = schoolOfGrad;
    }

    public String getBachelorS() {
        return bachelorS;
    }

    public void setBachelorS(String bachelorS) {
        this.bachelorS = bachelorS;
    }

    public String getMasterS() {
        return masterS;
    }

    public void setMasterS(String masterS) {
        this.masterS = masterS;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getDoctoral() {
        return doctoral;
    }

    public void setDoctoral(String doctoral) {
        this.doctoral = doctoral;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCurentPosition() {
        return curentPosition;
    }

    public void setCurentPosition(String curentPosition) {
        this.curentPosition = curentPosition;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
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
