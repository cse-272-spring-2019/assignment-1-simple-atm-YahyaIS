
package javaapplication1;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ATM{
    String[]history =new String[5];
    int index;
    int pointer;
    Stage stage;
    double money;
    Login login;
    Scene scene;
    Validity validity ;
    Balance balance= new Balance();
    Deposit deposit;
    WithDraw withDraw;

    public ATM() {
        this.pointer = 0;
        this.index = 0;
        this.money = 0;
        
    }
    
    public double getMoney() {
        return money;
    }
    
    public void setMoney(double money) {
        this.money = money;
        
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String[] getHistory( ) {
        return history;
    }

    public void setHistory(String[] history) {
        this.history = history;
    }
    
    
    public void draw() {
        Button withDrawalButton =new Button("Withdrawal");
        Button depositButton =new Button("Deposit");
        Button balanceInquiryButton =new Button("Balance Inquiry");
        Button previousButton =new Button("Previous History");
        Button nextButton =new Button("Next History");
        Button logOutButton =new Button("Logout");
        Label label =new Label();
        GridPane grid =new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.add(withDrawalButton, 0, 0);
        grid.add(depositButton, 1, 0);
        grid.add(balanceInquiryButton, 2, 0);
        grid.add(previousButton, 0, 1);
        grid.add(nextButton, 1, 1);
        grid.addRow(3, label);
        grid.add(logOutButton, 0, 4);
        withDrawalButton.setPrefSize(120, 40);
        depositButton.setPrefSize(120, 40);
        balanceInquiryButton.setPrefSize(120, 40);
        previousButton.setPrefSize(120, 40);
        nextButton.setPrefSize(120, 40);
        logOutButton.setPrefSize(120, 40);
        label.setPrefHeight(60);
        withDrawalButton.setFont(new Font("Verdana", 14));
        depositButton.setFont(new Font("Verdana", 16));
        balanceInquiryButton.setFont(new Font("Verdana", 11));
        previousButton.setFont(new Font("Verdana", 11));
        nextButton.setFont(new Font("Verdana", 13));
        logOutButton.setFont(new Font("Verdana", 14));
        label.setFont(new Font(11));
        scene =new Scene(grid, 450, 250);
        withDrawalButton.setOnAction((ActionEvent event) -> {
            label.setText("");
            stage.setScene(withDraw.getScene());
        });
        depositButton.setOnAction((ActionEvent event) -> {
            label.setText("");
            stage.setScene(deposit.getScene());
            
        });
        balanceInquiryButton.setOnAction((ActionEvent event) -> {
            label.setText("Your balance is :"+money);
            history[index++]="Balance Inquiry : "+money;
            if(index==4)
            {
                
                for(int i=0;i<index;i++)
                {
                history[i]=history[i+1];
                
                }
                index--;
            }
            pointer=index;
        });
        previousButton.setOnAction((ActionEvent event) -> {
            if(pointer>0){
                
                pointer--;
                label.setText(history[pointer]);
            }
        });
        nextButton.setOnAction((ActionEvent event) -> {
            if(pointer<index-1)
            {
            pointer++;
            label.setText(history[pointer]);
            }
        });
        logOutButton.setOnAction((ActionEvent event) -> {
            stage.setScene(login.getScene());
        });
        
        
        
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public void setWithDraw(WithDraw withDraw) {
        this.withDraw = withDraw;
    }
    
    
    public Scene getScene(){
        return scene;
    }

    

    

    
}
