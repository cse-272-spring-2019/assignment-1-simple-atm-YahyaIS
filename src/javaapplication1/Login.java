
package javaapplication1;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login {
        Scene scene;
        ATM atm;
        Stage stage;

    public Login() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    
        
    public void draw(){
        
        Label cardNumberLabel =new Label("Card Number:");
        TextField cardNumberField =new TextField();
        Button enterButton =new Button("Enter");
        Label ifErrorLabel =new Label();
        GridPane grid= new GridPane();
        grid.add(cardNumberLabel, 0, 0);
        grid.add(cardNumberField, 1, 0);
        grid.add(enterButton, 1, 1);
        grid.add(ifErrorLabel, 0, 1);
        cardNumberLabel.setFont(new Font("Verdana", 15));
        enterButton.setFont(new Font("Verdana", 16));
        cardNumberLabel.setPrefSize(110, 30);
        cardNumberField.setPrefSize(150, 30);
        enterButton.setPrefSize(150, 30);
        scene =new Scene(grid,450,250);
        enterButton.setOnAction((ActionEvent event) -> {
            String number =cardNumberField.getText();
            Validity validity =new Validity() ;
            if(validity.checkValidity(number)) {
                cardNumberField.setText("");
                stage.setScene(atm.getScene());
            } else 
            {
                ifErrorLabel.setText("Invalid card number!");
            }
        });

    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public Scene getScene() {
        return scene;
    }
    
}
