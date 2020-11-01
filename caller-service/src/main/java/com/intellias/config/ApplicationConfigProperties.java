package com.intellias.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "api")
public class ApplicationConfigProperties {
    private String externalServiceHost;
    private String externalServicePort;
}
