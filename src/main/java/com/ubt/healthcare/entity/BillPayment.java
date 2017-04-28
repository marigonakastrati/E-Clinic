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
    @NamedQuery(name = "BillPayment.findAll", query = "SELECT b FROM BillPayment b"),
    @NamedQuery(name = "BillPayment.findByDateOfPayment", query = "SELECT b FROM BillPayment b WHERE b.dateOfPayment = :dateOfPayment"),
    @NamedQuery(name = "BillPayment.findByBillPaymentId", query = "SELECT b FROM BillPayment b WHERE b.billPaymentId = :billPaymentId")})
public class BillPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_payment")
    @Temporal(TemporalType.DATE)
    private Date dateOfPayment;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bill_payment_id")
    private Integer billPaymentId;
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    @ManyToOne(optional = false)
    private Bill billId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "receptionist_id", referencedColumnName = "receptionist_id")
    @ManyToOne(optional = false)
    private Receptionist receptionistId;
    @JoinColumn(name = "visit_id", referencedColumnName = "visit_id")
    @OneToOne(optional = false)
    private Visit visitId;

    public BillPayment() {
    }

    public BillPayment(Integer billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    public BillPayment(Integer billPaymentId, Date dateOfPayment) {
        this.billPaymentId = billPaymentId;
        this.dateOfPayment = dateOfPayment;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
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

    public Receptionist getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(Receptionist receptionistId) {
        this.receptionistId = receptionistId;
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
        return "com.ubt.healthcare.entity.BillPayment[ billPaymentId=" + billPaymentId + " ]";
    }
    
}
