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
public class Commentaire {
    
    private int id;
    private String content;
    private LocalDate creationDate;
    private boolean isEnabled;
    private Client rClient;
    

    public Commentaire() {
        
    }
    
    public Commentaire(int id, String content, LocalDate creationDate, boolean isEnabled, Client rClient) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
        this.isEnabled = isEnabled;
        this.rClient = rClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }


    public Client getrClient() {
        return rClient;
    }

    public void setrClient(Client rClient) {
        this.rClient = rClient;
    }

    public void addrClient(Client client){
       /* if(!getrClient().contains(client)){
            getrClient().remove(client);
        }*/

       setrClient(client);
    }



    public void setClient(Client client){
        this.rClient = client;
    }

    public boolean equals(Object obj){
        return obj instanceof Commentaire && getId() == ((Commentaire) obj).getId();
    }

   
    
    
    
}
