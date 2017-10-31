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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Gender")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g")
    , @NamedQuery(name = "Gender.findByGenderId", query = "SELECT g FROM Gender g WHERE g.genderId = :genderId")
    , @NamedQuery(name = "Gender.findByGenderName", query = "SELECT g FROM Gender g WHERE g.genderName = :genderName")})
public class Gender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender_id")
    private Integer genderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "gender_name")
    private String genderName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genderId")
    private Collection<Person> personCollection;

    public Gender() {
    }

    public Gender(Integer genderId) {
        this.genderId = genderId;
    }

    public Gender(Integer genderId, String genderName) {
        this.genderId = genderId;
        this.genderName = genderName;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
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
        hash += (genderId != null ? genderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gender)) {
            return false;
        }
        Gender other = (Gender) object;
        if ((this.genderId == null && other.genderId != null) || (this.genderId != null && !this.genderId.equals(other.genderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.Gender[ genderId=" + genderId + " ]";
    }
    
}
