/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

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
 * @author F
 */
@Entity
@Table(name = "Guardian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guardian.findAll", query = "SELECT g FROM Guardian g"),
    @NamedQuery(name = "Guardian.findByGuardianId", query = "SELECT g FROM Guardian g WHERE g.guardianId = :guardianId")})
public class Guardian implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "guardian_id")
    private Integer guardianId;
    @JoinColumn(name = "child_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person childId;
    @JoinColumn(name = "parent_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person parentId;

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

    public Person getChildId() {
        return childId;
    }

    public void setChildId(Person childId) {
        this.childId = childId;
    }

    public Person getParentId() {
        return parentId;
    }

    public void setParentId(Person parentId) {
        this.parentId = parentId;
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
        return "com.ubt.healthcare.entity.Guardian[ guardianId=" + guardianId + " ]";
    }
    
}
