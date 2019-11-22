import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.awt.*;

public class BankAccountPane extends GridPane{
    private TextField username;
    private TextField password;
    private TextField amountDeposit;
    private TextField amountWithdraw;
    private Label result;
    private Button deposit;
    private Button withdraw;
    private Button signUp;
    private Button login;
    private double depositAmount;
    private double withdrawAmount;
    private String givenUsername;
    private String givenPassword;
    BankAccount bank;
    boolean loginTrue = false;
    boolean signUpTrue = false;

    public BankAccountPane(){
        Font font = new Font("Comic Sans MS",14);
        font.font("Comic Sans MS",14);
        Label inputUsername = new Label("Username");
        inputUsername.setFont(font);
        inputUsername.setStyle("-fx-background-color: green");
        GridPane.setHalignment(inputUsername,HPos.RIGHT);

        Label inputPassword = new Label("Pin");
        inputPassword.setFont(font);
        inputPassword.setStyle("-fx-background-color: red");
        GridPane.setHalignment(inputPassword,HPos.RIGHT);

        Label amountDepositT = new Label("Deposit");
        amountDepositT.setFont(font);
        amountDepositT.setStyle("-fx-background-color: yellow");
        GridPane.setHalignment(amountDepositT,HPos.RIGHT);

        Label amountWithdrawT = new Label("Withdraw");
        amountWithdrawT.setFont(font);
        amountWithdrawT.setStyle("-fx-background-color: LightSeaGreen");
        GridPane.setHalignment(amountWithdrawT,HPos.RIGHT);

        Label requirementPassword = new Label("4 chars");
        requirementPassword.setFont(font);
        requirementPassword.setStyle("-fx-background-color: CadetBlue ");
        GridPane.setHalignment(amountWithdrawT,HPos.RIGHT);

        result = new Label("---");
        result.setFont(font);
        result.setStyle("-fx-background-color: LawnGreen");
        GridPane.setHalignment(result, HPos.CENTER);

        username = new TextField();
        username.setFont(font);
        username.setPrefWidth(70);
        username.setStyle("-fx-background-color: magenta");
        username.setAlignment(Pos.CENTER);
        //username.setOnAction(this::processUsernameReturn);

        password = new TextField();
        password.setFont(font);
        password.setPrefWidth(70);
        password.setStyle("-fx-background-color: lime");
        password.setAlignment(Pos.CENTER);
        //password.setOnAction(this::processPasswordReturn);

        amountDeposit = new TextField();
        amountDeposit.setFont(font);
        amountDeposit.setPrefWidth(70);
        amountDeposit.setStyle("-fx-background-color: HotPink");
        amountDeposit.setAlignment(Pos.CENTER);
        //amountDeposit.setOnAction(this::processDepositReturn);

        amountWithdraw = new TextField();
        amountWithdraw.setFont(font);
        amountWithdraw.setPrefWidth(70);
        amountWithdraw.setStyle("-fx-background-color: DarkOrange");
        amountWithdraw.setAlignment(Pos.CENTER);
        //amountWithdraw.setOnAction(this::processWithdrawReturn);

        deposit = new Button("deposit");
        deposit.setStyle("-fx-background-color: Olive");
        deposit.setOnAction(this::processDepositPress);

        withdraw = new Button("withdraw");
        withdraw.setStyle("-fx-background-color: LightGreen");
        withdraw.setOnAction(this::processWithdrawPress);

        signUp = new Button("Sign Up");
        signUp.setStyle("-fx-background-color: Tan");
        signUp.setOnAction(this::processSignUpPress);

        login = new Button("Log In");
        login.setStyle("-fx-background-color: SandyBrown");
        login.setOnAction(this::processLoginPress);

        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: blue");

        add(result, 0, 0);
        add(signUp, 5, 5);
        add(inputUsername, 10, 0);
        add(username, 10,1);
        add(inputPassword, 11, 0);
        add(password, 11, 1);
        add(requirementPassword, 11, 2);
        add(amountDepositT, 10,6);
        add(amountDeposit, 10, 7);
        add(deposit, 10, 8);
        add(amountWithdrawT, 11,6);
        add(amountWithdraw, 11, 7);
        add(withdraw, 11, 8);
        add(login, 15, 5);
    }
    /*public void processUsernameReturn(ActionEvent event){
        givenUsername = username.getText();
        username.clear();
    }
    public void processPasswordReturn(ActionEvent event){
        givenPassword = password.getText();
        password.clear();
    }
    public void processDepositReturn(ActionEvent event){

    }
    public void processWithdrawReturn(ActionEvent event){

    }
    */
    public void processSignUpPress(ActionEvent event){
        if (password.getText().length() == 4 && !loginTrue && !signUpTrue) {
            givenPassword = password.getText();
            password.clear();
            result.setText("---");
            signUpTrue = true;
            givenUsername = username.getText();
            username.clear();
            bank = new BankAccount(givenUsername, givenPassword, 1000.00);
    }
        else if(signUpTrue){result.setText("already signed up");}
        else{result.setText("You need 4 characters");}

    }
    public void processDepositPress(ActionEvent event){
        double depositamt = Double.parseDouble(amountDeposit.getText());
        String pin = password.getText();
        if (depositamt >= 0 && pin.equals(bank.getPassword()) && loginTrue){
            if (depositamt > bank.getmoneyOut()){result.setText("You don't have enough money");}
            bank.deposit(depositamt);
            bank.intrest();
            result.setText("Your total in the account is "+ bank.getmoneyIn()+"\n" +
                    "total out: "+bank.getmoneyOut());
            password.clear();
            amountDeposit.clear();
        }
        else if (depositamt < 0){result.setText("Can't deposit a negative");}
        else if (loginTrue == false){result.setText("not Logged in");}
        else {result.setText("wrong Pin");}
    }
    public void processWithdrawPress(ActionEvent event){
        double withdrawamt = Double.parseDouble(amountWithdraw.getText());
        String pin = password.getText();
        if (withdrawamt >= 0 && pin.equals(bank.getPassword()) && loginTrue){
            if (withdrawamt > bank.getmoneyIn()){result.setText("You don't have enough money");}
            bank.withdraw(withdrawamt);
            bank.intrest();
            result.setText("Your total in the account is "+ bank.getmoneyIn()+"" +
                    "\ntotal out: "+bank.getmoneyOut());
            password.clear();
            amountWithdraw.clear();
        }
        else if (withdrawamt < 0){result.setText("Can't deposit a negative");}
        else if (loginTrue == false){result.setText("not Logged in");}
        else {result.setText("wrong Pin");}
    }
    public void processLoginPress(ActionEvent event){
        if (password.getText().equals(givenPassword) && username.getText().equals(givenUsername) && signUpTrue) {
            loginTrue = true;
            result.setText("You are logged in, current balance: "+ bank.getmoneyIn()+" Current out of account: "+bank.getmoneyOut());
            //password.clear();
        }
        else if (!signUpTrue){result.setText("Not signed up yet");}
        else if (password.getText().equals(givenPassword) || username.getText().equals(givenUsername)){result.setText("username or password incorrect");}

    }
}
