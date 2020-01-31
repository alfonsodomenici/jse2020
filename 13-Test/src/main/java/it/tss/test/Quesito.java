/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.test;

/**
 *
 * @author tss
 * @param <T>
 */
public abstract class Quesito<T> {

    protected final String domanda;
    protected final T esatta;
    protected T fornita;

    public Quesito(String domanda, T rispostaEsatta) {
        this.domanda = domanda;
        this.esatta = rispostaEsatta;
    }

    public String getDomanda() {
        return domanda;
    }

    public abstract int ask(T risposta);
}
