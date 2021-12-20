package org.da0hn;

import static org.da0hn.TransactionType.DEBIT;

public class DebitHandler implements Listener {
  private final AccountRepository accountRepository;

  public DebitHandler(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override public TransactionType operation() {
    return DEBIT;
  }

  @Override public void notify(final Command command) {
    if(!(command instanceof DebitCommand debitCommand)) {
      throw new IllegalArgumentException("Action cannot be executed");
    }
    final var account = this.accountRepository.get(debitCommand.accountDocument());
    account.debit(debitCommand.amount());
  }
}
