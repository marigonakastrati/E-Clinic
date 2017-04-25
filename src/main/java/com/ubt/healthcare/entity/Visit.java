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
@Table(name = "Visit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v"),
    @NamedQuery(name = "Visit.findByVisitId", query = "SELECT v FROM Visit v WHERE v.visitId = :visitId"),
    @NamedQuery(name = "Visit.findByDateTimeStart", query = "SELECT v FROM Visit v WHERE v.dateTimeStart = :dateTimeStart"),
    @NamedQuery(name = "Visit.findByDateTimeEnd", query = "SELECT v FROM Visit v WHERE v.dateTimeEnd = :dateTimeEnd"),
    @NamedQuery(name = "Visit.findByStatus", query = "SELECT v FROM Visit v WHERE v.status = :status")})
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit_id")
    private Integer visitId;
    @Column(name = "date_time_start")
    @Temporal(TemporalType.DATE)
    private Date dateTimeStart;
    @Column(name = "date_time_end")
    @Temporal(TemporalType.DATE)
    private Date dateTimeEnd;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    @ManyToOne(optional = false)
    private Bill billId;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private BookAppointment bookId;
    @JoinColumn(name = "prescription_id", referencedColumnName = "prescription_id")
    @ManyToOne(optional = false)
    private Prescription prescriptionId;

    public Visit() {
    }

    public Visit(Integer visitId) {
        this.visitId = visitId;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public Date getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(Date dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public Date getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(Date dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public BookAppointment getBookId() {
        return bookId;
    }

    public void setBookId(BookAppointment bookId) {
        this.bookId = bookId;
    }

    public Prescription getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Prescription prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitId != null ? visitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.visitId == null && other.visitId != null) || (this.visitId != null && !this.visitId.equals(other.visitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Visit[ visitId=" + visitId + " ]";
    }
    
}
