/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn;

/**
 *
 * @author hp
 */
public class H_participation {
    private int id;
    private int id_userP;
    private int id_event;

    
    public H_participation() {
    }

    public H_participation(int id_userP, int id_event) {
        this.id_userP = id_userP;
        this.id_event = id_event;
    }

    public H_participation(int id, int id_userP, int id_event) {
        this.id = id;
        this.id_userP = id_userP;
        this.id_event = id_event;
    }
public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_userP() {
        return id_userP;
    }

    public void setId_userP(int id_userP) {
        this.id_userP = id_userP;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

}
