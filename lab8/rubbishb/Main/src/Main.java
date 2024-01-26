import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Odpad metalowyOdpad = new Odpad(RodzajSmiecia.METAL, "Puszka", 20, 10);
        Odpad szklanyOdpad = new Odpad(RodzajSmiecia.SZKLO, "Butelka", 15, 5);
        Odpad plastikowyOdpad = new Odpad(RodzajSmiecia.PLASTIK, "Opakowanie", 25, 12);
        Odpad papierowyOdpad = new Odpad(RodzajSmiecia.PAPIER, "Karton", 30, 18);

        System.out.println(papierowyOdpad.toString());
        List<Odpad> listaOdpadow = new ArrayList<>();
        listaOdpadow.add(metalowyOdpad);
        listaOdpadow.add(szklanyOdpad);
        listaOdpadow.add(plastikowyOdpad);
        listaOdpadow.add(papierowyOdpad);

        Sortownia sortownia = new Sortownia();

        sortownia.dodajSmieci(listaOdpadow);

        List<Odpad> metalList = sortownia.getMetalList();
        List<Odpad> szkloList = sortownia.getSzkloList();
        List<Odpad> plastikList = sortownia.getPlastikList();
        List<Odpad> papierList = sortownia.getPapierList();

        System.out.println("Metalowe odpady:");
        for (Odpad metal : metalList) {
        System.out.println(metal);
        }

        System.out.println("\nSzkło odpady:");
        for (Odpad szklo : szkloList) {
        System.out.println(szklo);
        }

        System.out.println("\nPlastikowe odpady:");
        for (Odpad plastik : plastikList) {
        System.out.println(plastik);
        }

        System.out.println("\nPapierowe odpady:");
        for (Odpad papier : papierList) {
        System.out.println(papier);
        }
    }
}
