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
@Table(name = "UserGroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGroup.findAll", query = "SELECT u FROM UserGroup u"),
    @NamedQuery(name = "UserGroup.findByUserId", query = "SELECT u FROM UserGroup u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserGroup.findByUsrGroupId", query = "SELECT u FROM UserGroup u WHERE u.usrGroupId = :usrGroupId")})
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "user_id")
    private Integer userId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_group_id")
    private Integer usrGroupId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne
    private Group1 groupId;

    public UserGroup() {
    }

    public UserGroup(Integer usrGroupId) {
        this.usrGroupId = usrGroupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUsrGroupId() {
        return usrGroupId;
    }

    public void setUsrGroupId(Integer usrGroupId) {
        this.usrGroupId = usrGroupId;
    }

    public Group1 getGroupId() {
        return groupId;
    }

    public void setGroupId(Group1 groupId) {
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
        if (!(object instanceof UserGroup)) {
            return false;
        }
        UserGroup other = (UserGroup) object;
        if ((this.usrGroupId == null && other.usrGroupId != null) || (this.usrGroupId != null && !this.usrGroupId.equals(other.usrGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.entity.UserGroup[ usrGroupId=" + usrGroupId + " ]";
    }
    
}
