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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "usergroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usergroup.findAll", query = "SELECT u FROM Usergroup u")
    , @NamedQuery(name = "Usergroup.findByUserId", query = "SELECT u FROM Usergroup u WHERE u.userId = :userId")
    , @NamedQuery(name = "Usergroup.findByUsrGroupId", query = "SELECT u FROM Usergroup u WHERE u.usrGroupId = :usrGroupId")})
public class Usergroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_group_id")
    private Integer usrGroupId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne
    private Logingroup groupId;

    public Usergroup() {
    }

    public Usergroup(Integer usrGroupId) {
        this.usrGroupId = usrGroupId;
    }

    public Usergroup(Integer usrGroupId, int userId) {
        this.usrGroupId = usrGroupId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getUsrGroupId() {
        return usrGroupId;
    }

    public void setUsrGroupId(Integer usrGroupId) {
        this.usrGroupId = usrGroupId;
    }

    public Logingroup getGroupId() {
        return groupId;
    }

    public void setGroupId(Logingroup groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrGroupId != null ? usrGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergroup)) {
            return false;
        }
        Usergroup other = (Usergroup) object;
        if ((this.usrGroupId == null && other.usrGroupId != null) || (this.usrGroupId != null && !this.usrGroupId.equals(other.usrGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Usergroup[ usrGroupId=" + usrGroupId + " ]";
    }
    
}
