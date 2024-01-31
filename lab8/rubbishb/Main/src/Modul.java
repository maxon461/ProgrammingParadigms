import java.util.ArrayList;
import java.util.List;

public class Modul extends Sortownia {
    public List<Odpad> papiermet = new ArrayList<>();

    Modul(List<Odpad> other) {
        super();
        dodajSmieci(other);
        sortPapier();
    }

    public List<Odpad> getPapiermet() {
        return papiermet;
    }

    private void sortPapier() {
        List<Odpad> list = this.getPapierList();
        for (int i = 0; i < getPapierList().size(); i++) {
            Odpad curr = getPapierList().get(i);
            if (curr.czyMetal == true) {
                papiermet.add(curr);
                getPapierList().remove(curr);
                i--;

            }
        }
    }

}
