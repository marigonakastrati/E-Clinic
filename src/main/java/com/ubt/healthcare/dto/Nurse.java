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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "Nurse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nurse.findAll", query = "SELECT n FROM Nurse n")
    , @NamedQuery(name = "Nurse.findByPassCode", query = "SELECT n FROM Nurse n WHERE n.passCode = :passCode")
    , @NamedQuery(name = "Nurse.findByNurseId", query = "SELECT n FROM Nurse n WHERE n.nurseId = :nurseId")})
public class Nurse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "PassCode")
    private String passCode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NurseId")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer nurseId;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @OneToOne(optional = false)
    private Person personId;

    public Nurse() {
    }

    public Nurse(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public Nurse(Integer nurseId, String passCode) {
        this.nurseId = nurseId;
        this.passCode = passCode;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
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
        hash += (nurseId != null ? nurseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nurse)) {
            return false;
        }
        Nurse other = (Nurse) object;
        if ((this.nurseId == null && other.nurseId != null) || (this.nurseId != null && !this.nurseId.equals(other.nurseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.Nurse[ nurseId=" + nurseId + " ]";
    }

}
