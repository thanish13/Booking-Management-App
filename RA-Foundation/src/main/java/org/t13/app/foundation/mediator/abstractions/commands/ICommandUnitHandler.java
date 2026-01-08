package org.t13.app.foundation.mediator.abstractions.commands;

import org.t13.app.foundation.mediator.abstractions.requests.Unit;

public interface ICommandUnitHandler<TCommand extends ICommandUnit> extends ICommandHandler<TCommand, Unit> {}
