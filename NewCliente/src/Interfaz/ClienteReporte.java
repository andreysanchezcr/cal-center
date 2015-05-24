/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import static Interfaz.VnReporteCliente.chart;
import static Interfaz.VnReporteCliente.chartPanel;
import static Interfaz.VnReporteCliente.defaultpiedataset;
import com.toedter.calendar.JCalendar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
/**
 *
 * @author root
 */
public class ClienteReporte extends javax.swing.JFrame {

    /**
     * Creates new form ClienteReporte
     */
    ClienteVentana parent;
    public ClienteReporte(ClienteVentana parent) {
        this.parent=parent;
        initComponents();
        
             
        // Fuente de Datos
        defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("Total de Tickets Liberados", (Integer.parseInt(lblNumTicketsResividos.getText())-Integer.parseInt(lblNumTicketsSatisfactorios.getText())));
        defaultpiedataset.setValue("Tickets Atendidos Satisfactoriamente", Integer.parseInt(lblNumTicketsSatisfactorios.getText()));
        //defaultpiedataset.setValue("Hacking", new Double(19.5D));
        //defaultpiedataset.setValue("SEO", new Double(30.5D));
        //defaultpiedataset.setValue("Redes", new Double(2.0D));

        // Creando el Grafico
        chart = ChartFactory.createPieChart3D("Mi Proporción", defaultpiedataset, true, true, false);
        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot();
        pieplot3d.setDepthFactor(0.5);
        pieplot3d.setStartAngle(290D);
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        pieplot3d.setForegroundAlpha(0.5F);
        
        // Mostrar Grafico
        chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(0, 0, 314, 270);
        jpGrafico.add(chartPanel);
        this.setVisible(true);

        
    }
    public String getFecha(){
        
//        date.getCalendar().getTime().getDay()
        String fec=""+date.getDate().getMonth();
        System.out.println("fsdfasfasfasfasfasfafasdfasgasfas"+fec);
        String fecha=date.getCalendar().getTime().getDay()+"/"+date.getCalendar().getTime().getMonth()+"/"+date.getCalendar().getTime().getYear();
    
        System.out.println("ESta es la fechaaaaaaa: "+fecha);
        return fecha;
    }
    public boolean verificarUsuario(String nombre,String contrasena){
        if(nombre.equals(parent.cliente.getUsuario())&&contrasena.equals(parent.cliente.getContrasena())){
            return true;
        }
        return false;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpGrafico = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lblNumTicketsResividos = new javax.swing.JLabel();
        lblNumTicketsSatisfactorios = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpGraficoLayout = new javax.swing.GroupLayout(jpGrafico);
        jpGrafico.setLayout(jpGraficoLayout);
        jpGraficoLayout.setHorizontalGroup(
            jpGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGraficoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(220, 220, 220))
        );
        jpGraficoLayout.setVerticalGroup(
            jpGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGraficoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        lblNumTicketsResividos.setText("15");

        lblNumTicketsSatisfactorios.setText("7");

        jLabel1.setText("REPORTE DE ATENCION");

        jLabel2.setText("PORCENTAGE:");

        jLabel3.setText("Tikets Atendidos Satisfactoriamente:");

        jLabel4.setText("Total de Tikets Solicitados:");

        jLabel5.setText("EMPLEADO:");

        jLabel6.setText("Nombre del EMpleado");

        jLabel7.setText("Reporte perteneciente a la fecha:");

        jLabel8.setText("Tanto por ciento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNumTicketsSatisfactorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNumTicketsResividos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumTicketsResividos)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblNumTicketsSatisfactorios))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)))
                    .addComponent(jpGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ComprobarLogin ventanaLogin =new ComprobarLogin(this);
        this.getFecha();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jpGrafico;
    private javax.swing.JLabel lblNumTicketsResividos;
    private javax.swing.JLabel lblNumTicketsSatisfactorios;
    // End of variables declaration//GEN-END:variables
}
