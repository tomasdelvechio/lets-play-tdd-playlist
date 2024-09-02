package com.tomasdelvechio.examples.letsplaytdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountYearTest {
    @Test
    public void startingBalanceMatchesConstructorTest() {
        assertEquals(10000, newAccount().startingBalance());
    }

    @Test
    public void interestRateMatchesConstructorTest() {
        assertEquals(10, newAccount().interestRate());
    }

    @Test
    public void endingBalanceAppliesInterestRateTest() {
        assertEquals(11000, newAccount().endingBalance());
    }

    @Test
    public void nextYearsStartingBalanceEqualThisYearsEndingBalanceTest() {
        SavingsAccountYear thisYearAccount = newAccount();
        assertEquals(thisYearAccount.endingBalance(), thisYearAccount.nextYear().startingBalance());
    }

    @Test
    public void nextYearInterestRateEqualsThisYearsInterestRateTest() {
        SavingsAccountYear thisYearAccount = newAccount();
        assertEquals(thisYearAccount.interestRate(), thisYearAccount.nextYear().interestRate());
    }

    @Test
    public void withdrawingFundsOccursAtTheBeginningOfTheYearTest() {
        SavingsAccountYear thisYearAccount = newAccount();
        thisYearAccount.withdraw(1000);
        assertEquals(9900, thisYearAccount.endingBalance());
    }

    @Test
    public void withdrawingMoreThanPrincipalIncursCapitalGainsTaxTest() {
        SavingsAccountYear thisYearAccount = new SavingsAccountYear(10000, 7000, 10);
        thisYearAccount.withdraw(3000);
        assertEquals(7700, thisYearAccount.endingBalance());
        thisYearAccount.withdraw(5000);
        assertEquals(2000 + 200 - 1250, thisYearAccount.endingBalance());
    }

    private static SavingsAccountYear newAccount() {
        return new SavingsAccountYear(10000, 10);
    }
}
