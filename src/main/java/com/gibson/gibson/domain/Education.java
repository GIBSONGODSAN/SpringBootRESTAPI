package com.gibson.gibson.domain;

import lombok.Data;

@Data
public class Education {
    private String schoolOrCollegeName;
    private String medium;
    private String board;
    private int gradePercentage;
    private int yearOfCompletion;

    // Constructor
    public Education(String schoolOrCollegeName, String medium, String board, int gradePercentage,
                     int yearOfCompletion) {
        this.schoolOrCollegeName = schoolOrCollegeName;
        this.medium = medium;
        this.board = board;
        this.gradePercentage = gradePercentage;
        this.yearOfCompletion = yearOfCompletion;
    }

    public String getSchoolOrCollegeName() {
        return schoolOrCollegeName;
    }

    public void setSchoolOrCollegeName(String schoolOrCollegeName) {
        this.schoolOrCollegeName = schoolOrCollegeName;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public int getGradePercentage() {
        return gradePercentage;
    }

    public void setGradePercentage(int gradePercentage) {
        this.gradePercentage = gradePercentage;
    }

    public int getYearOfCompletion() {
        return yearOfCompletion;
    }

    public void setYearOfCompletion(int yearOfCompletion) {
        this.yearOfCompletion = yearOfCompletion;
    }


}