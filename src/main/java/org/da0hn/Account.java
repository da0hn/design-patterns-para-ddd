package org.da0hn;

public class Account {
  private final String bank;
  private final String branch;
  private final String account;
  private final String document;
  private int balance;

  public Account(final String bank, final String branch, final String account, final String document) {
    this.bank = bank;
    this.branch = branch;
    this.account = account;
    this.document = document;
    this.balance = 0;
  }

  public void credit(final int amount) {
    this.balance += amount;
  }

  public int getBalance() {
    return this.balance;
  }

  public void debit(final int amount) {
    this.balance -= amount;
  }
}
