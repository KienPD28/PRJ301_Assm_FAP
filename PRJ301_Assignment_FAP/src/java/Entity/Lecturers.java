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
public class Lecturers {
    private String lid;
    private String lname;
    private Date dob;
    private String PhoneNumber;
    private String IDcard;
    private String address;
    private String email;
    private String major;
    private String nickName;

    public Lecturers() {
    }

    public Lecturers(String lid, String lname, Date dob, String PhoneNumber, String IDcard, String address, String email, String major, String nickName) {
        this.lid = lid;
        this.lname = lname;
        this.dob = dob;
        this.PhoneNumber = PhoneNumber;
        this.IDcard = IDcard;
        this.address = address;
        this.email = email;
        this.major = major;
        this.nickName = nickName;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getnickName() {
        return nickName;
    }

    public void setnickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Lecturers{" + "lid=" + lid + ", lname=" + lname + ", dob=" + dob + ", PhoneNumber=" + PhoneNumber + ", IDcard=" + IDcard + ", address=" + address + ", email=" + email + ", major=" + major + ", nickName=" + nickName + '}';
    }

    
    
}
