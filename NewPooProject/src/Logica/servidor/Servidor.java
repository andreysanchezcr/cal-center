package Logica.servidor;

import Interfaz.ServidorVentana;

import Logica.Persona;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;


public class Servidor implements Runnable{

    ArrayList listaEmpleados = new ArrayList();
    ObjectInputStream objeto;
    DataInputStream dataInput;
        DataOutputStream saliente;
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
  
    private DefaultListModel charla = new DefaultListModel();

   
    private ServidorVentana ventana;

  
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
    public HiloDeCliente_1  gett(){
        return cli;
    }
        
        
        
        
        
        

        

    
    public void run() {
        try {
            ServerSocket socketServidor = new ServerSocket(5557);
            //socketServidor.setSoTimeout(10);
            System.out.println(socketServidor.getInetAddress());
            System.out.println(socketServidor.getLocalSocketAddress());
            while (true) {
                Socket cliente = socketServidor.accept();
                
                dataInput = new DataInputStream(cliente.getInputStream());
                saliente = new DataOutputStream(cliente.getOutputStream());
                String login = dataInput.readUTF();
                String nombre="";
                String tipo="";

                for (int i = 1; i < listaEmpleados.size(); i++) {

                    Persona temp = (Persona) listaEmpleados.get(i);
                    if (login.equals(temp.correo + " " + temp.contraseña)) {
                        sucess = true;
                        nombre=temp.getNombre();
                        tipo=temp.getCategoria();
                        temp.conectar();
                        listaEmpleados.set(i, temp);
                        
                        break;
                        

                    }

                }
                
                if (sucess) {

                    saliente.writeInt(0);
                    
                    System.out.println("Correcto");
                    ventana.setListaEmpleados(listaEmpleados);
                    ventana.setConectados();
                    saliente.writeUTF(nombre);
                    saliente.writeUTF(tipo);
                    HiloDeCliente_1 nuevoCliente = new HiloDeCliente_1(charla, cliente);
                    Thread hilo = new Thread(nuevoCliente);
                    listaConexiones.add(hilo);
                    cli=nuevoCliente;
                    hilo.start();
                    
                  
                    login = "";
                    

                    sucess = false;
                } else {
                    System.out.println("Incorrecto");
                    saliente.writeInt(-1);
                }
                    
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    }

