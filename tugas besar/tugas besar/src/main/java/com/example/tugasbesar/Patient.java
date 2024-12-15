package com.example.tugasbesar;

public class Patient {
    private String name;
    private int age;
    private String address;
    private String birthDate; // Tambahkan properti birthDate

    public Patient(String name, int age, String address, String birthDate) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthDate = birthDate; // Tambahkan parameter birthDate ke konstruktor
    }

    // Getter dan Setter untuk name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter dan Setter untuk address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter dan Setter untuk birthDate
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
