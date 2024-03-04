/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entity;
import java.sql.Time;

/**
 *
 * @author DELL
 */
public class TimeSlot {
    private int tid;
    private Time startTime;
    private Time endTime;

    public TimeSlot() {
    }

    public TimeSlot(int tid, Time startTime, Time endTime) {
        this.tid = tid;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TimeSlot{" + "tid=" + tid + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }

    
    
}


