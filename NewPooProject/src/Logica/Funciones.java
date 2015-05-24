/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public class Funciones {
    
    
    
    
    /*
    Basicamente este metodo toma una cadena y retorna solo la parte del ID guiado x
    indices tiene capacidad para retornar hasta un id maximo de 999999 se le puede
    poner mas o menos ademas el recorrido de busqeda para el ID inicia del indice 3
    */
    public static String getIDTiket(String pCadena){
	int incioIndex = 8;
        String pID = pCadena.substring(7,8);
        for (int i = 9; i < 13; i++){
            try {
                Integer.parseInt(pCadena.substring(incioIndex,i));
                pID += pCadena.substring(incioIndex,i);
                incioIndex++;
            }
            catch (NumberFormatException nfe) {
                break;
            }
        }
    return pID;
    }
    /*
    recibe como parametro un ID de algun tiket, recorre la lista de tikets y 
    despliega la informacion del tiket en el jTexArea
    */
    public static String cargaInfoTiket(String pID){
            String result = null;
            ArrayList <Tickets> ArrayListTicket =  ManejadorDeListas.getListaDePendientes();//Array de los tickets
            for (Tickets ticket: ArrayListTicket) {   
            if(Integer.toString(ticket.getIDTicket()).equals(pID)){
                result = "\n\nIdentificador: ";
                result += Integer.toString(ticket.getIDTicket());
                result += "\nAsunto: ";
                result += ticket.getAsunto();
            }
        }
    return result;
    }
    
    public static String cargaInfoTiketVerde(String pID){
            String result = null;
            ArrayList <Tickets> ArrayListTicketVerde =  ManejadorDeListas.getListaDeVerdes();//Array de los tickets verdes
            for (Tickets ticket: ArrayListTicketVerde) {   
            if(Integer.toString(ticket.getIDTicket()).equals(pID)){
                result = "\n\nIdentificador: ";
                result += Integer.toString(ticket.getIDTicket());
                result += "\nAsunto: ";
                result += ticket.getAsunto();
                result += "\nCategoría: ";
                result += ticket.getCategoria();
            }
        }
    return result;
    }
    
    
    public static String cargaInfoTiketAmarillo(String pID){
            String result = null;
            ArrayList <Tickets> ArrayListTicketAmarillo =  ManejadorDeListas.getListaDeAmarillos();//Array de los tickets
            for (Tickets ticket: ArrayListTicketAmarillo) {   
            if(Integer.toString(ticket.getIDTicket()).equals(pID)){
                result = "\n\nIdentificador: ";
                result += Integer.toString(ticket.getIDTicket());
                result += "\nAsunto: ";
                result += ticket.getAsunto();
                result += "\nCategoría: ";
                result += ticket.getCategoria();
            }
        }
    return result;
    }
    
    public static String cargaInfoTiketRojo(String pID){
            String result = null;
            ArrayList <Tickets> ArrayListTicketRojos =  ManejadorDeListas.getListaDeRojos();//Array de los tickets
            for (Tickets ticket: ArrayListTicketRojos) {   
            if(Integer.toString(ticket.getIDTicket()).equals(pID)){
                result = "\n\nIdentificador: ";
                result += Integer.toString(ticket.getIDTicket());
                result += "\nAsunto: ";
                result += ticket.getAsunto();
                result += "\nCategoría: ";
                result += ticket.getCategoria();
            }
        }
    return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//
