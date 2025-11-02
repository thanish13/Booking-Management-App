package org.t13.app.foundation.mediator.behaviors;


import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.t13.app.foundation.core.exception.ValidationException;
import org.t13.app.foundation.mediator.abstractions.requests.IPipelineBehavior;
import org.t13.app.foundation.mediator.abstractions.requests.IRequest;
import org.t13.app.foundation.mediator.abstractions.requests.RequestHandlerDelegate;

import java.util.List;

public class ValidationPipelineBehavior<TRequest extends IRequest<TResponse>, TResponse> implements IPipelineBehavior<TRequest, TResponse> {

    private final List<Validator> validators;

    public ValidationPipelineBehavior(List<Validator> validators) {
        this.validators = validators;
    }

    @Override
    public TResponse handle(TRequest request, RequestHandlerDelegate<TResponse> next) {
        // Find a validator that supports the request type
        Validator applicableValidator = validators.stream()
                .filter(validator -> validator.supports(request.getClass()))
                .findFirst()
                .orElse(null);

        if (applicableValidator != null) {
            // Perform validation
            DataBinder dataBinder = new DataBinder(request);
            dataBinder.setValidator(applicableValidator);
            dataBinder.validate();
            BindingResult bindingResult = dataBinder.getBindingResult();

            if (bindingResult.hasErrors()) {
                throw new ValidationException(bindingResult.getAllErrors().getFirst().getDefaultMessage());
            }
        }

        // Proceed to the next behavior in the pipeline
        return next.handle();
    }
}