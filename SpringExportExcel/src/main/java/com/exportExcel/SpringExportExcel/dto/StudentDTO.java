package com.exportExcel.SpringExportExcel.dto;

import com.exportExcel.SpringExportExcel.models.Student;

import java.util.Objects;

public class StudentDTO {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String pin;

    public StudentDTO() {

    }

    public StudentDTO(Long id, String name, String address, String city, String pin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.pin = pin;
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.address = student.getAddress();
        this.city = student.getCity();
        this.pin = student.getPin();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO)) return false;
        StudentDTO that = (StudentDTO) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getAddress().equals(that.getAddress()) && getCity().equals(that.getCity()) && getPin().equals(that.getPin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress(), getCity(), getPin());
    }
}
