

package Logica;

import java.io.Serializable;




public class Tickets implements Serializable{
    /**
     * Atributos
     */
    private String FechayHoraRecepcion;
    private String ID_CLIENTE;    
    private String asunto;
    private  int   IDTicket;
    private String categoria;
    private String ID_EMPLEADO;
    private String fechayHoraAtencion;
    private String tiempoSegundos;
    private String Comentario;
    private String estado;

    /**
     * Contructor (Utilizado por Exell.java para cargar Tikets Pendientes)
     * @param FechayHoraRecepcion Atributo seteado a la hora de la carga del archivo con la fecha y hora actuales
     * @param ID_CLIENTE Atributo situado en la segunda columna del Exel
     * @param asunto  Atributo ubicado en la tercera columna del Exel
     */ 
    public Tickets(String FechayHoraRecepcion, String ID_CLIENTE, String asunto, int IDTicket){
        this.FechayHoraRecepcion = FechayHoraRecepcion;
        this.ID_CLIENTE = ID_CLIENTE;
        this.asunto = asunto;
        this.IDTicket = IDTicket;
        this.estado="Sin atender";
    }
    /**
     * Contructor con todos los atributos (Exell.java creara objetos completos a partir de la carga del archivo"Tickets Rojos, Amarillos y Verdes")
     * @param FechayHoraRecepcion Columna del Exell
     * @param ID_CLIENTE Columna 0 del Exell
     * @param asunto     Columna 1 del Exell
     * @param IDTicket   Columna 2 del Exell
     * @param categoria  Columna 3 del Exell
     * @param ID_EMPLEADO Columna 4 del Exell
     * @param fechayHoraAtencion Columna 5 del Exell
     * @param tiempoSegundos Columna 6 del Exell
     * @param Comentario Columna 7 del Exell
     * @param estado     Columna 8 del Exell
     */
    public Tickets(String FechayHoraRecepcion, String ID_CLIENTE, String asunto, 
                   int IDTicket, String categoria, String ID_EMPLEADO, 
                   String fechayHoraAtencion,String tiempoSegundos, 
                   String Comentario, String estado){
    
        this.FechayHoraRecepcion=FechayHoraRecepcion;
        this.ID_CLIENTE=ID_CLIENTE;    
        this.asunto=asunto;
        this.IDTicket=IDTicket;
        this.categoria=categoria;
        this.ID_EMPLEADO=ID_EMPLEADO;
        this.fechayHoraAtencion=fechayHoraAtencion;
        this.tiempoSegundos=tiempoSegundos;
        this.Comentario=Comentario;
        this.estado="Sin atender";
    }
    
    public Tickets(String asunto, int IDTicket, String categoria, String estado){
        this.asunto = asunto;
        this.IDTicket = IDTicket;
        this.categoria = categoria;
        this.estado = estado;
    }
    
    
    
    /**
     * Stters and Getters
     */
    public String getFechayHoraRecepcion() {
        return FechayHoraRecepcion;
    }

    public void setFechayHoraRecepcion(String FechayHoraRecepcion) {
        this.FechayHoraRecepcion = FechayHoraRecepcion;
    }

    public String getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(String ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }
    
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    public int getIDTicket() {
        return IDTicket;
    }

    public void setIDTicket(int IDTicket) {
        this.IDTicket = IDTicket;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
 
    public String getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    public void setID_EMPLEADO(String ID_EMPLEADO) {
        this.ID_EMPLEADO = ID_EMPLEADO;
    }

    public String getFechayHoraAtencion() {
        return fechayHoraAtencion;
    }

    public void setFechayHoraAtencion(String fechayHoraAtencion) {
        this.fechayHoraAtencion = fechayHoraAtencion;
    }

    public String getTiempoSegundos() {
        return tiempoSegundos;
    }

    public void setTiempoSegundos(String tiempoSegundos) {
        this.tiempoSegundos = tiempoSegundos;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstadoActual(){
        return getAsunto()+" "+getEstado();
    }
    
    
    public String toString(){
        String datos = "Asunto: " + getAsunto() + "\n" +
                       "ID: " + getIDTicket() + "\n" +
                       "Categoria: " + getCategoria() + "\n" +
                       "Estado: " + getEstado() + "\n" ;
        return datos;
    }
    
}
