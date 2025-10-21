package org.t13.app.buildingblocks.mediator.abstractions.notifications;

@FunctionalInterface
public interface NotificationHandlerDelegate {
    Void handle();
}
