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
    private int Grid;
    private Exam Eid;
    private float Score;
    private Student stuid;
    private Subject subid;
    private Group gid;

    public Grade() {
    }

    public Grade(int Grid, Exam Eid, float Score, Student stuid, Subject subid, Group gid) {
        this.Grid = Grid;
        this.Eid = Eid;
        this.Score = Score;
        this.stuid = stuid;
        this.subid = subid;
        this.gid = gid;
    }

    public int getGrid() {
        return Grid;
    }

    public void setGrid(int Grid) {
        this.Grid = Grid;
    }

    public Exam getEid() {
        return Eid;
    }

    public void setEid(Exam Eid) {
        this.Eid = Eid;
    }

    public float getScore() {
        return Score;
    }

    public void setScore(float Score) {
        this.Score = Score;
    }

    public Student getStuid() {
        return stuid;
    }

    public void setStuid(Student stuid) {
        this.stuid = stuid;
    }

    public Subject getSubid() {
        return subid;
    }

    public void setSubid(Subject subid) {
        this.subid = subid;
    }

    public Group getGid() {
        return gid;
    }

    public void setGid(Group gid) {
        this.gid = gid;
    }

    
    
}
