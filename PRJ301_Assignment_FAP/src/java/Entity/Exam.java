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
    private Assignment Assid;
    private Date DateStart;
    private Date EndDate;

    public Exam() {
    }
    
    public Exam(String eid, Assignment Assid, Date DateStart, Date EndDate) {
        this.eid = eid;
        this.Assid = Assid;
        this.DateStart = DateStart;
        this.EndDate = EndDate;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Assignment getAssid() {
        return Assid;
    }

    public void setAssid(Assignment Assid) {
        this.Assid = Assid;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date DateStart) {
        this.DateStart = DateStart;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }
    
    

}
