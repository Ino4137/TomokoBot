package com.stack.overflow.works.model;

public class Data {

    private Long userID;
    private String elo;
    private String role1;
    private String role2;

    public Data() {}

    public Long getUserID(){
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getElo() {
        return elo;
    }

    public void setElo(String elo) {
        this.elo = elo;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
    }

    public String getRole2() {
        return role2;
    }

    public void setRole2(String role2) {
        this.role2 = role2;
    }
}
