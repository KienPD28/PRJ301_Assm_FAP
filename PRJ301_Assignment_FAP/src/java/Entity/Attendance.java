/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Attendance {
    private int aid;
    private Session seid;
    private Student stuid;
    private boolean isPresent;
    private String description;
    private Date dateTime;

    public Attendance() {
    }

    public Attendance(int aid, Session seid, Student stuid, boolean isPresent, String description, Date dateTime) {
        this.aid = aid;
        this.seid = seid;
        this.stuid = stuid;
        this.isPresent = isPresent;
        this.description = description;
        this.dateTime = dateTime;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Session getSeid() {
        return seid;
    }

    public void setSeid(Session seid) {
        this.seid = seid;
    }

    public Student getStuid() {
        return stuid;
    }

    public void setStuid(Student stuid) {
        this.stuid = stuid;
    }

    public boolean isIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Attendance{" + "aid=" + aid + ", seid=" + seid + ", stuid=" + stuid + ", isPresent=" + isPresent + ", description=" + description + ", dateTime=" + dateTime + '}';
    }

}
