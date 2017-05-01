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
@Table(name = "LoginGroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginGroup.findAll", query = "SELECT l FROM LoginGroup l")
    , @NamedQuery(name = "LoginGroup.findByGroupName", query = "SELECT l FROM LoginGroup l WHERE l.groupName = :groupName")
    , @NamedQuery(name = "LoginGroup.findByDescription", query = "SELECT l FROM LoginGroup l WHERE l.description = :description")
    , @NamedQuery(name = "LoginGroup.findByGroupId", query = "SELECT l FROM LoginGroup l WHERE l.groupId = :groupId")})
public class LoginGroup implements Serializable {

    @OneToMany(mappedBy = "groupId")
    private Collection<UserGroup> userGroupCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<GroupRole> groupRoleCollection;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "group_name")
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "description")
    private String description;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private Integer groupId;

    public LoginGroup() {
    }

    public LoginGroup(Integer groupId) {
        this.groupId = groupId;
    }

    public LoginGroup(Integer groupId, String groupName, String description) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.description = description;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginGroup)) {
            return false;
        }
        LoginGroup other = (LoginGroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.LoginGroup[ groupId=" + groupId + " ]";
    }

    @XmlTransient
    public Collection<GroupRole> getGroupRoleCollection() {
        return groupRoleCollection;
    }

    public void setGroupRoleCollection(Collection<GroupRole> groupRoleCollection) {
        this.groupRoleCollection = groupRoleCollection;
    }

    @XmlTransient
    public Collection<UserGroup> getUserGroupCollection() {
        return userGroupCollection;
    }

    public void setUserGroupCollection(Collection<UserGroup> userGroupCollection) {
        this.userGroupCollection = userGroupCollection;
    }
    
}
