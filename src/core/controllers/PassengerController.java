/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.LocalDate;

/**
 *
 * @author Laura
 */
public class PassengerController {
    public static Response PassengerRegistration(String id, String firstname, String lastname, String year, String month,String day,String code, String phone, String country){
    try {
            int idInt, yearInt, monthInt, codeInt ;
            long phoneLong;
            boolean genderB;

            try {
                
                //Transformar el ID en int
                idInt = Integer.parseInt(id);
                if (idInt < 0) {
                    return new Response("Id must be positive", Status.BAD_REQUEST); //Status es una clase abstracta, por lo cual no se debe instanciar ni usar getters
                }
                if(){
                
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
                //Convertir la edad en int
                ageInt = Integer.parseInt(age);
                if (ageInt < 0) {
                    return new Response("Age must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Age must be numeric", Status.BAD_REQUEST);
            }

            if (gender.equals("M")) {
                genderB = false;
            } else if (gender.equals("F")) {
                genderB = true;
            } else {
                return new Response("Gender error", Status.BAD_REQUEST);
            }

            //
            Storage storage = Storage.getInstance();
            if (!storage.addPerson(new Person(idInt, firstname, lastname, ageInt, genderB))) {
                return new Response("A person with that id already exists", Status.BAD_REQUEST);
            }
            return new Response("Person created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
