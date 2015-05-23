
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

}
