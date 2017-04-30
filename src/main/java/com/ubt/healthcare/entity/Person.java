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
 * @author F
 */
@Entity
@Table(name = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person.findByMiddleName", query = "SELECT p FROM Person p WHERE p.middleName = :middleName"),
    @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Person.findByDob", query = "SELECT p FROM Person p WHERE p.dob = :dob"),
    @NamedQuery(name = "Person.findByBirthState", query = "SELECT p FROM Person p WHERE p.birthState = :birthState"),
    @NamedQuery(name = "Person.findByBirthTown", query = "SELECT p FROM Person p WHERE p.birthTown = :birthTown"),
    @NamedQuery(name = "Person.findByOccupation", query = "SELECT p FROM Person p WHERE p.occupation = :occupation"),
    @NamedQuery(name = "Person.findByNationalty", query = "SELECT p FROM Person p WHERE p.nationalty = :nationalty"),
    @NamedQuery(name = "Person.findByEthnicOrigin", query = "SELECT p FROM Person p WHERE p.ethnicOrigin = :ethnicOrigin"),
    @NamedQuery(name = "Person.findByMaritalStatuss", query = "SELECT p FROM Person p WHERE p.maritalStatuss = :maritalStatuss"),
    @NamedQuery(name = "Person.findByCountry", query = "SELECT p FROM Person p WHERE p.country = :country"),
    @NamedQuery(name = "Person.findByPostCode", query = "SELECT p FROM Person p WHERE p.postCode = :postCode")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "person_id")
    private Integer personId;
    @Size(max = 20)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 20)
    @Column(name = "middle_name")
    private String middleName;
    @Size(max = 20)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 15)
    @Column(name = "birth_state")
    private String birthState;
    @Size(max = 20)
    @Column(name = "birth_town")
    private String birthTown;
    @Size(max = 20)
    @Column(name = "occupation")
    private String occupation;
    @Size(max = 10)
    @Column(name = "nationalty")
    private String nationalty;
    @Size(max = 10)
    @Column(name = "ethnic_origin")
    private String ethnicOrigin;
    @Size(max = 15)
    @Column(name = "marital_statuss")
    private String maritalStatuss;
    @Size(max = 10)
    @Column(name = "country")
    private String country;
    @Size(max = 5)
    @Column(name = "post_code")
    private String postCode;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private AdminClinic adminClinic;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private PharmacyManager pharmacyManager;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<Guardian> guardianCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
    private Collection<Guardian> guardianCollection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Receptionist receptionist;
    @OneToOne(mappedBy = "personId")
    private HRManager hRManager;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<EmergencyInformation> emergencyInformationCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Doctor doctor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Contact> contactCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Pharmacist pharmacist;
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
    @ManyToOne(optional = false)
    private Gender genderId;
    @JoinColumn(name = "religion_ID", referencedColumnName = "religion_ID")
    @ManyToOne
    private Religion religionID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<PersonEducation> personEducationCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Nurse nurse;

    public Person() {
    }

    public Person(Integer personId) {
        this.personId = personId;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthTown() {
        return birthTown;
    }

    public void setBirthTown(String birthTown) {
        this.birthTown = birthTown;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationalty() {
        return nationalty;
    }

    public void setNationalty(String nationalty) {
        this.nationalty = nationalty;
    }

    public String getEthnicOrigin() {
        return ethnicOrigin;
    }

    public void setEthnicOrigin(String ethnicOrigin) {
        this.ethnicOrigin = ethnicOrigin;
    }

    public String getMaritalStatuss() {
        return maritalStatuss;
    }

    public void setMaritalStatuss(String maritalStatuss) {
        this.maritalStatuss = maritalStatuss;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public AdminClinic getAdminClinic() {
        return adminClinic;
    }

    public void setAdminClinic(AdminClinic adminClinic) {
        this.adminClinic = adminClinic;
    }

    public PharmacyManager getPharmacyManager() {
        return pharmacyManager;
    }

    public void setPharmacyManager(PharmacyManager pharmacyManager) {
        this.pharmacyManager = pharmacyManager;
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

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public HRManager getHRManager() {
        return hRManager;
    }

    public void setHRManager(HRManager hRManager) {
        this.hRManager = hRManager;
    }

    @XmlTransient
    public Collection<EmergencyInformation> getEmergencyInformationCollection() {
        return emergencyInformationCollection;
    }

    public void setEmergencyInformationCollection(Collection<EmergencyInformation> emergencyInformationCollection) {
        this.emergencyInformationCollection = emergencyInformationCollection;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @XmlTransient
    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public Religion getReligionID() {
        return religionID;
    }

    public void setReligionID(Religion religionID) {
        this.religionID = religionID;
    }

    @XmlTransient
    public Collection<PersonEducation> getPersonEducationCollection() {
        return personEducationCollection;
    }

    public void setPersonEducationCollection(Collection<PersonEducation> personEducationCollection) {
        this.personEducationCollection = personEducationCollection;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
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
        return "com.ubt.healthcare.entity.Person[ personId=" + personId + " ]";
    }
    
}
