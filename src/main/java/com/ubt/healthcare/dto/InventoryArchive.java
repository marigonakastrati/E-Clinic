/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F
 */
@Entity
@Table(name = "InventoryArchive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventoryArchive.findAll", query = "SELECT i FROM InventoryArchive i")
    , @NamedQuery(name = "InventoryArchive.findByQuantity", query = "SELECT i FROM InventoryArchive i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "InventoryArchive.findByDateUpdated", query = "SELECT i FROM InventoryArchive i WHERE i.dateUpdated = :dateUpdated")
    , @NamedQuery(name = "InventoryArchive.findByComment", query = "SELECT i FROM InventoryArchive i WHERE i.comment = :comment")
    , @NamedQuery(name = "InventoryArchive.findByInventoryArchiveId", query = "SELECT i FROM InventoryArchive i WHERE i.inventoryArchiveId = :inventoryArchiveId")})
public class InventoryArchive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "comment")
    private String comment;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "inventory_archive_id")
    private Integer inventoryArchiveId;
    @JoinColumn(name = "location_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address locationId;
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    @ManyToOne(optional = false)
    private Inventory inventoryId;
    @JoinColumn(name = "inventory_type_id", referencedColumnName = "inventory_type_id")
    @ManyToOne(optional = false)
    private InventoryType inventoryTypeId;
    @JoinColumn(name = "updated_by", referencedColumnName = "pharmacy_manager_id")
    @ManyToOne(optional = false)
    private PharmacyManager updatedBy;

    public InventoryArchive() {
    }

    public InventoryArchive(Integer inventoryArchiveId) {
        this.inventoryArchiveId = inventoryArchiveId;
    }

    public InventoryArchive(Integer inventoryArchiveId, int quantity, Date dateUpdated, String comment) {
        this.inventoryArchiveId = inventoryArchiveId;
        this.quantity = quantity;
        this.dateUpdated = dateUpdated;
        this.comment = comment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getInventoryArchiveId() {
        return inventoryArchiveId;
    }

    public void setInventoryArchiveId(Integer inventoryArchiveId) {
        this.inventoryArchiveId = inventoryArchiveId;
    }

    public Address getLocationId() {
        return locationId;
    }

    public void setLocationId(Address locationId) {
        this.locationId = locationId;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public InventoryType getInventoryTypeId() {
        return inventoryTypeId;
    }

    public void setInventoryTypeId(InventoryType inventoryTypeId) {
        this.inventoryTypeId = inventoryTypeId;
    }

    public PharmacyManager getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(PharmacyManager updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryArchiveId != null ? inventoryArchiveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventoryArchive)) {
            return false;
        }
        InventoryArchive other = (InventoryArchive) object;
        if ((this.inventoryArchiveId == null && other.inventoryArchiveId != null) || (this.inventoryArchiveId != null && !this.inventoryArchiveId.equals(other.inventoryArchiveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.InventoryArchive[ inventoryArchiveId=" + inventoryArchiveId + " ]";
    }
    
}
