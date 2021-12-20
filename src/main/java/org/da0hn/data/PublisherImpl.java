package org.da0hn.data;

import org.da0hn.core.ports.Command;
import org.da0hn.core.ports.Listener;
import org.da0hn.core.ports.Publisher;

import java.util.ArrayList;
import java.util.List;

public class PublisherImpl implements Publisher {

  private final List<Listener> listeners = new ArrayList<>();


  @Override public void register(final Listener listener) {
    this.listeners.add(listener);
  }

  @Override public void publish(final Command command) {
    this.listeners.stream()
      .filter(observer -> observer.operation().equals(command.operation()))
      .forEach(observer -> observer.notify(command));
  }

}
