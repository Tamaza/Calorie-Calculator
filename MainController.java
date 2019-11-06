package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    int calories=0;

    int index=0;
    double maintenance;
    String age;
    String gender;
    String height;
    String weight;
    String activity;

    @FXML
    Button button1;
    @FXML
    Button button3;
    @FXML
    Button button2;
    @FXML
    TextField ageText;
    @FXML
    CheckBox cBox1;
    @FXML
    CheckBox cBox2;
    @FXML
    TextField heightText;
    @FXML
    TextField weightText;
    @FXML
    ComboBox comboBox1;

    private static ObservableList<String> tableLocationList = FXCollections.observableArrayList();

    @FXML
    public void ageOnAction(){
        try {
            age = ageText.getText();
            Integer.parseInt(age);
        } catch (NumberFormatException e){
            ageText.setText("Wrong Number format");
        }
    }
    @FXML
    public void genderOnAction(){
        if(cBox1.isSelected()){
            gender = "Male";
        }
        else {
            gender = "Female";
        }
    }

    @FXML
    public  void heightOnAction(){
        try {
            height = heightText.getText();
            Integer.parseInt(height);
        } catch (NumberFormatException e){
           heightText.setText("Wrong Number format");
        }

    }
    @FXML
    public void weightOnAction(){
        try {
            weight = weightText.getText();
            Integer.parseInt(weight);
        } catch (NumberFormatException e){
           weightText.setText("Wrong Number format");
        }

    }

    @FXML
    public void activityOnAction(){
        activity = comboBox1.getSelectionModel().getSelectedItem().toString();
        button3.setDisable(false);
        if(activity=="Sedentary: Little or no exercise"){
        calories=0;
        }
        if(activity=="Light: Exercise 1-3 times/week"){
          calories= 200;
        }
        if(activity=="Moderate: Exercise 4-5 times/week"){
            calories=400;
        }
        if(activity=="Active: Daily exercise or intense exercise 3-4 times/week"){
            calories = 500;
        }
        if(activity=="Very Active: Intense exercise 5-6 times/week"){
           calories=700;
        }
        if(activity=="Very Active: Very intense exercise daily or physical job"){
            calories=800;
        }


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<String> nodeList = new ArrayList<String>();
        nodeList.add("Sedentary: Little or no exercise");
        nodeList.add("Light: Exercise 1-3 times/week");
        nodeList.add("Moderate: Exercise 4-5 times/week");
        nodeList.add("Active: Daily exercise or intense exercise 3-4 times/week");
        nodeList.add("Very Active: Intense exercise 5-6 times/week");
        nodeList.add("Very Active: Very intense exercise daily or physical job");

        tableLocationList.addAll(nodeList);
        comboBox1.setItems(tableLocationList);

        button3.setDisable(true);


    }

    public void usOnAction(ActionEvent event) {
        heightText.setPromptText("Inches");
        weightText.setPromptText("Lb");
    }

    public void metersOnAction(ActionEvent event) {
        heightText.setPromptText("CM");
        weightText.setPromptText("KG");
    }

    public  void formula(){
        System.out.println("formula start" );
        if(index==1 && gender =="Male"){
            int w = Integer.parseInt(weight);
            int h = Integer.parseInt(height);
            int a = Integer.parseInt((age));
            maintenance = (10*w + 6.25*h -5*a+5)+calories;
        }
        if(index==1 && gender =="Female"){
            int w = Integer.parseInt(weight);
            int h = Integer.parseInt(height);
            int a = Integer.parseInt((age));
            maintenance = (10*w + 6.25*h  -5*a-161)+calories;
            System.out.println(w+h+a+maintenance);
        }
        if(index==0 && gender =="Male"){
            double w = Integer.parseInt(weight)*0.45;
            double h = Integer.parseInt(height)*2.54;
            int a = Integer.parseInt((age));
            maintenance = (10*w + 6.25*h  -5*a+5)+calories;
        }

        if(index==0 && gender =="Female"){
            double w = Integer.parseInt(weight)*0.45;
            double h = Integer.parseInt(height)*2.54;
            int a = Integer.parseInt((age));
            maintenance = (10*w + 6.25*h  -5*a-161)+calories;
        }

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
              index =1;

            }
        });

       button2. setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {

              index =0;

            }
        });

    }

    public void calcOnAction(ActionEvent event) {
        ageOnAction();
        genderOnAction();
        heightOnAction();
        weightOnAction();
        activityOnAction();
        formula();
        System.out.println(weight + gender + height+ activity+ maintenance+calories);
        button3.setText("Maintenance calories: " + maintenance);



    }
}
