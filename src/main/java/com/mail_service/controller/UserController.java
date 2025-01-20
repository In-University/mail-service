package com.mail_service.controller;

import com.mail_service.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private MailService mailService;

    @GetMapping("/test-mail")
    public ResponseEntity<?> generateAndSendOtp(@RequestParam(value = "mail") String userMail) {
        return ResponseEntity.ok(mailService.generateAndSendOtp(userMail));
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<?> validateOtp(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("userId");
        String otpCode = requestBody.get("code");
        System.out.println("otpCode:::" + otpCode + "/" + userId);
        boolean isValid = mailService.validateOtp(userId, otpCode);

        return isValid
                ? ResponseEntity.ok("OTP is valid")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
    }

}
