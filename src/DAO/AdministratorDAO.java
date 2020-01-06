/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dz.trash.model.Administrator;
import dz.trash.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

/**
 *
 * @author bkral
 */
public class AdministratorDAO extends DAO<Administrator> {

    private UserDAO userDAO;

    public AdministratorDAO(Connection con){
        super(con);
        this.userDAO = new UserDAO(con);
    }

    private static final String FIND_ALL = "SELECT * FROM Administrator ORDER BY id";

    @Override
    public boolean delete(Administrator obj) throws Exception{
        return userDAO.delete(obj) && super.delete(obj);
    }

    @Override
    public boolean create (Administrator obj) throws SQLException{
        if (UserDAO.create(obj)){
            return super.create(obj);
        }
        return false;
    }

    @Override
    public boolean update (Administrator obj) throws Exception{
        return userDAO.update(obj) && super.update(obj);
    }

    public Administrator find(int id) throws SQLException{
        ResultSet result = null;
        User parent = userDAO.find(result.getInt("id"));
        return new Administrator(result.getInt("id")),
        parent.getLastName(),
        parent.getFirstName(),
        parent.getUserName(),
        parent.getPassword(),
        parent.getBirthdate(),
        result.getString("email");
    }

    public Set<Administrator> findAll() throws SQLException{
        PreparedStatement stmt = con.prepareStatement(FIND_ALL);
        ResultSet result = stmt.executeQuery();
        Set<Administrator> records = new HashSet<>();
        while(result.next()){
            Administrator administrator = new Administrator();
            administrator.setId(result.getInt("id"));
            administrator.setLastName(result.getString("lastName"));
            administrator.setFirstName(result.getString("firstName"));
            administrator.setUserName(result.getString("userName"));
            administrator.setPassword(result.getString("password"));
            administrator.setBirthdate(result.getDate("birthDate"));
            administrator.setPhoneNumber(result.getString("email"));
            records.add(administrator);
        }
        return records ;
    }
}