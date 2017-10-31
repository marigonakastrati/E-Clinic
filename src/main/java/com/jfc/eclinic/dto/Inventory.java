/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jfc
 */
@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
    , @NamedQuery(name = "Inventory.findByQuantity", query = "SELECT i FROM Inventory i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "Inventory.findByDateUpdated", query = "SELECT i FROM Inventory i WHERE i.dateUpdated = :dateUpdated")
    , @NamedQuery(name = "Inventory.findByInventoryId", query = "SELECT i FROM Inventory i WHERE i.inventoryId = :inventoryId")})
public class Inventory implements Serializable {

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventory_id")
    private Integer inventoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryId")
    private Collection<Inventoryarchive> inventoryarchiveCollection;
    @JoinColumn(name = "inventory_type_id", referencedColumnName = "inventory_type_id")
    @ManyToOne(optional = false)
    private Inventorytype inventoryTypeId;
    @JoinColumn(name = "location_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address locationId;
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false)
    private Medicine medicineId;
    @JoinColumn(name = "updated_by", referencedColumnName = "pharmacy_manager_id")
    @ManyToOne(optional = false)
    private PharmacyManager updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId")
    private Collection<Orderitem> orderitemCollection;

    public Inventory() {
    }

    public Inventory(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Inventory(Integer inventoryId, int quantity, Date dateUpdated) {
        this.inventoryId = inventoryId;
        this.quantity = quantity;
        this.dateUpdated = dateUpdated;
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

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    @XmlTransient
    public Collection<Inventoryarchive> getInventoryarchiveCollection() {
        return inventoryarchiveCollection;
    }

    public void setInventoryarchiveCollection(Collection<Inventoryarchive> inventoryarchiveCollection) {
        this.inventoryarchiveCollection = inventoryarchiveCollection;
    }

    public Inventorytype getInventoryTypeId() {
        return inventoryTypeId;
    }

    public void setInventoryTypeId(Inventorytype inventoryTypeId) {
        this.inventoryTypeId = inventoryTypeId;
    }

    public Address getLocationId() {
        return locationId;
    }

    public void setLocationId(Address locationId) {
        this.locationId = locationId;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    public PharmacyManager getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(PharmacyManager updatedBy) {
        this.updatedBy = updatedBy;
    }

    @XmlTransient
    public Collection<Orderitem> getOrderitemCollection() {
        return orderitemCollection;
    }

    public void setOrderitemCollection(Collection<Orderitem> orderitemCollection) {
        this.orderitemCollection = orderitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryId != null ? inventoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.inventoryId == null && other.inventoryId != null) || (this.inventoryId != null && !this.inventoryId.equals(other.inventoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jfc.eclinic.dto.Inventory[ inventoryId=" + inventoryId + " ]";
    }
    
}
