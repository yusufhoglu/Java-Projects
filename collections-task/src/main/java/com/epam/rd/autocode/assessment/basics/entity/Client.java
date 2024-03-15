package com.epam.rd.autocode.assessment.basics.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Client extends User implements Serializable {
    private BigDecimal balance;
    private String driverLicense;

    public Client(long id, String email, String password, String name, BigDecimal balance, String driverLicense) {
        super(id, email, password, name);
        this.balance = balance;
        this.driverLicense = driverLicense;
    }

    public Client(BigDecimal balance, String driverLicense) {
        this.balance = balance;
        this.driverLicense = driverLicense;
    }
    public Client() {
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Client client)) return false;
        if (!super.equals(object)) return false;
        if (getClass() != object.getClass()) return false;
        return Objects.equals(getBalance(), client.getBalance()) && Objects.equals(getDriverLicense(), client.getDriverLicense());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBalance(), getDriverLicense());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() +
                ", email='" + getEmail() + '\''+
                ", name='" + getName() +'\''+
                ", balance=" + balance +
                ", driverLicense='" + driverLicense + '\'' +
                '}';
    }
}
