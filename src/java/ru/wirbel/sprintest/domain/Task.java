/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.wirbel.sprintest.domain;

/**
 *
 * @author roman
 * 
 *
 */
import java.util.Date;

public class Task {
    private int id;
    private String name;
    private String Descriprion;
    private Date date;

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriprion() {
        return Descriprion;
    }

    public void setDescriprion(String Descriprion) {
        this.Descriprion = Descriprion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
