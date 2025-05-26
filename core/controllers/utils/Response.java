/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

/**
 *
 * @author Laura
 */
public class Response {
    //Clase que contiene las condiciones de la respuesta al usuario
    
    private String message;
    private int status;
    private Object object; //Puede ser de cualquier tipo

    //La respuesta debe contener un mensaje y un estado
    public Response(String message, int status, Object object) {
        this.message = message;
        this.status = status;
        this.object = object;
    }
    
    public Response(String message, int status) {
        this.message = message;
        this.status = status;
    }

    
    
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Object getObject() {
        return object;
    }

    
    
}
