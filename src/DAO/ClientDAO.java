/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dz.trash.model.Client;
import dz.trash.model.User;
import java.sql.Connection;

/**
 *
 * @author bkral
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ClientDAO extends DAO<Client> {

    private UserDAO userDAO;

    public ClientDAO(Connection con){
        super(con);
        this.userDAO = new UserDAO(con);
    }

    private static final String FIND_ALL = "SELECT * FROM Client ORDER BY id";

    @Override
    public boolean delete (Client obj)throws Exception{
        return UserDAO.delete(obj) && super.delete(obj);
    }

    @Override
    public boolean create (Client obj) throws SQLException{
        if (UserDAO.create(obj)){
            return super.create(obj);
        }
        return false;
    }

    @Override
    public boolean update (Client obj) throws Exception{
        return userDAO.update(obj) && super.update(obj);
    }

    public Client find(int id) throws SQLException{
        ResultSet result = null;
        User parent = userDAO.find(result.getInt("id"));
        return new Client(result.getInt("id"),
        parent.getLastName(),
        parent.getFirstName(),
        parent.getUserName(),
        parent.getPassword(),
        parent.getBirthdate(),
        result.getString("phoneNumber"),
        result.getString("androidVersion"));
    }

    public Set<Client> findAll() throws SQLException{
        PreparedStatement stmt = con.prepareStatement(FIND_ALL);
        ResultSet result = stmt.executeQuery();
        Set<Client> records = new HashSet<>();
        while(result.next()){
            Client client = new Client();
            Client.setId(result.getInt("id"));
            client.setLastName(result.getString("lastName"));
            client.setFirstName(result.getString("firstName"));
            client.setUserName(result.getString("userName"));
            client.setPassword(result.getString("password"));
            client.setBirthDate(result.getDate("birthDate"));
            client.setPhoneNumber(result.getString("phoneNumber"));
            client.setAndroiVersion(result.getString("androidVersion"));
            records.add(client);
        }

        return records;

    }
}
