/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.networking;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App1 {

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest rq = HttpRequest.newBuilder(new URI("http://www.google.it"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(rq, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("---------------------------- HEADERS ---------------------------------");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            response.headers().map().keySet().forEach(v
                    -> System.out.println(v + "->" + response.headers().allValues(v)));
        } catch (URISyntaxException ex) {
            System.out.println(ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
