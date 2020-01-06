/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.trash.model;

import java.util.Set;

/**
 *
 * @author bkral
 */
public class Note {
    
    private int noteValue;
    private Set<Client> rClient;
    private Set<Challenge> rChallenge;

    public Note() {
        
    }
    
    public Note(int noteValue) {
        this.noteValue = noteValue;
    }

    public int getNoteValue() {
        return noteValue;
    }

    public void setNoteValue(int noteValue) {
        this.noteValue = noteValue;
    }

    public void setrClient(Set<Client> rClient) {
        this.rClient = rClient;
    }

    public Set<Client> getrClient() {
        return rClient;
    }

    public Set<Challenge> getrChallenge() {
        return rChallenge;
    }

    public void setrChallenge(Set<Challenge> rChallenge) {
        this.rChallenge = rChallenge;
    }

    /*public void addrClient(Set<Client> client){
        if(!client.getrNote().contains(this)){
            if(getrClient() !=null){
                removerClient();
            }
        }
        setrClient(client);
        client.addrNote(this);
        
    }
    
    
    
    public void removerClient(){
        getrClient().removerNote(this);
        setrClient(null);
    }




    
    public void addChallenge(Set<Challenge> challenge){
        if(!challenge.getrNote().contains(this)){
            if(getrChallenge() != null){
                removerChallenge();
            }
        }
        setrChallenge(challenge);
        challenge.addrNote(this);
    }
    
    public void removerChallenge(){
        getrChallenge().removerNote(this);
        setrChallenge(null);
    }*/
    
   
    
    
    
    
    
}
