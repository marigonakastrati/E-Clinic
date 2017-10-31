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
 * @author jfc
 */
@Entity
@Table(name = "skin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skin.findAll", query = "SELECT s FROM Skin s")
    , @NamedQuery(name = "Skin.findBySkinId", query = "SELECT s FROM Skin s WHERE s.skinId = :skinId")
    , @NamedQuery(name = "Skin.findByName", query = "SELECT s FROM Skin s WHERE s.name = :name")})
public class Skin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "skin_id")
    private Integer skinId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skinId")
    private Collection<Patientskinhx> patientskinhxCollection;

    public Skin() {
    }

    public Skin(Integer skinId) {
        this.skinId = skinId;
    }

    public Skin(Integer skinId, String name) {
        this.skinId = skinId;
        this.name = name;
    }

    public Integer getSkinId() {
        return skinId;
    }

    public void setSkinId(Integer skinId) {
        this.skinId = skinId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Patientskinhx> getPatientskinhxCollection() {
        return patientskinhxCollection;
    }

    public void setPatientskinhxCollection(Collection<Patientskinhx> patientskinhxCollection) {
        this.patientskinhxCollection = patientskinhxCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skinId != null ? skinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skin)) {
            return false;
        }
        Skin other = (Skin) object;
        if ((this.skinId == null && other.skinId != null) || (this.skinId != null && !this.skinId.equals(other.skinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Skin[ skinId=" + skinId + " ]";
    }
    
}
