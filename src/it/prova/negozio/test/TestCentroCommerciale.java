package it.prova.negozio.test;

import it.prova.negozio.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCentroCommerciale {

    public static void main(String[] args){

        // Test 1 - classe CentroCommerciale
        CentroCommerciale centrotto = new CentroCommerciale("Aprilia 2", "Via A Roma");
        centrotto.setNegozi(creaListaNegozio(5, centrotto));
        Commesso mario = new Commesso("Mario", "Rossi");
        for(Negozio negozio: centrotto.getNegozi()){
            negozio.setLavoratori(creaListaLavoratori(6));
            assegnaNegozio(negozio);
        }
        for(Negozio negozio: centrotto.getNegozi()){
            negozio.getLavoratori().add(mario);
            mario.setNegozio(negozio);
            Item pane = new Item("01", "Pane", 10);
            System.out.println(negozio.addToItems(mario, pane));
            System.out.println(negozio.removeFromItems(mario, pane));
            break;
        }



    }

    public static List<Lavoratore> creaListaLavoratori(int quanti){
        List<Lavoratore> risultato = new ArrayList<>();
        String[] listaNomi = {"Mario", "Giulia", "Luca", "Anna", "Paolo", "Elena", "Marco", "Sofia", "Matteo", "Francesca"};
        String[] listaCognomi = {"Rossi", "Bianchi", "Verdi", "Neri", "Bruni", "Russo", "Gallo", "Costa", "Fontana", "Ferrari"};

        for(int i = 0; i < quanti; i++){
            Random r = new Random();
            int nome = r.nextInt(listaNomi.length);
            int cognome = r.nextInt(listaCognomi.length);
            if(r.nextInt(100) % 3 == 0){
                risultato.add(new Commesso(listaNomi[nome], listaCognomi[cognome]));
            } else if(r.nextInt(100) % 3 == 1){
                risultato.add(new PersonaleAmministrativo(listaNomi[nome], listaCognomi[cognome]));
            } else {
                risultato.add(new Boss(listaNomi[nome], listaCognomi[cognome]));
            }
        }
        return risultato;
    }

    public static List<Negozio> creaListaNegozio(int quanti, CentroCommerciale centro){
        List<Negozio> risultato = new ArrayList<>();
        String[] listaNegozi = {"Panificio", "Farmacia", "Libreria"};
        for(int i = 0; i < quanti; i++){
            Random r = new Random();
            int negozio = r.nextInt(listaNegozi.length);
            String iva = "" + r.nextInt(1_000_000_000, 2_000_000_000);
            risultato.add(new Negozio(listaNegozi[negozio], iva, centro));
        }
        return risultato;
    }

    public static void assegnaNegozio(Negozio negozio){
        for(Lavoratore lavoratore: negozio.getLavoratori()){
            lavoratore.setNegozio(negozio);
        }
    }

}


