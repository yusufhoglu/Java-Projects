package com.epam.rd.autocode.assessment.basics.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Employee extends User implements Serializable {
    private String phone;
    private LocalDate dateOfBirth;

    public Employee(long id, String email, String password, String name, String phone, LocalDate dateOfBirth) {
        super(id, email, password, name);
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(String phone, LocalDate dateOfBirth) {
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee() {

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee employee)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(getPhone(), employee.getPhone()) && Objects.equals(getDateOfBirth(), employee.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPhone(), getDateOfBirth());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", email='" + getEmail() + '\''+
                ", name='" + getName() +'\''+
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
