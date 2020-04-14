package com.adarsh.spring.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard implements Serializable {

    private static final long serialVersionUID = 5924361831551833717L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NUMBER")
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String
    toString() {
        return "CreditCard{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
