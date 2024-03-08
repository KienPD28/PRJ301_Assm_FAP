/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author DELL
 */
public class Slot {
    private int slid;
    private String slname;

    public Slot() {
    }

    public Slot(int slid, String slname) {
        this.slid = slid;
        this.slname = slname;
    }

    public int getSlid() {
        return slid;
    }

    public void setSlid(int slid) {
        this.slid = slid;
    }

    public String getSlname() {
        return slname;
    }

    public void setSlname(String slname) {
        this.slname = slname;
    }

    @Override
    public String toString() {
        return "Slot{" + "slid=" + slid + ", slname=" + slname + '}';
    }
    
    
    
}
