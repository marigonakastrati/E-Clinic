/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author jfc
 */
@Entity
@Table(name = "applicationrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applicationrole.findAll", query = "SELECT a FROM Applicationrole a")
    , @NamedQuery(name = "Applicationrole.findByRoleCode", query = "SELECT a FROM Applicationrole a WHERE a.roleCode = :roleCode")
    , @NamedQuery(name = "Applicationrole.findByRoleName", query = "SELECT a FROM Applicationrole a WHERE a.roleName = :roleName")
    , @NamedQuery(name = "Applicationrole.findByRoleId", query = "SELECT a FROM Applicationrole a WHERE a.roleId = :roleId")})
public class Applicationrole implements Serializable {

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<Grouprole> grouproleCollection;

    public Applicationrole() {
    }

    public Applicationrole(Integer roleId) {
        this.roleId = roleId;
    }

    public Applicationrole(Integer roleId, String roleCode, String roleName) {
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
    public Collection<Grouprole> getGrouproleCollection() {
        return grouproleCollection;
    }

    public void setGrouproleCollection(Collection<Grouprole> grouproleCollection) {
        this.grouproleCollection = grouproleCollection;
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
        if (!(object instanceof Applicationrole)) {
            return false;
        }
        Applicationrole other = (Applicationrole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Applicationrole[ roleId=" + roleId + " ]";
    }
    
}
