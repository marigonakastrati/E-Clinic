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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "Address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByPostCode", query = "SELECT a FROM Address a WHERE a.postCode = :postCode"),
    @NamedQuery(name = "Address.findByStreetName", query = "SELECT a FROM Address a WHERE a.streetName = :streetName"),
    @NamedQuery(name = "Address.findByAppartmentNo", query = "SELECT a FROM Address a WHERE a.appartmentNo = :appartmentNo"),
    @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 15)
    @Column(name = "post_code")
    private String postCode;
    @Size(max = 256)
    @Column(name = "street_name")
    private String streetName;
    @Size(max = 25)
    @Column(name = "appartment_no")
    private String appartmentNo;
    @Id
    @Basic(optional = false)
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    @Column(name = "address_id")
    private Integer addressId;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Person> personCollection;

    public Address() {
    }

    public Address(Integer addressId) {
        this.addressId = addressId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAppartmentNo() {
        return appartmentNo;
    }

    public void setAppartmentNo(String appartmentNo) {
        this.appartmentNo = appartmentNo;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Address[ addressId=" + addressId + " ]";
    }
    
}
