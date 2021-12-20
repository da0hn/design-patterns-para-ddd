package org.da0hn;

public record TransferCommand(Account from, Account to, double amount) implements Command {
  @Override public void execute() {
    final var transferService = new TransferService();
    transferService.transfer(this.from, this.to, this.amount);
  }

  @Override public String operation() {
    return "transfer";
  }
}
