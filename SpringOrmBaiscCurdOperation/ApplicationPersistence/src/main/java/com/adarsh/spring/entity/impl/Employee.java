package com.adarsh.spring.entity.impl;

import com.adarsh.spring.entity.Bean;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Entity
@Table(name = "Employee")
public class Employee extends Bean {

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "middleName", nullable = true)
    private String middleName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "empEmail", nullable = false)
    private String empEmail;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dob;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(String firstName, String middleName, String lastName, String empEmail, Date dob) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.empEmail = empEmail;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", dob=" + dob +
                '}';
    }
}
