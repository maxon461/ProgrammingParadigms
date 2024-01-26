public class Karton extends Smieci {
    private double wymiary;
    private boolean czyLamany;

    public Karton(RodzajOdpadu rodzaj, double wymiary, boolean czyLamany) {
        super(rodzaj);
        this.wymiary = wymiary;
        this.czyLamany = czyLamany;
    }

    @Override
    public String toString() {
        return "Karton " + getRodzaj() + ", wymiary: " + wymiary + ", czy lamany: " + czyLamany;
    }
}
