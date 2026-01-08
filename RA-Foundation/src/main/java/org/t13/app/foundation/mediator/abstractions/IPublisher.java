package org.t13.app.foundation.mediator.abstractions;


import org.t13.app.foundation.mediator.abstractions.notifications.INotification;

public interface IPublisher {
    <TNotification extends INotification> Void publish(TNotification notification) throws Exception;
}
