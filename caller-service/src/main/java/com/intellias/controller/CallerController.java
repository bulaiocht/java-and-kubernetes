package com.intellias.controller;

import com.intellias.config.ApplicationConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RequiredArgsConstructor
@RestController
public class CallerController {

    private final ApplicationConfigProperties properties;
    private final RestTemplateBuilder templateBuilder;
    private final Environment environment;

    @GetMapping("/call")
    public ResponseEntity<String> callService() {
        RestTemplate template = templateBuilder.build();
        return template.getForEntity(properties.getExternalServiceHost(), String.class);
    }

    @GetMapping
    public ResponseEntity<String> sayMyName() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("local.server.port");
        return ResponseEntity.ok(String.format("HELLO FROM CALLER SERVICE on %s:%s", ip, port));
    }

    private String getUrl() {
        String host = properties.getExternalServiceHost();
        String port = properties.getExternalServicePort();
        return String.format("http://%s:%s", host, port);
    }

}
