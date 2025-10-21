package org.t13.app.buildingblocks.mediator.abstractions.requests;

@FunctionalInterface
public interface RequestHandlerDelegate<TResponse> {
    TResponse handle();
}
