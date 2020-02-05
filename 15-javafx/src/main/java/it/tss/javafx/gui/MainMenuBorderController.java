/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author tss
 */
public class MainMenuBorderController implements Initializable {

    
    @FXML
    BorderPane borderPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void onExit(){
        System.exit(0);
    }
    
    public void onNewSong() throws IOException{
        Parent view = App.loadFXML("newSong");
        borderPane.setCenter(view);
    }
}
