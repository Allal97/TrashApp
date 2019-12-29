/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.trash.model;

/**
 *
 * @author bkral
 */
public class Note {
    
    private int NoteValue;
    private Client rClient;
    private Challenge challenge;

    public Note() {
        
    }
    
    public Note(int NoteValue) {
        this.NoteValue = NoteValue;
    }

    public int getNoteValue() {
        return NoteValue;
    }

    public void setNoteValue(int NoteValue) {
        this.NoteValue = NoteValue;
    }

    public Client getClient() {
        return rClient;
    }

    public void setClient(Client client) {
        this.rClient = client;
    }
    
   
    
    public void addrClient(Client client){
        if(!client.getrNote().contains(this)){
            if(getClient() !=null){
                removerClient();
            }
        }
        setClient(client);
        client.addrNote(this);
        
    }
    
    
    
    public void removerClient(){
        getClient().removerNote(this);
        setClient(null);
    }

    public Client getrClient() {
        return rClient;
    }

    public void setrClient(Client rClient) {
        this.rClient = rClient;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
    
    public void addChallenge(Challenge challenge){
        if(!challenge.getrNote().contains(this)){
            if(getChallenge() != null){
                removerChallenge();
            }
        }
        setChallenge(challenge);
        challenge.addrNote(this);
    }
    
    public void removerChallenge(){
        getChallenge().removerNote(this);
        setChallenge(null);
    }
    
   
    
    
    
    
    
}
