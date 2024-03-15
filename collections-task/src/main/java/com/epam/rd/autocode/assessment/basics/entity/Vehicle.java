package com.epam.rd.autocode.assessment.basics.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Vehicle implements Serializable {
    private Long id;
    private String make;
    private String model;
    private String characteristics;
    private long odometer;
    private String color;
    private String licensePlate;
    private int numberOfSeats;
    private BigDecimal price;
    private char requiredLicense;
    private int yearOfProduction;
    private BodyType bodyType;

    public Vehicle() {
    }

    public Vehicle(Long id, String make, String model, String characteristics,int yearOfProduction, long odometer, String color, String licensePlate, int numberOfSeats, BigDecimal price, char requiredLicense,  BodyType bodyType) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.characteristics = characteristics;
        this.odometer = odometer;
        this.color = color;
        this.licensePlate = licensePlate;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        this.requiredLicense = requiredLicense;
        this.yearOfProduction = yearOfProduction;
        this.bodyType = bodyType;
    }

    public java.lang.String getCharacteristics()  {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.lang.String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public java.lang.String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getOdometer() {
        return odometer;
    }

    public void setOdometer(long odometer) {
        this.odometer = odometer;
    }

    public java.lang.String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public java.lang.String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public char getRequiredLicense() {
        return requiredLicense;
    }

    public void setRequiredLicense(char requiredLicense) {
        this.requiredLicense = requiredLicense;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Vehicle vehicle)) return false;
        if ( getClass() != object.getClass()) return false;
        return getOdometer() == vehicle.getOdometer() && getNumberOfSeats() == vehicle.getNumberOfSeats() && getRequiredLicense() == vehicle.getRequiredLicense() && getYearOfProduction() == vehicle.getYearOfProduction() && Objects.equals(getId(), vehicle.getId()) && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getCharacteristics(), vehicle.getCharacteristics()) && Objects.equals(getColor(), vehicle.getColor()) && Objects.equals(getLicensePlate(), vehicle.getLicensePlate()) && Objects.equals(getPrice(), vehicle.getPrice()) && getBodyType() == vehicle.getBodyType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMake(), getModel(), getCharacteristics(), getOdometer(), getColor(), getLicensePlate(), getNumberOfSeats(), getPrice(), getRequiredLicense(), getYearOfProduction(), getBodyType());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", characteristics='" + characteristics + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", odometer=" + odometer +
                ", color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", price=" + price +
                ", requiredLicense=" + requiredLicense +
                ", bodyType=" + bodyType +
                '}';
    }
}


