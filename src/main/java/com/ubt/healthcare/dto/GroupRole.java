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
@Table(name = "GroupRole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupRole.findAll", query = "SELECT g FROM GroupRole g")
    , @NamedQuery(name = "GroupRole.findByUsrGroupRole", query = "SELECT g FROM GroupRole g WHERE g.usrGroupRole = :usrGroupRole")})
public class GroupRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_group_role")
    private Integer usrGroupRole;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private ApplicationRole roleId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private LoginGroup groupId;

    public GroupRole() {
    }

    public GroupRole(Integer usrGroupRole) {
        this.usrGroupRole = usrGroupRole;
    }

    public Integer getUsrGroupRole() {
        return usrGroupRole;
    }

    public void setUsrGroupRole(Integer usrGroupRole) {
        this.usrGroupRole = usrGroupRole;
    }

    public ApplicationRole getRoleId() {
        return roleId;
    }

    public void setRoleId(ApplicationRole roleId) {
        this.roleId = roleId;
    }

    public LoginGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(LoginGroup groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof GroupRole)) {
            return false;
        }
        GroupRole other = (GroupRole) object;
        if ((this.usrGroupRole == null && other.usrGroupRole != null) || (this.usrGroupRole != null && !this.usrGroupRole.equals(other.usrGroupRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.GroupRole[ usrGroupRole=" + usrGroupRole + " ]";
    }
    
}
