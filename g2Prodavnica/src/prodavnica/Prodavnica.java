
package prodavnica;

import controller.Crung;
import java.sql.SQLException;

public class Prodavnica {

    //U paketu Model klasa Baza za konekcijom sa bazom koriguj metodu 'connect';
    public static void main(String[] args) throws SQLException {
      Crung.run();
      
    }
    
}
