package com.adarsh.spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@MappedSuperclass
public class Bean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="id",insertable = true, nullable = false, unique = true, updatable = true)
    protected Integer id;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 10)
    private Date createdDate;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "MODIFIED_DATE", nullable = false, length = 10)
    private Date modifiedDate;

    public Bean() {
        createdDate=new Date();
        modifiedDate=new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
