/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
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
@Table(name = "Schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByScheduleId", query = "SELECT s FROM Schedule s WHERE s.scheduleId = :scheduleId"),
    @NamedQuery(name = "Schedule.findByStatus", query = "SELECT s FROM Schedule s WHERE s.status = :status"),
    @NamedQuery(name = "Schedule.findByDateStart", query = "SELECT s FROM Schedule s WHERE s.dateStart = :dateStart"),
    @NamedQuery(name = "Schedule.findByDateEnd", query = "SELECT s FROM Schedule s WHERE s.dateEnd = :dateEnd"),
    @NamedQuery(name = "Schedule.findByTimeStart", query = "SELECT s FROM Schedule s WHERE s.timeStart = :timeStart"),
    @NamedQuery(name = "Schedule.findByTimeEnd", query = "SELECT s FROM Schedule s WHERE s.timeEnd = :timeEnd")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "schedule_id")
    private Integer scheduleId;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Column(name = "time_start")
    @Temporal(TemporalType.TIME)
    private Date timeStart;
    @Column(name = "time_end")
    @Temporal(TemporalType.TIME)
    private Date timeEnd;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "scheduleId")
    private BookAppointment bookAppointment;
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false)
    private Doctor doctorId;
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    @ManyToOne(optional = false)
    private HRManager managerId;

    public Schedule() {
    }

    public Schedule(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
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

    public BookAppointment getBookAppointment() {
        return bookAppointment;
    }

    public void setBookAppointment(BookAppointment bookAppointment) {
        this.bookAppointment = bookAppointment;
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
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Schedule[ scheduleId=" + scheduleId + " ]";
    }
    
}
