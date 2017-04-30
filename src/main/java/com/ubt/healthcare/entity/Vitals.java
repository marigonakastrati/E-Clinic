/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Vitals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vitals.findAll", query = "SELECT v FROM Vitals v"),
    @NamedQuery(name = "Vitals.findByVitalTaken", query = "SELECT v FROM Vitals v WHERE v.vitalTaken = :vitalTaken"),
    @NamedQuery(name = "Vitals.findByBp", query = "SELECT v FROM Vitals v WHERE v.bp = :bp"),
    @NamedQuery(name = "Vitals.findByHr", query = "SELECT v FROM Vitals v WHERE v.hr = :hr"),
    @NamedQuery(name = "Vitals.findByRr", query = "SELECT v FROM Vitals v WHERE v.rr = :rr"),
    @NamedQuery(name = "Vitals.findByLt", query = "SELECT v FROM Vitals v WHERE v.lt = :lt"),
    @NamedQuery(name = "Vitals.findByWt", query = "SELECT v FROM Vitals v WHERE v.wt = :wt"),
    @NamedQuery(name = "Vitals.findByBmi", query = "SELECT v FROM Vitals v WHERE v.bmi = :bmi"),
    @NamedQuery(name = "Vitals.findByComment", query = "SELECT v FROM Vitals v WHERE v.comment = :comment"),
    @NamedQuery(name = "Vitals.findByVitalId", query = "SELECT v FROM Vitals v WHERE v.vitalId = :vitalId"),
    @NamedQuery(name = "Vitals.findByDateTaken", query = "SELECT v FROM Vitals v WHERE v.dateTaken = :dateTaken")})
public class Vitals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "vital_taken")
    private String vitalTaken;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bp")
    private BigDecimal bp;
    @Column(name = "hr")
    private BigDecimal hr;
    @Column(name = "rr")
    private BigDecimal rr;
    @Column(name = "lt")
    private BigDecimal lt;
    @Column(name = "wt")
    private BigDecimal wt;
    @Column(name = "bmi")
    private BigDecimal bmi;
    @Size(max = 50)
    @Column(name = "comment")
    private String comment;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vital_id")
    private Integer vitalId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_taken")
    @Temporal(TemporalType.DATE)
    private Date dateTaken;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;

    public Vitals() {
    }

    public Vitals(Integer vitalId) {
        this.vitalId = vitalId;
    }

    public Vitals(Integer vitalId, Date dateTaken) {
        this.vitalId = vitalId;
        this.dateTaken = dateTaken;
    }

    public String getVitalTaken() {
        return vitalTaken;
    }

    public void setVitalTaken(String vitalTaken) {
        this.vitalTaken = vitalTaken;
    }

    public BigDecimal getBp() {
        return bp;
    }

    public void setBp(BigDecimal bp) {
        this.bp = bp;
    }

    public BigDecimal getHr() {
        return hr;
    }

    public void setHr(BigDecimal hr) {
        this.hr = hr;
    }

    public BigDecimal getRr() {
        return rr;
    }

    public void setRr(BigDecimal rr) {
        this.rr = rr;
    }

    public BigDecimal getLt() {
        return lt;
    }

    public void setLt(BigDecimal lt) {
        this.lt = lt;
    }

    public BigDecimal getWt() {
        return wt;
    }

    public void setWt(BigDecimal wt) {
        this.wt = wt;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getVitalId() {
        return vitalId;
    }

    public void setVitalId(Integer vitalId) {
        this.vitalId = vitalId;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vitalId != null ? vitalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vitals)) {
            return false;
        }
        Vitals other = (Vitals) object;
        if ((this.vitalId == null && other.vitalId != null) || (this.vitalId != null && !this.vitalId.equals(other.vitalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Vitals[ vitalId=" + vitalId + " ]";
    }
    
}
