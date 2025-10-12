package org.t13.app.mediator.abstractions.notifications;

@FunctionalInterface
public interface NotificationHandlerDelegate {
    Void handle();
}
