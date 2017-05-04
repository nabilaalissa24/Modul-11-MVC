/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nabila AAP
 */
public class c_koneksi {
    public static ResultSet executeQuery(String SQL) throws ClassNotFoundException    {
        ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try {
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public static int execute(String SQL) {
        int status = 0;
        Connection koneksi = getKoneksi();
        try { 
            Statement st = koneksi.createStatement();  
            status = st.executeUpdate(SQL); 
        } catch (SQLException ex) { 
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        return status; 
    }
    
    public static Connection setKoneksi() throws ClassNotFoundException {
        String konString = "jdbc:mysql://localhost:3306/toko";
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi  = (Connection)
                    DriverManager.getConnection(konString, "root", "");
            System.out.println("Koneksi Berhsail");;
        } catch (SQLException ex) {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);;
            System.out.println("kKoneksi Gagal");
        }
        return koneksi;
    }
    
    public static Object getConnection() {
        return null;
    }

    private static Connection getKoneksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    
    public c_koneksi() {
        try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toko","root","");
        st = con.createStatement(); 
        } catch (Exception a)
        {
            JOptionPane.showMessageDialog(null, "Koeksi Database Gagal"+ a); 
        }
    }
}
