package it.prova.negozio.model;

import java.util.ArrayList;
import java.util.List;

public class Negozio {

    private String ragioneSociale;
    private String partitaIva;
    private CentroCommerciale centroCommerciale;
    private List<Item> merce = new ArrayList<>();
    private List<Lavoratore> lavoratori = new ArrayList<>();

    public Negozio(String ragioneSociale, String partitaIva, CentroCommerciale centroCommerciale){
        this.centroCommerciale = centroCommerciale;
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
    }

    public Negozio(String ragioneSociale, String partitaIva){
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public CentroCommerciale getCentroCommerciale() {
        return centroCommerciale;
    }

    public void setCentroCommerciale(CentroCommerciale centroCommerciale) {
        this.centroCommerciale = centroCommerciale;
    }

    public List<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    public void setLavoratori(List<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }

    public List<Item> getMerce() {
        return merce;
    }

    public void setMerce(List<Item> merce) {
        this.merce = merce;
    }

    public boolean addToItems(Lavoratore lavoratore, Item item){
        if(!this.getLavoratori().contains(lavoratore) || this.getMerce().contains(item)){
            return false;
        }
        return lavoratore.handleItemAdd(item);
    }

    public boolean removeFromItems(Lavoratore lavoratore, Item item){
        if(!this.getLavoratori().contains(lavoratore)){
            return false;
        }
        return lavoratore.handleItemRemove(item);
    }
}
