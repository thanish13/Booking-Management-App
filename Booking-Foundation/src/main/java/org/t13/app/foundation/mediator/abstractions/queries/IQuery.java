package org.t13.app.foundation.mediator.abstractions.queries;


import org.t13.app.foundation.mediator.abstractions.requests.IRequest;

public interface IQuery<TResponse> extends IBaseQuery, IRequest<TResponse> {}
