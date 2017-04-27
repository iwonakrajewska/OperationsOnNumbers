package com.iwona.operationsonnumbers.operations.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class OperationsController {

    @GetMapping("/ok")
    public ResponseEntity<String> getMapping() {
        return ResponseEntity.status(HttpStatus.OK).body("Get, Test body string");
    }

    @GetMapping("/unauthorized")
    public ResponseEntity<Object> operationNotAuthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }

    @GetMapping("/exception")
    public ResponseEntity<String> operationRuntimeException() {
        throw new NullPointerException();
    }

}
