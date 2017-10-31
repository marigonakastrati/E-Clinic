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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId")
    , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Person.findByMiddleName", query = "SELECT p FROM Person p WHERE p.middleName = :middleName")
    , @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Person.findByDateOfBirth", query = "SELECT p FROM Person p WHERE p.dateOfBirth = :dateOfBirth")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonId")
    private Integer personId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 40)
    @Column(name = "MiddleName")
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Pharmacist> pharmacistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Contact> contactCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<PharmacyManager> pharmacyManagerCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Adminclinic adminclinic;
    @JoinColumn(name = "AddressId", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address addressId;
    @JoinColumn(name = "BirthCityId", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City birthCityId;
    @JoinColumn(name = "GenderId", referencedColumnName = "gender_id")
    @ManyToOne(optional = false)
    private Gender genderId;
    @JoinColumn(name = "MartialStatusId", referencedColumnName = "MartialStatusId")
    @ManyToOne(optional = false)
    private Martialstatus martialStatusId;
    @JoinColumn(name = "ReigionId", referencedColumnName = "religion_id")
    @ManyToOne(optional = false)
    private Religion reigionId;
    @OneToOne(mappedBy = "personId")
    private Hrmanager hrmanager;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Receptionist> receptionistCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Nurse nurse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Personarchive> personarchiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentID")
    private Collection<Guardian> guardianCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<Guardian> guardianCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<EmergencyInformation> emergencyInformationCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Doctor doctor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Personeducation> personeducationCollection;

    public Person() {
    }

    public Person(Integer personId) {
        this.personId = personId;
    }

    public Person(Integer personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @XmlTransient
    public Collection<Pharmacist> getPharmacistCollection() {
        return pharmacistCollection;
    }

    public void setPharmacistCollection(Collection<Pharmacist> pharmacistCollection) {
        this.pharmacistCollection = pharmacistCollection;
    }

    @XmlTransient
    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
    }

    @XmlTransient
    public Collection<PharmacyManager> getPharmacyManagerCollection() {
        return pharmacyManagerCollection;
    }

    public void setPharmacyManagerCollection(Collection<PharmacyManager> pharmacyManagerCollection) {
        this.pharmacyManagerCollection = pharmacyManagerCollection;
    }

    public Adminclinic getAdminclinic() {
        return adminclinic;
    }

    public void setAdminclinic(Adminclinic adminclinic) {
        this.adminclinic = adminclinic;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public City getBirthCityId() {
        return birthCityId;
    }

    public void setBirthCityId(City birthCityId) {
        this.birthCityId = birthCityId;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public Martialstatus getMartialStatusId() {
        return martialStatusId;
    }

    public void setMartialStatusId(Martialstatus martialStatusId) {
        this.martialStatusId = martialStatusId;
    }

    public Religion getReigionId() {
        return reigionId;
    }

    public void setReigionId(Religion reigionId) {
        this.reigionId = reigionId;
    }

    public Hrmanager getHrmanager() {
        return hrmanager;
    }

    public void setHrmanager(Hrmanager hrmanager) {
        this.hrmanager = hrmanager;
    }

    @XmlTransient
    public Collection<Receptionist> getReceptionistCollection() {
        return receptionistCollection;
    }

    public void setReceptionistCollection(Collection<Receptionist> receptionistCollection) {
        this.receptionistCollection = receptionistCollection;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    @XmlTransient
    public Collection<Personarchive> getPersonarchiveCollection() {
        return personarchiveCollection;
    }

    public void setPersonarchiveCollection(Collection<Personarchive> personarchiveCollection) {
        this.personarchiveCollection = personarchiveCollection;
    }

    @XmlTransient
    public Collection<Guardian> getGuardianCollection() {
        return guardianCollection;
    }

    public void setGuardianCollection(Collection<Guardian> guardianCollection) {
        this.guardianCollection = guardianCollection;
    }

    @XmlTransient
    public Collection<Guardian> getGuardianCollection1() {
        return guardianCollection1;
    }

    public void setGuardianCollection1(Collection<Guardian> guardianCollection1) {
        this.guardianCollection1 = guardianCollection1;
    }

    @XmlTransient
    public Collection<EmergencyInformation> getEmergencyInformationCollection() {
        return emergencyInformationCollection;
    }

    public void setEmergencyInformationCollection(Collection<EmergencyInformation> emergencyInformationCollection) {
        this.emergencyInformationCollection = emergencyInformationCollection;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @XmlTransient
    public Collection<Personeducation> getPersoneducationCollection() {
        return personeducationCollection;
    }

    public void setPersoneducationCollection(Collection<Personeducation> personeducationCollection) {
        this.personeducationCollection = personeducationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Person[ personId=" + personId + " ]";
    }
    
}
