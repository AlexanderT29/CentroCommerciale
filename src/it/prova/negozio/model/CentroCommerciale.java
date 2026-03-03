package it.prova.negozio.model;

import java.util.ArrayList;
import java.util.List;

public class CentroCommerciale {
    private String ragioneSociale;
    private String indirizzoEsteso;
    private List<Negozio> negozi = new ArrayList<>();

    public CentroCommerciale(){

    }

    public CentroCommerciale(String ragioneSociale, String indirizzoEsteso){
        this.ragioneSociale = ragioneSociale;
        this.indirizzoEsteso = indirizzoEsteso;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getIndirizzoEsteso() {
        return indirizzoEsteso;
    }

    public void setIndirizzoEsteso(String indirizzoEsteso) {
        this.indirizzoEsteso = indirizzoEsteso;
    }

    public List<Negozio> getNegozi() {
        return negozi;
    }

    public void setNegozi(List<Negozio> negozi) {
        this.negozi = negozi;
    }

}
