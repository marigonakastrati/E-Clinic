/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "guardian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guardian.findAll", query = "SELECT g FROM Guardian g")
    , @NamedQuery(name = "Guardian.findByGuardianId", query = "SELECT g FROM Guardian g WHERE g.guardianId = :guardianId")})
public class Guardian implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GuardianId")
    private Integer guardianId;
    @JoinColumn(name = "ParentID", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person parentID;
    @JoinColumn(name = "ChildId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person childId;

    public Guardian() {
    }

    public Guardian(Integer guardianId) {
        this.guardianId = guardianId;
    }

    public Integer getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(Integer guardianId) {
        this.guardianId = guardianId;
    }

    public Person getParentID() {
        return parentID;
    }

    public void setParentID(Person parentID) {
        this.parentID = parentID;
    }

    public Person getChildId() {
        return childId;
    }

    public void setChildId(Person childId) {
        this.childId = childId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guardianId != null ? guardianId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guardian)) {
            return false;
        }
        Guardian other = (Guardian) object;
        if ((this.guardianId == null && other.guardianId != null) || (this.guardianId != null && !this.guardianId.equals(other.guardianId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Guardian[ guardianId=" + guardianId + " ]";
    }
    
}
