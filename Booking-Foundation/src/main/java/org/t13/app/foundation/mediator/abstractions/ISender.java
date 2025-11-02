package org.t13.app.foundation.mediator.abstractions;


import org.t13.app.foundation.mediator.abstractions.commands.ICommand;
import org.t13.app.foundation.mediator.abstractions.queries.IQuery;
import org.t13.app.foundation.mediator.abstractions.requests.IRequest;

public interface ISender {

    <TResponse> TResponse send(IRequest<TResponse> request);

    <TResponse> TResponse send(ICommand<TResponse> command);

    <TResponse> TResponse send(IQuery<TResponse> query);
}
