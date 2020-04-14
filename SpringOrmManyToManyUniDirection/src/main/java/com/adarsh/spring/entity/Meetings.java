package com.adarsh.spring.entity;

import javax.persistence.*;

/**
 * @Author Adarsh
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */

@Entity
public class Meetings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    private int id;

    @Column(name = "meeting_place")
    private String meetingsPlace;

    @Column(name = "meeting_type")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingsPlace() {
        return meetingsPlace;
    }

    public void setMeetingsPlace(String meetingsPlace) {
        this.meetingsPlace = meetingsPlace;
    }

    public String getType() {
        return type;
    }

    public void setType(String phoneType) {
        this.type = phoneType;
    }

    @Override
    public String toString() {
        return "Meetings{" +
                "id=" + id +
                ", meetingsPlace='" + meetingsPlace + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}