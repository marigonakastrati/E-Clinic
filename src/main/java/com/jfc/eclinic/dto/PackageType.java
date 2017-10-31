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
@Table(name = "PackageType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PackageType.findAll", query = "SELECT p FROM PackageType p")
    , @NamedQuery(name = "PackageType.findByName", query = "SELECT p FROM PackageType p WHERE p.name = :name")
    , @NamedQuery(name = "PackageType.findByPackageTypeId", query = "SELECT p FROM PackageType p WHERE p.packageTypeId = :packageTypeId")})
public class PackageType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "package_type_id")
    private Integer packageTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageType")
    private Collection<Medicine> medicineCollection;

    public PackageType() {
    }

    public PackageType(Integer packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(Integer packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    @XmlTransient
    public Collection<Medicine> getMedicineCollection() {
        return medicineCollection;
    }

    public void setMedicineCollection(Collection<Medicine> medicineCollection) {
        this.medicineCollection = medicineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageTypeId != null ? packageTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageType)) {
            return false;
        }
        PackageType other = (PackageType) object;
        if ((this.packageTypeId == null && other.packageTypeId != null) || (this.packageTypeId != null && !this.packageTypeId.equals(other.packageTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubt.healthcare.dto.PackageType[ packageTypeId=" + packageTypeId + " ]";
    }
    
}
