/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Entity.Session;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author DELL
 */
public class SessionDate {
    private LocalDate date;
    private Session session;

    public SessionDate() {
    }

    public SessionDate(LocalDate date, Session session) {
        this.date = date;
        this.session = session;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    public String showDate(){
        return date.format(DateTimeFormatter.ofPattern("dd/MM"));
    }
    
    public String formatDate(){
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
