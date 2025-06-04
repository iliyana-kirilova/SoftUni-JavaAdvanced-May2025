package Week6_DefiningClasses.BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.2;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    BankAccount(){
        this.id = bankAccountCount++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    static void setInterestRate (double interest){
        BankAccount.interestRate = interest;
    }

    void deposit (double amount){
        balance+=amount;
    }

    double getInterestRate (int years){
        return BankAccount.interestRate * years * this.balance;
    }
}
