package org.t13.app.buildingblocks.mediator.abstractions.requests;

public interface IRequestHandler<TRequest extends IRequest<TResponse>, TResponse> {
    TResponse handle(TRequest request);
}
