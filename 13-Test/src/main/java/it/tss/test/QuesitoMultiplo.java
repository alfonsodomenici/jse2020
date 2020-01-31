/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.test;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class QuesitoMultiplo extends Quesito<Integer> {

    private final List<String> opzioni;
    
    public QuesitoMultiplo(String domanda, Integer esatta, List<String> opzioni) {
        super(domanda, esatta);
        this.opzioni = opzioni;
    }

    @Override
    public int ask(Integer risposta) {
        if(risposta<0 || risposta >= opzioni.size() ){
            throw new IllegalArgumentException("Risposta non valida");
        }
        this.fornita = risposta;
        return Objects.equals(esatta, risposta) ? 10 : 0;
    }

    @Override
    public String getDomanda() {
        StringBuilder result = new StringBuilder(domanda).append("\n");
        opzioni.forEach(v -> result.append(v).append("\n"));
        return result.toString();      
    }

    
}
