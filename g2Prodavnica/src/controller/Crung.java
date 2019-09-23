package controller;

import java.sql.SQLException;
import model.Baza;
import model.Kategorije;
import view.Izgled;

public class Crung {
    
    view.Izgled izgled;
    model.Baza baza;
    
    public Crung(){
        izgled = new Izgled();
        baza = new Baza();
    }
    
    public void prikaziKategoriju() throws SQLException{
        int id = izgled.unesiBroj();
        Kategorije k = baza.uzmiKategoriju(id);
        if(k==null){
            System.out.println("Nepostojaca kategorija!");
        }else{
            System.out.println("Id : " + k.id);
            System.out.println("Naziv : " + k.naziv);
            System.out.println("Opis : " + k.opis);
        }
    }
    
    public void brisiKategoriju() throws SQLException{
        int id = izgled.unesiBroj();
        baza.izbrisiKategoriju(id);
        
    }
    
    public void unesiKategoriju() throws SQLException{
        Kategorije zaUnos =izgled.uzmiKategoriju();
        baza.unesiKategoriju(zaUnos);
    }
    public void izmeniKategoriju() throws SQLException{
        int id = izgled.unesiBroj();
        Kategorije k = baza.uzmiKategoriju(id);
        izgled.izmeniKategoriju(k);
        baza.izmeniKategoriju(k);
    }
    
    public static void run() throws SQLException{
        Crung c = new Crung();
        int odabranaStavka = c.izgled.menu();
        switch(odabranaStavka){
            case 1:
                c.unesiKategoriju();
                break;
            case 2:
                c.izmeniKategoriju();
                break;
            case 3:
                c.brisiKategoriju();
                break;
            case 4:
                c.prikaziKategoriju();
                break;
        }
    }
    
}
