package Logica.servidor;

import Interfaz.ServidorVentana;
import Logica.ManejadorDeListas;

import Logica.Persona;
import Logica.Tickets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;

/**
 * Servidor de chat. Acepta conexiones de clientes, crea un hilo para
 * atenderlos, y espera la siguiente conexion.
 *
 * @author Chuidiang
 *
 */
public class Servidor implements Runnable {

    ArrayList listaEmpleados = new ArrayList();
    ObjectInputStream objetoentrante;
    DataInputStream dataInput;
    DataOutputStream saliente;
    ObjectOutputStream objetosaliente;
    boolean sucess = false;
    ArrayList listaConexiones = new ArrayList();
    HiloDeCliente_1 cli;
    ArrayList historial;

    private void registrarPersonas() {
        historial = new ArrayList();
        Persona admn = new Persona("Admin", "admin@tec.ac.cr", "12345", null, true);
        Persona rojo = new Persona("Fernando", "fernando@tec.ac.cr", "12345", "Rojo", true);
        Persona verde = new Persona("Luis", "luis@tec.ac.cr", "12345", "Amarillo", true);
        Persona amarillo = new Persona("Junior", "junior@tec.ac.cr", "12345", "Verde", true);
        listaEmpleados.add(admn);
        listaEmpleados.add((Persona) verde);
        listaEmpleados.add((Persona) rojo);
        listaEmpleados.add((Persona) amarillo);

    }

    public ArrayList getHistorial() {
        return historial;
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
        this.ventana = ventana;
        ventana.setServidor(this);
        ventana.setListaEmpleados(listaEmpleados);
        ventana.setConectados();

    }

    public ArrayList getListaConexiones() {
        return listaConexiones;
    }

    public ArrayList getListaEmpleados() {
        return listaEmpleados;
    }

    public void sendRojo() throws IOException {

        objetosaliente.writeObject(ManejadorDeListas.ListaDeRojos);
    }

    public void sendAmarillo() throws IOException {

        objetosaliente.writeObject(ManejadorDeListas.ListaDeAmarillos);
    }

    public void sendVerde() throws IOException {
       // System.out.println("ENTRO EN VERDEEEE");
        ManejadorDeListas.ListaDeVerdes.size();
        for (int i = 0; i < ManejadorDeListas.ListaDeVerdes.size(); i++) {
            System.out.println(ManejadorDeListas.ListaDeVerdes.get(i));
        }
        objetosaliente.writeObject(ManejadorDeListas.ListaDeVerdes);
       // System.out.println("SALIOS EN VERDEEEE");
    }

    public void loggin(String login) throws IOException {
        String nombre = "";
        String tipo = "";
        Persona temp = null;
        for (int i = 1; i < listaEmpleados.size(); i++) {

            temp = (Persona) listaEmpleados.get(i);
            if (login.equals(temp.correo + " " + temp.contraseña)) {
                if (!temp.getEstado()) {
                    sucess = true;

                    listaEmpleados.set(i, temp);

                }
                break;

            }

        }
        if (sucess) {
            saliente.writeInt(0);
            nombre = temp.getNombre();
            tipo = temp.getCategoria();
            temp.conectar();

            ventana.setListaEmpleados(listaEmpleados);
            ventana.setConectados();
            saliente.writeUTF(nombre);
            saliente.writeUTF(tipo);
            historial.add(nombre + " se ha conectado");
            ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
        } else {
            saliente.writeInt(-1);
        }
        sucess = false;

    }

    public void desconectarPersona(String nombre) {
        int i = 0;
        for (i = 0; i < this.listaEmpleados.size(); i++) {
            if (((Persona) listaEmpleados.get(i)).getNombre().equals(nombre)) {
                ((Persona) listaEmpleados.get(i)).desconectar();
                this.ventana.setLista(listaEmpleados);
                break;
            }
        }
        historial.add(nombre + " se ha desconectado");
        ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
        this.ventana.setConectados();

    }
    public String getTiempoActual(){
        Date fechaHoraActual = new Date();
        String strFechaHora = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa").format(fechaHoraActual);
        return strFechaHora;
            
    }

