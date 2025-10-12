package org.t13.app.mediator.abstractions.commands;

import buildingblocks.mediator.abstractions.requests.Unit;

public interface ICommandUnitHandler<TCommand extends ICommandUnit> extends ICommandHandler<TCommand, Unit> {}
