package com.company.spring.model;

import javafx.scene.chart.ScatterChart;

import javax.print.attribute.standard.PresentationDirection;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Context
{
    String connectionstring = "jdbc/mysql/springtest?ServerTimeZone=\'UTC\'";
    String username = "root";
    String password = "0000";
    private boolean isinsert;

    public List<Task> getAllTasks(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Task> tasks = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(connectionstring, username, password);
            String query = "select * from tasks";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()){
                int i = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                java.sql.Date data = result.getDate("date");
                tasks.add(new Task(i, name, description, new java.util.Date(data.getTime())));
            }
        }
        catch (SQLException ex){
            try{
                connection.close();
                result.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        catch (ClassNotFoundException | NoSuchMethodException ex){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
                result.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        return tasks;
    }
    public Task getTaskById(int id){
        Task task = new Task();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(connectionstring, username, password);
            String query = "select * from task where id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            result = statement.executeQuery();
            while (result.next()){
                task.setId(result.getInt("id"));
                task.setName(result.getString("name"));
                task.setDescription(result.getString("description"));
                task.setDate(new java.util.Date(result.getDate("date").getTime()));
            }
        }
        catch (SQLException ex){
            try{
                connection.close();
                result.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        catch (ClassNotFoundException | NoSuchMethodException ex1){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try{
                connection.close();
                result.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        return task;
    }
    public boolean insertTask(Task task){
        boolean isinsert = true;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(connectionstring, username, password);
            String query = "insert into task (id, name, description, date) values (?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1,task.getId());
            statement.setString(2,task.getName());
            statement.setString(3,task.getDescription());
            statement.setDate(4,new java.sql.Date(new java.util.Date().getTime()));
            isinsert = statement.executeUpdate()>0;
        }
        catch (SQLException ex1){
            try{
                isinsert = false;
                connection.close();
                statement.close();
            }
            catch (SQLException ex2){
                ex2.printStackTrace();
            }
        }
        catch (ClassNotFoundException | NoSuchMethodException ex){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try{

                connection.close();
                statement.close();
            }
            catch (SQLException ex2){
                ex2.printStackTrace();
            }
        }
        return isinsert;
    }
    public  boolean updateTask(Task task){
        boolean isupdate = true;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(connectionstring, username, password);
            String query = "update task set name=?, description = ?, date=? where id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1,task.getName());
            statement.setString(2,task.getDescription());
            statement.setDate(3,new java.sql.Date(task.getDate().getTime()));
            isupdate = statement.executeUpdate()>0;
        }
        catch (SQLException ex){
            try{
                isupdate = false;
                connection.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        catch (ClassNotFoundException | NoSuchMethodException ex1){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try{
                connection.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        return isupdate;
    }
    public boolean removeTask(int id){
        boolean isremoved = true;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(connectionstring,username,password);
            String query = "detete from task where id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            isremoved = statement.executeLargeUpdate()>0;
        }
        catch (SQLException ex1){
            try{
                connection.close();
                statement.close();
            }
            catch (SQLException ex2){
                ex2.printStackTrace();
            }
        }
        finally {
            try{
                connection.close();
                statement.close();
            }
            catch (SQLException ex2){
                ex2.printStackTrace();
            }
        }
        return isremoved;
    }
}
