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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "PersonArchive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonArchive.findAll", query = "SELECT p FROM PersonArchive p")
    , @NamedQuery(name = "PersonArchive.findByFirstName", query = "SELECT p FROM PersonArchive p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "PersonArchive.findByMiddleName", query = "SELECT p FROM PersonArchive p WHERE p.middleName = :middleName")
    , @NamedQuery(name = "PersonArchive.findByLastName", query = "SELECT p FROM PersonArchive p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "PersonArchive.findByReligionId", query = "SELECT p FROM PersonArchive p WHERE p.religionId = :religionId")
    , @NamedQuery(name = "PersonArchive.findByGenderId", query = "SELECT p FROM PersonArchive p WHERE p.genderId = :genderId")
    , @NamedQuery(name = "PersonArchive.findByMartialStatusId", query = "SELECT p FROM PersonArchive p WHERE p.martialStatusId = :martialStatusId")
    , @NamedQuery(name = "PersonArchive.findByAddressId", query = "SELECT p FROM PersonArchive p WHERE p.addressId = :addressId")
    , @NamedQuery(name = "PersonArchive.findByPersonArchiveId", query = "SELECT p FROM PersonArchive p WHERE p.personArchiveId = :personArchiveId")
    , @NamedQuery(name = "PersonArchive.findByDateChanged", query = "SELECT p FROM PersonArchive p WHERE p.dateChanged = :dateChanged")})
public class PersonArchive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 20)
    @Column(name = "MiddleName")
    private String middleName;
    @Size(max = 20)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReligionId")
    private int religionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GenderId")
    private int genderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MartialStatusId")
    private int martialStatusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AddressId")
    private int addressId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonArchiveId")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer personArchiveId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateChanged")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateChanged;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;

    public PersonArchive() {
    }

    public PersonArchive(Integer personArchiveId) {
        this.personArchiveId = personArchiveId;
    }

    public PersonArchive(Integer personArchiveId, int religionId, int genderId, int martialStatusId, int addressId, Date dateChanged) {
        this.personArchiveId = personArchiveId;
        this.religionId = religionId;
        this.genderId = genderId;
        this.martialStatusId = martialStatusId;
        this.addressId = addressId;
        this.dateChanged = dateChanged;
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

    public int getReligionId() {
        return religionId;
    }

    public void setReligionId(int religionId) {
        this.religionId = religionId;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public int getMartialStatusId() {
        return martialStatusId;
    }

    public void setMartialStatusId(int martialStatusId) {
        this.martialStatusId = martialStatusId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Integer getPersonArchiveId() {
        return personArchiveId;
    }

    public void setPersonArchiveId(Integer personArchiveId) {
        this.personArchiveId = personArchiveId;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personArchiveId != null ? personArchiveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonArchive)) {
            return false;
        }
        PersonArchive other = (PersonArchive) object;
        if ((this.personArchiveId == null && other.personArchiveId != null) || (this.personArchiveId != null && !this.personArchiveId.equals(other.personArchiveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PersonArchive[ personArchiveId=" + personArchiveId + " ]";
    }

}
