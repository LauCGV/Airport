/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.table;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import core.models.storage.PassengerStorage;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import java.util.Comparator;

public class PassengerTableController {

    public static Response updatePassengerTable(DefaultTableModel model) {
        try {
            model.setRowCount(0); 
            PassengerStorage passengerStorage = PassengerStorage.getInstance();
            ArrayList<Passenger> passengers = passengerStorage.getPassengers();

            if (passengers == null || passengers.isEmpty()) {
                return new Response("The list is empty.", Status.NO_CONTENT, passengers.clone());
            }

            passengers.sort(Comparator.comparingLong(Passenger::getId));

            for (Passenger passenger : passengers) {
                model.addRow(new Object[]{
                    passenger.getId(),
                    passenger.getFirstname(),
                    passenger.getBirthDate(),
                    passenger.calculateAge(),
                    passenger.generateFullPhone(),
                    passenger.getCountry(),
                    passenger.getNumFlights()
                });
            }

            return new Response("Data successfully added", Status.OK, passengers.clone());
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
