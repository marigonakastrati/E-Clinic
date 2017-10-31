/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "vitals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vitals.findAll", query = "SELECT v FROM Vitals v")
    , @NamedQuery(name = "Vitals.findByBp", query = "SELECT v FROM Vitals v WHERE v.bp = :bp")
    , @NamedQuery(name = "Vitals.findByHr", query = "SELECT v FROM Vitals v WHERE v.hr = :hr")
    , @NamedQuery(name = "Vitals.findByRr", query = "SELECT v FROM Vitals v WHERE v.rr = :rr")
    , @NamedQuery(name = "Vitals.findByLt", query = "SELECT v FROM Vitals v WHERE v.lt = :lt")
    , @NamedQuery(name = "Vitals.findByWt", query = "SELECT v FROM Vitals v WHERE v.wt = :wt")
    , @NamedQuery(name = "Vitals.findByBmi", query = "SELECT v FROM Vitals v WHERE v.bmi = :bmi")
    , @NamedQuery(name = "Vitals.findByVitalId", query = "SELECT v FROM Vitals v WHERE v.vitalId = :vitalId")})
public class Vitals implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "bp")
    private BigDecimal bp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hr")
    private BigDecimal hr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rr")
    private BigDecimal rr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lt")
    private BigDecimal lt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wt")
    private BigDecimal wt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bmi")
    private BigDecimal bmi;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vital_id")
    private Integer vitalId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vitalId")
    private Collection<Patientvitalhx> patientvitalhxCollection;

    public Vitals() {
    }

    public Vitals(Integer vitalId) {
        this.vitalId = vitalId;
    }

    public Vitals(Integer vitalId, BigDecimal bp, BigDecimal hr, BigDecimal rr, BigDecimal lt, BigDecimal wt, BigDecimal bmi) {
        this.vitalId = vitalId;
        this.bp = bp;
        this.hr = hr;
        this.rr = rr;
        this.lt = lt;
        this.wt = wt;
        this.bmi = bmi;
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

    public Integer getVitalId() {
        return vitalId;
    }

    public void setVitalId(Integer vitalId) {
        this.vitalId = vitalId;
    }

    @XmlTransient
    public Collection<Patientvitalhx> getPatientvitalhxCollection() {
        return patientvitalhxCollection;
    }

    public void setPatientvitalhxCollection(Collection<Patientvitalhx> patientvitalhxCollection) {
        this.patientvitalhxCollection = patientvitalhxCollection;
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
        return "com.jfc.eclinic.dto.Vitals[ vitalId=" + vitalId + " ]";
    }
    
}
