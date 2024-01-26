import java.util.ArrayList;
import java.util.List;

public class Sortownia {
    private List<Odpad> metalList;
    private List<Odpad> szkloList;
    private List<Odpad> plastikList;
    private List<Odpad> papierList;

    public Sortownia() {
        this.metalList = new ArrayList<>();
        this.szkloList = new ArrayList<>();
        this.plastikList = new ArrayList<>();
        this.papierList = new ArrayList<>();
    }

    public void dodajSmieci(List<Odpad> smieciList) {
        for (Odpad smiec : smieciList) {
            sortujSmiec(smiec);
        }
    }

    private void sortujSmiec(Odpad smiec) {
        switch (smiec.getRodzaj()) {
            case METAL:
                metalList.add(smiec);
                break;
            case SZKLO:
                szkloList.add(smiec);
                break;
            case PLASTIK:
                plastikList.add(smiec);
                break;
            case PAPIER:
                papierList.add(smiec);
                break;
            default:
               
                break;
        }
    }

    public List<Odpad> getMetalList() {
        return metalList;
    }

    public List<Odpad> getSzkloList() {
        return szkloList;
    }

    public List<Odpad> getPlastikList() {
        return plastikList;
    }

    public List<Odpad> getPapierList() {
        return papierList;
    }
}
