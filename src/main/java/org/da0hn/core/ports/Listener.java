package org.da0hn.core.ports;

import org.da0hn.core.domain.TransactionType;

public interface Listener {
  TransactionType operation();

  void notify(Command command);
}
