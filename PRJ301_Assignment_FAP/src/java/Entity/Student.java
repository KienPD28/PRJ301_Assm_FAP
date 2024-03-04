/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Student {
    
    private String stuid;
    private String name;
    private Date dob;
    private boolean gender;
    private int semester;
    private String PhoneNumber;
    private String IDcard;
    private String address;
    private String email;
    private String major;

    public Student() {
    }

    public Student(String stuid, String name, Date dob, boolean gender, int semester, String PhoneNumber, String IDcard, String address, String email, String major) {
        this.stuid = stuid;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.semester = semester;
        this.PhoneNumber = PhoneNumber;
        this.IDcard = IDcard;
        this.address = address;
        this.email = email;
        this.major = major;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" + "stuid=" + stuid + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", semester=" + semester + ", PhoneNumber=" + PhoneNumber + ", IDcard=" + IDcard + ", address=" + address + ", email=" + email + ", major=" + major + '}';
    }
    
    
}
