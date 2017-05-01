/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author F
 */
@Entity
@Table(name = "ApplicationRole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationRole.findAll", query = "SELECT a FROM ApplicationRole a"),
    @NamedQuery(name = "ApplicationRole.findByRoleCode", query = "SELECT a FROM ApplicationRole a WHERE a.roleCode = :roleCode"),
    @NamedQuery(name = "ApplicationRole.findByRoleName", query = "SELECT a FROM ApplicationRole a WHERE a.roleName = :roleName"),
    @NamedQuery(name = "ApplicationRole.findByRoleId", query = "SELECT a FROM ApplicationRole a WHERE a.roleId = :roleId")})
public class ApplicationRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "role_code")
    private String roleCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "role_name")
    private String roleName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private Integer roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<GroupRole> groupRoleCollection;

    public ApplicationRole() {
    }

    public ApplicationRole(Integer roleId) {
        this.roleId = roleId;
    }

    public ApplicationRole(Integer roleId, String roleCode, String roleName) {
        this.roleId = roleId;
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public Collection<GroupRole> getGroupRoleCollection() {
        return groupRoleCollection;
    }

    public void setGroupRoleCollection(Collection<GroupRole> groupRoleCollection) {
        this.groupRoleCollection = groupRoleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationRole)) {
            return false;
        }
        ApplicationRole other = (ApplicationRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.ApplicationRole[ roleId=" + roleId + " ]";
    }
    
}
