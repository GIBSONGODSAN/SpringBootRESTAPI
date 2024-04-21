package com.gibson.gibson.domain;

public class UpdateMemberRequest {
    private String email;
    private boolean isMember;

    public UpdateMemberRequest(String email, boolean isMember) {
        this.email = email;
        this.isMember = isMember;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
    }
}
