package com.engim.verificapratica;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private static Sorteggio sorteggio = new Sorteggio();

    //es1
    @GetMapping(value = "/add")
    public void aggiungiSquadra(@RequestParam(value = "nome")String nome,@RequestParam(value = "nazione")String nazione){
        sorteggio.aggiungi(nome, nazione);
    }

    //es2

    @GetMapping(value = "/listaSquadre")
    public List<Squadra> listaSquadre(@RequestParam(value = "nazione")String nazione){
        List<Squadra> squadre = new ArrayList<>();
        List<Squadra> allSquadre = sorteggio.getSquadre();

        for (Squadra squadra : allSquadre){
            if (squadra.getNazione().equals(nazione))
                squadre.add(squadra);
        }
        return squadre;
    }

    //es 3

    @GetMapping(value = "/sorteggia")
    public List<Squadra> sorteggio2Squadre(){

        List<Squadra> squadreSorteggiate = new ArrayList<>();

        Squadra squadra1 = sorteggio.next();
        Squadra squadra2 = sorteggio.next();

        while(squadra1.getNazione().equals(squadra2.getNazione())){
            squadra2 = sorteggio.next();
        }

        squadreSorteggiate.add(squadra1);
        squadreSorteggiate.add(squadra2);

        return squadreSorteggiate;
    }

    //es 4
        @GetMapping(value= "/getPartite")
        public void partite(){
        sorteggio.sorteggiaPartite();
        }


    /*
     * ES 1: get ("/add?nome=n&nazione=m") che aggiunge al sorteggio una squadra con nome n e nazione m (utilizzare
     * la classe Sorteggio) - 15 p
     *
     * ES 2: get ("/listaSquadre?nazione=n") che restituisce la lista delle squadre di nazione n - 20 p
     *
     * ES 3: get ("/sorteggia") che restituisce 2 squadre di nazioni diverse (utilizzare la classe Sorteggio, il metodo
     * next. Consiglio: dopo aver sorteggiato la prima, continuare a sorteggiare finché la seconda
     * non è di una nazione diversa) - 20 p
     *
     * ES 4: implementare il sorteggio delle squadre di una fase finale di un torneo a eliminazione diretta.
     * Creare il metodo sorteggiaPartite che:
     * - controlla se il numero di squadre aggiunte è una potenza di 2. Se non lo è lancia una RuntimeException.
     * - Finché ci sono squadre non sorteggiate: sorteggia 2 squadre e le inserisce in un oggetto della classe Partita (da creare)
     * - restituisce la lista di Partite.
     * creare get ("/getPartite") che restituisce la lista appena creata - 30 p
     * */

}
