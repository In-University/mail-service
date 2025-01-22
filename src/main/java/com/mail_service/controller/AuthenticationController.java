package com.mail_service.controller;

import com.mail_service.dto.request.AuthenticationRequest;
import com.mail_service.dto.response.ApiResponse;
import com.mail_service.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/introspect")
    public ApiResponse<?> introspect(@RequestHeader("Authorization") String token) {
        boolean isValid = authenticationService.introspect(token);
        return ApiResponse.builder()
                .status(isValid ? "success" : "fail")
                .message(isValid ? "Token is valid" : "Invalid token")
                .build();
    }

    @PostMapping("/authenticate")
    public ApiResponse<?> authenticate(@RequestBody AuthenticationRequest request) {
        String token = authenticationService.authenticate(request);
        return ApiResponse.success(Map.of("token", token));
    }
}
