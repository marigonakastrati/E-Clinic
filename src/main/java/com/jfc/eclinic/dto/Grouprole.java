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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "grouprole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grouprole.findAll", query = "SELECT g FROM Grouprole g")
    , @NamedQuery(name = "Grouprole.findByUsrGroupRole", query = "SELECT g FROM Grouprole g WHERE g.usrGroupRole = :usrGroupRole")})
public class Grouprole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_group_role")
    private Integer usrGroupRole;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private Logingroup groupId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Applicationrole roleId;

    public Grouprole() {
    }

    public Grouprole(Integer usrGroupRole) {
        this.usrGroupRole = usrGroupRole;
    }

    public Integer getUsrGroupRole() {
        return usrGroupRole;
    }

    public void setUsrGroupRole(Integer usrGroupRole) {
        this.usrGroupRole = usrGroupRole;
    }

    public Logingroup getGroupId() {
        return groupId;
    }

    public void setGroupId(Logingroup groupId) {
        this.groupId = groupId;
    }

    public Applicationrole getRoleId() {
        return roleId;
    }

    public void setRoleId(Applicationrole roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrGroupRole != null ? usrGroupRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grouprole)) {
            return false;
        }
        Grouprole other = (Grouprole) object;
        if ((this.usrGroupRole == null && other.usrGroupRole != null) || (this.usrGroupRole != null && !this.usrGroupRole.equals(other.usrGroupRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Grouprole[ usrGroupRole=" + usrGroupRole + " ]";
    }
    
}
