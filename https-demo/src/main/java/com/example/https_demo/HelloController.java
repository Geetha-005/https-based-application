package com.example.https_demo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    // Endpoint 1: Simple GET request
    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of(
                "message", "Hello from Spring Boot HTTPS!",
                "protocol", "HTTPS request"
        );
    }

    // Endpoint 2: Application status
    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of(
                "application", "https-demo",
                "status", "UP"
        );
    }

    // Endpoint 3: GET request with a query parameter
    @GetMapping("/greeting")
    public Map<String, String> greeting(
            @RequestParam(defaultValue = "Guest") String name) {

        return Map.of(
                "greeting", "Hello, " + name + "!"
        );
    }

    // Endpoint 4: POST request with JSON
    @PostMapping("/echo")
    public Map<String, Object> echo(
            @RequestBody Map<String, Object> request) {

        return Map.of(
                "message", "Request received securely",
                "data", request
        );
    }
}