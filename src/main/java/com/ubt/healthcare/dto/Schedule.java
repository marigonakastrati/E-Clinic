/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author F
 */
@Entity
@Table(name = "Schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findByStatus", query = "SELECT s FROM Schedule s WHERE s.status = :status")
    , @NamedQuery(name = "Schedule.findByDateStart", query = "SELECT s FROM Schedule s WHERE s.dateStart = :dateStart")
    , @NamedQuery(name = "Schedule.findByDateEnd", query = "SELECT s FROM Schedule s WHERE s.dateEnd = :dateEnd")
    , @NamedQuery(name = "Schedule.findByTimeStart", query = "SELECT s FROM Schedule s WHERE s.timeStart = :timeStart")
    , @NamedQuery(name = "Schedule.findByTimeEnd", query = "SELECT s FROM Schedule s WHERE s.timeEnd = :timeEnd")
    , @NamedQuery(name = "Schedule.findBySchedule", query = "SELECT s FROM Schedule s WHERE s.schedule = :schedule")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TimeStart")
    @Temporal(TemporalType.TIME)
    private Date timeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TimeEnd")
    @Temporal(TemporalType.TIME)
    private Date timeEnd;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Schedule")
    private Integer schedule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleId")
    private Collection<BookAppointment> bookAppointmentCollection;
    @JoinColumn(name = "DoctorId", referencedColumnName = "DoctorId")
    @ManyToOne(optional = false)
    private Doctor doctorId;
    @JoinColumn(name = "ManagerId", referencedColumnName = "ManagerId")
    @ManyToOne(optional = false)
    private HRManager managerId;

    public Schedule() {
    }

    public Schedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Schedule(Integer schedule, String status, Date dateStart, Date dateEnd, Date timeStart, Date timeEnd) {
        this.schedule = schedule;
        this.status = status;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    @XmlTransient
    public Collection<BookAppointment> getBookAppointmentCollection() {
        return bookAppointmentCollection;
    }

    public void setBookAppointmentCollection(Collection<BookAppointment> bookAppointmentCollection) {
        this.bookAppointmentCollection = bookAppointmentCollection;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public HRManager getManagerId() {
        return managerId;
    }

    public void setManagerId(HRManager managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schedule != null ? schedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.schedule == null && other.schedule != null) || (this.schedule != null && !this.schedule.equals(other.schedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.Schedule[ schedule=" + schedule + " ]";
    }
    
}
