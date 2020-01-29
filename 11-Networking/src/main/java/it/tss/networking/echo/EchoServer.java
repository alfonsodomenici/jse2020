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

/**
 *
 * @author tss
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(10000);

        System.out.println("---------- Echo server start ----------------------");

        while (true) {
            try ( Socket clientSocket = serverSocket.accept()) {
                //Stream in lettura dal cliente
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream())
                );
                //Stream in scrittura sul client
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());

                //leggo frase dal client
                String line;
                line = br.readLine();

                System.out.println("ricevuta la frase: " + line);

                //invio echo al client 
                pw.println("ECHO..... " + line);

                pw.flush();
            }
        }
    }
}
