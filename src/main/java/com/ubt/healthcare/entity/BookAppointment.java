/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

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
@Table(name = "BookAppointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookAppointment.findAll", query = "SELECT b FROM BookAppointment b"),
    @NamedQuery(name = "BookAppointment.findByBookId", query = "SELECT b FROM BookAppointment b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "BookAppointment.findByDateBooked", query = "SELECT b FROM BookAppointment b WHERE b.dateBooked = :dateBooked"),
    @NamedQuery(name = "BookAppointment.findByTimeBooked", query = "SELECT b FROM BookAppointment b WHERE b.timeBooked = :timeBooked"),
    @NamedQuery(name = "BookAppointment.findByStatus", query = "SELECT b FROM BookAppointment b WHERE b.status = :status")})
public class BookAppointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "date_booked")
    @Temporal(TemporalType.DATE)
    private Date dateBooked;
    @Column(name = "time_booked")
    @Temporal(TemporalType.TIME)
    private Date timeBooked;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Collection<Visit> visitCollection;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id")
    @ManyToOne(optional = false)
    private Schedule scheduleId;

    public BookAppointment() {
    }

    public BookAppointment(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Date dateBooked) {
        this.dateBooked = dateBooked;
    }

    public Date getTimeBooked() {
        return timeBooked;
    }

    public void setTimeBooked(Date timeBooked) {
        this.timeBooked = timeBooked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Visit> getVisitCollection() {
        return visitCollection;
    }

    public void setVisitCollection(Collection<Visit> visitCollection) {
        this.visitCollection = visitCollection;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Schedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Schedule scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookAppointment)) {
            return false;
        }
        BookAppointment other = (BookAppointment) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.BookAppointment[ bookId=" + bookId + " ]";
    }
    
}
