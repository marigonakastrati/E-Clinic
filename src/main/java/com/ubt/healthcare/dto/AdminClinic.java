/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "AdminClinic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminClinic.findAll", query = "SELECT a FROM AdminClinic a"),
    @NamedQuery(name = "AdminClinic.findByPassCode", query = "SELECT a FROM AdminClinic a WHERE a.passCode = :passCode"),
    @NamedQuery(name = "AdminClinic.findByAdminClinicId", query = "SELECT a FROM AdminClinic a WHERE a.adminClinicId = :adminClinicId")})
public class AdminClinic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "pass_code")
    private String passCode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin_clinic_id")
    private Integer adminClinicId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @OneToOne(optional = false)
    private Person personId;

    public AdminClinic() {
    }

    public AdminClinic(Integer adminClinicId) {
        this.adminClinicId = adminClinicId;
    }

    public AdminClinic(Integer adminClinicId, String passCode) {
        this.adminClinicId = adminClinicId;
        this.passCode = passCode;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Integer getAdminClinicId() {
        return adminClinicId;
    }

    public void setAdminClinicId(Integer adminClinicId) {
        this.adminClinicId = adminClinicId;
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
        hash += (adminClinicId != null ? adminClinicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminClinic)) {
            return false;
        }
        AdminClinic other = (AdminClinic) object;
        if ((this.adminClinicId == null && other.adminClinicId != null) || (this.adminClinicId != null && !this.adminClinicId.equals(other.adminClinicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.AdminClinic[ adminClinicId=" + adminClinicId + " ]";
    }
    
}
