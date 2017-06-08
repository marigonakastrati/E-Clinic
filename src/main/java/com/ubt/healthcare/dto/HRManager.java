/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "HRManager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HRManager.findAll", query = "SELECT h FROM HRManager h")
    , @NamedQuery(name = "HRManager.findByPassCode", query = "SELECT h FROM HRManager h WHERE h.passCode = :passCode")
    , @NamedQuery(name = "HRManager.findByManagerId", query = "SELECT h FROM HRManager h WHERE h.managerId = :managerId")})
public class HRManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "PassCode")
    private String passCode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ManagerId")
    private Integer managerId;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @OneToOne
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "managerId")
    private Collection<Schedule> scheduleCollection;

    public HRManager() {
    }

    public HRManager(Integer managerId) {
        this.managerId = managerId;
    }

    public HRManager(Integer managerId, String passCode) {
        this.managerId = managerId;
        this.passCode = passCode;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managerId != null ? managerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HRManager)) {
            return false;
        }
        HRManager other = (HRManager) object;
        if ((this.managerId == null && other.managerId != null) || (this.managerId != null && !this.managerId.equals(other.managerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.HRManager[ managerId=" + managerId + " ]";
    }
    
}
