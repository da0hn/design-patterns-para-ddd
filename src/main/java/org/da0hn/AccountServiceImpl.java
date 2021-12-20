package org.da0hn;

public class AccountServiceImpl implements AccountService {

  private final AccountRepository repository;
  private final Publisher publisher;


  public AccountServiceImpl(final AccountRepository repository, final Publisher publisher) {
    this.repository = repository;
    this.publisher = publisher;
  }

  @Override public void create(final String document) {
    this.repository.save(new AccountBuilder(document).build());
  }

  @Override public void credit(final String document, final double amount) {
    final var creditCommand = new CreditCommand(document, amount);
    this.publisher.publish(creditCommand);
  }


  @Override public Account get(final String document) {
    return this.repository.get(document);
  }

  @Override public void debit(final String document, final double amount) {
    final var debitCommand = new DebitCommand(document, amount);
    this.publisher.publish(debitCommand);
  }

  @Override public void transfer(final String documentFrom, final String documentTo, final double amount) {
    final var transferCommand = new TransferCommand(documentFrom, documentTo, amount);
    this.publisher.publish(transferCommand);
  }
}
