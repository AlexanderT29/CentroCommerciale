package it.prova.negozio.model;

public class Boss extends Lavoratore{

    public Boss(String nome, String cognome){
        super(nome, cognome);
    }

    public Boss(String nome, String cognome, Negozio negozio){
        super(nome, cognome);
        super.negozio = negozio;
    }

    @Override
    public boolean handleItemAdd(Item item) {
        return false;
    }

    @Override
    public boolean handleItemRemove(Item item) {
        return false;
    }
}
