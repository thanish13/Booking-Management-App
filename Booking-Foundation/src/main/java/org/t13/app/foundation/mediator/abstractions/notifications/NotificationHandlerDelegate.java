package org.t13.app.foundation.mediator.abstractions.notifications;

@FunctionalInterface
public interface NotificationHandlerDelegate {
    Void handle();
}
