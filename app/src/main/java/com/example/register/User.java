package com.example.register;

import java.io.Serializable;

public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String newNumber) {
        this.number = newNumber;
    }

    private Boolean gender;

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean newGender) {
        this.gender = newGender;
    }

    private byte literacy;

    public byte getLiteracy() {
        return literacy;
    }

    public void setLiteracy(byte newLiteracy) {
        this.literacy = newLiteracy;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    private Boolean sport;

    public Boolean getSport() {
        return sport;
    }

    public void setSport(Boolean newSport) {
        this.sport = newSport;
    }

    private String music;

    public String getMusic() {
        return music;
    }

    public void setMusic(String newMusic) {
        this.music = newMusic;
    }

    public User() {

    }

    public User(String name, String number, Boolean gender, byte literacy, int age, Boolean sport, String music){
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.literacy = literacy;
        this.age = age;
        this.sport = sport;
        this.music = music;
    }
}
