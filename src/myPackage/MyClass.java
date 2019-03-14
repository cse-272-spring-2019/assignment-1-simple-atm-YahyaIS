
package myPackage;

import javafx.application.Application;
import javafx.stage.Stage;
import javaapplication1.ATM;
import javaapplication1.Deposit;
import javaapplication1.Login;
import javaapplication1.WithDraw;

public class MyClass extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Login login =new Login();
        login.setStage(stage);
        login.draw();
        ATM atm =new ATM();
        atm.setStage(stage);
        atm.draw();
        WithDraw withdraw = new WithDraw();
        withdraw.setStage(stage);
        withdraw.draw();
        Deposit deposit = new Deposit();
        deposit.setStage(stage);
        deposit.draw();
        login.setAtm(atm);
        atm.setDeposit(deposit);
        atm.setWithDraw(withdraw);
        atm.setLogin(login);
        withdraw.setAtm(atm);
        deposit.setAtm(atm);
        
        stage.setTitle("ATM Machine.");
        stage.setScene(login.getScene());
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
