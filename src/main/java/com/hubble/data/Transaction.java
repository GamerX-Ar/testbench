package com.hubble.data;


public class Transaction {

    public enum Type { PAYMENT, REFUND }

    private final Type type;
    private final String currency;
    private final Long amount;


    public Transaction (Type type, String currency, Long amount) {
        this.type = type;
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }

}
