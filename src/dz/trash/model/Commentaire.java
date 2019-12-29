/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.trash.model;

import java.time.LocalDate;

/**
 *
 * @author bkral
 */
public class Commentaire {
    
    private int id;
    private String content;
    private LocalDate creationDate;
    private boolean isEnabled;
    

    public Commentaire() {
        
    }
    
    public Commentaire(int id, String content, LocalDate creationDate, boolean isEnabled) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
        this.isEnabled = isEnabled;
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
    
    public boolean equals(Object obj){
        return obj instanceof Commentaire && getId() == ((Commentaire) obj).getId();
    }

   
    
    
    
}
