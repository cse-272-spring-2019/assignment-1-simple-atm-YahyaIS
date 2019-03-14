
package javaapplication1;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Deposit {
    Stage stage;
    Scene scene;
    ATM atm;
    String[] history;
    int index;
    int pointer;
    double change;
    double money;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    
    
    public void draw(){
        Label amountLabel =new Label("Deposit Amount:");
        Label inputLabel =new Label();
        Button submitButton =new Button("Submit");
        Button backButton =new Button("Back");
        Label comment =new Label();
        GridPane grid =new GridPane();
        grid.add(amountLabel,0,0);
        grid.add(inputLabel,6,0);
        grid.add(submitButton,0,1);
        grid.add(comment,1,1);
        grid.add(backButton,0,3);
        Button oneButton =new Button("1");
        Button twoButton =new Button("2");
        Button threeButton =new Button("3");
        Button fourButton =new Button("4");
        Button fiveButton =new Button("5");
        Button sixButton =new Button("6");
        Button sevenButton =new Button("7");
        Button eightButton =new Button("8");
        Button nineButton =new Button("9");
        Button zeroButton =new Button("0");
        Button backSpaceButton =new Button("<");
        grid.add(oneButton, 3, 3);
        grid.add(twoButton, 4, 3);
        grid.add(threeButton, 5, 3);
        grid.add(fourButton, 3, 4);
        grid.add(fiveButton, 4, 4);
        grid.add(sixButton, 5, 4);
        grid.add(sevenButton, 3, 5);
        grid.add(eightButton, 4, 5);
        grid.add(nineButton, 5, 5);
        grid.add(zeroButton, 4, 6);
        grid.add(backSpaceButton, 3, 6);
        
        scene =new Scene(grid,450,250);
        submitButton.setOnAction((ActionEvent event) -> {
            money =atm.getMoney();
            change =Double.parseDouble(inputLabel.getText());
            atm.setMoney(money+change);
            history = atm.getHistory();
            index =atm.getIndex();
            history[index]="Deposit : "+(change);
            if(index==4)
            {
                
                for(int i=0;i<index;i++)
                {
                history[i]=history[i+1];
                
                }
                index--;
            }
            atm.setIndex(++index);
            atm.setPointer(index);
            atm.setHistory(history);
            inputLabel.setText("");
            stage.setScene(atm.getScene());
            
        });
        backButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText("");
            stage.setScene(atm.getScene());
        });
        oneButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+1);
        });
        twoButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+2);
        });
        threeButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+3);
        });
        fourButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+4);
        });
        fiveButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+5);
        });
        sixButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+6);
        });
        sevenButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+7);
        });
        eightButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+8);
        });
        nineButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+9);
        });
        zeroButton.setOnAction((ActionEvent event) -> {
            inputLabel.setText(inputLabel.getText()+0);
        });
        backSpaceButton.setOnAction((ActionEvent event) -> {
            if(inputLabel.getText().length()>0)
            inputLabel.setText(inputLabel.getText().substring(0, inputLabel.getText().length()-1));
        });
    }
    
    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public Scene getScene() {
        return scene;
    }

    
    
}

    
    

