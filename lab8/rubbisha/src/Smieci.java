public abstract class Smieci {
    public enum RodzajOdpadu {
        METAL,
        SZKLO,
        PLASTIK,
        PAPIER
    }

    private RodzajOdpadu rodzaj;

    public Smieci(RodzajOdpadu rodzaj) {
        this.rodzaj = rodzaj;
    }

    public RodzajOdpadu getRodzaj() {
        return rodzaj;
    }

    public abstract String toString();
}
