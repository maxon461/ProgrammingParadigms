public class Odpad {
    private RodzajSmiecia rodzaj;
    private String nazwa;
    private int dlugosc;
    private int szerokosc;
    public boolean czyMetal;

    
    public Odpad(RodzajSmiecia rodzaj, String nazwa, int dlugosc, int szerokosc, boolean czyMetal) {
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.czyMetal = czyMetal;
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
