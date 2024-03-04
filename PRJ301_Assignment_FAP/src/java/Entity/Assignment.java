/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author DELL
 */
public class Assignment {
    private String assid;
    private String assname;
    private Subject subid;
    private float weight;
    
    public Assignment() {
    }

    public Assignment(String assid, String assname, Subject subid, float weight) {
        this.assid = assid;
        this.assname = assname;
        this.subid = subid;
        this.weight = weight;
    }

    public String getAssid() {
        return assid;
    }

    public void setAssid(String assid) {
        this.assid = assid;
    }

    public String getAssname() {
        return assname;
    }

    public void setAssname(String assname) {
        this.assname = assname;
    }

    public Subject getSubid() {
        return subid;
    }

    public void setSubid(Subject subid) {
        this.subid = subid;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    

}
