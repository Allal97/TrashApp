/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dz.trash.model.User;
import java.sql.Connection;

/**
 *
 * @author bkral
 */
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDAO extends DAO<User> {
    public UserDAO (Connection con){
        super(con);
    }

    private static final String DRIVER_NAME = "";
    private static final String DB_URL = "";
    private static final String ID = "";
    private static final String PASS = "";

    private static final String DELETE = "DELETE FROM User WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM User ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM User WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM User WHERE firstName = ?";
    private static final String INSERT = "INSERT INTO User (lastName, firstName, userName, password, birthDate) VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPADATE User SET lastName = ?, firstName = ?, userName = ?, password = ?, birthDate = ? WHERE id = ?";

    public boolean delete(User user) throws Exception{
        PreparedStatement stmt = con.prepareStatement(DELETE);
        stmt.setInt(1,getPrimaryKey(user));
        return stmt.execute();
    }

    protected int getPrimaryKey(User user) throws Exception{
        Field f = user.getClass().getDeclaredField("id");
        f.setAccessible(true);
        return f.getInt(user);
    }

    public Set<User> findAll() throws SQLException{
        PreparedStatement stmt = con.prepareStatement(FIND_ALL);
        ResultSet result = stmt.executeQuery();
        Set<User> records = new HashSet<>();
        while(result.next()){
            User user = new User();
            user.setId(result.getInt("id"));
            user.setLastName(result.getString("lastName"));
            user.setFirstName(result.getString("firstName"));
            user.setUserName(result.getString("userName"));
            user.setPassword(result.getString("password"));
            user.setBirthdate(result.getDate("birthDate"));
            records.add(user);
        }
        return records;
    }

    public User find(int id) throws SQLException{
        PreparedStatement stmt = con.prepareStatement(FIND_BY_ID);
        stmt.setInt(1,id);
        ResultSet result = stmt.executeQuery();

        if (result.next()){
            User user = new User ();
            user.setId(result.getInt("id"));
            user.setLastName(result.getString("lastName"));
            user.setFirstName(result.getString("firstName"));
            user.setUserName(result.getString("userName"));
            user.setPassword(result.getString("password"));
            user.setBirthdate(result.getDate("birthDate"));

            return user;
        }else{
            return null;
        }
    }

    public boolean update(User user) throws Exception{
        PreparedStatement stmt = con.prepareStatement(UPDATE);
        stmt.setInt(1, user.getId());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getFirstName());
        stmt.setString(4, user.getUserName());
        stmt.setString(5, user.getPassword());
        stmt.setDate(6, (Date) user.getBirthdate());

        return stmt.execute();
    }

    public boolean create(User user) throws SQLException{
        PreparedStatement stmt = con.prepareStatement(INSERT);
        stmt.setInt(1, user.getId());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getFirstName());
        stmt.setString(4, user.getUserName());
        stmt.setString(5, user.getPassword());
        stmt.setDate(6, (Date) user.getBirthdate());

        return stmt.execute();

    }
    
}
