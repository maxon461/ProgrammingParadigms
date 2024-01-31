import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Smieci pudelko = new Pudelko(Smieci.RodzajOdpadu.PAPIER, 20.0, "zielony");
        Smieci butelka = new Butelka(Smieci.RodzajOdpadu.SZKLO, 0.5, true);
        Smieci puszka = new Puszka(Smieci.RodzajOdpadu.METAL, 0.3, "grochowa");
        Smieci worek = new Worek(Smieci.RodzajOdpadu.PLASTIK, "szyszki", 5);
        Smieci karton = new Pudelko(Smieci.RodzajOdpadu.PAPIER, 15.0, "brązowy");
        Smieci plastikowaButelka = new Butelka(Smieci.RodzajOdpadu.PLASTIK, 1.0, false);
        Smieci puszekPoNapoju = new Puszka(Smieci.RodzajOdpadu.METAL, 0.25, "napój gazowany");

        Karton kartonowyOdpad = new Karton(Smieci.RodzajOdpadu.PAPIER, 25.0, true, true);

        List<Smieci> smieciList = new ArrayList<>();
        smieciList.add(pudelko);
        smieciList.add(butelka);
        smieciList.add(puszka);
        smieciList.add(worek);
        smieciList.add(puszekPoNapoju);
        smieciList.add(kartonowyOdpad);
        smieciList.add(karton);
        smieciList.add(plastikowaButelka);

        // Tworzenie sortowni
 

        SortujPapier sortownia = new SortujPapier(smieciList);
      
        
        System.out.println("Metal List:");
        wyswietlListe(sortownia.getMetalList());

        System.out.println("\nSzkło List:");
        wyswietlListe(sortownia.getSzkloList());

        System.out.println("\nPlastik List:");
        wyswietlListe(sortownia.getPlastikList());

        System.out.println("\nPapier List:");
        wyswietlListe(sortownia.getPapierList());

        System.out.println("\nPapierMet List:");
        wyswietlListe(sortownia.getPapiermetalizowany());
    }

    private static void wyswietlListe(List<Smieci> lista) {
        for (Smieci smiec : lista) {
            System.out.println(smiec.toString());
        }
    }
}