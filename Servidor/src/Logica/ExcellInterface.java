
package Logica;

import java.util.ArrayList;

/**
 *
 * @author root
 * Interface para el correcto manejo de la clase Exell
 */
    public abstract interface  ExcellInterface{

        /**
         * Metodos para la cargar y guardar de Tickets para el Servidor
         * @return Array de Tickets correspondientes 
         */
        public ArrayList<Tickets>  cargarTiketsDeArchivo();
        public ArrayList<Tickets>  cargarTiketsRojosDeArchivo();
        public ArrayList<Tickets>  cargarTiketsVerdesDeArchivo();
        public ArrayList<Tickets>  cargarTiketsAmarillosDeArchivo();
        public void cargarGuardarCambiosEnArchivo(ArrayList<Tickets> listaPendientes,
                                                ArrayList<Tickets> listaVerdes,
                                                ArrayList<Tickets> listaAmarillos,
                                                ArrayList<Tickets> listaRojos);
    
}
