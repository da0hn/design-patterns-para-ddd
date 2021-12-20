package org.da0hn.core.ports;

import org.da0hn.core.domain.TransactionType;

public interface Command {

  TransactionType operation();
}
