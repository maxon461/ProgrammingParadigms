public class Worek extends Smieci {
    private String zawartosc;
    private int ilosc;

    public Worek(RodzajOdpadu rodzaj, String zawartosc, int ilosc) {
        super(rodzaj);
        this.zawartosc = zawartosc;
        this.ilosc = ilosc;
    }

    @Override
    public String toString() {
        return "Worek " + getRodzaj() + ", zawartosc: " + zawartosc + ", ilosc: " + ilosc;
    }
}
