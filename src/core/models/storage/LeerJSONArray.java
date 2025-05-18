/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeerJSONArray {
    public static void main(String[] args) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get("datos.json")));

            // Convertir a JSONArray
            JSONArray personas = new JSONArray(contenido);

            // Iterar sobre cada objeto
            for (int i = 0; i < personas.length(); i++) {
                JSONObject persona = personas.getJSONObject(i);
                String nombre = persona.getString("nombre");
                int edad = persona.getInt("edad");

                System.out.println("Nombre: " + nombre + ", Edad: " + edad);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (org.json.JSONException e) {
            System.out.println("Error al procesar el JSON: " + e.getMessage());
        }
    }
}