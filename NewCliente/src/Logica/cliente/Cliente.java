package Logica.cliente;


import Interfaz.Login;
import Interfaz.ClienteVentana;
import static Interfaz.ClienteVentana.ListaEmpleado;
import Logica.Persona;
import Logica.Tickets;
import java.awt.List;
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
import sun.security.krb5.internal.Ticket;

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
    ClienteVentana clienteventana;
    
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
                clienteventana = new ClienteVentana(nombre,socket,tipo,this);
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
   
    public String getColor(){
        return parent.getColor();
    }
    public void mandarListaAtencion(int indice) throws IOException{
        socket = new Socket("localhost", 5557);
        System.out.println("Mandando lista");
        System.out.println(this.getColor());
        flujoSaliente = new DataOutputStream(socket.getOutputStream());
        this.flujoSaliente.writeUTF("Lista"+this.getColor());
        
        
        flujoSaliente.writeInt(indice);
        this.flujoSaliente.writeUTF("En atencion");
//this.flujoSaliente.writeUTF(this.parent.getNombre());
        
        
        
    }
    public void mandarListaAtendido(int indice) throws IOException{
        socket = new Socket("localhost", 5557);
        System.out.println("Mandando lista");
        System.out.println(this.getColor());
        flujoSaliente = new DataOutputStream(socket.getOutputStream());
        this.flujoSaliente.writeUTF("Lista"+this.getColor());
        
        
        flujoSaliente.writeInt(indice);
        this.flujoSaliente.writeUTF("Atendido");
//this.flujoSaliente.writeUTF(this.parent.getNombre());
        
        
        
    }
    public ArrayList getListaTickets(){
        return this.listaTicketes;
    }
   
    public void cargarListaTikets(){   
        //ListaEmpleado=new List();
        //ListaEmpleado.clear();
        for (int x=ListaEmpleado.countItems(); x<listaTicketes.size(); x++) { 
            Tickets tiket = (Tickets)listaTicketes.get(x);
            ListaEmpleado.add(tiket.getEstadoActual());
        }
        
    }
    public void modificarEstadoTicketAtencion(int indice) throws IOException{
        Tickets temp =(Tickets)listaTicketes.get(indice);
        temp.setEstado("En atencion");
        this.listaTicketes.set(indice, temp);
        modificarJList();
        mandarListaAtencion(indice);
        
    }
    public void modificarEstadoTicketAtendido(int indice) throws IOException{
        Tickets temp =(Tickets)listaTicketes.get(indice);
        temp.setEstado("Atendido");
        this.listaTicketes.set(indice, temp);
        modificarJList();
        mandarListaAtendido(indice);
        
    }
    public void modificarJList(){
        for(int i=0;i<listaTicketes.size();i++){
            if((((Tickets)listaTicketes.get(i)).getEstado().equals("En atencion")||((Tickets)listaTicketes.get(i)).getEstado().equals("Atendido"))&&!ListaEmpleado.getItem(i).equals(((Tickets)listaTicketes.get(i)).getEstadoActual())){
                ListaEmpleado.replaceItem(((Tickets)listaTicketes.get(i)).getEstadoActual(), i);
            }
        }
        
    }
    
    
    public void desconectar() throws IOException, InterruptedException{
        
        
        
        socket = new Socket("localhost", 5557);
        System.out.println("111111");
            flujoSaliente = new DataOutputStream(socket.getOutputStream());
        this.flujoSaliente.writeUTF("Desconectar");
        System.out.println("111111");
        this.flujoSaliente.writeUTF(this.clienteventana.getNombre());
        System.out.println("111111");
        //socket.close();
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
            cargarListaTikets();
            modificarJList();
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
