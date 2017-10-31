/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "visit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v")
    , @NamedQuery(name = "Visit.findByDateTimeStart", query = "SELECT v FROM Visit v WHERE v.dateTimeStart = :dateTimeStart")
    , @NamedQuery(name = "Visit.findByDateTimeEnd", query = "SELECT v FROM Visit v WHERE v.dateTimeEnd = :dateTimeEnd")
    , @NamedQuery(name = "Visit.findByStatus", query = "SELECT v FROM Visit v WHERE v.status = :status")
    , @NamedQuery(name = "Visit.findByVisitId", query = "SELECT v FROM Visit v WHERE v.visitId = :visitId")})
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateTimeStart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateTimeEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VisitId")
    private Integer visitId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "visitId")
    private Billpayment billpayment;
    @JoinColumn(name = "BookId", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private Bookappointment bookId;
    @JoinColumn(name = "PrescriptionID", referencedColumnName = "prescription_id")
    @ManyToOne(optional = false)
    private Prescription prescriptionID;

    public Visit() {
    }

    public Visit(Integer visitId) {
        this.visitId = visitId;
    }

    public Visit(Integer visitId, Date dateTimeStart, Date dateTimeEnd, String status) {
        this.visitId = visitId;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.status = status;
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

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public Billpayment getBillpayment() {
        return billpayment;
    }

    public void setBillpayment(Billpayment billpayment) {
        this.billpayment = billpayment;
    }

    public Bookappointment getBookId() {
        return bookId;
    }

    public void setBookId(Bookappointment bookId) {
        this.bookId = bookId;
    }

    public Prescription getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(Prescription prescriptionID) {
        this.prescriptionID = prescriptionID;
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
        return "com.jfc.eclinic.dto.Visit[ visitId=" + visitId + " ]";
    }
    
}
