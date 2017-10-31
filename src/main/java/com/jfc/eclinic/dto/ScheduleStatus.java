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
@Table(name = "ScheduleStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduleStatus.findAll", query = "SELECT s FROM ScheduleStatus s")
    , @NamedQuery(name = "ScheduleStatus.findByScheduleStatusId", query = "SELECT s FROM ScheduleStatus s WHERE s.scheduleStatusId = :scheduleStatusId")
    , @NamedQuery(name = "ScheduleStatus.findByStatusName", query = "SELECT s FROM ScheduleStatus s WHERE s.statusName = :statusName")})
public class ScheduleStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ScheduleStatusId")
    private Integer scheduleStatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "StatusName")
    private String statusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Schedule> scheduleCollection;

    public ScheduleStatus() {
    }

    public ScheduleStatus(Integer scheduleStatusId) {
        this.scheduleStatusId = scheduleStatusId;
    }

    public ScheduleStatus(Integer scheduleStatusId, String statusName) {
        this.scheduleStatusId = scheduleStatusId;
        this.statusName = statusName;
    }

    public Integer getScheduleStatusId() {
        return scheduleStatusId;
    }

    public void setScheduleStatusId(Integer scheduleStatusId) {
        this.scheduleStatusId = scheduleStatusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
        hash += (scheduleStatusId != null ? scheduleStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduleStatus)) {
            return false;
        }
        ScheduleStatus other = (ScheduleStatus) object;
        if ((this.scheduleStatusId == null && other.scheduleStatusId != null) || (this.scheduleStatusId != null && !this.scheduleStatusId.equals(other.scheduleStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.ScheduleStatus[ scheduleStatusId=" + scheduleStatusId + " ]";
    }
    
}
