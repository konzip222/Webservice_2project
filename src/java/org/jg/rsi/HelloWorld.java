/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jg.rsi;

/**
 *
 * @author Jakub
 */

import java.util.Calendar;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import javax.jws.WebService;

import javax.jws.soap.SOAPBinding;

import javax.jws.soap.SOAPBinding.Style;

import javax.jws.soap.SOAPBinding.Use;

@WebService

@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL) //optional

public interface HelloWorld {

/**
 * This method returns Events of Day 
 * @param  day  number of Day (1-31)
 * @param  month number of Month(1-12)
 * @param  year number of year
 * @return List<Events>
 */
@WebMethod
public List<Events> getEventsOfDay(@WebParam(name = "day") int day, @WebParam(name = "month") int month, @WebParam(name = "year") int year);
/**
 * This method returns Events of Week 
 * @param  week  number of Day (1-52)
 * @param  year number of year
 * @return List<Events>
 */
@WebMethod
public List<Events> getEventsOfWeek(@WebParam(name = "week") int week , @WebParam(name = "year") int year);
/**
 * This method modifies Event with desire ID 
 * @param  id  ID of Event that you want to modify
 * @param  name new name of Event
 * @param  typeOfEvent new type of Event
 * @param  day new day of Event
 * @param  month new month of Event
 * @param  year new year of Event
 * @param  description new description of Event
 */
@WebMethod
public void modifyEvent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "type") String typeOfEvent,
           @WebParam(name = "day") int day, @WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "description") String description);
/**
 * This method add Event 
 * @param  name name of Event
 * @param  typeOfEvent type of Event
 * @param  day day of Event
 * @param  month month of Event
 * @param  year year of Event
 * @param  description description of Event
 */
@WebMethod
public void addEvent(@WebParam(name = "name") String name, @WebParam(name = "type") String typeOfEvent,
           @WebParam(name = "day") int day, @WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "description") String description);
}