package org.da0hn.core.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class Account {
  private final String bank;
  private final String branch;
  private final String account;
  private final String document;
  private final List<Transaction> transactions;
  private final int balance;

  public Account(final String bank, final String branch, final String account, final String document) {
    this.bank = bank;
    this.branch = branch;
    this.account = account;
    this.document = document;
    this.balance = 0;
    this.transactions = new ArrayList<>();
  }

  public void credit(final double amount) {
    this.transactions.add(new Transaction(TransactionType.CREDIT, amount));
  }

  public double getBalance() {
    final var transactionsByType = this.transactions.stream()
      .collect(groupingBy(
        Transaction::type,
        summingDouble(Transaction::amount)
      ));

    return transactionsByType.getOrDefault(TransactionType.CREDIT, 0.0) - transactionsByType.getOrDefault(TransactionType.DEBIT, 0.0);
  }

  public void debit(final double amount) {
    this.transactions.add(new Transaction(TransactionType.DEBIT, amount));
  }

  public String getDocument() {
    return this.document;
  }
}
