package it.prova.negozio.model;

public class PersonaleAmministrativo extends Lavoratore{

     public PersonaleAmministrativo(String nome, String cognome){
         super(nome, cognome);
     }

    public PersonaleAmministrativo(String nome, String cognome, Negozio negozio){
        super(nome, cognome);
        super.negozio = negozio;
    }

    @Override
    public boolean handleItemAdd(Item item) {
        this.getNegozio().getMerce().add(item);
        item.setNegozio(this.getNegozio());
        return true;
    }

    @Override
    public boolean handleItemRemove(Item item) {
        return false;
    }
}
