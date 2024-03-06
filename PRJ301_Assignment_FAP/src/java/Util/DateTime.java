/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DateTime {
    private int week;
    private String content;
    private List<SessionDate> listsessionDate;

    public DateTime() {
    }

    public DateTime(int week, String content, List<SessionDate> listsessionDate) {
        this.week = week;
        this.content = content;
        this.listsessionDate = listsessionDate;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<SessionDate> getListsessionDate() {
        return listsessionDate;
    }

    public void setListsessionDate(List<SessionDate> listsessionDate) {
        this.listsessionDate = listsessionDate;
    }
    
    public boolean selectedWeek(LocalDate date){
        for (SessionDate sdate : listsessionDate) {
            if(sdate.getDate().isEqual(date)){
                return true;
            }
        }
        return false;
    }
    
}
