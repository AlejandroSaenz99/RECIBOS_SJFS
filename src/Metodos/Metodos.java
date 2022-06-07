/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Datos.ConexionBD;
import Datos.DCategorias;
import Datos.DRecibos;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author del.sistemas_res
 */
public class Metodos {

 

    

  public void GuardarRecibo(DRecibos prod) {
    try {
      this.con = new ConexionBD();
 String Sentencia_Guardar = "INSERT INTO tablarecibos (Envoice, Date, Truck, Total,Details,Year,Image)VALUES(?,?,?,?,?,?,?) ";

      FileInputStream archivofoto = new FileInputStream(prod.getImage());
      PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(Sentencia_Guardar);
    sentencia_preparada.setString(1, prod.getEnvoice());
      sentencia_preparada.setDate(2, prod.getDate());
      sentencia_preparada.setString(3, prod.getTruck());
      sentencia_preparada.setFloat(4, prod.getTotal());
      sentencia_preparada.setString(5, prod.getDetails());
      sentencia_preparada.setInt(6, prod.getYear());
      sentencia_preparada.setBinaryStream(7, archivofoto);
      int n = sentencia_preparada.executeUpdate();
      if (n > 0)
        JOptionPane.showMessageDialog(null, "Registro Guardado", "Confirmacion", 1); 
      this.con.CerrarConexion();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Clase no encontrada..." + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error de conexion..." + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
  }
   public  void  GuardarCategoria(DCategorias prod) {
            int resultado = 0;
    Connection conexion = null;
    String Sentencia_Guardar = "INSERT INTO Categoria (Id,Description)VALUES(?,?) ";
    try {
      this.con = new ConexionBD();
      PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(Sentencia_Guardar);
      sentencia_preparada.setInt(1, prod.getId());
      sentencia_preparada.setString(2, prod.getDetalle());
      
      int n = sentencia_preparada.executeUpdate();
      if (n > 0)
        JOptionPane.showMessageDialog(null, "Saved data", "Confirm", 1); 
      this.con.CerrarConexion();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Clase no encontrada..." + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error de conexion..." + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
    } 
  }
   public int consultaIdCategoria() {
    int Id = 0;
    try {
      String sql = "SELECT * FROM Categoria ORDER BY Id Desc limit 1";
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      ResultSet rs = this.sentenciaSQL.executeQuery(sql);
      if (rs.first())
        Id = rs.getInt("Id"); 
      rs.close();
      this.con.CerrarConexion();
    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
    } 
    return Id + 1;
  }
        public JTable MostrarTabla(JTable TablaDatos) {
    try {
      String sql = "SELECT *FROM Categoria ORDER BY Id";
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      ResultSet rs = this.sentenciaSQL.executeQuery(sql);
      ResultSetMetaData rsm = rs.getMetaData();
      int col = rsm.getColumnCount();
      DefaultTableModel modelo = new DefaultTableModel();
      for (int i = 1; i <= col; i++)
        modelo.addColumn(rsm.getColumnLabel(i)); 
      while (rs.next()) {
        String[] fila = new String[col];
        for (int j = 0; j < col; j++)
          fila[j] = rs.getString(j + 1); 
        modelo.addRow((Object[])fila);
      } 
      TablaDatos.setModel(modelo);
      rs.close();
      this.con.CerrarConexion();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Clase no encontrada..." + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error de conexion..." + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
    } 
    return TablaDatos;
  }
  Statement sentenciaSQL;
  
  ConexionBD con;
  
  public static PreparedStatement sentencia_preparada;
  
  public static ResultSet resultado;
  
  public static String url;
  
  public static int Resultado_numero = 0;
  
   
  public int Guardar(int Id, String First_Name, String Last_Name, String User_Name, String Password) {
    int resultado = 0;
    Connection conexion = null;
    String Sentencia_Guardar = "INSERT INTO usuarios (Id, First_Name, Last_Name, User_Name, Password)VALUES(?,?,?,?,?) ";
    try {
      this.con = new ConexionBD();
      PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(Sentencia_Guardar);
      sentencia_preparada.setInt(1, Id);
      sentencia_preparada.setString(2, First_Name);
      sentencia_preparada.setString(3, Last_Name);
      sentencia_preparada.setString(4, User_Name);
      sentencia_preparada.setString(5, Password);
      resultado = sentencia_preparada.executeUpdate();
      JOptionPane.showMessageDialog(null, "Welcome " + First_Name);
      sentencia_preparada.close();
      conexion.close();
    } catch (Exception e) {
      System.out.println(e);
    } 
    return resultado;
  }
  public int consultaId() {
    int Id = 0;
    try {
      String sql = "SELECT * FROM usuarios ORDER BY Id Desc limit 1";
      
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      ResultSet rs = this.sentenciaSQL.executeQuery(sql);
      if (rs.first())
        Id = rs.getInt("Id"); 
      rs.close();
      this.con.CerrarConexion();
    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
    } 
    return Id + 1;
  }
    public static String Buscar_Usuario(String Usuario, String Contraseña) {
        String Busqueda_Usuario = null;
        Connection conexion = null;
        try {
            ConexionBD con = new ConexionBD();
            String Sentencia_Buscar_Usuario = "SELECT First_Name, Last_Name FROM usuarios WHERE User_Name='" + Usuario + "'&& Password= '" + Contraseña + "'";

            PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar_Usuario);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {

                Busqueda_Usuario = "Usuario encontrado";
            } else {

                Busqueda_Usuario = "Usuario no encontrado";
            }
            sentencia_preparada.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Busqueda_Usuario;
    }

    public static String Buscar_Nombre(String Usuario) {
        String Busqueda_Nombre = null;
        Connection conexion = null;
        try {
            ConexionBD con = new ConexionBD();
            String Sentencia_Buscar = "SELECT First_Name,Last_Name, User_Name,Password FROM usuarios WHERE User_Name=  '" + Usuario + "'";

            PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {

                String Nombre = resultado.getString("First_Name");
                String Apellidos = resultado.getString("Last_Name");
                Busqueda_Nombre = Nombre + " " + Apellidos;
            }
            sentencia_preparada.close();
            conexion.close();
        } catch (Exception exception) {
        }

        return Busqueda_Nombre;
    }

    public static String Buscar_Envoice(String Envoice) {
/*  99 */     String Busqueda_Envoice = null;
/* 100 */     Connection conexion = null;
/*     */     try {
/* 102 */       ConexionBD con = new ConexionBD();
/* 103 */       String Sentencia_Buscar_Ticket = "SELECT Envoice FROM tablarecibos WHERE Envoice='" + Envoice +"'";
/*     */       
/* 105 */       PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar_Ticket);
/* 106 */       resultado = sentencia_preparada.executeQuery();
/* 107 */       if (resultado.next()) {
/*     */         
/* 109 */         Busqueda_Envoice = "Envoice ya existe";
/*     */       } else {
/*     */         
/* 112 */         Busqueda_Envoice = "Envoice no existe";
/*     */       } 
/* 114 */       sentencia_preparada.close();
/* 115 */       conexion.close();
/* 116 */     } catch (Exception e) {
/* 117 */       System.out.println(e);
/*     */     } 
/* 119 */     return Busqueda_Envoice;
/*     */   }
    
