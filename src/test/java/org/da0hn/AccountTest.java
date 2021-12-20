package org.da0hn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
class AccountTest {

  private AccountService accountService;
  private Publisher publisher;
  private AccountRepositoryImpl repository;

  @BeforeEach
  void setUp() {
    this.publisher = new PublisherImpl();
    this.repository = new AccountRepositoryImpl();
    this.publisher.register(new CreditHandler(this.repository));
    this.publisher.register(new DebitHandler(this.repository));
    this.publisher.register(new TransferHandler(this.repository));
    this.accountService = new AccountServiceImpl(this.repository, this.publisher);
  }

  @Test
  @DisplayName("Deve criar uma conta")
  void shouldCreateAccount() {
    final var account = new AccountBuilder("111.111.111-11")
      .account("123456-7")
      .bank("033")
      .branch("001")
      .build();
    assertEquals(0, account.getBalance(), "Balance should be 0");
  }

  @Test
  @DisplayName("Deve criar uma conta e fazer um deposito")
  void shouldCreateAccountAndCreditAmount() {

    final var document = "111.111.111-11";

    this.accountService.create(document);
    this.accountService.credit(document, 1000);

    final var account = this.accountService.get(document);

    assertEquals(1000, account.getBalance(), "Balance should be 1000");
  }

  @Test
  @DisplayName("Deve criar uma conta e fazer um débito")
  void shouldCreateAccountAndDebitAmount() {
    final var document = "111.111.111-11";

    this.accountService.create(document);
    this.accountService.credit(document, 1000);

    this.accountService.debit(document, 500);

    final var account = this.accountService.get(document);
    assertEquals(500, account.getBalance(), "Balance should be 500");
  }

  @Test
  @DisplayName("Deve criar duas contas e fazer uma transferência")
  void shouldCreateTwoAccountsAndTransfer() {
    final var documentFrom = "111.111.111-11";
    this.accountService.create(documentFrom);
    this.accountService.credit(documentFrom, 1000);
    final var documentTo = "000.000.000-01";
    this.accountService.create(documentTo);
    this.accountService.credit(documentTo, 500);

    this.accountService.transfer(documentFrom, documentTo, 700);

    final var accountFrom = this.accountService.get(documentFrom);
    final var accountTo = this.accountService.get(documentTo);

    assertEquals(300, accountFrom.getBalance(), "Account From should transfer 700");
    assertEquals(1200, accountTo.getBalance(), "Account To should receive 700");
  }

}
