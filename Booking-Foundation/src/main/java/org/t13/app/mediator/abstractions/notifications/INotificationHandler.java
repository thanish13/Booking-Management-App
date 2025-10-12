package org.t13.app.mediator.abstractions.notifications;

public interface INotificationHandler<TNotification extends INotification> {

    Void handle(TNotification notification);
}
