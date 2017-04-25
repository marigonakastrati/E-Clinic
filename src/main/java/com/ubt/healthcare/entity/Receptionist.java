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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "Receptionist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receptionist.findAll", query = "SELECT r FROM Receptionist r"),
    @NamedQuery(name = "Receptionist.findByReceptionistId", query = "SELECT r FROM Receptionist r WHERE r.receptionistId = :receptionistId")})
public class Receptionist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "receptionist_id")
    private Integer receptionistId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @OneToOne(optional = false)
    private Person personId;

    public Receptionist() {
    }

    public Receptionist(Integer receptionistId) {
        this.receptionistId = receptionistId;
    }

    public Integer getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(Integer receptionistId) {
        this.receptionistId = receptionistId;
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
        hash += (receptionistId != null ? receptionistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receptionist)) {
            return false;
        }
        Receptionist other = (Receptionist) object;
        if ((this.receptionistId == null && other.receptionistId != null) || (this.receptionistId != null && !this.receptionistId.equals(other.receptionistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.Receptionist[ receptionistId=" + receptionistId + " ]";
    }
    
}
