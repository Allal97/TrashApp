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
public class Photo {
    
    private int id;
    private String path;
    private LocalDate creationDate;
    
    public Photo(){
        
    }

    public Photo(int integer, String path, LocalDate creationDate) {
        this.id = integer;
        this.path = path;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int integer) {
        this.id = integer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    
    public boolean equals(Object obj){
        return obj instanceof Photo && getId() == ((Photo) obj).getId();
    }
    
    
    
}
