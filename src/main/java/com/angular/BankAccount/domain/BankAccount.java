package com.angular.BankAccount.domain;

import org.mongodb.morphia.annotations.Entity;

import java.util.Objects;

/**
 * Created by Nagendra on 23-10-2016.
 */
public enum BankAccount{

    CURRENT_DEPOSITS("Current Deposits"),
    SAVING_BANK("Saving  Bank"),
    RECURRING_DEPOSITS("Recurring Deposits"),
    FIXED_DEPOSITS("Fixed Deposits");

    private final String text;

    /**
     * @param text
     */
    private BankAccount(final String text) {
        this.text = text;
    }


    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }

}
