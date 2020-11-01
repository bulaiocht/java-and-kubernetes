package com.intellias.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RequiredArgsConstructor
@RestController
public class EchoController {

    private final Environment environment;

    @GetMapping
    public ResponseEntity<String> sayMyName() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("local.server.port");
        return ResponseEntity.ok(String.format("HELLO FROM ECHO SERVICE on %s:%s", ip, port));
    }

    @PostMapping(value = "echo")
    public ResponseEntity<String> echo(@RequestBody String message) {
        return ResponseEntity.ok(String.format("ECHO: %s", message));
    }
}
