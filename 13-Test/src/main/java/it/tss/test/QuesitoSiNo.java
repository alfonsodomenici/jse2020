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
public class QuesitoSiNo extends Quesito<Boolean> {

    public QuesitoSiNo(String domanda, Boolean esatta){
        super(domanda, esatta);
    }
    
    @Override
    public int ask(Boolean risposta) {
        this.fornita = risposta;
        return Objects.equals(esatta, risposta) ? 10 : 0;
    }

}
