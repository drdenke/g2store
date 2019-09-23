package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Baza {
     public static Connection conn;
     public static void connect() throws SQLException{
         conn = DriverManager.getConnection("jdbc:mysql://localhost/g2_skladiste?useSSL=false","root","");// <-- unesi pw
     }
     public static void disconnect() throws SQLException{
         conn.close();
         conn=null;
     }
     
      public List uzmiKategorije() throws SQLException{
         connect();
         
         PreparedStatement st = conn.prepareStatement("select * from kategorije");

         List rezultat = new ArrayList();
                 //new Kategorije();
         ResultSet rs = st.executeQuery();
         
         while(rs.next()){
             Kategorije k = new Kategorije();
             k.id=rs.getInt("id");
             k.naziv=rs.getString("naziv");
             k.opis=rs.getString("opis");
             rezultat.add(k);
         }
         
         disconnect();
         return rezultat;
     }
     
     public Kategorije uzmiKategoriju(int id) throws SQLException{
         connect();
         
         PreparedStatement st = conn.prepareStatement("select * from kategorije where id=?");
         st.setInt(1, id);
         
         Kategorije rezultat = null;
                 //new Kategorije();
         ResultSet rs = st.executeQuery();
         
         if(rs.next()){
             rezultat = new Kategorije();
             rezultat.id=rs.getInt("id");
             rezultat.naziv=rs.getString("naziv");
             rezultat.opis=rs.getString("opis");
         }
         
         disconnect();
         return rezultat;
     }
     
     public void izbrisiKategoriju(int id) throws SQLException{
         connect();
         
         PreparedStatement st = conn.prepareStatement("delete from kategorije where id=?");
         st.setInt(1, id);
         st.execute();
         
         disconnect();
     }
     
     public void izmeniKategoriju(Kategorije k) throws SQLException{
         connect();
         
         PreparedStatement st = conn.prepareStatement("update kategorije set naziv = ?, opis = ? where id=?");
         st.setString(1, k.naziv);;
         st.setString(2, k.opis);
         st.setInt(3, k.id);
         
         st.execute();
         
         disconnect();
     }
     
     public void unesiKategoriju(Kategorije k) throws SQLException{
         connect();
         
         PreparedStatement st = conn.prepareStatement("insert into kategorije values (null,?,?)",Statement.RETURN_GENERATED_KEYS);
         st.setString(1, k.naziv);
         st.setString(2, k.opis);
         st.execute();
         ResultSet keys = st.getGeneratedKeys();
         if(keys.next()){
             k.id=keys.getInt(1);
         
         }
         disconnect();
     }   
    
}
