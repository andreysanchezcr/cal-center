package Interfaz;
import javax.swing.*;
import java.io.File;
import Logica.*;//<---------------------------------------------------------------------Despues le borro
import static Logica.ManejadorDeListas.ListaDeAmarillos;
import static Logica.ManejadorDeListas.ListaDeRojos;
import static Logica.ManejadorDeListas.ListaDeVerdes;
import Logica.servidor.HiloDeCliente_1;
import Logica.servidor.Servidor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ServidorVentana extends javax.swing.JFrame implements Runnable {

    Servidor servidor;
    ArrayList listaEmpleados;
    boolean luis;
    boolean fernando;
    boolean junior;
    public ServidorVentana() {
       //this.servidor=servidor;
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    public void setLabel(){
        jLabel2.setText("Conectado");
    }
    public void setConectados(){
        if(((Persona)listaEmpleados.get(1)).getEstado()){
            jLabel2.setText("Fernando conectado");
        }else{
            jLabel2.setText("Fernando desconectado");
        }
        if(((Persona)listaEmpleados.get(2)).getEstado()){
            jLabel3.setText("Luis conectado");
        }else{
            jLabel3.setText("Luis desconectado");
        }
        if(((Persona)listaEmpleados.get(1)).getEstado()){
            jLabel4.setText("Junior conectado");
        }else{
            jLabel4.setText("Junior desconectado");
        }
    }
    public void setListaEmpleados(ArrayList lista){
        listaEmpleados=lista;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnCargarTickets = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSetComoVERDE = new javax.swing.JButton();
        btnSetComoAmarillo = new javax.swing.JButton();
        btnSetComoRojo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Lista = new java.awt.List();
        btnCargarTickets1 = new javax.swing.JButton();
        Lista4 = new java.awt.List();
        Lista5 = new java.awt.List();
        Lista6 = new java.awt.List();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("SERVIDOR"); // NOI18N
        setResizable(false);

        btnCargarTickets.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnCargarTickets.setText("Cargar tikets");
        btnCargarTickets.setToolTipText("Carga en la lista los tickets pendientes");
        btnCargarTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTicketsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Servidor para categorizar los tickets");

        btnSetComoVERDE.setBackground(new java.awt.Color(51, 204, 0));
        btnSetComoVERDE.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnSetComoVERDE.setText("VERDE");
        btnSetComoVERDE.setEnabled(false);
        btnSetComoVERDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetComoVERDEActionPerformed(evt);
            }
        });

        btnSetComoAmarillo.setBackground(new java.awt.Color(255, 255, 0));
        btnSetComoAmarillo.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnSetComoAmarillo.setText("AMARILLO");
        btnSetComoAmarillo.setEnabled(false);
        btnSetComoAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetComoAmarilloActionPerformed(evt);
            }
        });

        btnSetComoRojo.setBackground(new java.awt.Color(255, 0, 0));
        btnSetComoRojo.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnSetComoRojo.setText("ROJO");
        btnSetComoRojo.setEnabled(false);
        btnSetComoRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetComoRojoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 0, 14))); // NOI18N

        jLabel2.setText("NULL");

        jLabel3.setText("NULL");

        jLabel4.setText("NULL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Lista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ListaItemStateChanged(evt);
            }
        });
        Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaActionPerformed(evt);
            }
        });

        btnCargarTickets1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnCargarTickets1.setText("Desconectar");
        btnCargarTickets1.setToolTipText("Carga en la lista los tickets pendientes");
        btnCargarTickets1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTickets1ActionPerformed(evt);
            }
        });

        Lista4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Lista4ItemStateChanged(evt);
            }
        });
        Lista4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lista4ActionPerformed(evt);
            }
        });

        Lista5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Lista5ItemStateChanged(evt);
            }
        });
        Lista5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lista5ActionPerformed(evt);
            }
        });

        Lista6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Lista6ItemStateChanged(evt);
            }
        });
        Lista6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lista6ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 0));
        jLabel9.setText("VERDE");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("AMARILLO");

        jLabel11.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("ROJO");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Cuadro Informativo");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargarTickets)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(218, 218, 218)
                                .addComponent(btnCargarTickets1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Lista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSetComoAmarillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSetComoVERDE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSetComoRojo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(84, 84, 84)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lista4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Lista6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Lista5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(117, 117, 117))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnCargarTickets1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lista, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSetComoVERDE)
                                .addGap(19, 19, 19)
                                .addComponent(btnSetComoAmarillo)
                                .addGap(21, 21, 21)
                                .addComponent(btnSetComoRojo)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarTickets)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(Lista4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(Lista6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lista5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTicketsActionPerformed
      //================FIle Chooser=========================//
        JFileChooser ventanaSeleccionArchivo = new JFileChooser();
        ventanaSeleccionArchivo.showOpenDialog(null);
        File archivoActual= ventanaSeleccionArchivo.getSelectedFile();
        String pathArchivo = archivoActual.getAbsolutePath();
        //====================================================//
        
       
        ManejadorDeListas.addNewTiketsToLocalListPendientes(    MyExell.Open_Load_And_ReturnListOfTickets(pathArchivo)   );
        
        //MyExell.save_All_Changes(pathArchivo, MyExell.Open_Load_And_ReturnListOfTickets(pathArchivo),MyExell.Open_Load_And_ReturnListOfTickets(pathArchivo),MyExell.Open_Load_And_ReturnListOfTickets(pathArchivo),MyExell.Open_Load_And_ReturnListOfTickets(pathArchivo));

        Lista.repaint();
        
    }//GEN-LAST:event_btnCargarTicketsActionPerformed

    public void setServidor(Servidor servidor){
        this.servidor=servidor;
    }
    public void actualizarListaTiquetes() throws IOException{
        ArrayList lista=servidor.getListaConexiones();
        for(int i=0;i<lista.size();i++){
            HiloDeCliente_1 temp=((HiloDeCliente_1)lista.get(i));
            temp.actualizarLista();
            
        }
    }
    
    private void btnSetComoVERDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetComoVERDEActionPerformed
        // TODO add your handling code here:
        String pTiket = Lista.getSelectedItem();
        Lista.remove(pTiket);
        Lista4.add(pTiket);
        btnSetComoVERDE.setEnabled(false);
        btnSetComoAmarillo.setEnabled(false);
        btnSetComoRojo.setEnabled(false);
        
        ManejadorDeListas.finderThenInsert(pTiket, ListaDeVerdes);
        
    }//GEN-LAST:event_btnSetComoVERDEActionPerformed

    private void btnSetComoAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetComoAmarilloActionPerformed
        // TODO add your handling code here:
        String pTiket = Lista.getSelectedItem();
        Lista.remove(pTiket);
        Lista6.add(pTiket);
        btnSetComoVERDE.setEnabled(false);
        btnSetComoAmarillo.setEnabled(false);
        btnSetComoRojo.setEnabled(false);
        
        ManejadorDeListas.finderThenInsert(pTiket, ListaDeAmarillos);
    }//GEN-LAST:event_btnSetComoAmarilloActionPerformed

    private void btnSetComoRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetComoRojoActionPerformed
        // TODO add your handling code here:
        String pTiket = Lista.getSelectedItem();
        Lista.remove(pTiket);
        Lista5.add(pTiket);
        btnSetComoVERDE.setEnabled(false);
        btnSetComoAmarillo.setEnabled(false);
        btnSetComoRojo.setEnabled(false);
        
        ManejadorDeListas.finderThenInsert(pTiket, ListaDeRojos);
        try {
            this.servidor.gett().actualizarLista();
        } catch (IOException ex) {
            Logger.getLogger(ServidorVentana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSetComoRojoActionPerformed

    private void ListaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ListaItemStateChanged
        btnSetComoVERDE.setEnabled(true);
        btnSetComoAmarillo.setEnabled(true);
        btnSetComoRojo.setEnabled(true);
    }//GEN-LAST:event_ListaItemStateChanged

    private void ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaActionPerformed

    private void btnCargarTickets1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTickets1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarTickets1ActionPerformed

    private void Lista4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Lista4ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Lista4ItemStateChanged

    private void Lista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lista4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Lista4ActionPerformed

    private void Lista5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Lista5ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Lista5ItemStateChanged

    private void Lista5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lista5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Lista5ActionPerformed

    private void Lista6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Lista6ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Lista6ItemStateChanged

    private void Lista6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lista6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Lista6ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static java.awt.List Lista;
    public static java.awt.List Lista4;
    public static java.awt.List Lista5;
    public static java.awt.List Lista6;
    private javax.swing.JButton btnCargarTickets;
    private javax.swing.JButton btnCargarTickets1;
    private javax.swing.JButton btnSetComoAmarillo;
    private javax.swing.JButton btnSetComoRojo;
    private javax.swing.JButton btnSetComoVERDE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    }

   
    
}
