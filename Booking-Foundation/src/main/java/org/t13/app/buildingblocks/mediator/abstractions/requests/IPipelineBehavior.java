package org.t13.app.buildingblocks.mediator.abstractions.requests;

public interface IPipelineBehavior<TRequest extends IRequest<TResponse>, TResponse> {
    TResponse handle(TRequest request, RequestHandlerDelegate<TResponse> next);
}
