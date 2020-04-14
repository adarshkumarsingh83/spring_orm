package com.adarsh.spring.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.*;

/**
 * @Author Adarsh
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:32 PM
 * This Class provide the implementation for the functionality of..
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="employee_id")
    private Long employeeId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birth_date")
    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Collection<Phone> phones;


    public Employee() {

    }

    public Employee(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }
}
