package Entities;

public class Account {
    private Integer accountNumber;
    private String holder;
    private Double balance;
    private Double withdrawLim;

    public Account() {
    }

    public Account(Integer accountNumber, String holder, Double balance, Double withdrawLim) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLim = withdrawLim;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLim() {
        return withdrawLim;
    }

    public void setWithdrawLim(Double withdrawLim) {
        this.withdrawLim = withdrawLim;
    }

    public Double deposit(double value) {
        this.balance = balance + value;
        return balance;
    }
    public Double withdraw(double value) {
        this.balance = balance - value;
        return balance - value;
    }
}
