/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "Religion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Religion.findAll", query = "SELECT r FROM Religion r"),
    @NamedQuery(name = "Religion.findByReligionID", query = "SELECT r FROM Religion r WHERE r.religionID = :religionID"),
    @NamedQuery(name = "Religion.findByName", query = "SELECT r FROM Religion r WHERE r.name = :name")})
public class Religion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "religion_ID")
    private Integer religionID;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "religionID")
    private Collection<Person> personCollection;

    public Religion() {
    }

    public Religion(Integer religionID) {
        this.religionID = religionID;
    }

    public Integer getReligionID() {
        return religionID;
    }

    public void setReligionID(Integer religionID) {
        this.religionID = religionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (religionID != null ? religionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Religion)) {
            return false;
        }
        Religion other = (Religion) object;
        if ((this.religionID == null && other.religionID != null) || (this.religionID != null && !this.religionID.equals(other.religionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Religion[ religionID=" + religionID + " ]";
    }
    
}
