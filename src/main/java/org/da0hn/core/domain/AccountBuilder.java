package org.da0hn.core.domain;

public class AccountBuilder {

  private final String document;
  private String bank;
  private String branch;
  private String account;

  public AccountBuilder(final String document) {
    this.document = document;
  }

  public AccountBuilder bank(final String bank) {
    this.bank = bank;
    return this;
  }

  public AccountBuilder branch(final String branch) {
    this.branch = branch;
    return this;
  }

  public AccountBuilder account(final String account) {
    this.account = account;
    return this;
  }

  public Account build() {
    return new Account(
      this.bank,
      this.branch,
      this.account,
      this.document
    );
  }

}
