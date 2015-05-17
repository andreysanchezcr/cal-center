package Logica;

import static Interfaz.ServidorVentana.Lista;
import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


import jxl.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import jxl.read.biff.BiffException;



public abstract class MyExell {
    
    public static int ID_Secuencia = 0;
    
    public static Workbook libroDeTrabajo;
    public static WritableWorkbook copiaDeLibro;
    public static WritableSheet hojaTikets;
    
    public static void open(String path){
    
        try{
            /**
             * Abrir el exell
             */
            File temp = new File(path);
             
            libroDeTrabajo = Workbook.getWorkbook(temp);
        }
        
        //----------------------------------------------------------
        catch (IOException ioex) {
            System.out.println("ERROR---->>"+ioex.getMessage());
        } 
        catch (NumberFormatException nfe) {
            System.out.println("ERROR---->>"+nfe.getMessage());    
        }
        catch (BiffException biff){
            System.out.println("ERROR---->>"+biff.getMessage());
        }
        //----------------------------------------------------------
    
    }
    
     /**
     * Metodo que carga los tikets pendientes del .xls 
     * Ademas Actualiza El JList Lista en la ventana de Servidor Ventana
     * @return Lista con Tikets con la informacion principal, hora de ingreso, ID cliente y Asunto
     */
    public static ArrayList<Tickets> Open_Load_And_ReturnListOfTickets(String path){
        
        //Abriendo Archivo .xls
        open(path);
                
        
        //Hoja 0 es donde permanesen los tickets sin categorizar
        Sheet hojaActual = libroDeTrabajo.getSheet(0);
        
        
        ArrayList<Tickets> listaTikets = new ArrayList();
        
        int numFilas = hojaActual.getRows();
        
        for( int fila = 0; fila+1 < numFilas; fila++ ){
             
     
//Validacion de cargar solo Tickets Pendientes
            Cell celdaEstado =  hojaActual.getCell(4,fila+1);
            if (celdaEstado.getContents()==""){
            
            ID_Secuencia ++;
                
            Date fechaHoraActual = new Date();
            String strFechaHora = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa").format(fechaHoraActual);
            
            
            //String para el Jlist para desplegar la informcion de los tikets    
            String strDisplayToLista = "❧ ID:  ";
            
            
            Cell celdaIDcliente = hojaActual.getCell(1,fila+1);
            String strIDcliente = celdaIDcliente.getContents();       
            
            strDisplayToLista += Integer.toString(ID_Secuencia);
            
           
            
            strDisplayToLista += "   Asunto: ";
            
            Cell celdaAsunto = hojaActual.getCell(2,fila+1);
            String strAsunto = celdaAsunto.getContents();
            strDisplayToLista += strAsunto;
                    
            
            
            Tickets ticket = new Tickets(strFechaHora, strIDcliente, strAsunto ,ID_Secuencia);
            listaTikets.add(ticket);
            Lista.add(strDisplayToLista); // Adding to JList Lista in Interfaz
            }
        }
        
        return listaTikets;
        
    }
    
    
    
    
    
    
        public static void save_All_Changes(String path, ArrayList<Tickets> listaPendientes,
                                                ArrayList<Tickets> listaVerdes,
                                                ArrayList<Tickets> listaAmarillos,
                                                ArrayList<Tickets> listaRojos) {
        

            //Fecha y Hora para el Nombre del Archivo Final
            Date fechaHoraActualParaFile = new Date();
            String strFechaHoraParaFile = new SimpleDateFormat("/dd-MM-yyyy hh:mm aaa").format(fechaHoraActualParaFile);    


            //Abrir archivo .xls para clonarlo
            open(path);


            try {

                copiaDeLibro =  Workbook.createWorkbook(new File (" TICKETS_"+cortar(path)+strFechaHoraParaFile+".xls"),libroDeTrabajo);

                insertSheet(listaPendientes,0);
                insertSheet(listaVerdes,1);
                insertSheet(listaAmarillos,2);
                insertSheet(listaRojos,3);

            } catch (IOException wse) {
               System.out.println("ERROR---->>"+wse.getMessage());
            }

        }


