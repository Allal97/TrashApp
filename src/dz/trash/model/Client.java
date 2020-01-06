/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.trash.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bkral
 */
public class Client extends User {
    
    private String phoneNumber;
    private String androidversion;
    private Note rNote;
    private Set<Challenge> rChallenge;

    public Client() {
       // rNote = new HashSet<Note>();
       // rChallenge = new HashSet<Challenge>();
        
    }
    
    public Client(String phoneNumber, String androidversion, int id, String lastName, String firstName, String userName, String password, Date birthDate) {
        super(id, lastName, firstName, userName, password, birthDate);
        this.phoneNumber = phoneNumber;
        this.androidversion = androidversion;
        rChallenge = new HashSet<Challenge>();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAndroidversion() {
        return androidversion;
    }

    public void setAndroidversion(String androidversion) {
        this.androidversion = androidversion;
    }
    
    public boolean equals(Object obj){
        return obj instanceof Client && getId() == ((Client) obj).getId();
    }



    public Note getrNote() {
        return rNote;
    }

    public void setrNote(Note rNote) {
        this.rNote = rNote;
    }
    
//    public void addrNote( Note note){
//        if(!getrNote().contains(note)){
//            if(note.getrClient()!= null ){
//                note.removerClient();
//            }
//            note.setrClient((Set<Client>) this);
//            getrNote().add(note);
//        }
//    }
//
//    public void removerNote(Note note){
//        if (getrNote().contains(note)){
//            getrNote().remove(note);
//            note.setrClient(null);
//        }
//    }
    
    public void setNote(Note note){
        this.rNote = note;
    }

    public Set<Challenge> getrChallenge() {
        return rChallenge;
    }

    public void setrChallenge(Set<Challenge> rChallenge) {
        this.rChallenge = rChallenge;
    }
    
    
    
    public void addrChallenge(Challenge challenge){
        if(!getrChallenge().contains(challenge)){
            if(challenge.getrClient() != null){
                challenge.removerClient();
            }
        }
        challenge.setrClient(this);
        getrChallenge().add(challenge);
    }
    
    public void removerChallenge(Challenge challenge){
        if(getrChallenge().contains(challenge)){
            getrChallenge().remove(challenge);
            challenge.setClient(null);
        }
    }
    
    public void setChallenge(Set<Challenge> challenge){
        this.rChallenge = challenge;
    }
    
    
    
    
}
