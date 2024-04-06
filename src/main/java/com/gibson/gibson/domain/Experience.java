package com.gibson.gibson.domain;

import lombok.Data;

@Data
public class Experience {
    private String companyName;
    private String role;
    private String description;
    private double salary;
    private int yearsOfExperience;

    // Constructor
    public Experience(String companyName, String role, String description, double salary,
                      int yearsOfExperience) {
        this.companyName = companyName;
        this.role = role;
        this.description = description;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }


}