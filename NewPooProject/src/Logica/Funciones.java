/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interfaz.VnServidorReportes;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public class Funciones {
    public static boolean origenDeLosTiempos = false;
    
    public static void busquedaTiketsReportes(){
        
        
        if(origenDeLosTiempos==true && (VnServidorReportes.cbTipoBusqueda.getSelectedItem().toString().equals("Fernando"))){
            ArrayList <Tickets> tiketsEncontrados;
            tiketsEncontrados = getTiketsAtendidosTodosUnEmpleado("Fernando");
            for(int i = 0; i < tiketsEncontrados.size() ; i++){
                
                VnServidorReportes.jlReportes.add(Integer.toString(tiketsEncontrados.get(i).getIDTicket()));
                
                
            }   
        }
        
        if(origenDeLosTiempos==true && (VnServidorReportes.cbTipoBusqueda.getSelectedItem().toString().equals("Junior"))){
            ArrayList <Tickets> tiketsEncontrados;
            tiketsEncontrados = getTiketsAtendidosTodosUnEmpleado("Fernando");
            for(int i = 0; i < tiketsEncontrados.size() ; i++){
                
                VnServidorReportes.jlReportes.add(Integer.toString(tiketsEncontrados.get(i).getIDTicket()));
                
                
            }   
        }
        
        if(origenDeLosTiempos==true && (VnServidorReportes.cbTipoBusqueda.getSelectedItem().toString().equals("Luis"))){
            ArrayList <Tickets> tiketsEncontrados;
            tiketsEncontrados = getTiketsAtendidosTodosUnEmpleado("Fernando");
            for(int i = 0; i < tiketsEncontrados.size() ; i++){
                
                VnServidorReportes.jlReportes.add(Integer.toString(tiketsEncontrados.get(i).getIDTicket()));
                
                
            }   
        }
        
        if(origenDeLosTiempos==true && (VnServidorReportes.cbTipoBusqueda.getSelectedItem().toString().equals("Todos"))){
            ArrayList <Tickets> tiketsEncontrados;
            tiketsEncontrados = getTiketsAtendidosTodosUnEmpleado("Fernando");
            for(int i = 0; i < tiketsEncontrados.size() ; i++){
                
                VnServidorReportes.jlReportes.add(Integer.toString(tiketsEncontrados.get(i).getIDTicket()));
                
            }
            tiketsEncontrados = getTiketsAtendidosTodosUnEmpleado("Junior");
            for(int i = 0; i < tiketsEncontrados.size() ; i++){
                
                VnServidorReportes.jlReportes.add(Integer.toString(tiketsEncontrados.get(i).getIDTicket()));
                
            }
            tiketsEncontrados = getTiketsAtendidosTodosUnEmpleado("Luis");
            for(int i = 0; i < tiketsEncontrados.size() ; i++){
                
                VnServidorReportes.jlReportes.add(Integer.toString(tiketsEncontrados.get(i).getIDTicket()));
                
            }
            
        }
        
        
        
        
        
        if(origenDeLosTiempos==false){
            
        
        }
        
        

    }
    
    
    
    
    public static ArrayList <Tickets> getTiketsAtendidosTodosUnEmpleado(String Empleado){
        ArrayList <Tickets> tiketsEncontrados = new ArrayList();
        for(int i = 0; i < ManejadorDeListas.ListaDeVerdes.size(); i++){
            if (ManejadorDeListas.ListaDeVerdes.get(i).getID_EMPLEADO().equals(Empleado)){
                tiketsEncontrados.add(ManejadorDeListas.ListaDeVerdes.get(i));
            }
        }
        for(int i = 0; i < ManejadorDeListas.ListaDeAmarillos.size(); i++){
            if (ManejadorDeListas.ListaDeAmarillos.get(i).getID_EMPLEADO().equals(Empleado)){
                tiketsEncontrados.add(ManejadorDeListas.ListaDeAmarillos.get(i));
            }
        }
        for(int i = 0; i < ManejadorDeListas.ListaDeRojos.size(); i++){
            if (ManejadorDeListas.ListaDeRojos.get(i).getID_EMPLEADO().equals(Empleado)){
                tiketsEncontrados.add(ManejadorDeListas.ListaDeRojos.get(i));
            }
        }
            
        return tiketsEncontrados;
    }
    
    
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
