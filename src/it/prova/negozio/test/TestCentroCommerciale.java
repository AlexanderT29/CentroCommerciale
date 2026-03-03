package it.prova.negozio.test;

import it.prova.negozio.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCentroCommerciale {

    public static void main(String[] args){


        // Inizio Test Alexander
        System.out.println("**********************************************");
        System.out.println("Test di Alexander (io)" );
        System.out.println();


        CentroCommerciale cc = new CentroCommerciale("RomaEst", "Via Collatina, Roma");


        Negozio negozioElettronica = new Negozio("Tech Store Srl", "IT123456789", cc);
        Negozio negozioTech = new Negozio("Tech Store", "IT11111", cc);
        Negozio negozioAbbigliamento = new Negozio("Fashion Boutique", "IT22222", cc);
        cc.getNegozi().add(negozioElettronica);
        cc.getNegozi().add(negozioTech);
        cc.getNegozi().add(negozioAbbigliamento);


        // Creazione dei Lavoratori
        Boss boss1 = new Boss("Mario", "Rossi");
        PersonaleAmministrativo admin = new PersonaleAmministrativo("Luigi", "Verdi");
        Commesso commesso1 = new Commesso("Paolo", "Bianchi");
        Boss bossTech = new Boss("Mario", "Rossi");
        Commesso commessoTech = new Commesso("Luigi", "Verdi");
        Commesso commessoFashion = new Commesso("Anna", "Bianchi");

        // Aggiungiamo i lavoratori alla lista del negozio per passare il controllo contains()
        negozioElettronica.getLavoratori().add(boss1);
        negozioElettronica.getLavoratori().add(admin);
        negozioElettronica.getLavoratori().add(commesso1);

        negozioTech.getLavoratori().add(bossTech);
        negozioTech.getLavoratori().add(commessoTech);
        bossTech.setNegozio(negozioTech);
        commessoTech.setNegozio(negozioTech);

        negozioAbbigliamento.getLavoratori().add(commessoFashion);
        commessoFashion.setNegozio(negozioAbbigliamento);

        // Impostiamo il negozio nel lavoratore per evitare il NullPointerException
        boss1.setNegozio(negozioElettronica);
        admin.setNegozio(negozioElettronica);
        commesso1.setNegozio(negozioElettronica);



        //  Creazione della Merce
        Item smartphone = new Item("SM01", "Smartphone 5G", 699);
        Item cuffie = new Item("CU02", "Cuffie Bluetooth", 149);
        Item laptop = new Item("LP03", "Laptop Gaming", 1299);
        Item pc = new Item("PC01", "Computer Portatile", 1000);
        Item mouse = new Item("MS01", "Mouse Wireless", 30);
        Item mouse2 = new Item("MS02", "Mouse Wireless", 35);
        Item maglietta = new Item("MG01", "T-Shirt Cotone", 20);

        System.out.println("TEST: Aggiunta degli Item: ");
        System.out.println("--- TEST AGGIUNTA MERCE ---");

        // Il Boss non può aggiungere merce (restituisce false)
        boolean esitoBoss = negozioElettronica.addToItems(boss1, smartphone);
        System.out.println("Boss aggiunge smartphone: Atteso: false, \nRisultato: " + esitoBoss);

        // L'Amministrativo può aggiungere merce
        boolean esitoAdmin = negozioElettronica.addToItems(admin, cuffie);
        System.out.println("Admin aggiunge cuffie: Atteso: true, \nRisultato: " + esitoAdmin);

        // Il Commesso può aggiungere merce
        boolean esitoCommesso = negozioElettronica.addToItems(commesso1, laptop);
        System.out.println("Commesso aggiunge laptop: Atteso: true, \nRisultato: " + esitoCommesso);

        // Il Boss non può aggiungere merce
        boolean testBossAdd = negozioTech.addToItems(bossTech, pc);
        System.out.println("Boss prova ad aggiungere PC: Atteso: false, \nRisultato: " + testBossAdd);

        // Il commesso può aggiungere merce
        boolean testCommessoAdd = negozioTech.addToItems(commessoTech, pc);
        System.out.println("Commesso Tech aggiunge PC: Atteso: true, \nRisultato: " + testCommessoAdd);

        // Il commesso aggiunge il mouse per la prima volta
        negozioTech.addToItems(commessoTech, mouse);
        System.out.println("Quantità merce dopo 1° inserimento Mouse: " + negozioTech.getMerce().size());

        // Il commesso aggiunge LO STESSO IDENTICO mouse una seconda volta
        negozioTech.addToItems(commessoTech, mouse);
        System.out.println("Quantità merce dopo 2° inserimento dello STESSO Mouse: " + negozioTech.getMerce().size());



        System.out.println("Merce attualmente in negozio: " + negozioElettronica.getMerce().size() + " articoli.");

        System.out.println("\nTEST: Rimozione degli Item");
        System.out.println("\n--- TEST RIMOZIONE MERCE ---");

        // Il Boss non può rimuovere merce
        boolean rimozioneBoss = negozioElettronica.removeFromItems(boss1, cuffie);
        System.out.println("Boss rimuove cuffie: Atteso: false, \nRisultato: " + rimozioneBoss );

        // L'Amministrativo non può rimuovere merce
        boolean rimozioneAdmin = negozioElettronica.removeFromItems(admin, cuffie);
        System.out.println("Admin rimuove cuffie: Atteso: false, \nRisultato: " + rimozioneAdmin );

        // Il Commesso può rimuovere merce
        boolean rimozioneCommesso = negozioElettronica.removeFromItems(commesso1, cuffie);
        System.out.println("Commesso rimuove cuffie: Atteso: true, \nRisultato: " + rimozioneCommesso);

        // Il commesso cerca di rimuovere un mouse che non è mai stato aggiunto
        boolean testRimozioneFantasma = negozioTech.removeFromItems(commessoTech, mouse2);
        System.out.println("Commesso Tech prova a rimuovere Mouse non presente: Atteso: false, \nRisultato: " + testRimozioneFantasma);

        System.out.println("Merce attualmente in negozio: " + negozioElettronica.getMerce().size() + " articoli.");

        // Fine Test Alexander
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Test di Pietro");
        System.out.println();

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

        // Fine Test Pietro


        // Inizio Test Tommaso

        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Inizio Test Tommaso");
        System.out.println();

        CentroCommerciale centroCommerciale = new CentroCommerciale();

        Negozio negozio = new Negozio("asdsad","srl");
        Lavoratore commesso = new Commesso("Alfredo", "Gigli", negozio);
        Lavoratore boss = new Boss("Mario", "Rossi", negozio);
        Lavoratore personaleAmministrativo = new PersonaleAmministrativo("Luigi", "Verdi", negozio);
        List<Lavoratore> lavoratori = new ArrayList<>();
        lavoratori.add(commesso);
        lavoratori.add(boss);
        lavoratori.add(personaleAmministrativo); // popolo la lista di lavoratori
        negozio.setLavoratori(lavoratori);// setto la lista al negozio
        Lavoratore commessoSec = new Commesso("Francesco", "Neri");


        Item cellulare = new Item("A32", "Uno smartphone performante", 300, negozio);
        Item matita = new Item("B56", "Una semplice matita", 1, negozio);
        Item lavatrice = new Item("T98", "Una comoda lavatrice", 100, negozio);

        /*List<Item> prodotti = new ArrayList<>();
        prodotti.add(cellulare);
        prodotti.add(matita);
        prodotti.add(lavatrice);*/
        System.out.println("Test della funzione addToItems()");
        System.out.println(negozio.addToItems(commesso, cellulare)); // mi aspetto true
        System.out.println(negozio.getMerce()); // controllo che il cellulare sia presente nella lista
        System.out.println(negozio.addToItems(boss, matita)); // mi aspetto false
        System.out.println(negozio.getMerce()); // controllo che solo il cellulare sia presente nella lista
        System.out.println(negozio.addToItems(personaleAmministrativo, matita)); // mi aspetto true
        System.out.println(negozio.getMerce()); // controllo che sia il cellulare che la matita siano presenti nella lista
        System.out.println(negozio.addToItems(commesso, cellulare)); // mi aspetto false perchè l'oggetto è già presente tra i prodotti
        System.out.println(negozio.getMerce()); // controllo che non venga aggiunto l'item
        System.out.println(negozio.addToItems(commessoSec, lavatrice)); //mi aspetto false perchè il commesso non è presente nel negozio
        System.out.println(negozio.getMerce()); // controllo che non venga aggiunto l'item
        System.out.println("FINE TEST \n");

        negozio.addToItems(commesso, lavatrice); // popolo la lista anche con l'ultimo oggetto in vista del prossimo test
        System.out.println("Test della funzione removeFromItems()");
        System.out.println(negozio.getMerce());
        System.out.println(negozio.removeFromItems(commesso, cellulare)); // mi aspetto true
        System.out.println(negozio.getMerce()); // controllo che il cellulare sia stato rimosso dalla lista
        System.out.println(negozio.removeFromItems(boss, matita)); // mi aspetto false
        System.out.println(negozio.getMerce()); // controllo che la lista non sia cambiata dalla stampa precedente
        System.out.println(negozio.removeFromItems(personaleAmministrativo, matita)); // mi aspetto false
        System.out.println(negozio.getMerce()); // controllo che la lista non sia cambiata dalla stampa precedente
        System.out.println(negozio.removeFromItems(commesso, cellulare)); // mi aspetto false perchè l'oggetto non è più presente tra i prodotti
        System.out.println(negozio.getMerce()); // controllo che la lista non sia cambiata dalla stampa precedente
        System.out.println(negozio.removeFromItems(commessoSec, lavatrice)); //mi aspetto false perchè il commesso non è presente nel negozio
        System.out.println(negozio.getMerce()); // controllo che la lista non sia cambiata dalla stampa precedente
        System.out.println("FINE TEST \n");




    }



}


