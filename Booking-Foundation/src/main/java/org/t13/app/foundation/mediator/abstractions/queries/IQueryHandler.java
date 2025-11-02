package org.t13.app.foundation.mediator.abstractions.queries;


import org.t13.app.foundation.mediator.abstractions.requests.IRequestHandler;

public interface IQueryHandler<TQuery extends IQuery<TResponse>, TResponse> extends IRequestHandler<TQuery, TResponse> {
    TResponse handle(TQuery query);
}
