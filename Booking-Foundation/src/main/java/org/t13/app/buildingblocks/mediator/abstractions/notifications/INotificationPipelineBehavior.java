package org.t13.app.buildingblocks.mediator.abstractions.notifications;

public interface INotificationPipelineBehavior<TNotification extends INotification> {
    Void handle(TNotification notification, NotificationHandlerDelegate next);
}
