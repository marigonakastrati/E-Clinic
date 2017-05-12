/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "BillPayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillPayment.findAll", query = "SELECT b FROM BillPayment b")
    , @NamedQuery(name = "BillPayment.findByDateOfPayment", query = "SELECT b FROM BillPayment b WHERE b.dateOfPayment = :dateOfPayment")
    , @NamedQuery(name = "BillPayment.findByBilled", query = "SELECT b FROM BillPayment b WHERE b.billed = :billed")
    , @NamedQuery(name = "BillPayment.findByBillPaymentId", query = "SELECT b FROM BillPayment b WHERE b.billPaymentId = :billPaymentId")})
public class BillPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "DateOfPayment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Billed")
    private boolean billed;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BillPaymentId")
    private Integer billPaymentId;
    @JoinColumn(name = "BillId", referencedColumnName = "BillId")
    @ManyToOne(optional = false)
    private Bill billId;
    @JoinColumn(name = "PatientId", referencedColumnName = "patient_id")
    @ManyToOne
    private Patient patientId;
    @JoinColumn(name = "ReceptionistID", referencedColumnName = "receptionist_id")
    @ManyToOne
    private Receptionist receptionistID;
    @JoinColumn(name = "VisitId", referencedColumnName = "VisitId")
    @OneToOne(optional = false)
    private Visit visitId;

    public BillPayment() {
    }

    public BillPayment(Integer billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    public BillPayment(Integer billPaymentId, boolean billed) {
        this.billPaymentId = billPaymentId;
        this.billed = billed;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public boolean getBilled() {
        return billed;
    }

    public void setBilled(boolean billed) {
        this.billed = billed;
    }

    public Integer getBillPaymentId() {
        return billPaymentId;
    }

    public void setBillPaymentId(Integer billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Receptionist getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(Receptionist receptionistID) {
        this.receptionistID = receptionistID;
    }

    public Visit getVisitId() {
        return visitId;
    }

    public void setVisitId(Visit visitId) {
        this.visitId = visitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billPaymentId != null ? billPaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillPayment)) {
            return false;
        }
        BillPayment other = (BillPayment) object;
        if ((this.billPaymentId == null && other.billPaymentId != null) || (this.billPaymentId != null && !this.billPaymentId.equals(other.billPaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.BillPayment[ billPaymentId=" + billPaymentId + " ]";
    }
    
}
