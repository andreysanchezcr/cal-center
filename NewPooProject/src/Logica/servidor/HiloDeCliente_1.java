package Logica.servidor;


import Logica.ManejadorDeListas;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


public class HiloDeCliente_1 implements Runnable, ListDataListener
{
    private DefaultListModel charla;

    private Socket socket;

    private DataInputStream dataInput;

    private DataOutputStream dataOutput;
    private Servidor servidor;
    ObjectOutputStream salienteServidor;

    public HiloDeCliente_1(DefaultListModel charla, Socket socket) throws IOException
    {
        
        this.charla = charla;
        this.socket = socket;
        ArrayList lista = ManejadorDeListas.ListaDeRojos;
        //lista.add("PERE");
        salienteServidor=new ObjectOutputStream(socket.getOutputStream());
        salienteServidor.writeObject(lista);
        
        try
        {
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
            charla.addListDataListener(this);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void actualizarLista() throws IOException{
        ArrayList lista = ManejadorDeListas.ListaDeRojos;
        //lista.add("PERE");
        //salienteServidor=new ObjectOutputStream(socket.getOutputStream());
        salienteServidor.writeObject(lista);
    }

    public void run()
    {
        try
        {
            while (true)
            {
                String texto = dataInput.readUTF();
                synchronized (charla)
                {
                    charla.addElement(texto);
                    System.out.println(texto);
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void actualizaLista() throws IOException{
        
        ArrayList lista = ManejadorDeListas.ListaDeRojos;
        //lista.add("PERE");
        salienteServidor.writeObject(lista);
    }

  
    

    
    public void intervalRemoved(ListDataEvent e)
    {
    }


    public void contentsChanged(ListDataEvent e)
    {
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
