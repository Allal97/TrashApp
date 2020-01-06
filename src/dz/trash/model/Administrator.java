/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.trash.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author bkral
 */
public class Administrator extends User{
    
    private String email;

    public Administrator() {
        
    }
    
    public Administrator(String email, int id, String lastName, String firstName, String userName, String password, Date birthDate) {
        super(id, lastName, firstName, userName, password, birthDate);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean equals(Object obj){
        return obj instanceof Administrator && getId() == ((Administrator) obj).getId();
    }
    
    public void deleteClient(){
        // there is code to be implemented here
    }
    
    public void disableChallenge(){
        // there is code to be implemented here
    }
    
    
    
}
