public class Pudelko extends Smieci {
    private double wymiary;
    private String kolor;

    public Pudelko(RodzajOdpadu rodzaj, double wymiary, String kolor) {
        super(rodzaj);
        this.wymiary = wymiary;
        this.kolor = kolor;
    }

    @Override
    public String toString() {
        return "Pudelko " + getRodzaj() + ", wymiary: " + wymiary + ", kolor: " + kolor;
    }
}
