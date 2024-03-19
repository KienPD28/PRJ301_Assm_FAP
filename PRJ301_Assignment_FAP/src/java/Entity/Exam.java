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
public class Exam {
    private String eid;
    private Assignment assid;
    private Date dateStart;
    private Date endDate;
    
    public Exam() {
    }
    
    public Exam(String eid, Assignment assid, Date dateStart, Date endDate) {
        this.eid = eid;
        this.assid = assid;
        this.dateStart = dateStart;
        this.endDate = endDate;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Assignment getAssid() {
        return assid;
    }

    public void setAssid(Assignment assid) {
        this.assid = assid;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Exam{" + "eid=" + eid + ", assid=" + assid + ", dateStart=" + dateStart + ", endDate=" + endDate + '}';
    }
    
    

    
    
    
    

}
