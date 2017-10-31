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
@Table(name = "inventorytype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventorytype.findAll", query = "SELECT i FROM Inventorytype i")
    , @NamedQuery(name = "Inventorytype.findByInventoryType", query = "SELECT i FROM Inventorytype i WHERE i.inventoryType = :inventoryType")
    , @NamedQuery(name = "Inventorytype.findByInventoryTypeId", query = "SELECT i FROM Inventorytype i WHERE i.inventoryTypeId = :inventoryTypeId")})
public class Inventorytype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "inventory_type")
    private String inventoryType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventory_type_id")
    private Integer inventoryTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryTypeId")
    private Collection<Inventoryarchive> inventoryarchiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryTypeId")
    private Collection<Inventory> inventoryCollection;

    public Inventorytype() {
    }

    public Inventorytype(Integer inventoryTypeId) {
        this.inventoryTypeId = inventoryTypeId;
    }

    public Inventorytype(Integer inventoryTypeId, String inventoryType) {
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
    public Collection<Inventoryarchive> getInventoryarchiveCollection() {
        return inventoryarchiveCollection;
    }

    public void setInventoryarchiveCollection(Collection<Inventoryarchive> inventoryarchiveCollection) {
        this.inventoryarchiveCollection = inventoryarchiveCollection;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
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
        if (!(object instanceof Inventorytype)) {
            return false;
        }
        Inventorytype other = (Inventorytype) object;
        if ((this.inventoryTypeId == null && other.inventoryTypeId != null) || (this.inventoryTypeId != null && !this.inventoryTypeId.equals(other.inventoryTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Inventorytype[ inventoryTypeId=" + inventoryTypeId + " ]";
    }
    
}
