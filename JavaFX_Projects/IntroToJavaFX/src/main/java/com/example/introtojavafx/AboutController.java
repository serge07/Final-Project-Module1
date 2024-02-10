package com.example.introtojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import javafx.scene.control.*;
import  javafx.scene.text.*;
import java.util.ResourceBundle;


public class AboutController implements Initializable {


    private static final String message =
            "This JavaFX application provides a user-friendly interface for encrypting and\n" +
                    "decrypting files using either the AES or Caesar encryption cipher. Users can load a file\n" +
                    "from their local system, choose the encryption method, provide a key or shift value (for\n" +
                    "Caesar cipher), and then perform the encryption or decryption operation.\n" +
                    "================================================================= \n"+
                    "The Application uses hardcoded key for AES Cipher and shift key 3 for Caesar Cipher";


    @FXML
    private Label AboutLabel;

    @FXML
    private Button closeAbout;

    @FXML
    void onClose(ActionEvent event) {
         System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AboutLabel.setText(message);
    }



}


