/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.test;

/**
 *
 * @author tss
 */
public class QuesitoSiNo extends Quesito<QuesitoSiNo.Risposta> {

    public static enum Risposta {
        SI, NO
    }

    public QuesitoSiNo(String domanda, QuesitoSiNo.Risposta esatta) {
        super(domanda, esatta);
    }

    @Override
    public int ask() {
        System.out.println("--------------------------------------------");
        System.out.println(getDomanda());
        int punteggio = 0;
        boolean error;
        do {
            try {
                error = false;
                String risp = readRisposta(scanner, this).toString();
                System.out.println("hai risposto: " + risp);
                punteggio = Risposta.valueOf(risp) == esatta ? 10 : 0;
                System.out.println("punteggio -> " + punteggio);
            } catch (Exception ex) {
                System.err.println("risposta non accettata");
                error = true;
                scanner.nextLine();
            }
        } while (error);
        return punteggio;
    }

}
