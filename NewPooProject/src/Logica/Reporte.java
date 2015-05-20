/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



       
        /*
        tempTiket.getID_CLIENTE();
        tempTiket.getCategoria();
        tempTiket.getTiempoSegundos();
        */
package Logica;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author root
 */
public abstract class Reporte {

    public static ArrayList<Tickets> ListaDePendientes = new ArrayList();
    public static ArrayList<Tickets> ListaDeVerdes = new ArrayList();
    public static ArrayList<Tickets> ListaDeAmarillos = new ArrayList();
    public static ArrayList<Tickets> ListaDeRojos = new ArrayList();
    
    
    
    public static int findTiketsAtendidos(ArrayList<Tickets> ListaAConocer,String IDcliente) {
        
        int numeroDeTiketsAtendidos = 0; 
        
        /*Buscar en la lista los tiketes atendidos por el empleado*/
        for(int i = 0;i < ListaAConocer.size();i++){
            if(ListaAConocer.get(i).getID_CLIENTE().equals(IDcliente)){
                numeroDeTiketsAtendidos ++;
            }
        }
 
        return numeroDeTiketsAtendidos;
    }
    
    public static int findTiempoAtencionIndividual(ArrayList<Tickets> ListaAConocer,String IDcliente) {
        
        int intTiempoSegundosPromedio = 0;
        
        for(int i = 0;i < ListaAConocer.size();i++){
                if(ListaAConocer.get(i).getID_CLIENTE().equals(IDcliente)){
                    /*Combertimos y sumamos las cantidades en segundos*/
                    intTiempoSegundosPromedio += Integer.parseInt(ListaAConocer.get(i).getTiempoSegundos());
                }
        }
        
        /*Dividimos el tiempo en segundos total entre la cantidad de Tikets atendidos*/
        intTiempoSegundosPromedio = intTiempoSegundosPromedio / findTiketsAtendidos(ListaAConocer,IDcliente);
                
        return intTiempoSegundosPromedio;
        }
    
    
    
    
    /**
     * Calcula el tiempo promedio total de atencion de una lista;
     * @param ListaAConocer
     * @param IDcliente
     * @return 
     */
    public static String findTiempoAtencionTotal(ArrayList<Tickets> ListaAConocer,String IDcliente) {
       
        /*El tiempo promedio de duracion es igual a la suma del tiempo que duro cada empleado divido entre 3*/
        String strTiempoSegundosPromedioTotal = Integer.toString((
            findTiempoAtencionIndividual(ListaAConocer,"Luis")+
            findTiempoAtencionIndividual(ListaAConocer,"Fernando")+
            findTiempoAtencionIndividual(ListaAConocer,"Junior"))/3);
        
        return strTiempoSegundosPromedioTotal;
    }
    
    public static int findTiempoAtencionIndividualTotosLosTickets(String Cliente){
        
        int intTiempoAtencionIndividualTotosLosTickets = (
               findTiempoAtencionIndividual(ManejadorDeListas.ListaDeVerdes,Cliente)+
               findTiempoAtencionIndividual(ManejadorDeListas.ListaDeAmarillos,Cliente)+
               findTiempoAtencionIndividual(ManejadorDeListas.ListaDeRojos,Cliente))
                /3
                ;
        
        return intTiempoAtencionIndividualTotosLosTickets;
    }
    
    /*public static ArrayList<Tickets>  findAndGetTiketsAtendidos(){
        
    
    
    }*/
    
    
    public static void llenarEmpleadoInfo(JLabel etiqueta,String ID_Empleado){
        etiqueta = new JLabel ("<html> <font size=\"3\" color=\"red\">Hola<br>mundo</html>"); 
    
    
        etiqueta.repaint();
    }
    
    
    
}