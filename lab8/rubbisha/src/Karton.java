public class Karton extends Smieci {
    private double wymiary;
    private boolean czyLamany;
    private boolean aluminium;
    public boolean isAluminium;

    

    public boolean isAluminium() {
        return aluminium;
    }

    public Karton(RodzajOdpadu rodzaj, double wymiary, boolean czyLamany, boolean aluminium) {
        super(rodzaj);
        this.wymiary = wymiary;
        this.czyLamany = czyLamany;
        this.aluminium = aluminium;
    }

    @Override
    public String toString() {
        return "Karton " + getRodzaj() + ", wymiary: " + wymiary + ", czy lamany: " + czyLamany + ", czy ma metal " + aluminium;
    }
}
