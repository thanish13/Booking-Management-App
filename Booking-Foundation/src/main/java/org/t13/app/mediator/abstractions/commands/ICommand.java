package org.t13.app.mediator.abstractions.commands;

import org.t13.app.mediator.abstractions.requests.IRequest;

public interface ICommand<TResponse> extends IRequest<TResponse>, IBaseCommand {}
