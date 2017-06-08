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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
    @NamedQuery(name = "UserGroup.findAll", query = "SELECT u FROM UserGroup u")
    , @NamedQuery(name = "UserGroup.findByUserId", query = "SELECT u FROM UserGroup u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserGroup.findByUsrGroupId", query = "SELECT u FROM UserGroup u WHERE u.usrGroupId = :usrGroupId")})
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_group_id")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer usrGroupId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne
    private LoginGroup groupId;

    public UserGroup() {
    }

    public UserGroup(Integer usrGroupId) {
        this.usrGroupId = usrGroupId;
    }

    public UserGroup(Integer usrGroupId, int userId) {
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

    public LoginGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(LoginGroup groupId) {
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
        return "com.ubt.healthcare.dto.UserGroup[ usrGroupId=" + usrGroupId + " ]";
    }

}
