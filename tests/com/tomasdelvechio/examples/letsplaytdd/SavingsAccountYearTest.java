package com.tomasdelvechio.examples.letsplaytdd;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountYearTest {
    @Test
    public void startingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        assertEquals(10000, account.startingBalance());
    }

    @Test
    public void endingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        assertEquals(11000, account.endingBalance());
    }

    @Test
    public void nextYearsStartingBalanceShouldEqualThisYearsEndingBalance() {
        SavingsAccountYear thisYearAccount = new SavingsAccountYear(10000, 10);
        assertEquals(thisYearAccount.endingBalance(), thisYearAccount.nextYear().startingBalance());
    }

    @Test
    public void nextYearInterestRateEqualsThisYearsInterestRate() {
        SavingsAccountYear thisYearAccount = new SavingsAccountYear(10000, 10);
        assertEquals(thisYearAccount.interestRate(), thisYearAccount.nextYear().interestRate());
    }
}