     public JTable MostrarTablaPorCamion(JTable TablaDatos,JComboBox Camion,JComboBox ComboAño) {
     
    try {
      String sql = "SELECT Envoice,Date,Truck,Total,Details,Year,Image FROM tablarecibos Where Truck='"+Camion.getSelectedItem()+"' AND Year='"+ComboAño.getSelectedItem()+"'";
        System.out.println(sql);
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      ResultSet rs = this.sentenciaSQL.executeQuery(sql);
      ResultSetMetaData rsm = rs.getMetaData();
      int col = rsm.getColumnCount();
      DefaultTableModel modelo = new DefaultTableModel();
      for (int i = 1; i <= col; i++)
        modelo.addColumn(rsm.getColumnLabel(i)); 
      while (rs.next()) {
        String[] fila = new String[col];
        for (int j = 0; j < col; j++)
          fila[j] = rs.getString(j + 1); 
        modelo.addRow((Object[])fila);
      } 
      TablaDatos.setModel(modelo);
      rs.close();
      this.con.CerrarConexion();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Clase no encontrada..." + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error de conexion..." + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
    } 
    return TablaDatos;
  }
     public JTable MostrarTablaPorCamionAgrupado(JTable TablaDatos,JComboBox Camion,JComboBox ComboAño) {
     
    try {
//      String sql = "SELECT Envoice,Truck,Date,Year,Details, ROUND(SUM(Total),2) AS 'Total',Image  FROM tablarecibos Where Truck='"+Camion.getSelectedItem()+"'AND Year='"+ComboAño.getSelectedItem()+"' GROUP BY Details";
      String sql = "SELECT Envoice,Date,Truck, ROUND(SUM(Total),2) AS 'Total',Details,Year,Image  FROM tablarecibos Where Truck='"+Camion.getSelectedItem()+"'AND Year='"+ComboAño.getSelectedItem()+"' GROUP BY Details";
        System.out.println(sql);
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      ResultSet rs = this.sentenciaSQL.executeQuery(sql);
      ResultSetMetaData rsm = rs.getMetaData();
      int col = rsm.getColumnCount();
      DefaultTableModel modelo = new DefaultTableModel();
      for (int i = 1; i <= col; i++)
        modelo.addColumn(rsm.getColumnLabel(i)); 
      while (rs.next()) {
        String[] fila = new String[col];
        for (int j = 0; j < col; j++)
          fila[j] = rs.getString(j + 1); 
        modelo.addRow((Object[])fila);
      } 
      TablaDatos.setModel(modelo);
      rs.close();
      this.con.CerrarConexion();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Clase no encontrada..." + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error de conexion..." + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
    } 
    return TablaDatos;
  }
     public JTable MostrarTablaPorEnvoice(JTable TablaDatos,JTextField envoice) {
    try {
      String sql = "SELECT * FROM tablarecibos Where Envoice='"+envoice.getText()+"'";
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      ResultSet rs = this.sentenciaSQL.executeQuery(sql);
      
      ResultSetMetaData rsm = rs.getMetaData();
      int col = rsm.getColumnCount();
      DefaultTableModel modelo = new DefaultTableModel();
      for (int i = 1; i <= col; i++)
        modelo.addColumn(rsm.getColumnLabel(i)); 
      while (rs.next()) {
        String[] fila = new String[col];
        for (int j = 0; j < col; j++)
          fila[j] = rs.getString(j + 1); 
        modelo.addRow((Object[])fila);
      } 
      TablaDatos.setModel(modelo);
      rs.close();
      this.con.CerrarConexion();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Clase no encontrada..." + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error de conexion..." + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
    } 
    return TablaDatos;
  }

