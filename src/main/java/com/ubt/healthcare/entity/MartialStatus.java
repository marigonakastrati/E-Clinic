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
@Table(name = "MartialStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MartialStatus.findAll", query = "SELECT m FROM MartialStatus m"),
    @NamedQuery(name = "MartialStatus.findByMartialStatusId", query = "SELECT m FROM MartialStatus m WHERE m.martialStatusId = :martialStatusId"),
    @NamedQuery(name = "MartialStatus.findByMartialStatusName", query = "SELECT m FROM MartialStatus m WHERE m.martialStatusName = :martialStatusName")})
public class MartialStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "martial_status_id")
    private Integer martialStatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "martial_status_name")
    private String martialStatusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "martialStatusId")
    private Collection<Person> personCollection;

    public MartialStatus() {
    }

    public MartialStatus(Integer martialStatusId) {
        this.martialStatusId = martialStatusId;
    }

    public MartialStatus(Integer martialStatusId, String martialStatusName) {
        this.martialStatusId = martialStatusId;
        this.martialStatusName = martialStatusName;
    }

    public Integer getMartialStatusId() {
        return martialStatusId;
    }

    public void setMartialStatusId(Integer martialStatusId) {
        this.martialStatusId = martialStatusId;
    }

    public String getMartialStatusName() {
        return martialStatusName;
    }

    public void setMartialStatusName(String martialStatusName) {
        this.martialStatusName = martialStatusName;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (martialStatusId != null ? martialStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MartialStatus)) {
            return false;
        }
        MartialStatus other = (MartialStatus) object;
        if ((this.martialStatusId == null && other.martialStatusId != null) || (this.martialStatusId != null && !this.martialStatusId.equals(other.martialStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.MartialStatus[ martialStatusId=" + martialStatusId + " ]";
    }
    
}
