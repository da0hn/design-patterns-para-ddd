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
    account.credit(1000);
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
    account.credit(1000);
    account.debit(500);
    assertEquals(500, account.getBalance(), "Balance should be 500");
  }
}
