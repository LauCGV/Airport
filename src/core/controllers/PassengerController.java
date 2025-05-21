/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Ordenamiento;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import core.models.storage.PassengerStorage;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class PassengerController {

    public static Response passengerRegistration(String id, String firstname, String lastname, String year, String month, String day, String code, String phone, String country) {
        PassengerStorage passengerRegister = PassengerStorage.getInstance();
        ArrayList<Passenger> passengers = passengerRegister.getPassengers();
        try {
            int  yearInt, monthInt, codeInt;
            long phoneLong, idLong;
            boolean genderB;
            LocalDate birthday;

            try {
                idLong = Long.parseLong(id);
                if (idLong < 0) {
                    return new Response("Id must be a positive", Status.BAD_REQUEST);
                }

                if (id.length() > 15) {
                    return new Response("Id must have a maximum of 15 digits", Status.BAD_REQUEST);
                }

                if (passengers != null) {
                    for (Passenger passenger : passengers) {
                        if (passenger.getId() == idLong) {
                            return new Response("Id in use. Enter another id", Status.BAD_REQUEST);
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }

            if (firstname.equals("")) {
                return new Response("Firstname must be not empty", Status.BAD_REQUEST);
            }

            if (lastname.equals("")) {
                return new Response("Lastname must be not empty", Status.BAD_REQUEST);
            }

            try {
                yearInt = Integer.parseInt(year);
                if (yearInt < 2000) {
                    return new Response("Year must be greater than 2000", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Year must be numeric", Status.BAD_REQUEST);
            }

            if (month.equals("Month")) {
                return new Response("Select a month", Status.BAD_REQUEST);
            }

            if (day.equals("Day")) {
                return new Response("Select a day", Status.BAD_REQUEST);
            }

            try {
                String localDate = String.format("%s-%02d-%02d", year, Integer.parseInt(month), Integer.parseInt(day));
                birthday = LocalDate.parse(localDate);
            } catch (DateTimeParseException e) {
                return new Response("Date invalid", Status.BAD_REQUEST);
            }
            try {
                codeInt = Integer.parseInt(code);
                if (codeInt < 0 || code.length() > 3) {
                    return new Response("The code must be 1 to 3 digits long", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Code must be numeric", Status.BAD_REQUEST);
            }

            try {
                phoneLong = Long.parseLong(code);
                if (phoneLong < 0 || phone.length() > 11) {
                    return new Response("Phone must be 0 to 11 digits long", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone must be numeric", Status.BAD_REQUEST);
            }
            
            if (country.equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }
            Passenger passengerTemp = new Passenger(idLong, firstname, lastname, birthday, codeInt, phoneLong, country);
            passengers.add(passengerTemp); 
            
            return new Response("Person created successfully", Status.CREATED);
            
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
