package com.tomasdelvechio.examples.letsplaytdd;

public class SavingsAccountYear {
    private int startingBalance = 0;
    private int interestRate = 0;

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear() {

    }

    public int startingBalance() {
        return startingBalance;
    }

    public int interestRate() {
        return interestRate;
    }

    public int endingBalance() {
        return startingBalance() + (startingBalance() * interestRate / 100);
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), this.interestRate);
    }
}
