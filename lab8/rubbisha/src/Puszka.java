public class Puszka extends Smieci {
    private double masa;
    private String zawartosc;

    public Puszka(RodzajOdpadu rodzaj, double masa, String zawartosc) {
        super(rodzaj);
        this.masa = masa;
        this.zawartosc = zawartosc;
    }

    @Override
    public String toString() {
        return "Puszka " + getRodzaj() + ", masa: " + masa + ", zawartosc: " + zawartosc;
    }
}
