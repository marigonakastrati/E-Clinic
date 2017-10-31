/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "receptionist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receptionist.findAll", query = "SELECT r FROM Receptionist r")
    , @NamedQuery(name = "Receptionist.findByPassCode", query = "SELECT r FROM Receptionist r WHERE r.passCode = :passCode")
    , @NamedQuery(name = "Receptionist.findByReceptionistId", query = "SELECT r FROM Receptionist r WHERE r.receptionistId = :receptionistId")})
public class Receptionist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "pass_code")
    private String passCode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "receptionist_id")
    private Integer receptionistId;
    @OneToMany(mappedBy = "receptionistID")
    private Collection<Billpayment> billpaymentCollection;
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Person personId;

    public Receptionist() {
    }

    public Receptionist(Integer receptionistId) {
        this.receptionistId = receptionistId;
    }

    public Receptionist(Integer receptionistId, String passCode) {
        this.receptionistId = receptionistId;
        this.passCode = passCode;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Integer getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(Integer receptionistId) {
        this.receptionistId = receptionistId;
    }

    @XmlTransient
    public Collection<Billpayment> getBillpaymentCollection() {
        return billpaymentCollection;
    }

    public void setBillpaymentCollection(Collection<Billpayment> billpaymentCollection) {
        this.billpaymentCollection = billpaymentCollection;
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
        return "com.jfc.eclinic.dto.Receptionist[ receptionistId=" + receptionistId + " ]";
    }
    
}
