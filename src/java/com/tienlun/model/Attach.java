/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tienpv
 */
@Entity
@Table(name = "attach")

public class Attach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ATTACH_ID")
    private Long attachId;
    @Basic(optional = false)
    @Column(name = "OBJECT_ID")
    private Long objectId;
    @Basic(optional = false)
    @Lob
    @Column(name = "OBJECT_TYPE")
    private String objectType;
    @Basic(optional = false)
    @Lob
    @Column(name = "ATTACH_NAME")
    private String attachName;
    @Basic(optional = false)
    @Lob
    @Column(name = "ATTACH_PATH")
    private String attachPath;
    @Basic(optional = false)
    @Lob
    @Column(name = "ATTACH_DES")
    private String attachDes;
    @Basic(optional = false)
    @Column(name = "REFERENT_ID")
    private Long referentId;
    @Basic(optional = false)
    @Column(name = "IS_ACTIVE")
    private int isActive;
    @Basic(optional = false)
    @Column(name = "CREATED_BY")
    private Long createdBy;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;
    @Basic(optional = false)
    @Column(name = "MODIFY_DATE")
    @Temporal(TemporalType.DATE)
    private Date modifyDate;

    public Attach() {
    }

    public Attach(Long attachId) {
        this.attachId = attachId;
    }

    public Attach(Long attachId, Long objectId, String objectType, String attachName, String attachPath, String attachDes, Long referentId, int isActive, Long createdBy, Date createDate, Long modifiedBy, Date modifyDate) {
        this.attachId = attachId;
        this.objectId = objectId;
        this.objectType = objectType;
        this.attachName = attachName;
        this.attachPath = attachPath;
        this.attachDes = attachDes;
        this.referentId = referentId;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.modifiedBy = modifiedBy;
        this.modifyDate = modifyDate;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    public String getAttachDes() {
        return attachDes;
    }

    public void setAttachDes(String attachDes) {
        this.attachDes = attachDes;
    }

    public Long getReferentId() {
        return referentId;
    }

    public void setReferentId(Long referentId) {
        this.referentId = referentId;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attachId != null ? attachId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attach)) {
            return false;
        }
        Attach other = (Attach) object;
        return !((this.attachId == null && other.attachId != null) || (this.attachId != null && !this.attachId.equals(other.attachId)));
    }

    @Override
    public String toString() {
        return "com.tienlun.model.Attach[ attachId=" + attachId + " ]";
    }

}
