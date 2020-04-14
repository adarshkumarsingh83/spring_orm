package com.adarsh.spring.jpa.entity;

/**
 * Created by Adarsh on 3/21/15.
 */
import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    private Integer id;

    private String name;

    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

}
