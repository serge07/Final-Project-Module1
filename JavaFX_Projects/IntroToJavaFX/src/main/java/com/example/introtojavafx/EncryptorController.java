package com.example.introtojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EncryptorController implements Initializable {

    @FXML
    private Button chooseFileButton;

    @FXML
    private AnchorPane clearButton;

    @FXML
    private RadioButton decryption;

    @FXML
    private RadioButton encryption;

    @FXML
    private Label errorMessage;

    @FXML
    private Label fileSelected;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Label passwordLength;

    @FXML
    private ToggleGroup radioGroup;

    @FXML
    private TextArea inpuTextArea;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Button EncryptButton;

    @FXML
    private Button DecryptButton;

    FileChooser fileChooser=new FileChooser();


    @FXML
    void onChooseFileButton(ActionEvent event) throws FileNotFoundException {

            getFile();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onClear(ActionEvent event) {
       passwordInput.setText("");
    }

    @FXML
    void onEncrypt(ActionEvent event) throws Exception {
        if(radioGroup.getSelectedToggle().equals(encryption)) {
            outputTextArea.setText("");
            String plainTextData = inpuTextArea.getText();
            String encryptedData = Encryptor.encrypt(plainTextData);
            outputTextArea.setText(encryptedData);
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Operation Error");
            alert.setContentText("Make sure the Encryption is selected!!!");
            alert.showAndWait();
        }

    }

    @FXML
    void onDecrypt(ActionEvent event) throws Exception{
      if (radioGroup.getSelectedToggle().equals(decryption)) {
          String cipheredTextData = inpuTextArea.getText();
          String decryptedData = Encryptor.decrypt(cipheredTextData);
          inpuTextArea.setText(decryptedData);

      }else {
          Alert alert=new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Operation Error");
          alert.setContentText("Make sure the Decryption is selected!!!");
          alert.showAndWait();
      }
    }

    public void getFile() throws FileNotFoundException {
        //set the title
        fileChooser.setTitle("My File Chooser");

        //set the default directory for the display file dialog
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File file=fileChooser.showOpenDialog(null);
        //shows a new file open dialog
         if(file !=null) {
             //Returns the absolute path string
             fileSelected.setText(file.getAbsolutePath());
             try{
                 Scanner loader=new Scanner(file);
                 while (loader.hasNextLine()){
                     inpuTextArea.appendText(loader.nextLine() + "\n");
                 }
             }catch(FileNotFoundException e){
                 e.printStackTrace();
             }
         }else {
            System.out.println(" the file invalid");

        }
    }
}
