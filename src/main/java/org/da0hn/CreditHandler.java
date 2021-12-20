package org.da0hn;

import static org.da0hn.TransactionType.CREDIT;

public class CreditHandler implements Listener {
  private final AccountRepository accountRepository;

  public CreditHandler(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override public TransactionType operation() {
    return CREDIT;
  }

  @Override public void notify(final Command command) {
    if(!(command instanceof CreditCommand creditCommand)) {
      throw new IllegalArgumentException("Action cannot be executed");
    }
    final var account = this.accountRepository.get(creditCommand.accountDocument());
    account.credit(creditCommand.amount());
  }
}
