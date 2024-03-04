/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Enrollment {
    private String eid;
    private Group gid;
    private List<Student> stuid;

    public Enrollment() {
    }

    public Enrollment(String eid, Group gid, List<Student> stuid) {
        this.eid = eid;
        this.gid = gid;
        this.stuid = stuid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Group getGid() {
        return gid;
    }

    public void setGid(Group gid) {
        this.gid = gid;
    }

    public List<Student> getStuid() {
        return stuid;
    }

    public void setStuid(List<Student> stuid) {
        this.stuid = stuid;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "eid=" + eid + ", gid=" + gid + ", stuid=" + stuid + '}';
    }

    
    
}
