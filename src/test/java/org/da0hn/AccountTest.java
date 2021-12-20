package org.da0hn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("unit")
class AccountTest {

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
    final var account = new AccountBuilder("111.111.111-11")
      .account("123456-7")
      .bank("033")
      .branch("001")
      .build();

    final var creditCommand = new CreditCommand(account, 1000);
    creditCommand.execute();

    assertEquals(1000, account.getBalance(), "Balance should be 1000");
  }

  @Test
  @DisplayName("Deve criar uma conta e fazer um débito")
  void shouldCreateAccountAndDebitAmount() {
    final var account = new AccountBuilder("111.111.111-11")
      .account("123456-7")
      .bank("033")
      .branch("001")
      .build();

    final var creditCommand = new CreditCommand(account, 1000);
    creditCommand.execute();

    final var debitCommand = new DebitCommand(account, 500);
    debitCommand.execute();
    assertEquals(500, account.getBalance(), "Balance should be 500");
  }

  @Test
  @DisplayName("Deve criar duas contas e fazer uma transferência")
  void shouldCreateTwoAccountsAndTransfer() {
    final var accountTo = new AccountBuilder("111.111.111-11")
      .account("123456-7")
      .bank("033")
      .branch("001")
      .build();

    final var accountFrom = new AccountBuilder("000.000.000-01")
      .account("876543-7")
      .bank("033")
      .branch("001")
      .build();

    final var creditCommandFrom = new CreditCommand(accountFrom, 1000);
    creditCommandFrom.execute();
    final var creditCommandTo = new CreditCommand(accountTo, 500);
    creditCommandTo.execute();

    final var transferCommand = new TransferCommand(accountFrom, accountTo, 700);
    transferCommand.execute();

    assertEquals(300, accountFrom.getBalance(), "Account From should transfer 700");
    assertEquals(1200, accountTo.getBalance(), "Account To should receive 700");
  }

}
