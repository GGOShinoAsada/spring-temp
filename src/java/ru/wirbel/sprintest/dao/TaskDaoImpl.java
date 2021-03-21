/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.wirbel.sprintest.dao;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import ru.wirbel.sprintest.domain.Task;

/**
 *
 * @author roman
 */
public class TaskDaoImpl implements TaskDao {

    @Override
    public List<Task> listAllTasks() {
        Connection con = null;
        List<Task> tasks = new ArrayList();
        Statement s = null;
        ResultSet r = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC","root","0000");
            String query = "select * from task";
            s = con.createStatement();
            r = s.executeQuery(query);
            while (r.next()){
                int id = r.getInt("id");
                String n = r.getString("name");
                String d = r.getString("description");
                java.util.Date d11 = new java.util.Date(r.getDate("date").getTime());
                tasks.add(new Task(id,n,d,d11));
            }
        }
        catch (SQLException ex){
            try{
                con.close();
                s.close();
                r.close();
            }
            catch (SQLException ex2){
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
        finally{
            try{
                con.close();
                s.close();
                r.close();
            }
            catch (SQLException e1){
                e1.printStackTrace();
            }
        }
        return tasks;
    }

    @Override
    public Task getTaskById(Integer tid) {
        Task t = null;
        Statement s = null;
        Connection c = null;
        ResultSet r = null;
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC","root","0000");
            String query = "select * from task where id ="+tid;
            s = c.createStatement();
            r = s.executeQuery(query);
            while (r.next()){
                int id = r.getInt("id");
                String n = r.getString("name");
                String d = r.getString("description");
                java.util.Date d11 = new java.util.Date(r.getDate("date").getTime());
                t = new Task(id,n,d,d11);
            }
        }
        catch (SQLException ex){
            try{
                r.close();
                c.close();
                s.close();
            }
            catch (SQLException elvl2){
                elvl2.printStackTrace();
            }
        }
        finally{
            try{
                r.close();
                s.close();
                r.close();
            }
            catch (SQLException e3){
                e3.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public boolean addTask(Task t) {
        Connection c = null;
        PreparedStatement s = null;
        boolean t1 = true;
        try {
            String query = "insert into tasks (id, name, description, date) values (?,?,?,?)";
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC","root","0000");
            s = c.prepareCall(query);
            s.setInt(1, t.getId());
            s.setString(2, t.getName());
            s.setString(3,t.getDescriprion());
            s.setDate(4, new java.sql.Date(t.getDate().getTime()));
            t1 = (s.executeUpdate()>0)?true:false;
        }
        catch (SQLException e1){
            try{
                s.close();;
                c.close();
            }
            catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        finally{
            try{
                s.close();
                c.close();
            }
            catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return t1;
    }

    @Override
    public boolean updateTask(Task t) {
       boolean t1 = true;
       Connection c = null;
       PreparedStatement pr = null;
       try{
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC","root","0000");
           String query = "update task set name=?, description =?, date = ? where id = ?";
           pr = c.prepareStatement(query);
           pr.setString(1, t.getName());
           pr.setString(2,t.getDescriprion());
           pr.setDate(3, new java.sql.Date(t.getDate().getTime()));
           pr.setInt(4, t.getId());
           t1 = (pr.executeUpdate()>0)?true:false;
       }
       catch (SQLException ex2){
           try {
               pr.close();;
               c.close();
           }
           catch (SQLException e3){
               e3.printStackTrace();
           }
       }
       finally {
           try{
               pr.close();
               c.close();
           }
           catch (SQLException e){
               e.printStackTrace();
           }
       }
       return t1;
    }

    @Override
    public boolean RemoveTask(Task t) {
        boolean t1 = true;
        Connection c = null;
        PreparedStatement r = null;
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC","root","0000");
            String query = "delete from task where id = ?";
            r = c.prepareStatement(query);
            r.setInt(1, t.getId());
            t1 = (r.executeUpdate()>0)?true:false;
        }
        catch (SQLException e3){
            try{
                r.close();
                c.close();
            }
            catch (SQLException e4){
                e4.printStackTrace();
            }
        }
        finally {
             try{
                r.close();
                c.close();
            }
            catch (SQLException e4){
                e4.printStackTrace();
            }
        }
        return t1;
    }
    
}