        private static void insertSheet(ArrayList<Tickets> lista , int numeroHoja){
        try {

                
            
                
            //=======================================Verificar si la hoja existe    
                if(copiaDeLibro.getSheet(numeroHoja)!= null){
                    hojaTikets = copiaDeLibro.getSheet(numeroHoja);
                }
                    
                else{
                    if(numeroHoja == 0){
                        hojaTikets = copiaDeLibro.createSheet("Tickets Pendientes", numeroHoja);
                    }
                    if(numeroHoja == 1){
                        hojaTikets = copiaDeLibro.createSheet("Tickets Verdes", numeroHoja);
                    }
                    if(numeroHoja == 2){
                        hojaTikets = copiaDeLibro.createSheet("Tickets Amarillo", numeroHoja);
                    }
                    if(numeroHoja == 3){
                        hojaTikets = copiaDeLibro.createSheet("Tickets Rojos", numeroHoja);
                    }

                }
            //=======================================    
                
                
                try{
                    for(int i =0; i+1<lista.size(); i++){

                        Label lblFechaHoraRecepcion = new Label(0,i,"Mario Bross");
                        Tickets tempTiket = lista.get(i);
                        

                        Label lblFechayHoraRecepcion = new Label(0,i+1,tempTiket.getFechayHoraRecepcion());
                        hojaTikets.addCell(lblFechayHoraRecepcion);
                        Label lblID_CLIENTE = new Label(1,i+1,tempTiket.getID_CLIENTE());
                        hojaTikets.addCell(lblID_CLIENTE);
                        Label lblasunto = new Label(2,i+1,tempTiket.getAsunto());
                        hojaTikets.addCell(lblasunto);
                        Label lblIDTicket = new Label(3,i+1,Integer.toString(tempTiket.getIDTicket()));
                        hojaTikets.addCell(lblIDTicket);
                        Label lblcategoria= new Label(4,i+1,tempTiket.getCategoria());
                        hojaTikets.addCell(lblcategoria);
                        Label lblID_EMPLEADO = new Label(5,i+1,tempTiket.getID_EMPLEADO());
                        hojaTikets.addCell(lblID_EMPLEADO);
                        Label lblfechayHoraAtencion = new Label(6,i+1,tempTiket.getFechayHoraAtencion());
                        hojaTikets.addCell(lblfechayHoraAtencion);
                        Label lbltiempoSegundos = new Label(7,i+1,tempTiket.getTiempoSegundos());
                        hojaTikets.addCell(lbltiempoSegundos);
                        Label lblComentario = new Label(8,i+1,tempTiket.getComentario());
                        hojaTikets.addCell(lblComentario);
                        Label lblestado = new Label(9,i+1,tempTiket.getEstado());
                        hojaTikets.addCell(lblestado);

                    }
                    copiaDeLibro.write();
                    copiaDeLibro.close();    
                }
                catch (WriteException wexep){
                    System.out.println("ERROR---->>"+wexep.getMessage());
                }


            } catch (IOException wse) {
               System.out.println("ERROR---->>"+wse.getMessage());
            }
        }

    
    

        /**
         * Metodo para extraer  el path del archivo que se clonara para generar un nuevo archivo en ese lugar
         * @param direccion del archivo original que sera clonado
         * @return path del archivo
         */
        public static String cortar(String direccion){

            String cutString="";
            int indice=0;

            for (int i = 0; i<direccion.length();i++){    
                    if(direccion.charAt(i)=='/'){
                        indice=i;
                    }
                    if(direccion.charAt(i)=='.'){
                        String temp2="";
                        for(int u=0;u<direccion.length();u++){
                            if(u==indice){
                                return "/"+temp2;
                            }
                            temp2=temp2+direccion.charAt(u);
                        }
                    }
                    cutString = cutString+direccion.charAt(i);
            }
            return cutString;
        }    
}