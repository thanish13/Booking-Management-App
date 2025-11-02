package org.t13.app.foundation.r2dbc;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.ReactiveAuditorAware;
import reactor.core.publisher.Mono;

public class ReactiveAuditorAwareImpl implements ReactiveAuditorAware<Long> {

    @Override
    public @NotNull Mono<Long> getCurrentAuditor() {
        // Replace this with your logic to fetch the current user ID
        // For example, fetching it from a reactive security context
        return Mono.justOrEmpty(getCurrentUserId());
    }

    private Long getCurrentUserId() {
        // Implement your logic to fetch the current user ID
        return 1L; // Example: Return a fixed user ID
    }
}