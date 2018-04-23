/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jg.rsi;

//Service Implementation

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;


//@WebService(endpointInterface = "org.jg.rsi.HelloWorld", portName = "portN", serviceName = "ServiceName", targetNamespace = "t_name")
@WebService(endpointInterface = "org.jg.rsi.HelloWorld")
@HandlerChain(file="handler-chain.xml")

public class HelloWorldImpl implements HelloWorld  {
        
@Override
public void addEvent(String name, String typeOfEvent,
           int day, int month, int year, String description){
        // Creating dateObject and calculating week    
        Calendar dateOfEvent = new GregorianCalendar(year,(month-1),day);
        int week = dateOfEvent.get(Calendar.WEEK_OF_YEAR);
        // Creating variable for connection with database
        int id = 0;
        String dataBaseURL = "jdbc:derby://localhost:1527/Events";
        String userName = "kuba";
        String password = "kuba";
        String query = "Select * from KUBA.TESTOS";
        Connection myConnObj =  null;
        Statement myStateObj = null;
        ResultSet myResObj = null;
        try{
            // Connecting to database
            myConnObj = DriverManager.getConnection(dataBaseURL, userName, password);
            System.out.println("Connection Created");
            myStateObj = myConnObj.createStatement();
            // getting lasr id in database
            myResObj = myStateObj.executeQuery(query);
            while(myResObj.next()){
                id = myResObj.getInt("ID");
                System.out.println(id+"\t");
            }
              id++;
           // adding Event to database
            String addQuery = "INSERT INTO KUBA.TESTOS (ID, NAME, TYPE, DAY, MONTH, YEAR_, WEEK, DESCRIPTION)\n" +
                    "VALUES ("+id+", \'"+name+"\' , \'"+typeOfEvent+
                    "\' , "+day+" , "+month+" , "+year+" , "+week+" , \'"+description+"\' )";
            myStateObj.executeUpdate(addQuery);
        }
        catch(SQLException e){
            e.printStackTrace();
        }


}

@Override
public List<Events> getEventsOfDay(int day, int month, int year){
    
        // Creating variable for connection with database
        List<Events> resultList = new LinkedList();
        String dataBaseURL = "jdbc:derby://localhost:1527/Events";
        String userName = "kuba";
        String password = "kuba";
        String query = "Select * from KUBA.TESTOS WHERE"+" DAY = "+day+" AND MONTH = "+month+ " AND YEAR_ = "+year; 
        Connection myConnObj =  null;
        Statement myStateObj = null;
        ResultSet myResObj = null;
        try{
            // Connecting with database
            myConnObj = DriverManager.getConnection(dataBaseURL, userName, password);
            System.out.println("Connection Created");
            myStateObj = myConnObj.createStatement();
            // executing Select Query
            myResObj = myStateObj.executeQuery(query);
            while(myResObj.next()){
                String name = myResObj.getString("NAME");
                String typeOfEvent = myResObj.getString("TYPE");
                String description = myResObj.getString("DESCRIPTION");
                int dayOfEvent = myResObj.getInt("DAY");                
                int weekOfEvent = myResObj.getInt("WEEK");
                int monthOfEvent = myResObj.getInt("MONTH");
                int yearOfEvent = myResObj.getInt("YEAR_");
                int id = myResObj.getInt("ID");
                // Creating result list with Events
                Events event = new Events(name, typeOfEvent, description, dayOfEvent, weekOfEvent, 
                                   monthOfEvent, yearOfEvent,id);
                resultList.add(event);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return resultList;
}

@Override
public List<Events> getEventsOfWeek(int week , int year){
        
        // Creating variable for connection with database
        List<Events> resultList = new LinkedList();
        String dataBaseURL = "jdbc:derby://localhost:1527/Events";
        String userName = "kuba";
        String password = "kuba";
        String query = "Select * from KUBA.TESTOS WHERE"+" WEEK = "+week+" AND YEAR_ = "+year;
        Connection myConnObj =  null;
        Statement myStateObj = null;
        ResultSet myResObj = null;
        try{
            // Connecting with database            
            myConnObj = DriverManager.getConnection(dataBaseURL, userName, password);
            System.out.println("Connection Created");
            myStateObj = myConnObj.createStatement();
            // executing Select Query            
            myResObj = myStateObj.executeQuery(query);
            while(myResObj.next()){
                String name = myResObj.getString("NAME");
                String typeOfEvent = myResObj.getString("TYPE");
                String description = myResObj.getString("DESCRIPTION");
                int dayOfEvent = myResObj.getInt("DAY");                
                int weekOfEvent = myResObj.getInt("WEEK");
                int monthOfEvent = myResObj.getInt("MONTH");
                int yearOfEvent = myResObj.getInt("YEAR_");
                int id = myResObj.getInt("ID");
                // Creating result list with Events
                Events event = new Events(name, typeOfEvent, description, dayOfEvent, weekOfEvent, 
                                   monthOfEvent, yearOfEvent, id);
                resultList.add(event);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return resultList;
}

public void modifyEvent(int id, String name, String typeOfEvent,
           int day, int month, int year, String description){
    
        // Creating dateObject and calculating week    
        Calendar dateOfEvent = new GregorianCalendar(year, (month-1),day);
        int week = dateOfEvent.get(Calendar.WEEK_OF_YEAR);
        // Creating variable for connection with database
        String dataBaseURL = "jdbc:derby://localhost:1527/Events";
        String userName = "kuba";
        String password = "kuba";
        String query = "Update KUBA.TESTOS SET NAME = \'"+name+"\', TYPE = \'"+typeOfEvent+
                "\', DAY = "+day+", MONTH = "+month+", YEAR_ = "+year+
                ", WEEK = "+week+", DESCRIPTION = \'"+description+"\' WHERE "+"ID = "+id;
        Connection myConnObj =  null;
        Statement myStateObj = null;
        ResultSet myResObj = null;
        try{
            // Connecting with database                        
            myConnObj = DriverManager.getConnection(dataBaseURL, userName, password);
            System.out.println("Connection Created");
           // modifying Event with desired ID            
            myStateObj = myConnObj.createStatement();
            myStateObj.executeUpdate(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }      
}
}