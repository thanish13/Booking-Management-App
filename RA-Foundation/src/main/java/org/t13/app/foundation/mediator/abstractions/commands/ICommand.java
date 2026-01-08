package org.t13.app.foundation.mediator.abstractions.commands;

import org.t13.app.foundation.mediator.abstractions.requests.IRequest;

public interface ICommand<TResponse> extends IRequest<TResponse>, IBaseCommand {}