    public void modificarEstadoTicketAmarillo(int indice, String tipo) throws IOException {
        Tickets temp = (Tickets) ManejadorDeListas.ListaDeAmarillos.get(indice);
     //   System.out.println(this.getOracion(tipo));
        if (this.getOracion(tipo).equals("")) {

            temp.setEstado("En atencion");
            historial.add(this.getName(tipo) + " esta atendiendo el tickete numero: " + this.getTicketeActual(tipo));
            ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
        } else {
            temp.setEstado("Atendido");
        //    System.out.println("ATEMDIDO");
            historial.add(this.getName(tipo) + " ha atendido el tickete numero: " + this.getTicketeActual(tipo));
            //System.out.println(this.getOracion(tipo));
            ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
            temp.setTiempoSegundos(this.getTiempo(tipo));
            temp.setFechayHoraAtencion(this.getTiempoActual());
           // temp.setFechayHoraAtencion(tipo);
            temp.setComentario(this.getOracion(tipo));
            temp.setID_EMPLEADO(this.getName(tipo));
            ManejadorDeListas.MegaLista.add(temp);
        }
        ManejadorDeListas.ListaDeAmarillos.set(indice, temp);

    }

    public void modificarEstadoTicketRojo(int indice, String tipo) throws IOException {
        Tickets temp = (Tickets) ManejadorDeListas.ListaDeRojos.get(indice);
      //  System.out.println(this.getOracion(tipo));
        if (this.getOracion(tipo).equals("")) {

            temp.setEstado("En atencion");
            historial.add(this.getName(tipo) + " esta atendiendo el tickete numero: " + this.getTicketeActual(tipo));
            ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
        } else {
            temp.setEstado("Atendido");
        //    System.out.println("ATEMDIDO");
            historial.add(this.getName(tipo) + " ha atendido el tickete numero: " + this.getTicketeActual(tipo));
            //System.out.println(this.getOracion(tipo));
            ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
            temp.setTiempoSegundos(this.getTiempo(tipo));
            temp.setComentario(this.getOracion(tipo));
            temp.setID_EMPLEADO(this.getName(tipo));
            temp.setFechayHoraAtencion(this.getTiempoActual());
            ManejadorDeListas.MegaLista.add(temp);
        }
        ManejadorDeListas.ListaDeRojos.set(indice, temp);

    }

    public void modificarEstadoTicketVerde(int indice, String tipo) throws IOException {
        Tickets temp = (Tickets) ManejadorDeListas.ListaDeVerdes.get(indice);
      //  System.out.println("++++++++++++++++++++");
      //  System.out.println(this.getOracion(tipo));
      //  System.out.println("++++++++++++++++++++");
        if (this.getOracion(tipo).equals("")) {

            temp.setEstado("En atencion");
            historial.add(this.getName(tipo) + " esta atendiendo el tickete numero: " + this.getTicketeActual(tipo));
            ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
        } else {
            temp.setEstado("Atendido");
          //  System.out.println("ATEMDIDO");
            historial.add(this.getName(tipo) + " ha atendido el tickete numero: " + this.getTicketeActual(tipo));

            ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
//System.out.println(this.getOracion(tipo));

            temp.setComentario(this.getOracion(tipo));
            temp.setTiempoSegundos(this.getTiempo(tipo));
            temp.setID_EMPLEADO(this.getName(tipo));
            temp.setFechayHoraAtencion(this.getTiempoActual());
            ManejadorDeListas.MegaLista.add(temp);
            //Manejado
        }
        ManejadorDeListas.ListaDeVerdes.set(indice, temp);

    }

    public void modificarEstadoTicketLiberadoVerde(int indice, String tipo) {
        Tickets temp = (Tickets) ManejadorDeListas.ListaDeVerdes.get(indice);
        if (this.getName(tipo).equals("Fernando")) {
            ManejadorDeListas.arrgloTiketsLiberados[0] = ManejadorDeListas.arrgloTiketsLiberados[0] + 1;

        } else if (this.getName(tipo).equals("Junior")) {
            ManejadorDeListas.arrgloTiketsLiberados[1] = ManejadorDeListas.arrgloTiketsLiberados[1] + 1;

        } else if (this.getName(tipo).equals("Luis")) {
            ManejadorDeListas.arrgloTiketsLiberados[2] = ManejadorDeListas.arrgloTiketsLiberados[2] + 1;

        }
       // System.out.println(this.getOracion(tipo));

        temp.setEstado("Pendiente");
        historial.add(this.getName(tipo) + " ha liberado el tickete numero: " + this.getTicketeActual(tipo));
        ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
        temp.setComentarioLiberado(this.getOracion(tipo));

        ManejadorDeListas.ListaDeVerdes.set(indice, temp);

    }

