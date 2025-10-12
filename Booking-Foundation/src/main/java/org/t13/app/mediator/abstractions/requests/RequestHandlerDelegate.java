package org.t13.app.mediator.abstractions.requests;

@FunctionalInterface
public interface RequestHandlerDelegate<TResponse> {
    TResponse handle();
}
