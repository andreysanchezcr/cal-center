package Logica.servidor;

import Interfaz.ServidorVentana;
import Logica.ManejadorDeListas;

import Logica.Persona;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

/**
 * Servidor de chat. Acepta conexiones de clientes, crea un hilo para
 * atenderlos, y espera la siguiente conexion.
 *
 * @author Chuidiang
 *
 */
public class Servidor implements Runnable{

    ArrayList listaEmpleados = new ArrayList();
    ObjectInputStream objetoentrante;
    DataInputStream dataInput;
        DataOutputStream saliente;
        ObjectOutputStream objetosaliente;
        boolean sucess = false;
        ArrayList listaConexiones=new ArrayList();
        HiloDeCliente_1 cli;

    private void registrarPersonas() {
        Persona admn = new Persona("Admin", "admin@tec.ac.cr", "12345", null, true);
        Persona rojo = new Persona("Fernando", "fernando@tec.ac.cr", "12345", "Rojo", true);
        Persona verde = new Persona("Luis", "luis@tec.ac.cr", "12345", "Amarillo", true);
        Persona amarillo = new Persona("Junior", "junior@tec.ac.cr", "12345", "Verde", true);
        listaEmpleados.add(admn);
        listaEmpleados.add((Persona) verde);
        listaEmpleados.add((Persona) rojo);
        listaEmpleados.add((Persona) amarillo);

    }
    /**
     * Lista en la que se guaradara toda la conversacion
     */
    private DefaultListModel charla = new DefaultListModel();

    /**
     * Instancia esta clase.
     *
     * @param args
     */
    private ServidorVentana ventana;

    /**
     * Se mete en un bucle infinito para ateder clientes, lanzando un hilo para
     * cada uno de ellos.
     */
    public Servidor(ServidorVentana ventana) {
        registrarPersonas();
        this.ventana=ventana;
        ventana.setServidor(this);
        ventana.setListaEmpleados(listaEmpleados);
        ventana.setConectados();
        
        
        
            
        }
    public ArrayList getListaConexiones(){
        return listaConexiones;
    }
    
    
    public ArrayList getListaEmpleados(){
        return listaEmpleados;
    }
    
        
        
        
        public void sendRojo() throws IOException{
            
            objetosaliente.writeObject(ManejadorDeListas.ListaDeRojos);
        }
        public void sendAmarillo() throws IOException{
            
            objetosaliente.writeObject(ManejadorDeListas.ListaDeAmarillos);
        }
        public void sendVerde() throws IOException{
            
            objetosaliente.writeObject(ManejadorDeListas.ListaDeVerdes);
        }
        
        

        public void loggin(String login) throws IOException{
            String nombre="";
            String tipo="";
            Persona temp=null;
            for (int i = 1; i < listaEmpleados.size(); i++) {

                    temp = (Persona) listaEmpleados.get(i);
                    if (login.equals(temp.correo + " " + temp.contraseña)) {
                        sucess = true;
                        listaEmpleados.set(i, temp);
                        
                        
                        
                        break;
                        

                    }

                }
            if(sucess){
                saliente.writeInt(0);
                        nombre=temp.getNombre();
                        tipo=temp.getCategoria();
                        temp.conectar();
                        
                        ventana.setListaEmpleados(listaEmpleados);
                        ventana.setConectados();
                        saliente.writeUTF(nombre);
                        saliente.writeUTF(tipo);
            }else{
                saliente.writeInt(-1);
            }
            
        }
        public void desconectarPersona(String nombre){
            int i =0;
            for(i =0;i<this.listaEmpleados.size();i++){
                    if(((Persona)listaEmpleados.get(i)).getNombre().equals(nombre)){
                        ((Persona)listaEmpleados.get(i)).desconectar();
                        this.ventana.setLista(listaEmpleados);
                        break;    
                        }
                    }
            this.ventana.setConectados();
           
            
        
        }
        

    
    public void run() {
        try {
            ServerSocket socketServidor = new ServerSocket(5557);
            
            while (true) {
                Socket cliente = socketServidor.accept();
                System.out.println("nueva conexion");
                
                dataInput = new DataInputStream(cliente.getInputStream());
                saliente = new DataOutputStream(cliente.getOutputStream());
                objetosaliente=new ObjectOutputStream(cliente.getOutputStream());
                String instruccion=dataInput.readUTF();
                System.out.println(instruccion);
               
                if(instruccion.equals("Login")){
                    String login = dataInput.readUTF();
                    loggin(login);
                }else if(instruccion.equals("ROJO")){
                    this.sendRojo();
                    
                }
                else if(instruccion.equals("VERDE")){
                    this.sendVerde();
                    
                }
                else if(instruccion.equals("AMARILLO")){
                    this.sendAmarillo();
                    
                }
                else if(instruccion.equals("Desconectar")){
                    String persona=dataInput.readUTF();
                    desconectarPersona(persona);
                }
                else if(instruccion.equals("ListaROJO")){
                    ManejadorDeListas.ListaDeRojos=(ArrayList)this.objetoentrante.readObject();
                    System.out.println("Se ha mandado una lista roja");
                    
                }
                else if(instruccion.equals("ListaVERDE")){
                    ManejadorDeListas.ListaDeVerdes=(ArrayList)this.objetoentrante.readObject();
                    System.out.print("Se ha mandado una lista Verde");
                    
                }
                else if(instruccion.equals("ListaAMARILLO")){
                    ManejadorDeListas.ListaDeAmarillos=(ArrayList)this.objetoentrante.readObject();
                    System.out.println("Se ha mandado una lista amarilla");
                    
                }
                    
                    
                
                
                
                    
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    }

