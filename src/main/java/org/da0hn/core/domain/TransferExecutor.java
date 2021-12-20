package org.da0hn.core.domain;

public class TransferExecutor {
  public void execute(final Account from, final Account to, final double amount) {
    from.debit(amount);
    to.credit(amount);
  }
}
