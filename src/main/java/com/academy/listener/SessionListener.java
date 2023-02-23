package com.academy.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionAttributeListener {
  public void attributeAdded(HttpSessionBindingEvent event) {
    System.out.println("Session attribute was added with name " + event.getName() + " and value " + event.getValue());
  }

  public void attributeRemoved(HttpSessionBindingEvent event) {
    System.out.println("Session attribute was removed");
  }

  public void attributeReplaced(HttpSessionBindingEvent event) {
    System.out.println("Session attribute was replaced");
  }
}
