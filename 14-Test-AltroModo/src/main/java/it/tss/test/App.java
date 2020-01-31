/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        List<Quesito> questionario = createQuestionario();
        System.out.println("punteggio totale: " + questionario.stream().mapToInt(q -> q.ask()).sum());
    }

    private static List<Quesito> createQuestionario() {
        List<Quesito> result = new ArrayList<>();
        List<String> options = new ArrayList<>();
        options.add("elicottero");
        options.add("marca di scarpe");
        options.add("un'isola");
        options.add("un'olio solare");
        result.add(new QuesitoSiNo("Oggi c'è il sole??", QuesitoSiNo.Risposta.SI));
        result.add(new QuesitoNumerico("2 + 2 quanto fa??", 4));
        result.add(new QuesitoMultiplo("Cos'è JAVA?", 2, options));
        return result;
    }

}
