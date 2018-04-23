/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jg.rsi;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jakub
 */
public class Events {

    private String name;
    private String type;
    private String description;    
    private int day;
    private int week;
    private int month;
    private int year;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }    
    // konstruktor z jakiegos powodu tak sie robi
    Events(String name, String type,
           String description, int day, int week, int month, int year, int id){
        this.name = name;
        this.type = type;
        this.day = day;
        this.description = description;
        this.week = week;
        this.month = month;   
        this.year = year;
        this.id = id;
    }
    
    
}
