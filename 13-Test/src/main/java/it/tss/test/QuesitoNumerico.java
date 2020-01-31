/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.test;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class QuesitoNumerico extends Quesito<Integer> {

    public QuesitoNumerico(String domanda, Integer esatta) {
        super(domanda, esatta);
    }

    @Override
    public int ask(Integer risposta) {
        this.fornita = risposta;
        return Objects.equals(esatta, risposta) ? 10 : 0;
    }

}
