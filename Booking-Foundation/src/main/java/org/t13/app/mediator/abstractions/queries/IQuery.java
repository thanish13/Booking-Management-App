package org.t13.app.mediator.abstractions.queries;


import org.t13.app.mediator.abstractions.requests.IRequest;

public interface IQuery<TResponse> extends IBaseQuery, IRequest<TResponse> {}
