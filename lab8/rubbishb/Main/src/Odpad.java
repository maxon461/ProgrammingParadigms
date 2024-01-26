public class Odpad {
    private RodzajSmiecia rodzaj;
    private String nazwa;
    private int dlugosc;
    private int szerokosc;

    
    public Odpad(RodzajSmiecia rodzaj, String nazwa, int dlugosc, int szerokosc) {
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    public Odpad(RodzajSmiecia rodzaj) {
        this.rodzaj = rodzaj;
    }

    public RodzajSmiecia getRodzaj() {
        return rodzaj;
    }

    @Override
    public String toString() {
        return "Odpad [rodzaj=" + rodzaj + ", nazwa=" + nazwa + ", dlugosc=" + dlugosc + ", szerokosc=" + szerokosc
                + "]";
    }


}
