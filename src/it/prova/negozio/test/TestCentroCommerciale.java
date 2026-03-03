package it.prova.negozio.test;

import it.prova.negozio.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCentroCommerciale {

    public static void main(String[] args){


        // Inizio Test Alexander

        // Creazione del Centro Commerciale
        CentroCommerciale cc = new CentroCommerciale("RomaEst", "Via Collatina, Roma");

        // Creazione del Negozio e associazione al Centro
        Negozio negozioElettronica = new Negozio("Tech Store Srl", "IT123456789", cc);
        cc.getNegozi().add(negozioElettronica);

        // Creazione dei Lavoratori
        Boss boss = new Boss("Mario", "Rossi");
        PersonaleAmministrativo admin = new PersonaleAmministrativo("Luigi", "Verdi");
        Commesso commesso = new Commesso("Paolo", "Bianchi");

        // Aggiungiamo i lavoratori alla lista del negozio per passare il controllo contains()
        negozioElettronica.getLavoratori().add(boss);
        negozioElettronica.getLavoratori().add(admin);
        negozioElettronica.getLavoratori().add(commesso);

        // Impostiamo il negozio nel lavoratore per evitare il NullPointerException
        boss.setNegozio(negozioElettronica);
        admin.setNegozio(negozioElettronica);
        commesso.setNegozio(negozioElettronica);

        //  Creazione della Merce
        Item smartphone = new Item("SM01", "Smartphone 5G", 699);
        Item cuffie = new Item("CU02", "Cuffie Bluetooth", 149);
        Item laptop = new Item("LP03", "Laptop Gaming", 1299);

        System.out.println("TEST: Aggiunta degli Item: ");
        System.out.println("--- TEST AGGIUNTA MERCE ---");

        // Il Boss non può aggiungere merce (restituisce false)
        boolean esitoBoss = negozioElettronica.addToItems(boss, smartphone);
        System.out.println("Boss aggiunge smartphone: " + (esitoBoss ? "Successo" : "Fallito"));

        // L'Amministrativo può aggiungere merce
        boolean esitoAdmin = negozioElettronica.addToItems(admin, cuffie);
        System.out.println("Admin aggiunge cuffie: " + (esitoAdmin ? "Successo" : "Fallito"));

        // Il Commesso può aggiungere merce
        boolean esitoCommesso = negozioElettronica.addToItems(commesso, laptop);
        System.out.println("Commesso aggiunge laptop: " + (esitoCommesso ? "Successo" : "Fallito"));

        System.out.println("Merce attualmente in negozio: " + negozioElettronica.getMerce().size() + " articoli.");

        System.out.println("\nTEST: Rimozione degli Item");
        System.out.println("\n--- TEST RIMOZIONE MERCE ---");

        // Il Boss non può rimuovere merce
        boolean rimozioneBoss = negozioElettronica.removeFromItems(boss, cuffie);
        System.out.println("Boss rimuove cuffie: " + (rimozioneBoss ? "Successo" : "Fallito"));

        // L'Amministrativo non può rimuovere merce
        boolean rimozioneAdmin = negozioElettronica.removeFromItems(admin, cuffie);
        System.out.println("Admin rimuove cuffie: " + (rimozioneAdmin ? "Successo" : "Fallito"));

        // Il Commesso può rimuovere merce
        boolean rimozioneCommesso = negozioElettronica.removeFromItems(commesso, cuffie);
        System.out.println("Commesso rimuove cuffie: " + (rimozioneCommesso ? "Successo" : "Fallito"));

        System.out.println("Merce attualmente in negozio: " + negozioElettronica.getMerce().size() + " articoli.");

        // Fine Test Alexander

        // Inizio Test Pietro

        System.out.println("Centro commerciale esercizio");

        System.out.println("\n Creo due negozi diversi");
        Negozio negozioA = new Negozio("Negozio A", "AAA111");
        Negozio negozioB = new Negozio("Negozio B", "BBB222");

        System.out.println("\n Creo item");
        Item item1 = new Item("A001", "Smartphone", 500);
        Item item2 = new Item("A002", "Tablet", 300);
        Item item3 = new Item("A003", "Cuffie", 50);
        Item item4 = new Item("A004", "Mouse", 25);
        Item item5 = new Item("A005", "Tastiera", 40);
        Item item6 = new Item("A006", "Monitor", 180);
        Item item7 = new Item("A007", "Powerbank", 35);
        Item item8 = new Item("A008", "Caricatore", 20);

        System.out.println("\n Creo lavoratori");
        Commesso commessoA = new Commesso("Luca", "Bianchi");
        commessoA.setNegozio(negozioA); // commesso che appartiene al negozio A
        negozioA.getLavoratori().add(commessoA);

        Commesso commessoB = new Commesso("Marco", "Rossi");
        commessoB.setNegozio(negozioB); // commesso che appartiene al negozio B
        negozioB.getLavoratori().add(commessoB);

        Commesso commessoSenzaNegozio = new Commesso("Paolo", "Neri"); // negozio null

        Boss bossA = new Boss("Gianni", "Boss");
        bossA.setNegozio(negozioA); // boss che appartiene ad A
        negozioA.getLavoratori().add(bossA);

        PersonaleAmministrativo personaleAmministrativoA = new PersonaleAmministrativo("Sara", "Verdi");
        personaleAmministrativoA.setNegozio(negozioA); // personale amministrativo che appartiene ad A
        negozioA.getLavoratori().add(personaleAmministrativoA);

        // altri lavoratori (stesso stile di nomi)
        Commesso commessoA2 = new Commesso("Anna", "Gialli");
        commessoA2.setNegozio(negozioA); // altro commesso di A
        negozioA.getLavoratori().add(commessoA2);

        Boss bossB = new Boss("Claudio", "BossB");
        bossB.setNegozio(negozioB); // boss di B
        negozioB.getLavoratori().add(bossB);

        PersonaleAmministrativo personaleAmministrativoB = new PersonaleAmministrativo("Marta", "Blu");
        personaleAmministrativoB.setNegozio(negozioB); // admin di B
        negozioB.getLavoratori().add(personaleAmministrativoB);

        // =========================
        System.out.println("\nTEST 1: Commesso A aggiunge item1 su Negozio A (atteso: true)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Contiene commesso A " + negozioA.getLavoratori().contains(commessoA));
        System.out.println("Esito: " + negozioA.addToItems(commessoA, item1));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 2: Commesso A2 aggiunge item2 su Negozio A (atteso: true)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Esito: " + negozioA.addToItems(commessoA2, item2));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 3: personaleAmministrativoA aggiunge item3 su Negozio A (atteso: true)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Esito: " + negozioA.addToItems(personaleAmministrativoA, item3));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 4: Boss A prova ad aggiungere item4 su Negozio A (atteso: false)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Esito: " + negozioA.addToItems(bossA, item4));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 5: Commesso B (di Negozio B) prova ad aggiungere item5 su Negozio A (atteso: false - non appartiene)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Esito: " + negozioA.addToItems(commessoB, item5));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 6: Commesso senza negozio prova ad aggiungere item6 su Negozio A (atteso: false - negozio null)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Esito: " + negozioA.addToItems(commessoSenzaNegozio, item6));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 7: Commesso A rimuove item1 da Negozio A (atteso: true)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Esito: " + negozioA.removeFromItems(commessoA, item1));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 8: personaleAmministrativoA prova a rimuovere item3 da Negozio A (atteso: false - admin non può remove)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Esito: " + negozioA.removeFromItems(personaleAmministrativoA, item3));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 9: Commesso B prova a rimuovere item2 da Negozio A (atteso: false - non appartiene)");
        System.out.println("Item prima: " + negozioA.getMerce().size());
        System.out.println("Esito: " + negozioA.removeFromItems(commessoB, item2));
        System.out.println("Item dopo: " + negozioA.getMerce().size());
        System.out.println("Items Negozio A: " + negozioA.getMerce());

        // =========================
        System.out.println("\nTEST 10: Commesso B aggiunge item7 su Negozio B (atteso: true)");
        System.out.println("Item prima: " + negozioB.getMerce().size());
        System.out.println("Esito: " + negozioB.addToItems(commessoB, item7));
        System.out.println("Item dopo: " + negozioB.getMerce().size());
        System.out.println("Items Negozio B: " + negozioB.getMerce());

        // =========================
        System.out.println("\nTEST 11: Boss B prova ad aggiungere item8 su Negozio B (atteso: false)");
        System.out.println("Item prima: " + negozioB.getMerce().size());
        System.out.println("Esito: " + negozioB.addToItems(bossB, item8));
        System.out.println("Item dopo: " + negozioB.getMerce().size());
        System.out.println("Items Negozio B: " + negozioB.getMerce());

        // =========================
        System.out.println("\nTEST 12: personaleAmministrativoB aggiunge item4 su Negozio B (atteso: true)");
        System.out.println("Item prima: " + negozioB.getMerce().size());
        System.out.println("Esito: " + negozioB.addToItems(personaleAmministrativoB, item4));
        System.out.println("Item dopo: " + negozioB.getMerce().size());
        System.out.println("Items Negozio B: " + negozioB.getMerce());

        // =========================
        System.out.println("\nTEST 13: Commesso B rimuove item7 da Negozio B (atteso: true)");
        System.out.println("Item prima: " + negozioB.getMerce().size());
        System.out.println("Esito: " + negozioB.removeFromItems(commessoB, item7));
        System.out.println("Item dopo: " + negozioB.getMerce().size());
        System.out.println("Items Negozio B: " + negozioB.getMerce());

        // =========================
        System.out.println("\nTEST 14: Commesso A prova a rimuovere item4 da Negozio B (atteso: false - non appartiene)");
        System.out.println("Item prima: " + negozioB.getMerce().size());
        System.out.println("Esito: " + negozioB.removeFromItems(commessoA, item4));
        System.out.println("Item dopo: " + negozioB.getMerce().size());
        System.out.println("Items Negozio B: " + negozioB.getMerce());

        // =========================
        System.out.println("\n=== STATO FINALE ===");
        System.out.println("Items Negozio A: " + negozioA.getMerce());
        System.out.println("Items Negozio B: " + negozioB.getMerce());

        System.out.println("\n=== FINE TEST ===");




    }



}


