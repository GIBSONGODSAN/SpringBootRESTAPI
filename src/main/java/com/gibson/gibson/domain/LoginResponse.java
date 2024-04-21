package com.gibson.gibson.domain;
public class LoginResponse {
    User user;
    private boolean success;
    private String message; 
    private String token;
    private Boolean isMember;
    private String email;

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse(boolean success, String message, String token, Boolean isMember, String email) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.isMember = isMember;
        this.email = email;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
