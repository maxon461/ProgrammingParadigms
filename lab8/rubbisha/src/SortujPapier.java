import java.util.ArrayList;
import java.util.List;

public class SortujPapier extends Sortownia {

    private List<Smieci> papiermetalizowany;

    public SortujPapier() {
        super();
        papiermetalizowany = new ArrayList<>();
    }

    public SortujPapier(List<Smieci> other) {

        super();
        papiermetalizowany = new ArrayList<>();
        dodajSmieci(other);
        sortujpapier();

    }

    public void sortujpapier() {
        for (int i = 0; i < papierList.size(); i++) {
            Smieci smiec = getPapiereEl(i);
            if (smiec instanceof Karton) {
                if (((Karton) smiec).isAluminium = true) {
                    papiermetalizowany.add(smiec);
                    papierList.remove(smiec);
                    i--;
                }
            }
        }
        System.out.println(papierList.toString());
        System.out.println(papiermetalizowany.toString());

    }

    public List<Smieci> getPapierList() {
        return papierList;
    }

    public List<Smieci> getPapiermetalizowany() {
        return papiermetalizowany;
    }

    public Smieci getPapiereEl(int i) {
        return papierList.get(i);
    }
}