    public void modificarEstadoLiberadoTicketAmarillo(int indice, String tipo) {
        Tickets temp = (Tickets) ManejadorDeListas.ListaDeAmarillos.get(indice);
        if (this.getName(tipo).equals("Fernando")) {
            ManejadorDeListas.arrgloTiketsLiberados[0] = ManejadorDeListas.arrgloTiketsLiberados[0] + 1;

        } else if (this.getName(tipo).equals("Junior")) {
            ManejadorDeListas.arrgloTiketsLiberados[1] = ManejadorDeListas.arrgloTiketsLiberados[1] + 1;

        } else if (this.getName(tipo).equals("Luis")) {
            ManejadorDeListas.arrgloTiketsLiberados[2] = ManejadorDeListas.arrgloTiketsLiberados[2] + 1;

        }
      //  System.out.println(this.getOracion(tipo));

        temp.setEstado("Pendiente");
        historial.add(this.getName(tipo) + " ha liberado el tickete numero: " + this.getTicketeActual(tipo));
        ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
        temp.setComentarioLiberado(this.getOracion(tipo));

        ManejadorDeListas.ListaDeAmarillos.set(indice, temp);

    }

    public void modificarEstadoTicketLiberadoRojo(int indice, String tipo) {
        Tickets temp = (Tickets) ManejadorDeListas.ListaDeRojos.get(indice);
        if (this.getName(tipo).equals("Fernando")) {
            ManejadorDeListas.arrgloTiketsLiberados[0] = ManejadorDeListas.arrgloTiketsLiberados[0] + 1;

        } else if (this.getName(tipo).equals("Junior")) {
            ManejadorDeListas.arrgloTiketsLiberados[1] = ManejadorDeListas.arrgloTiketsLiberados[1] + 1;

        } else if (this.getName(tipo).equals("Luis")) {
            ManejadorDeListas.arrgloTiketsLiberados[2] = ManejadorDeListas.arrgloTiketsLiberados[2] + 1;

        }
     //   System.out.println(this.getOracion(tipo));

        temp.setEstado("Pendiente");
        historial.add(this.getName(tipo) + " ha liberado el tickete numero: " + this.getTicketeActual(tipo));
        ManejadorDeListas.cargaListaActividadReciente((String) historial.get(historial.size() - 1));
        temp.setComentarioLiberado(this.getOracion(tipo));

        ManejadorDeListas.ListaDeRojos.set(indice, temp);

    }

    public void rellenarActividadReciente() {
        ManejadorDeListas.clearActividadReciente();
        ManejadorDeListas.setActividadReciente(historial);
    }

