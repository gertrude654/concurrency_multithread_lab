package day2.multithreading.sysnc;

public class Transaction implements Runnable {
    private BankAccount account;
    private double amount;
    private boolean deposit;

    public Transaction(BankAccount account, double amount, boolean deposit) {
        this.account = account;
        this.amount = amount;
        this.deposit = deposit;
    }

    @Override
    public void run() {
        if (deposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
