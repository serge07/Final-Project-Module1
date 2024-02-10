package com.example.introtojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EncryptorController implements Initializable {

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Button chooseFileButton;

    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private RadioButton onAES;

    @FXML
    private RadioButton onCaesar;


    @FXML
    private Label fileSelected;

    @FXML
    private ToggleGroup radioGroup;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Button EncryptButton;

    @FXML
    private Button DecryptButton;

    @FXML
    private Button clearPlainText;


    @FXML
    void onCloseMenuItem(ActionEvent event) {
       System.exit(0);// close the application
    }

    @FXML
    void onAboutMenuItem(ActionEvent event) throws Exception {
        // load About window from the fxml resource
        FXMLLoader fxmlLoader = new FXMLLoader(EncryptorApplication.class.getResource("About-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage(); //Stage object for the new window
        stage.setTitle("About");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);// Modality to prevent interaction with the parent  window whilst About window is open
        stage.show();


    }


    FileChooser fileChooser=new FileChooser();


    @FXML
    void onChooseFileButton(ActionEvent event) throws FileNotFoundException {

            getFile();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void onClearPlainText(ActionEvent event) {

        inputTextArea.setText("");
    }

    @FXML
    void onEncrypt(ActionEvent event) throws Exception {
        if(radioGroup.getSelectedToggle().equals(onAES)){
            outputTextArea.setText("");
            String plainTextData = inputTextArea.getText();
            String encryptedData = EncryptorAES.encrypt(plainTextData);
            outputTextArea.setText(encryptedData);
        }else {

            outputTextArea.setText("");
            String plainTextData = inputTextArea.getText();
            String encryptedData = EncryptorCaesar.encrypt(plainTextData,3);
            outputTextArea.setText(encryptedData);
        }

    }

    @FXML
    void onDecrypt(ActionEvent event) throws Exception{
      if ((radioGroup.getSelectedToggle().equals(onAES)) &&(inputTextArea.getText().isEmpty())){

          String cipheredTextData = outputTextArea.getText();
          String decryptedData = EncryptorAES.decrypt(cipheredTextData);
          inputTextArea.setText(decryptedData);

      }else if ((radioGroup.getSelectedToggle().equals(onCaesar)) &&(inputTextArea.getText().isEmpty())){
          String cipheredTextData = outputTextArea.getText();
          String decryptedData = EncryptorCaesar.decrypt(cipheredTextData,3);
          inputTextArea.setText(decryptedData);
      }else{
          Alert alert=new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Operation Error");
          alert.setContentText("Please clear first the plain text data!!!");
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
                     inputTextArea.appendText(loader.nextLine() + "\n");
                 }
             }catch(FileNotFoundException e){
                 e.printStackTrace();
             }
         }else {
            System.out.println(" the file invalid");

        }


    }


}
