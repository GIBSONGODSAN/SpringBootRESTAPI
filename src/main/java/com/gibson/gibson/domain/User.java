package com.gibson.gibson.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String dob;
    private String gender;
    private Education education;
    private Experience experience;

    // Constructor
    public User(String username, String email, String password, String dob, String gender,
                Education education, Experience experience) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.education = education;
        this.experience = experience;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public Education getEducation() {
        return education;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }
    

}
