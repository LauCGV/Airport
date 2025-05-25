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

/**
 *
 * @author Allison Ruiz
 */
import java.util.Comparator;

public class PassengerListController {

    public static Response updatePassengerList(DefaultTableModel model) {
        try {
            model.setRowCount(0); // Limpiar el modelo
            PassengerStorage passengerStorage = PassengerStorage.getInstance();
            ArrayList<Passenger> passengers = passengerStorage.getPassengers();

            if (passengers == null || passengers.isEmpty()) {
                return new Response("The list is empty.", Status.NO_CONTENT);
            }

            // Ordenar por ID ascendente
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

            return new Response("List updated successfully.", Status.OK);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
