package com.kelvin.javafxspringboot.controller;

import com.kelvin.javafxspringboot.service.UserService;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleUiController  {

    private final HostServices hostServices;

    @FXML
    public Button btnLogin, btnRegister, btnSucessAdd;

    @FXML
    public AnchorPane anchor;

    @FXML
    public Text textUserExist;

    @FXML
    public TextField txtFielUsername, txtFielPassword;

    @FXML
    public Pane paneLogin, paneRegister;

    @FXML
    public TextField txtFieldFN, txtFieldLN, txtFielUsernameR, txtFielPasswordR;

    @FXML
    public Button btnSubmit, btnCancel;

    @FXML
    public Text textAlertR;

    @Autowired
    private UserService service;

    public SimpleUiController(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    public void initialize () {

    }

    public void authenticate(){
        if(txtFielUsername.getText().isEmpty() | txtFielPassword.getText().isEmpty()){
            textUserExist.setText("form is empty");
            textUserExist.setVisible(true);
        }else{
            service.authenticate(txtFielUsername.getText(), txtFielPassword.getText());
        }
    }

    public void btnRegister(){
        paneLogin.setVisible(false);
        paneRegister.setVisible(true);
        btnSucessAdd.setVisible(false);
    }
    public void btnCancel(){
        paneLogin.setVisible(true);
        paneRegister.setVisible(false);
        btnSucessAdd.setVisible(false);
        textAlertR.setVisible(false);
    }

    public void btnSubmit(){
        if(txtFieldFN.getText().isEmpty()
                | txtFieldLN.getText().isEmpty()
                | txtFielUsernameR.getText().isEmpty()
                | txtFielPasswordR.getText().isEmpty()){

            textAlertR.setText("form is empty");
            textAlertR.setVisible(true);

        }else{
            service.create(txtFieldFN.getText(), txtFieldLN.getText(), txtFielUsernameR.getText(), txtFielPasswordR.getText());
        }
    }

}
