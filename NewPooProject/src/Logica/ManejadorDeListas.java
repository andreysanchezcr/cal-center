
package Logica;

import Logica.Tickets;
import java.util.ArrayList;

public abstract class ManejadorDeListas {


    public static ArrayList<Tickets> ListaDePendientes = new ArrayList();
    public static ArrayList<Tickets> ListaDeVerdes = new ArrayList();
    public static ArrayList<Tickets> ListaDeAmarillos = new ArrayList();
    public static ArrayList<Tickets> ListaDeRojos = new ArrayList();
    public static int arrgloTiketsLiberados[]={0,0,0};
    
    public static void addNewTiketsToLocalListPendientes(ArrayList<Tickets> ListaDePendientesInsert){
        for (int i = 0; i < ListaDePendientesInsert.size();i++){
            ListaDePendientes.add(ListaDePendientesInsert.get(i));
        }
    }
    public static ArrayList getLists(){
        ArrayList temp=new ArrayList();
        temp.add(ListaDeVerdes);
        temp.add(ListaDeAmarillos);
        temp.add(ListaDeRojos);
        return temp;
    }

    public static void addNewTiketsToLocalListVerdes(ArrayList<Tickets> ListaDeVerdesInsert){
        for (int i = 0; i < ListaDeVerdesInsert.size();i++){
            ListaDeVerdes.add(ListaDeVerdesInsert.get(i));
        }
    }

    public static void addNewTiketsToLocalListAmarillos(ArrayList<Tickets> ListaDeAmarillosInsert){
        for (int i = 0; i < ListaDeAmarillosInsert.size();i++){
            ListaDeAmarillos.add(ListaDeAmarillosInsert.get(i));
        }
    }
    
    public static void addNewTiketsToLocalListRojos(ArrayList<Tickets> ListaDeRojosInsert){
        for (int i = 0; i < ListaDeRojosInsert.size();i++){
            ListaDeRojos.add(ListaDeRojosInsert.get(i));
        }
    }
    
   
    
    public static String getDia(String fecha){
        String temp="";
        for(int i=0;i<fecha.length();i++){
        if(fecha.charAt(i)=='/'){
            return temp;
        }
        temp=temp+fecha.charAt(i);
        }
        System.out.println("Error en la funcion get dia");
        return "";
    }
    public static String getMes(String fecha){
        String temp="";
        int contador=0;
        for(int i=0;i<fecha.length();i++){
        if((fecha.charAt(i)=='/')&&contador==0){
            temp="";
            contador++;
            //continue;
        }else if((fecha.charAt(i)=='/')&&contador==1){
            return temp;
            //continue;
        }
        else{
            temp=temp+fecha.charAt(i);
        }
        
        }
        System.out.println("Error en la funcion get mes");
        return "";
    }
    public static String getAno(String fecha){
        String temp="";
        int contador=0;
        for(int i=0;i<fecha.length();i++){
        if((fecha.charAt(i)=='/')){
            temp="";
            contador++;
            continue;
        }
        temp=temp+fecha.charAt(i);
        
        }
        //System.out.println("Error en la funcion get mes");
        return temp;
    }        
    
  
    public static ArrayList<Tickets> getListaDePendientes() {
        return ListaDePendientes;
    }

    public static ArrayList<Tickets> getListaDeAmarillos() {
        return ListaDeAmarillos;
    }

    public static ArrayList<Tickets> getListaDeRojos() {
        return ListaDeRojos;
    }
    
    public static ArrayList<Tickets> getListaDeVerdes() {
        return ListaDeVerdes;
    }
    
    public static void setListaDePendientes(ArrayList<Tickets> ListaDePendientes) {
        ManejadorDeListas.ListaDePendientes = ListaDePendientes;
    }


    public static void finderThenInsert(String StrOfJList, ArrayList<Tickets> ListaDestino){
        String MyID = "";
        
        for(int n = 7; n < StrOfJList.length();n++){
            if(StrOfJList.charAt(n) == ' '){
                //Si encuentra el espacio en blanco ese es el numero que buscamos
                //Enpesamos busqueda
                for(int i = 0; i < ListaDePendientes.size() ;i ++){
                    //Si encuentra el objeto con el mismo ID
                    if(Integer.toString(ListaDePendientes.get(i).getIDTicket()).equals(MyID)){
                        //ListaDePendientes.get(i).setCategoria(MyID);
                        ListaDestino.add(ListaDePendientes.get(i));
                        ListaDePendientes.remove(i);
                
                        //System.out.println("Se encontro el objeto ya fue agregado");
                        break;
                    }
                    //Si no sigue buscando
                    //else{System.out.println("No se ha encontado tiket con->"+MyID+"<- en conparacion con->"+Integer.toString(ListaDePendientes.get(i).getIDTicket())+"<-");}
                }
            }
            MyID = MyID+StrOfJList.charAt(n);
        }
        for(int i = 0; i < ListaDePendientes.size() ;i ++){
        }    
    }
    public static void getCantidadTiketsAtendidos(){
    }
    
    public static int tiempoSegundos(ArrayList<Tickets> lista, String idEmpleado){
        int largoLista = lista.size();
        int recorrido = 0;
        int tiempoTotal = 0;
        while(recorrido < largoLista){
            if(lista.get(recorrido).getID_EMPLEADO().equals(idEmpleado)){
                tiempoTotal = tiempoTotal + Integer.parseInt(lista.get(recorrido).getTiempoSegundos());
            }
            recorrido = recorrido +1;
        }
        return tiempoTotal;
    }
    
    public static int tiempoSegEmpleado(String idEmpleado){
        int tiempoTotalEmpleado = 0;
        tiempoTotalEmpleado = tiempoSegundos(ListaDeVerdes, idEmpleado);
        tiempoTotalEmpleado = tiempoSegundos(ListaDeAmarillos, idEmpleado);
        tiempoTotalEmpleado = tiempoSegundos(ListaDeRojos, idEmpleado);
        return tiempoTotalEmpleado;
    }
    
    public static  ArrayList<Tickets> ticketEntreFecha(int dia1, int mes1, int ano1, int dia2, int mes2, int ano2, ArrayList<Tickets> lista){
        int largoLista = lista.size();
        int recorrido = 0;
        ArrayList<Tickets> listaFecha = new ArrayList<Tickets>();
        if(ano1 == ano2){
            while(recorrido < largoLista){
                if(Integer.parseInt(getAno(lista.get(recorrido).getFechayHoraRecepcion())) == ano1){
                    listaFecha.add(lista.get(recorrido));
                }
                recorrido = recorrido +1;
            }
        }
        else{
            while(recorrido < largoLista){
            if((Integer.parseInt(getAno(lista.get(recorrido).getFechayHoraRecepcion())) <= ano1) && (Integer.parseInt(getAno(lista.get(recorrido).getFechayHoraRecepcion())) >= ano2)){
                if((Integer.parseInt(getMes(lista.get(recorrido).getFechayHoraRecepcion())) <= mes1) && (Integer.parseInt(getMes(lista.get(recorrido).getFechayHoraRecepcion())) >= mes2)){
                    if((Integer.parseInt(getDia(lista.get(recorrido).getFechayHoraRecepcion())) <= dia1) && (Integer.parseInt(getDia(lista.get(recorrido).getFechayHoraRecepcion())) >= dia2)){
                        listaFecha.add(lista.get(recorrido));
                        }
                    }
                }
            recorrido = recorrido+1;
            }
        }
        return listaFecha;
    }

}
