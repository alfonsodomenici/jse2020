/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javaio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("lettura stream di bytes");
        //Leggo come stream di bytes
        FileInputStream in = new FileInputStream("/home/tss/testo.txt");
        int data;
        while ((data = in.read()) != -1) {
            System.out.println(data);
        }
        in.close();

        
        
        //Leggo come stream di caratteri
        System.out.println("lettura stream di caratteri");
        FileReader rd = new FileReader("/home/tss/testo.txt");
        while((data = rd.read()) != -1){
            System.out.println(data);
        }
        rd.close();
        
        //Leggo come stream di caratteri bufferizzati
        System.out.println("lettura stream di caratteri a righe");
        BufferedReader br = new BufferedReader(new FileReader("/home/tss/testo.txt"));
        br.mark(0);
        String riga;
        while((riga = br.readLine()) != null){
            System.out.println(riga);
        }
        br.close();
        
        //Cerca file
        br = new BufferedReader(new FileReader("/home/tss/testo.txt"));
        
        System.out.println("cerca la parola file");
        br.lines()
                .filter(v -> v.contains("file"))
                .map(v->v.toUpperCase())
                .forEach(System.out::println);
        
        br.close();
        
        //Scrive l'input da tastiera
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new FileOutputStream("/home/tss/echo.txt"));
        String line;
        while(!(line = scanner.nextLine()).equals("fine")){
            pw.println(line);
        }
        pw.close();
        
        duplicaFile1("/home/tss/testo.txt", "/home/tss/testo(copia).txt");
    }

    private static void duplicaFile3(String src, String dest) {

        try(FileInputStream in = new FileInputStream(src);
            FileOutputStream out = new FileOutputStream(dest)) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        } 
    }
    
    private static void duplicaFile2(String src, String dest) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException ex) {
                System.out.println("Errore nella chiusura dei files");
            }
        }
    }

    private static void duplicaFile1(String src, String dest) {
        try {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
            out.close();
            in.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
