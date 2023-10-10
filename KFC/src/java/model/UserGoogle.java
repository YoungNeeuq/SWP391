/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class UserGoogle {
    private String id;
    private String email;
    private String name;
    private String given_name;
    private String familiName;
    private String picture;
    private boolean verifyEmail;

    public UserGoogle() {
    }

    public UserGoogle(String id, String email, String name, String given_name, String familiName, String picture, boolean verifyEmail) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.given_name = given_name;
        this.familiName = familiName;
        this.picture = picture;
        this.verifyEmail = verifyEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamiliName() {
        return familiName;
    }

    public void setFamiliName(String familiName) {
        this.familiName = familiName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(boolean verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    @Override
    public String toString() {
        return "UserGoogle{" + "id=" + id + ", email=" + email + ", name=" + name + ", given_name=" + given_name + ", familiName=" + familiName + ", picture=" + picture + ", verifyEmail=" + verifyEmail + '}';
    }
    
}