    public String getName(String oracion) {
        String temp = "";
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == '@') {
                return temp;
            }
            temp = temp + oracion.charAt(i);
           // System.out.println("Este es el valo de temp " + temp);

        }

       // System.out.println("Se ha retornado null");
        return "";
    }

    public String getOracion(String oracion) {
        String temp = "";
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == '%') {
                temp = "";
                continue;
            }
            if (oracion.charAt(i) == '&') {
                return temp;
            }
            temp = temp + oracion.charAt(i);

        }

        //System.out.println("Se ha retornado null");
        return temp;
    }

    public String getTicketeActual(String oracion) {
        String temp = "";
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == '@') {
                temp = "";
                continue;
            }
            if (oracion.charAt(i) == '%') {
                return temp;
            }
            temp = temp + oracion.charAt(i);

        }

        //System.out.println("Se ha retornado null");
        return temp;
    }

    public String getTiempo(String oracion) {
        String temp = "";
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == '&') {
                temp = "";
                continue;
            }
            temp = temp + oracion.charAt(i);
        }
        return temp;
    }

    public void run() {

        try {
            ServerSocket socketServidor = new ServerSocket(5557);

            while (true) {

               
                Socket cliente = socketServidor.accept();

                //ObjectInputStream objetoentrante=new ObjectInputStream(cliente.getInputStream());
                dataInput = new DataInputStream(cliente.getInputStream());
                saliente = new DataOutputStream(cliente.getOutputStream());
                objetosaliente = new ObjectOutputStream(cliente.getOutputStream());

                String instruccion = dataInput.readUTF();
                System.out.println("instruccion: " + instruccion);

                if (instruccion.equals("Login")) {

                    String login = dataInput.readUTF();
                    loggin(login);
                } else if (instruccion.equals("ROJO")) {
                    this.sendRojo();

                } else if (instruccion.equals("VERDE")) {
                    this.sendVerde();

                } else if (instruccion.equals("AMARILLO")) {
                    this.sendAmarillo();

                } else if (instruccion.equals("Desconectar")) {
                    String persona = dataInput.readUTF();
                   // System.out.println("Se ha desconectado: " + persona);
                    desconectarPersona(persona);
                    cliente.close();
                } else if (instruccion.equals("ListaROJO")) {
                    int indice = dataInput.readInt();

                    String tipo = dataInput.readUTF();

                    this.modificarEstadoTicketRojo(indice, tipo);

                    //ManejadorDeListas.ListaDeRojos=(ArrayList)this.objetoentrante.readObject();
                } else if (instruccion.equals("ListaVERDE")) {
                    int indice = dataInput.readInt();

                    String tipo = dataInput.readUTF();

                  //  System.out.println(tipo + "Este es el tip");

                    this.modificarEstadoTicketVerde(indice, tipo);
                    // ManejadorDeListas.ListaDeVerdes=(ArrayList)this.objetoentrante.readObject();

                } else if (instruccion.equals("ListaAMARILLO")) {
                    int indice = dataInput.readInt();
                    String tipo = dataInput.readUTF();

                    this.modificarEstadoTicketAmarillo(indice, tipo);
                    //ManejadorDeListas.ListaDeAmarillos=(ArrayList)this.objetoentrante.readObject();

                } else if (instruccion.equals("ListaLiberadoAMARILLO")) {
                    int indice = dataInput.readInt();

                    String tipo = dataInput.readUTF();

                 //   System.out.println(tipo + "Este es el tip");

                    this.modificarEstadoLiberadoTicketAmarillo(indice, tipo);
                    //ManejadorDeListas.ListaDeAmarillos=(ArrayList)this.objetoentrante.readObject();

                } else if (instruccion.equals("ListaLiberadoROJO")) {
                    int indice = dataInput.readInt();

                    String tipo = dataInput.readUTF();

                 //   System.out.println(tipo + "Este es el tip");

                    this.modificarEstadoTicketLiberadoRojo(indice, tipo);
                    //ManejadorDeListas.ListaDeAmarillos=(ArrayList)this.objetoentrante.readObject();

                } else if (instruccion.equals("ListaLiberadoVERDE")) {
                    int indice = dataInput.readInt();

                    String tipo = dataInput.readUTF();

                 //   System.out.println(tipo + "Este es el tip");

                    this.modificarEstadoTicketLiberadoVerde(indice, tipo);
                    //ManejadorDeListas.ListaDeAmarillos=(ArrayList)this.objetoentrante.readObject();

                } else if (instruccion.equals("Reporte")) {
                    mandarReporteIndividual();

                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mandarReporteIndividual() throws IOException {
        System.out.println("Entro en obtenr reporte");
        String tipo = this.dataInput.readUTF();
        System.out.println("Nombre de la persona que lo solicito: " + this.getName(tipo));
        System.out.println("Esta es la fecha: " + this.getFecha(tipo));
        int efectivos = contarEfectivos(this.getName(tipo), this.getFecha(tipo));
        int liberados = contarLiberados(this.getName(tipo), this.getFecha(tipo));
        System.out.println("antes de mandar el reporte");
       
        this.saliente.writeUTF(efectivos+"@"+liberados);
        System.out.println("despues de terminar el reporte");

    }

    public int contarEfectivos(String nombre, String fecha) {
        int resultado = 0;
        ArrayList temp = ManejadorDeListas.MegaLista;
        System.out.println("nombre::::"+nombre);
        System.out.println("fecha:::::"+fecha);
        for (int i = 0; i < temp.size(); i++) {
            
            Tickets tictemp = (Tickets) temp.get(i);
            System.out.println(tictemp.getID_EMPLEADO());
            System.out.println(tictemp.getFechayHoraAtencion());
            
            if (tictemp.getID_EMPLEADO().equals(nombre) && tictemp.getFechayHoraAtencion().equals(fecha)) {
                resultado++;
            }

        }
        return 4;

    }

    public int contarLiberados(String nombre, String fecha) {
        int resultado = 0;
        ArrayList temp = ManejadorDeListas.MegaLiberados;

        for (int i = 0; i < temp.size(); i++) {
            Tickets tictemp = (Tickets) temp.get(i);
            if (tictemp.getID_EMPLEADO().equals(nombre) && tictemp.getFechayHoraAtencion().equals(fecha)) {
                resultado++;
            }

        }
        System.out.println("Termino contar liberados00");
        return 3;

    }

    public String getFecha(String oracion) {
        String temp = "";
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == '@') {
                temp = "";
                continue;
            }
            temp = temp + oracion.charAt(i);
        }
        return temp;
    }
}
