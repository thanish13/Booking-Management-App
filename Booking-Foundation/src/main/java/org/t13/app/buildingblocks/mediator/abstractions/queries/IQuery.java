package org.t13.app.buildingblocks.mediator.abstractions.queries;

import buildingblocks.mediator.abstractions.requests.IRequest;

public interface IQuery<TResponse> extends IBaseQuery, IRequest<TResponse> {}
