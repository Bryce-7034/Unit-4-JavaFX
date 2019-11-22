import java.text.DecimalFormat;
public class BankAccount{
  private double moneyIn;
  private double moneyOut;
  private String accountUsername;
  private String accountPassword;

  private final double INTREST = 1.013;

  DecimalFormat fmt = new DecimalFormat("0.00");
  /*
  creates a new account
  */
  public BankAccount(String newUsername, String newPassword, double startingMoney){
    accountUsername = newUsername;
    accountPassword = newPassword;
    moneyIn = ((int)(startingMoney*100))/100.0;;
  }


  public void setmoneyOut(double setMoney){
    moneyOut = setMoney;
  }
  public double getmoneyOut(){
    return ((int)(moneyOut*100))/100.0;
  }
  public double getmoneyIn(){
    return ((int)(moneyIn*100))/100.0;
  }
  public String getUsername(){
    return accountUsername;
  }
  public String getPassword(){
    return accountPassword;
  }

  public void resetPassword(String newPassword){
    accountPassword = newPassword;
  }
  public void deposit(double addedAmt){
    if (addedAmt <= moneyOut){
      moneyIn = moneyIn + addedAmt;
      moneyOut = moneyOut - addedAmt;
    } else{
      System.out.println("You don't have enough money");
      moneyIn = moneyIn + moneyOut;
      moneyOut = 0;
    }
  }
  public void withdraw(double withdrawnAmt){
    if (withdrawnAmt <= moneyIn){
      moneyIn = moneyIn - withdrawnAmt;
      moneyOut = moneyOut + withdrawnAmt;
    }else {
      System.out.println("You don't have the money");
      moneyOut = moneyOut + moneyIn;
      moneyIn = 0;
    }
  }
  public void intrest(){
    moneyIn = moneyIn * INTREST;
  }
  public void hacked(){
    moneyIn = 0;
  }
  public String toString(){
    String result = "";
    result += "Money Withdrawn: "+ fmt.format(moneyOut)+"\n";
    result += "Money Deposited: "+ fmt.format(moneyIn)+"\n";
    result += "Username: "+ accountUsername+"\n";
    return result;
  }
}
