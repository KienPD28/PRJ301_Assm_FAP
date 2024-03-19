/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author DELL
 */
public class Grade {
    private int grid;
    private Exam eid;
    private float score;
    private Student stuid;
    

    public Grade() {
    }

    public Grade(int grid, Exam eid, float score, Student stuid) {
        this.grid = grid;
        this.eid = eid;
        this.score = score;
        this.stuid = stuid;
    }

    public int getGrid() {
        return grid;
    }

    public void setGrid(int grid) {
        this.grid = grid;
    }

    public Exam getEid() {
        return eid;
    }

    public void setEid(Exam eid) {
        this.eid = eid;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Student getStuid() {
        return stuid;
    }

    public void setStuid(Student stuid) {
        this.stuid = stuid;
    }

    @Override
    public String toString() {
        return "Grade{" + "grid=" + grid + ", Eid=" + eid + ", Score=" + score + ", stuid=" + stuid + '}';
    }

    
    
}
