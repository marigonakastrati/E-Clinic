/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByPassCode", query = "SELECT p FROM Patient p WHERE p.passCode = :passCode")
    , @NamedQuery(name = "Patient.findByPatientId", query = "SELECT p FROM Patient p WHERE p.patientId = :patientId")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "pass_code")
    private String passCode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id")
    private Integer patientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientvaccinehx> patientvaccinehxCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientmentalhealthhx> patientmentalhealthhxCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Order1> order1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientmedicineallergy> patientmedicineallergyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientsurgicalhx> patientsurgicalhxCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientvitalhx> patientvitalhxCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientinfectiousdiseasehx> patientinfectiousdiseasehxCollection;
    @OneToMany(mappedBy = "patientId")
    private Collection<Billpayment> billpaymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientrelative> patientrelativeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relativeId")
    private Collection<Patientrelative> patientrelativeCollection1;
    @JoinColumn(name = "occupation_id", referencedColumnName = "occupation_id")
    @ManyToOne(optional = false)
    private Occupation occupationId;
    @JoinColumn(name = "person_id", referencedColumnName = "PersonId")
    @OneToOne(optional = false)
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Bookappointment> bookappointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientskinhx> patientskinhxCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<EmergencyInformation> emergencyInformationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Patientfoodallergylhx> patientfoodallergylhxCollection;

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
    public Collection<Patientvaccinehx> getPatientvaccinehxCollection() {
        return patientvaccinehxCollection;
    }

    public void setPatientvaccinehxCollection(Collection<Patientvaccinehx> patientvaccinehxCollection) {
        this.patientvaccinehxCollection = patientvaccinehxCollection;
    }

    @XmlTransient
    public Collection<Patientmentalhealthhx> getPatientmentalhealthhxCollection() {
        return patientmentalhealthhxCollection;
    }

    public void setPatientmentalhealthhxCollection(Collection<Patientmentalhealthhx> patientmentalhealthhxCollection) {
        this.patientmentalhealthhxCollection = patientmentalhealthhxCollection;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @XmlTransient
    public Collection<Patientmedicineallergy> getPatientmedicineallergyCollection() {
        return patientmedicineallergyCollection;
    }

    public void setPatientmedicineallergyCollection(Collection<Patientmedicineallergy> patientmedicineallergyCollection) {
        this.patientmedicineallergyCollection = patientmedicineallergyCollection;
    }

    @XmlTransient
    public Collection<Patientsurgicalhx> getPatientsurgicalhxCollection() {
        return patientsurgicalhxCollection;
    }

    public void setPatientsurgicalhxCollection(Collection<Patientsurgicalhx> patientsurgicalhxCollection) {
        this.patientsurgicalhxCollection = patientsurgicalhxCollection;
    }

    @XmlTransient
    public Collection<Patientvitalhx> getPatientvitalhxCollection() {
        return patientvitalhxCollection;
    }

    public void setPatientvitalhxCollection(Collection<Patientvitalhx> patientvitalhxCollection) {
        this.patientvitalhxCollection = patientvitalhxCollection;
    }

    @XmlTransient
    public Collection<Patientinfectiousdiseasehx> getPatientinfectiousdiseasehxCollection() {
        return patientinfectiousdiseasehxCollection;
    }

    public void setPatientinfectiousdiseasehxCollection(Collection<Patientinfectiousdiseasehx> patientinfectiousdiseasehxCollection) {
        this.patientinfectiousdiseasehxCollection = patientinfectiousdiseasehxCollection;
    }

    @XmlTransient
    public Collection<Billpayment> getBillpaymentCollection() {
        return billpaymentCollection;
    }

    public void setBillpaymentCollection(Collection<Billpayment> billpaymentCollection) {
        this.billpaymentCollection = billpaymentCollection;
    }

    @XmlTransient
    public Collection<Patientrelative> getPatientrelativeCollection() {
        return patientrelativeCollection;
    }

    public void setPatientrelativeCollection(Collection<Patientrelative> patientrelativeCollection) {
        this.patientrelativeCollection = patientrelativeCollection;
    }

    @XmlTransient
    public Collection<Patientrelative> getPatientrelativeCollection1() {
        return patientrelativeCollection1;
    }

    public void setPatientrelativeCollection1(Collection<Patientrelative> patientrelativeCollection1) {
        this.patientrelativeCollection1 = patientrelativeCollection1;
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
    public Collection<Bookappointment> getBookappointmentCollection() {
        return bookappointmentCollection;
    }

    public void setBookappointmentCollection(Collection<Bookappointment> bookappointmentCollection) {
        this.bookappointmentCollection = bookappointmentCollection;
    }

    @XmlTransient
    public Collection<Patientskinhx> getPatientskinhxCollection() {
        return patientskinhxCollection;
    }

    public void setPatientskinhxCollection(Collection<Patientskinhx> patientskinhxCollection) {
        this.patientskinhxCollection = patientskinhxCollection;
    }

    @XmlTransient
    public Collection<EmergencyInformation> getEmergencyInformationCollection() {
        return emergencyInformationCollection;
    }

    public void setEmergencyInformationCollection(Collection<EmergencyInformation> emergencyInformationCollection) {
        this.emergencyInformationCollection = emergencyInformationCollection;
    }

    @XmlTransient
    public Collection<Patientfoodallergylhx> getPatientfoodallergylhxCollection() {
        return patientfoodallergylhxCollection;
    }

    public void setPatientfoodallergylhxCollection(Collection<Patientfoodallergylhx> patientfoodallergylhxCollection) {
        this.patientfoodallergylhxCollection = patientfoodallergylhxCollection;
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
        return "com.jfc.eclinic.dto.Patient[ patientId=" + patientId + " ]";
    }
    
}
