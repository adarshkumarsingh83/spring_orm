package com.adarsh.spring.entity;

import javax.persistence.*;

/**
 * @Author Adarsh
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int id;

    @Column(name = "phone_number")
    private String number;

    @Column(name = "phone_type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String phoneNo) {
        this.number = phoneNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String phoneType) {
        this.type = phoneType;
    }

    @Override
    public String toString() {
        return "Phone [id=" + id + ", phone_number=" + number + ", type=" + type
                + "]";
    }
}