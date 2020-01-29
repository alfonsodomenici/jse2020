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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class EchoServerMultiThread {

    public static void main(String[] args) {

        try {
            System.out.println("---------- Echo server start ----------------------");
            
            ServerSocket serverSocket = new ServerSocket(10000);

            while(true){
                Socket socket = serverSocket.accept();
                new Thread(new EchoThread(socket)).start();
            }
            

        } catch (IOException ex) {
            Logger.getLogger(EchoServerMultiThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class EchoThread implements Runnable {

    final Socket socket;

    public EchoThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader br;
        try (socket) {
            br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            //eseguo echo
            String line;

            //leggo input
            line = br.readLine();

            System.out.println("ricevuta la frase: " + line);

            //invio risposta
            pw.println("ECHO..... " + line);
            pw.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(EchoThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
