package org.t13.app.mediator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "mediator")
@ConditionalOnBean({MediatorConfiguration.class})
public class MediatorProperties {

    private boolean enabled = true;
    private boolean enabledLogPipeline = true;

}
