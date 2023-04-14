package Entities;

import Execption.BusinessException;

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

    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) {
        validateWithdraw(value);
        balance -= value;
    }

    private void validateWithdraw(double amount) {
        if (amount > getWithdrawLim()) {
             throw new BusinessException("Withdraw error: the requested amount exceed withdraw limit.");
        }
        if (getBalance() < amount) {
            throw new BusinessException("Withdraw Error: insufficient amount in your account ");
        }
    }
}
