package org.t13.app.mediator.abstractions.commands;

import org.t13.app.mediator.abstractions.requests.IRequestHandler;

public interface ICommandHandler<TCommand extends ICommand<TResponse>, TResponse>
        extends IRequestHandler<TCommand, TResponse> {
    TResponse handle(TCommand command);
}