    public void Borrar(DRecibos prod) {
   
    try {
      String sql = "DELETE  FROM tablarecibos WHERE Envoice='" + prod.getEnvoice()+"'";
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      int n = this.sentenciaSQL.executeUpdate(sql);
      if (n > 0)
        JOptionPane.showMessageDialog(null, "deleted data: ", "deleted data", 1); 
      this.con.CerrarConexion();
      this.sentenciaSQL.close();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Error 1: " + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error 2: " + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Error 3: " + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error 4: " + ex);
    } 
    }
    public void EliminarCategorias(DCategorias Prod) {
    try {
      String sql = "DELETE FROM Categoria WHERE Id=" + Prod.getId();
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      int n = this.sentenciaSQL.executeUpdate(sql);
      if (n > 0)
        JOptionPane.showMessageDialog(null, "Deleted Data ", "Confimacion", 1); 
      this.con.CerrarConexion();
      this.sentenciaSQL.close();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Error 1: " + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error 2: " + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Error 3: " + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error 4: " + ex);
    } 
  }
    public ComboBoxModel llenarCategorias(){
     JComboBox combo=null;
        combo= new JComboBox();
        combo.addItem("Description");
    try {
        
       
      String sql = "SELECT Description FROM Categoria Order by Id";
        
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      ResultSet rs = this.sentenciaSQL.executeQuery(sql);
      while(rs.next()){
      
      combo.addItem(rs.getString("Description"));}
      rs.close();
      this.con.CerrarConexion();
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Clase no encontrada..." + ex);
    } catch (InstantiationException ex) {
      JOptionPane.showMessageDialog(null, "Error de conexion..." + ex);
    } catch (IllegalAccessException ex) {
      JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
    } 
    return combo.getModel();
    }
    
     public ImageIcon obtenerImagen(int id) throws SQLException {
    InputStream IS = null;
    ImageIcon II = null;
    String sql = "SELECT Image FROM tablarecibos WHERE Envoice=" + id;
    try {
      this.con = new ConexionBD();
      this.sentenciaSQL = this.con.Conectarse().createStatement();
      ResultSet rs = this.sentenciaSQL.executeQuery(sql);
      if (rs.next()) {
        IS = rs.getBinaryStream(1);
        BufferedImage bi = ImageIO.read(IS);
        II = new ImageIcon(bi);
      } 
    } catch (Exception e) {
        System.out.println(e);      
//JOptionPane.showMessageDialog(null, "Error: " + ex);
    } 
    this.con.CerrarConexion();
    this.sentenciaSQL.close();
    return II;
  }
}
