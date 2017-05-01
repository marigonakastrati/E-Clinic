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
import javax.persistence.ManyToOne;
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
@Table(name = "Patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByPassCode", query = "SELECT p FROM Patient p WHERE p.passCode = :passCode"),
    @NamedQuery(name = "Patient.findByPatientId", query = "SELECT p FROM Patient p WHERE p.patientId = :patientId")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "pass_code")
    private String passCode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_id")
    private Integer patientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<BillPayment> billPaymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Alergis> alergisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<BookAppointment> bookAppointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Order1> order1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<EmergencyInformation> emergencyInformationCollection;
    @JoinColumn(name = "occupation_id", referencedColumnName = "occupation_id")
    @ManyToOne(optional = false)
    private Occupation occupationId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @OneToOne(optional = false)
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Vitals> vitalsCollection;

    public Patient() {
    }

    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    public Patient(Integer patientId, String passCode) {
        this.patientId = patientId;
        this.passCode = passCode;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @XmlTransient
    public Collection<BillPayment> getBillPaymentCollection() {
        return billPaymentCollection;
    }

    public void setBillPaymentCollection(Collection<BillPayment> billPaymentCollection) {
        this.billPaymentCollection = billPaymentCollection;
    }

    @XmlTransient
    public Collection<Alergis> getAlergisCollection() {
        return alergisCollection;
    }

    public void setAlergisCollection(Collection<Alergis> alergisCollection) {
        this.alergisCollection = alergisCollection;
    }

    @XmlTransient
    public Collection<BookAppointment> getBookAppointmentCollection() {
        return bookAppointmentCollection;
    }

    public void setBookAppointmentCollection(Collection<BookAppointment> bookAppointmentCollection) {
        this.bookAppointmentCollection = bookAppointmentCollection;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @XmlTransient
    public Collection<EmergencyInformation> getEmergencyInformationCollection() {
        return emergencyInformationCollection;
    }

    public void setEmergencyInformationCollection(Collection<EmergencyInformation> emergencyInformationCollection) {
        this.emergencyInformationCollection = emergencyInformationCollection;
    }

    public Occupation getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Occupation occupationId) {
        this.occupationId = occupationId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Collection<Vitals> getVitalsCollection() {
        return vitalsCollection;
    }

    public void setVitalsCollection(Collection<Vitals> vitalsCollection) {
        this.vitalsCollection = vitalsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Patient[ patientId=" + patientId + " ]";
    }
    
}
