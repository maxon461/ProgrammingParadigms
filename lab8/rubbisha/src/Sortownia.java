import java.util.ArrayList;
import java.util.List;

public class Sortownia {
    private List<Smieci> metalList;
    private List<Smieci> szkloList;
    private List<Smieci> plastikList;
    protected List<Smieci> papierList;

    public Sortownia() {
        this.metalList = new ArrayList<>();
        this.szkloList = new ArrayList<>();
        this.plastikList = new ArrayList<>();
        this.papierList = new ArrayList<>();
        
    }

    public void dodajSmieci(List<Smieci> smieciList) {
        for (Smieci smiec : smieciList) {
            sortujSmiec(smiec);
            // sortujpapier();
        }
    }

    private void sortujSmiec(Smieci smiec){ 
    
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


    public Smieci getPapiereEl(int i){
        return papierList.get(i);
    }

    public List<Smieci> getMetalList() {
        return metalList;
    }

    public List<Smieci> getSzkloList() {
        return szkloList;
    }

    public List<Smieci> getPlastikList() {
        return plastikList;
    }

    public List<Smieci> getPapierList() {
        return papierList;
    }
}
