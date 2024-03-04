/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;



/**
 *
 * @author DELL
 */
public class Room {

    private String id;
    private String rname;
    private String rbuilding;

    public Room() {
    }

    public Room(String id, String rname, String rbuilding) {
        this.id = id;
        this.rname = rname;
        this.rbuilding = rbuilding;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRbuilding() {
        return rbuilding;
    }

    public void setRbuilding(String rbuilding) {
        this.rbuilding = rbuilding;
    }

    
    

}
