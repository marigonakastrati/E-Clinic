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
@Table(name = "InventoryType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventoryType.findAll", query = "SELECT i FROM InventoryType i")
    , @NamedQuery(name = "InventoryType.findByInventoryType", query = "SELECT i FROM InventoryType i WHERE i.inventoryType = :inventoryType")
    , @NamedQuery(name = "InventoryType.findByInventoryTypeId", query = "SELECT i FROM InventoryType i WHERE i.inventoryTypeId = :inventoryTypeId")})
public class InventoryType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "inventory_type")
    private String inventoryType;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "inventory_type_id")
    private Integer inventoryTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryTypeId")
    private Collection<Inventory> inventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryTypeId")
    private Collection<InventoryArchive> inventoryArchiveCollection;

    public InventoryType() {
    }

    public InventoryType(Integer inventoryTypeId) {
        this.inventoryTypeId = inventoryTypeId;
    }

    public InventoryType(Integer inventoryTypeId, String inventoryType) {
        this.inventoryTypeId = inventoryTypeId;
        this.inventoryType = inventoryType;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Integer getInventoryTypeId() {
        return inventoryTypeId;
    }

    public void setInventoryTypeId(Integer inventoryTypeId) {
        this.inventoryTypeId = inventoryTypeId;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
    }

    @XmlTransient
    public Collection<InventoryArchive> getInventoryArchiveCollection() {
        return inventoryArchiveCollection;
    }

    public void setInventoryArchiveCollection(Collection<InventoryArchive> inventoryArchiveCollection) {
        this.inventoryArchiveCollection = inventoryArchiveCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryTypeId != null ? inventoryTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventoryType)) {
            return false;
        }
        InventoryType other = (InventoryType) object;
        if ((this.inventoryTypeId == null && other.inventoryTypeId != null) || (this.inventoryTypeId != null && !this.inventoryTypeId.equals(other.inventoryTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.InventoryType[ inventoryTypeId=" + inventoryTypeId + " ]";
    }
    
}
