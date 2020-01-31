/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Quesito> questionario = createQuestionario();
        questionario.forEach(q -> {
            System.out.println("--------------------------------------------");
            System.out.println(q.getDomanda());
            boolean error;
            do {
                try {
                    error = false;
                    Object risp = readRisposta(scanner, q);
                    System.out.println("hai risposto: " + risp);
                    System.out.println("punteggio -> " + q.ask(risp));
                } catch (Exception ex) {
                    System.err.println("risposta non accettata");
                    error = true;
                    scanner.nextLine();
                }
            } while (error && scanner.hasNext());

        });
    }

    private static List<Quesito> createQuestionario() {
        List<Quesito> result = new ArrayList<>();
        List<String> options = new ArrayList<>();
        options.add("elicottero");
        options.add("marca di scarpe");
        options.add("un'isola");
        options.add("un'olio solare");
        result.add(new QuesitoSiNo("Oggi c'è il sole??", Boolean.TRUE));
        result.add(new QuesitoNumerico("2 + 2 quanto fa??", 4));
        result.add(new QuesitoMultiplo("Cos'è JAVA?", 2, options));
        return result;
    }

    private static Object readRisposta(Scanner s, Quesito q) {
        if (q instanceof QuesitoNumerico || q instanceof QuesitoMultiplo) {
            return s.nextInt();
        } else {
            return s.nextBoolean();
        }
    }

}
