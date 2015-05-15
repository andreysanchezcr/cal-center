package Logica.cliente;


import Interfaz.Login;
import Interfaz.ClienteVentana;
import Logica.Persona;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Clase con el main de un cliente del chat.
 * Establece la conexion y crea la ventana y la clase de control.
 * @author Chuidiang
 *
 */

public class Cliente
{
    /** Socket con el servidor del chat */
    private Socket socket;

    /** Panel con la ventana del cliente */
    private PanelCliente panel;
    ArrayList listaEmpleados= new ArrayList();
    ObjectInputStream objeto_entrante;

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
            //creaYVisualizaVentana();
            socket = new Socket("localhost", 5557);
            
            DataOutputStream flujoSaliente = new DataOutputStream(socket.getOutputStream());
            DataInputStream flujoEntrante = new DataInputStream(socket.getInputStream());
            
            flujoSaliente.writeUTF(correo+" "+contrasena);
            
            int indicador=flujoEntrante.readInt();
            System.out.println(indicador);
            if(indicador==0){
                parent.dispose();
                String nombre=flujoEntrante.readUTF();
                String tipo=flujoEntrante.readUTF();
                ClienteVentana ventana = new ClienteVentana(nombre,socket,tipo);
                System.out.println("EXito");
                ControlCliente control = new ControlCliente(socket, panel);
                
            }else{
                System.out.println("Fallo");
            }
                        
            
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
       
        Cliente cl=new Cliente("fernando@tec.ac.cr","12345",null);
       
        
        
        
        
        
        
        
            
        
        
    }

    

    /**
     * Crea una ventana, le mete dentro el panel para el cliente y la visualiza
     */
   
}
