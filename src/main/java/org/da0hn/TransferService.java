package org.da0hn;

public class TransferService {
  public void transfer(final Account from, final Account to, final double amount) {
    from.debit(amount);
    to.credit(amount);
  }
}
