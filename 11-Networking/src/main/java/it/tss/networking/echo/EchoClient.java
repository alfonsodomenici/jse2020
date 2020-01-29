/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.networking.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class EchoClient {

    public static void main(String[] args) {
        try ( Socket socket = new Socket("localhost", 10000);) {

            //Stream in lettura dal server
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            //Stream in scrittura
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            
            //leggo input dell'utente
            Scanner input = new Scanner(System.in);
            System.out.println("Scrivi la frase da inviare al server");
            String line = input.nextLine();
            
            //invio al server la frase
            pw.println(line);
            pw.flush();
            
            //leggo e stampo la risposta
            String echo = br.readLine();
            System.out.println(echo);
                    
        } catch (IOException ex) {
            Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
