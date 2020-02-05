/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tss
 */
public class NewSongController implements Initializable {

    @FXML
    private TextField txtTitolo;
    @FXML
    private TextField txtArtista;
    @FXML
    private TextField txtAlbum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize newSong controller...");
    }

    public void onSave() {
        DbStore.saveNewSong(txtTitolo.getText(),txtArtista.getText(),txtAlbum.getText());
        clearFields();
    }

    private void clearFields() {
        txtTitolo.setText("");
        txtArtista.setText("");
        txtAlbum.setText("");
    }
}
