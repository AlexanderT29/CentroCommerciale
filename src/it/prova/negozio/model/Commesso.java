package it.prova.negozio.model;

public class Commesso extends Lavoratore{

    public Commesso(String nome, String cognome){
        super(nome, cognome);
    }

    @Override
    public boolean handleItemAdd(Item item) {
        this.getNegozio().getMerce().add(item);
        item.setNegozio(this.getNegozio());
        return true;
    }

    @Override
    public boolean handleItemRemove(Item item) {
        if(!this.getNegozio().getMerce().contains(item)){
            return false;
        }
        this.getNegozio().getMerce().remove(item);
        return true;
    }
}
