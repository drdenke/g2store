package view;

import java.util.Scanner;
import model.Kategorije;

public class Izgled {
    
    
    public int menu(){
        System.out.println("1. Unos , 2. Izmena , 3. Brisanje , 4. Prikaz");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
    
    public int unesiBroj(){
        System.out.println("Unesi broj: ");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
    
    public void izmeniKategoriju(Kategorije k){
        System.out.println("Unesi naziv kategorije: ");
        Scanner s = new Scanner(System.in);
        k.naziv = s.nextLine();
        System.out.println("Unesi opis kategorije: ");
        k.opis = s.nextLine();
    }
    
    public Kategorije uzmiKategoriju(){
        System.out.println("Unesi naziv kategorije: ");
        Scanner s = new Scanner(System.in);
        Kategorije rezultat = new Kategorije();
        rezultat.naziv = s.nextLine();
        System.out.println("Unesi opis kategorije: ");
        rezultat.opis = s.nextLine();
        return rezultat;
    }
    
   
}
