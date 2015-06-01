/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

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
public class VnReporteCliente extends javax.swing.JFrame {
    public static DefaultPieDataset defaultpiedataset;
    public static JFreeChart chart;
    public static ChartPanel chartPanel;
    /**
     * Creates new form VnReporteCliente
     */
    public VnReporteCliente() {
        initComponents();
        setLocationRelativeTo(null);
        
                
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
        lblTituloReporteAtencion = new javax.swing.JLabel();
        lblUsuarioTitulo = new javax.swing.JLabel();
        lblUsuarioTitulo1 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuarioTitulo2 = new javax.swing.JLabel();
        lblUsuarioTitulo3 = new javax.swing.JLabel();
        lblUsuarioTitulo4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblNumTicketsResividos = new javax.swing.JLabel();
        lblNumTicketsSatisfactorios = new javax.swing.JLabel();
        lblUsuarioTitulo5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpGraficoLayout = new javax.swing.GroupLayout(jpGrafico);
        jpGrafico.setLayout(jpGraficoLayout);
        jpGraficoLayout.setHorizontalGroup(
            jpGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        jpGraficoLayout.setVerticalGroup(
            jpGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblTituloReporteAtencion.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lblTituloReporteAtencion.setText("Reporte de Atención");

        lblUsuarioTitulo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblUsuarioTitulo.setText("Usuario:");

        lblUsuarioTitulo1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblUsuarioTitulo1.setText("Consultar en la Fecha:");

        lblNombreUsuario.setText("NOMBRE DEL EMPLEADO");

        jLabel1.setBackground(java.awt.Color.darkGray);
        jLabel1.setText("aqui va el Calendar");

        lblUsuarioTitulo2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lblUsuarioTitulo2.setText("Atendidos Satisfactoriamente:");

        lblUsuarioTitulo3.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lblUsuarioTitulo3.setText("Total Tikets Resividos: ");

        lblUsuarioTitulo4.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblUsuarioTitulo4.setText("Proporción:");

        jButton1.setText("Volver");

        lblNumTicketsResividos.setText("15");

        lblNumTicketsSatisfactorios.setText("7");

        lblUsuarioTitulo5.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblUsuarioTitulo5.setText("Tanto por Ciento");

        jButton2.setText("Consultar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuarioTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTituloReporteAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuarioTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUsuarioTitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuarioTitulo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNumTicketsSatisfactorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblUsuarioTitulo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsuarioTitulo3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumTicketsResividos, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jpGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTituloReporteAtencion)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuarioTitulo)
                            .addComponent(lblNombreUsuario))
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuarioTitulo1)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuarioTitulo3)
                            .addComponent(lblNumTicketsResividos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuarioTitulo2)
                            .addComponent(lblNumTicketsSatisfactorios))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuarioTitulo4)
                            .addComponent(lblUsuarioTitulo5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VnReporteCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VnReporteCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VnReporteCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VnReporteCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VnReporteCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpGrafico;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblNumTicketsResividos;
    private javax.swing.JLabel lblNumTicketsSatisfactorios;
    private javax.swing.JLabel lblTituloReporteAtencion;
    private javax.swing.JLabel lblUsuarioTitulo;
    private javax.swing.JLabel lblUsuarioTitulo1;
    private javax.swing.JLabel lblUsuarioTitulo2;
    private javax.swing.JLabel lblUsuarioTitulo3;
    private javax.swing.JLabel lblUsuarioTitulo4;
    private javax.swing.JLabel lblUsuarioTitulo5;
    // End of variables declaration//GEN-END:variables
}
