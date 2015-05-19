package Logica.cliente;


import Interfaz.Login;
import Interfaz.ClienteVentana;
import Logica.Persona;
import Logica.Tickets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Clase con el main de un cliente del chat.
 * Establece la conexion y crea la ventana y la clase de control.
 * @author Chuidiang
 *
 */

public class Cliente
implements Runnable{
    /** Socket con el servidor del chat */
    private Socket socket;

    /** Panel con la ventana del cliente */
    
    ObjectInputStream objeto_entrante;
    ObjectOutputStream objeto_saliente;
    boolean logueado=false;
    DataOutputStream flujoSaliente;
    DataInputStream flujoEntrante;
    ArrayList listaTicketes;
    Thread hilo;
    Login parent;
    boolean solicitud=false;
    String nombre;

    /**
     * Arranca el Cliente de chat.
     * @param args
     */
  
    /**
     * Crea la ventana, establece la conexi�n e instancia al controlador.
     */
    public Cliente(String correo, String contrasena,Login parent)
    {
        try
        {
            this.nombre =nombre;
            socket = new Socket("localhost", 5557);
            this.objeto_entrante=new ObjectInputStream(socket.getInputStream());
           flujoSaliente = new DataOutputStream(socket.getOutputStream());
            flujoEntrante = new DataInputStream(socket.getInputStream());
            flujoSaliente.writeUTF("Login");
            flujoSaliente.writeUTF(correo+" "+contrasena);
            this.parent=parent;
            int indicador=flujoEntrante.readInt();
            System.out.println(indicador);
            if(indicador==0){
                parent.dispose();
                String nombre=flujoEntrante.readUTF();
                String tipo=flujoEntrante.readUTF();
                ClienteVentana ventana = new ClienteVentana(nombre,socket,tipo,this);
                System.out.println("EXito");
                logueado=true;
                socket.close();
                
            }else{
                socket.close();
                System.out.println("Fallo");
            }
                        
            
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        this.hilo=new Thread(this);
        hilo.start();
    }
    public static void main(String[] args) {
       
        Cliente cl=new Cliente("fernando@tec.ac.cr","12345",null);
       
        
        
        
        
        
        
        
            
        
        
    }
    public int mandarLista() throws IOException{
        while(true){
            if(this.solicitud){
                
           
            hilo.stop();
            socket = new Socket("localhost", 5557);
            flujoSaliente.writeUTF("Lista");
            objeto_saliente=new ObjectOutputStream(socket.getOutputStream());
            objeto_saliente.writeObject(this.listaTicketes);
            socket.close();
            hilo.resume();
            return 0;
             }
        }
        
        
    }
   
    public void desconectar() throws IOException, InterruptedException{
        
        
        
        socket = new Socket("localhost", 5557);
        System.out.println("111111");
            flujoSaliente = new DataOutputStream(socket.getOutputStream());
        this.flujoSaliente.writeUTF("Desconectar");
        System.out.println("111111");
        this.flujoSaliente.writeUTF("Fernando");
        System.out.println("111111");
    }

    @Override
    public void run() {
        try {
            while(true){
                solicitud=false;
                
            
            socket = new Socket("localhost", 5557);
            this.objeto_entrante=new ObjectInputStream(socket.getInputStream());
           flujoSaliente = new DataOutputStream(socket.getOutputStream());
            flujoEntrante = new DataInputStream(socket.getInputStream());
            System.out.println("Entroo");
            flujoSaliente.writeUTF(this.parent.getColor());
            this.listaTicketes=(ArrayList)this.objeto_entrante.readObject();
            for(int i=0;i<this.listaTicketes.size();i++){
                System.out.println(((Tickets)this.listaTicketes.get(i)).getAsunto());
            }
            
            socket.close();
            solicitud=true;
            Thread.sleep(10000);
            
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

    /**
     * Crea una ventana, le mete dentro el panel para el cliente y la visualiza
     */
   
}
