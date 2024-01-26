public class Butelka extends Smieci {
    private double pojemnosc;
    private boolean czyZwrotna;

    public Butelka(RodzajOdpadu rodzaj, double pojemnosc, boolean czyZwrotna) {
        super(rodzaj);
        this.pojemnosc = pojemnosc;
        this.czyZwrotna = czyZwrotna;
    }

    @Override
    public String toString() {
        return "Butelka " + getRodzaj() + ", pojemnosc: " + pojemnosc + ", zwrotna: " + czyZwrotna;
    }
}
