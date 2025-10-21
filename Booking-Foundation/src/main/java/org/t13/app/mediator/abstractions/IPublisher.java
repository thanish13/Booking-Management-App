package org.t13.app.mediator.abstractions;


import org.t13.app.mediator.abstractions.notifications.INotification;

public interface IPublisher {
    <TNotification extends INotification> Void publish(TNotification notification) throws Exception;
}
