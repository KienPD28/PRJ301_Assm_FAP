/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class Session {
    private int seid;
    private Group gid;
    private Slot slid;
    private TimeSlot tid;
    private Room rid;
    private Date date;
    private Subject subid;
    private Lecturers lid;
    private boolean isTaken;

    public Session() {
    }

    public Session(int seid, Group gid, Slot slid, TimeSlot tid, Room rid, Subject subid, Date date, Lecturers lid, boolean isTaken) {
        this.seid = seid;
        this.gid = gid;
        this.slid = slid;
        this.tid = tid;
        this.rid = rid;
        this.date = date;
        this.subid = subid;
        this.lid = lid;
        this.isTaken = isTaken;
    }

    public int getSeid() {
        return seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
    }

    public Group getGid() {
        return gid;
    }

    public void setGid(Group gid) {
        this.gid = gid;
    }

    public Slot getSlid() {
        return slid;
    }

    public void setSlid(Slot slid) {
        this.slid = slid;
    }

    public TimeSlot getTid() {
        return tid;
    }

    public void setTid(TimeSlot tid) {
        this.tid = tid;
    }

    public Room getRid() {
        return rid;
    }

    public void setRid(Room rid) {
        this.rid = rid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Subject getSubid() {
        return subid;
    }

    public void setSubid(Subject subid) {
        this.subid = subid;
    }

    public Lecturers getLid() {
        return lid;
    }

    public void setLid(Lecturers lid) {
        this.lid = lid;
    }

    public boolean isIsTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    @Override
    public String toString() {
        return "Session{" + "seid=" + seid + ", gid=" + gid + ", slid=" + slid + ", tid=" + tid + ", rid=" + rid + ", date=" + date + ", subid=" + subid + ", lid=" + lid + ", isTaken=" + isTaken + '}';
    }

    
    
    
}
