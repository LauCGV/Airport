/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.flights;

import core.models.Flight;
import java.time.LocalDateTime;

/**
 *
 * @author Laura
 */
public class DelayFlight {
    public static void delay(Flight flight, int hour, int minutes){
        System.out.println(flight.getDepartureDate());
        flight.setDepartureDate(flight.getDepartureDate().plusHours(hour).plusMinutes(minutes));
        System.out.println(flight.getDepartureDate());
    }
}
