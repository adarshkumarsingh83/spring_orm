package com.adarsh.spring.entity.impl;


import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity implements java.io.Serializable{

    @Column(name = "active", nullable = false, insertable = true, updatable = true, length = 1)
    protected boolean active;

    @Column(name="created_by_username",length=50, unique=false ,nullable=false)
    protected String createdByUserName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    protected Date createdDateTime;

    @Column(name = "updated_by_username", length = 50, nullable = false)
    protected String updatedByUserName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", nullable = false)
    protected Date updatedDateTime;

    public BaseEntity() {}


    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCreatedByUserName() {
        return createdByUserName;
    }

    public void setCreatedByUserName(String createdByUserName) {
        this.createdByUserName = createdByUserName;
    }

    public String getUpdatedByUserName() {
        return updatedByUserName;
    }

    public void setUpdatedByUserName(String updatedByUserName) {
        this.updatedByUserName = updatedByUserName;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDataAndTime) {
        this.createdDateTime = createdDataAndTime;
    }

    public Date getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Date updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

}

