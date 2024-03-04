/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author DELL
 */
public class Group {
    private String gid;
    private String gname;
    private Subject subid;
    private Student stuid;
    private Lecturers lid;

    public Group() {
    }

    public Group(String gid, String gname, Subject subid, Student stuid, Lecturers PIC) {
        this.gid = gid;
        this.gname = gname;
        this.subid = subid;
        this.stuid = stuid;
        this.lid = lid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Subject getSubid() {
        return subid;
    }

    public void setSubid(Subject subid) {
        this.subid = subid;
    }

    public Student getStuid() {
        return stuid;
    }

    public void setStuid(Student stuid) {
        this.stuid = stuid;
    }

    public Lecturers getLid() {
        return lid;
    }

    public void setLid(Lecturers lid) {
        this.lid = lid;
    }
    
    
}
