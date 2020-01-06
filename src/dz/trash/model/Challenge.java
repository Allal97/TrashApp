/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.trash.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bkral
 */
public class Challenge {
    
    private int id;
    private int ownerId;
    private LocalDate creationDate;
    private int state;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private Address rAddress;
    private Set<Photo> rPhoto;
    private Set<Commentaire> rCommentaire;
    private Note rNote;
    private Client rClient;
    
    
    
    
    public Challenge(){
        //rCommentaire = new HashSet<Commentaire>();
        //rNote = new HashSet<Note>();
    }

    public Challenge(int id, LocalDate creationDate, int state, LocalDate startingDate, LocalDate endingDate, HashSet<Photo> rPhoto) {
        this.id = id;
        this.creationDate = creationDate;
        this.state = state;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.rPhoto = rPhoto;
        rCommentaire = new HashSet<Commentaire>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    
    
    
    public boolean equals(Object obj){
        return obj instanceof Challenge && getId() == ((Challenge) obj).getId();
    }
    
    public int getParticipantCount(){
        // there is still code to be implemented here
        return 0;
    }

    public Address getrAddress() {
        return rAddress;
    }

    public void setrAddress(Address rAddress) {
        this.rAddress = rAddress;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }
    
    public void addAddress (Address address){
        setrAddress(address);
    }
    
    public void removeAddress(){
        setrAddress(null);
    }
    
    public void setAddress(Address address){
        this.rAddress = address;
    }

    public Set<Photo> getrPhoto() {
        return rPhoto;
    }

    public void setrPhoto(Set<Photo> rPhoto) {
        this.rPhoto = rPhoto;
    }
    
    
    
    public void addrPhoto(Photo photo){
        if (!getrPhoto().contains(photo)){
            getrPhoto().add(photo);
        }
    }
    
    public void removerPhoto(Photo photo){
        if(getrPhoto().contains(photo)){
            getrPhoto().remove(photo);
        }
    }
    
    public void setPhoto(Set<Photo> photo){
        this.rPhoto=photo;
    }

    public Set<Commentaire> getrCommentaire() {
        return rCommentaire;
    }

    public void setrCommentaire(Set<Commentaire> rCommentaire) {
        this.rCommentaire = rCommentaire;
    }
    
    public void addrCommentaire(Commentaire commentaire){
        if(!getrCommentaire().contains(commentaire)){
            getrCommentaire().add(commentaire);
        }
    }
    
    public void removerCommentaire(Commentaire commentaire){
        if(getrCommentaire().contains(commentaire)){
            getrCommentaire().remove(commentaire);
        }
    }
    
    public void setCommentaire(Set<Commentaire> commentaire){
        this.rCommentaire = commentaire;
    }

    public Note getrNote() {
        return rNote;
    }

    public void setrNote(Note rNote) {
        this.rNote = rNote;
    }
    
    /*public void addrNote(Note note){
        if(!getrNote().contains(note)){
            if(note.getrChallenge() !=null){
                note.removerChallenge();
            }
            note.setrChallenge((Set<Challenge>) this);
            getrNote().add(note);
        }
    }*/
    
    /*public void removerNote(Note note){
        if (getrNote().contains(note)){
            getrNote().remove(note);
            note.setrChallenge(null);
        }
    }*/
    
    public void setNote(Note note){
        this.rNote = note;
    }

    public Client getrClient() {
        return rClient;
    }

    public void setrClient(Client rClient) {
        this.rClient = rClient;
    }
    
    public void addrClient(Client client){
        if(!client.getrChallenge().contains(this)){
            if(getrClient() != null){
                removerClient();
            }
        }
        setrClient(client);
        client.addrChallenge(this);
    }
    
    public void removerClient(){
        getrClient().removerChallenge(this);
        setrClient(null);
    }
    
    public void setClient(Client client){
        this.rClient = client;
    }
    
    
    
    
    
    
    
    
    
    
    
}
