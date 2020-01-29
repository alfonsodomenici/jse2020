/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author tss
 */
public class App {
    
    public static void main(String[] args) {
        try {
            
            URL url = new URL("http://www.google.it");
            URLConnection cn = url.openConnection();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(cn.getInputStream()));
            br.lines().forEach(System.out::println);
            br.close();
        } catch (IOException ex) {
            System.out.println(ex);
        } 
    }
}
