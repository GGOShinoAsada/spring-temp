package com.company.model;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrext {
    public List<Task> getAllTasks(){
        List<Task> tasks = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/springtest?ServerTimeZone=\'UTC\'","root","0000");
            String query = "select * from task";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()){
                int id= result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                Date date = new Date(result.getDate("date").getTime());
                tasks.add(new Task(id, name, description, date));
            }
        }
        catch (SQLException ex){
            try{
                connection.close();
                result.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex.printStackTrace();
            }
            ex.printStackTrace();
        }
        finally{
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return tasks;
    }
    public Task getTaskById(int id){
        Task task = new Task();
        ResultSet result = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/springtest?ServerTimeZone=\'UTC\'");
           Class.forName("com.mysql.jdbc.driver").getDeclaredConstructor().newInstance();
            String query = "select * from task where id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            result = statement.executeQuery();
            while (result.next()){
                Integer id1 = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                Date date = new Date(result.getDate("date").getTime());
                task.setId(id1);
                task.setName(name);
                task.setDescription(description);
                task.setDate(date);
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
        catch ( ClassNotFoundException | NoSuchMethodException ex){
            try{
                connection.close();
                result.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
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
    public void addTask(Task task){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc://mysql/localhost/springtest?ServerTimeZone=\'UTC\'","root","0000");
            Class.forName("com.mysql.jdbc.driver").getDeclaredConstructor().newInstance();
            String query = "insert into task (id, name, description, date) values (?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1,task.getId());
            statement.setString(2,task.getName());
            statement.setString(3,task.getDescription());
            statement.setDate(4,new java.sql.Date(task.getDate().getTime()));
            statement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException ex){
            try {
                connection.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
    }
    public void removeTask(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc://mysql/localhost/springtest?ServerTimeZone=\'UTC\'","root","0000");
            String query = "delete from task where id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeQuery();
        }
        catch (SQLException ex){
            try{
                connection.close();
                statement.close();
            }
            catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        finally {
            try{
                connection.close();
                statement.close();
            }
            catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
    }
    public void updateTask(Task task){
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        ResultSet result = null;
        try{
            connection = DriverManager.getConnection("jdbc://mysql/localhost/springtest?ServerTimeZone=\'UTC\'","root","0000");
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            String query = "select id from task where id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,task.getId());
            Task newtask = new Task();
            result = statement.executeQuery();
            while (result.next()){
                String name = result.getString("name");
                String description = result.getString("description");
                Date date = new java.util.Date(result.getDate("date").getTime());
                newtask.setId(task.getId());
                newtask.setName(name);
                newtask.setDescription(description);
                newtask.setDate(date);
            }
            statement.close();

           String query1 = "update task set name =?, description =?, date =? where id = ?";
            statement1 = connection.prepareStatement(query1);
            statement1.setString(1,newtask.getName());
            statement1.setString(2,newtask.getDescription());
            statement1.setDate(3,new java.sql.Date(newtask.getDate().getTime()));
            statement1.setInt(4,newtask.getId());
            statement1.executeQuery();
        }
        catch (SQLException | ClassNotFoundException | NoSuchMethodException ex){
            try{
                connection.close();
                statement1.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
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
                statement1.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Task> searchTask(String name){
        List<Task> searchlist = new ArrayList<>();
        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;
        try{
            String query = "select * from task where name=?";
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc://mysql/localhost/springtest?ServerTimeZone=\'UTC\'","root","0000");
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String n = result.getString("name");
                String d = result.getString("description");
                Date date = new Date(result.getDate("date").getTime());
                searchlist.add(new Task(id,n,d,date));
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
        catch (SQLException ex){
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException ex1){
                ex1.printStackTrace();
            }
        }
        return  searchlist;
    }
}
