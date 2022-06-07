/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DRecibos;
import Metodos.Metodos;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author del.sistemas_res
 */
public class Buscar extends javax.swing.JFrame {
 Metodos mp;
    /**
     * Creates new form Buscar
     */
    public Buscar() {
        initComponents();
        txtEnvoice1.setEnabled(false);
        txtFecha.setEnabled(false);
        txtCamion1.setEnabled(false);
        txtTotal.setEnabled(false);
        txtDetails.setEnabled(false);
        setLocationRelativeTo(null);
        setResizable(false);
    }
public void MostarTablaPorCamion(){ 
    Metodos Met=new Metodos();
        Met.MostrarTablaPorCamion(TablaBuscar, txtCamion,comboaño);
    }
public void MostarTablaPorCamionAgrupado(){ 
    Metodos Met=new Metodos();
        Met.MostrarTablaPorCamionAgrupado(TablaBuscar, txtCamion,comboaño);
    }
public void MostrarTablaPorEnvoice(){        
     Metodos Met=new Metodos();
        Met.MostrarTablaPorEnvoice(TablaBuscar,txtEnvoice);
}
public ImageIcon puenteObtenerImagen(int clv) {
   
    this.mp = new Metodos();
    ImageIcon img = null;
    try {
      img = this.mp.obtenerImagen(clv);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Error: " + ex);
    } 
    return img;
  }
public void limpiar(){
    txtEnvoice1.setText("");
txtCamion1.setText("");
txtFecha.setText("");
txtTotal.setText("");
txtDetails.setText("");}
public float suma() {
        int contar = TablaBuscar.getRowCount();
        float suma = 0;
        for (int i = 0; i < contar; i++) {
            suma = suma + Float.parseFloat(TablaBuscar.getValueAt(i, 5).toString());
        }

        return suma;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaBuscar = new javax.swing.JTable();
        txtEnvoice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCamion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtEnvoice1 = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtCamion1 = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetails = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtTotaltotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        comboaño = new javax.swing.JComboBox<>();
        lbMostrarImagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaBuscarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaBuscar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 550, 256));
        getContentPane().add(txtEnvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 171, 220, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Envoice:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 174, -1, -1));

        txtCamion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "800", "801", "804", "805", "806" }));
        txtCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCamionActionPerformed(evt);
            }
        });
        getContentPane().add(txtCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 171, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Truck:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 174, -1, -1));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 220, -1));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 480, 63, -1));
        getContentPane().add(txtEnvoice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 11, 181, -1));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 220, -1));
        getContentPane().add(txtCamion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 220, -1));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 220, -1));

        txtDetails.setColumns(20);
        txtDetails.setRows(5);
        jScrollPane2.setViewportView(txtDetails);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 49, 230, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Envoice:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 14, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Truck:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Details:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 49, -1, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 450, -1, -1));
        getContentPane().add(txtTotaltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 181, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, -1, -1));

        jButton4.setText("Order by Details");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 140, -1));

        comboaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2021", "2032" }));
        getContentPane().add(comboaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));
        getContentPane().add(lbMostrarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 450, 410));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lojo.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
MostrarTablaPorEnvoice();
limpiar();
txtTotaltotal.setText(Float.toString(suma()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCamionActionPerformed
MostarTablaPorCamion();
txtTotaltotal.setText(Float.toString(suma()));// TODO add your handling code here:
    }//GEN-LAST:event_txtCamionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Sistema si=new Sistema();
       si.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaBuscarMouseClicked
if (evt.getButton() == 1) {
            int fila = TablaBuscar.getSelectedRow();
            lbMostrarImagen.setIcon(null);
            txtEnvoice1.setText(TablaBuscar.getValueAt(fila, 0).toString());
            txtFecha.setText(this.TablaBuscar.getValueAt(fila, 1).toString());
            txtCamion1.setText(this.TablaBuscar.getValueAt(fila, 2).toString());
            txtTotal.setText(this.TablaBuscar.getValueAt(fila, 3).toString());
            txtDetails.setText(this.TablaBuscar.getValueAt(fila, 4).toString());
            String x=TablaBuscar.getValueAt(fila,6).toString();
            if(x.equals("")){System.out.println("no hay");}
            else{
int clv = Integer.parseInt(this.txtEnvoice1.getText());
      ImageIcon img = puenteObtenerImagen(clv);
      Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.lbMostrarImagen.getWidth(), this.lbMostrarImagen.getHeight(), 1));
      if (img != null)
        this.lbMostrarImagen.setIcon(icono); }
        }       
    }//GEN-LAST:event_TablaBuscarMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
if (txtEnvoice1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a row");
        } else {
    DRecibos prod=new DRecibos();
            Metodos me = new Metodos();
            prod.setEnvoice(txtEnvoice1.getText());
            me.Borrar(prod);
            limpiar();
            MostarTablaPorCamion();
            txtTotaltotal.setText(Float.toString(suma()));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
MostarTablaPorCamionAgrupado();
txtTotaltotal.setText(Float.toString(suma()));       
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaBuscar;
    private javax.swing.JComboBox<String> comboaño;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMostrarImagen;
    private javax.swing.JComboBox<String> txtCamion;
    private javax.swing.JTextField txtCamion1;
    private javax.swing.JTextArea txtDetails;
    private javax.swing.JTextField txtEnvoice;
    private javax.swing.JTextField txtEnvoice1;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotaltotal;
    // End of variables declaration//GEN-END:variables
}