/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.test;

import java.util.Scanner;

/**
 *
 * @author tss
 * @param <T>
 */
public abstract class Quesito<T> {

    protected static Scanner scanner;
    protected final String domanda;
    protected final T esatta;
    protected T fornita;

    public Quesito(String domanda, T rispostaEsatta) {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        this.domanda = domanda;
        this.esatta = rispostaEsatta;
    }

    public String getDomanda() {
        return domanda;
    }

    protected Object readRisposta(Scanner s, Quesito q) {
        if (q instanceof QuesitoNumerico || q instanceof QuesitoMultiplo) {
            return s.nextInt();
        } else {
            return s.nextLine();
        }
    }

    public abstract int ask();
}
