/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "bookappointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookappointment.findAll", query = "SELECT b FROM Bookappointment b")
    , @NamedQuery(name = "Bookappointment.findByDateBooked", query = "SELECT b FROM Bookappointment b WHERE b.dateBooked = :dateBooked")
    , @NamedQuery(name = "Bookappointment.findByTimeBooked", query = "SELECT b FROM Bookappointment b WHERE b.timeBooked = :timeBooked")
    , @NamedQuery(name = "Bookappointment.findByStatus", query = "SELECT b FROM Bookappointment b WHERE b.status = :status")
    , @NamedQuery(name = "Bookappointment.findByBookId", query = "SELECT b FROM Bookappointment b WHERE b.bookId = :bookId")})
public class Bookappointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "DateBooked")
    @Temporal(TemporalType.DATE)
    private Date dateBooked;
    @Column(name = "TimeBooked")
    @Temporal(TemporalType.TIME)
    private Date timeBooked;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @JoinColumn(name = "PatientId", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "ScheduleId", referencedColumnName = "Schedule")
    @ManyToOne(optional = false)
    private Schedule scheduleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Collection<Visit> visitCollection;

    public Bookappointment() {
    }

    public Bookappointment(Integer bookId) {
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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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

    @XmlTransient
    public Collection<Visit> getVisitCollection() {
        return visitCollection;
    }

    public void setVisitCollection(Collection<Visit> visitCollection) {
        this.visitCollection = visitCollection;
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
        if (!(object instanceof Bookappointment)) {
            return false;
        }
        Bookappointment other = (Bookappointment) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Bookappointment[ bookId=" + bookId + " ]";
    }
    
}
