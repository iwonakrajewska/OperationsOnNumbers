package com.iwona.operationsonnumbers.operations.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OperationsController {

	@GetMapping("/test/ok")
    public ResponseEntity<String> getMapping() {
        return ResponseEntity.status(HttpStatus.OK).body("Get, Test body string");
    }

	@GetMapping("/test/unauthorized")
    public ResponseEntity<Object> operationNotAuthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }

	@GetMapping("/test/exception")
    public ResponseEntity<String> operationRuntimeException() {
        throw new NullPointerException();
    }

	@PostMapping("/login")
	public ResponseEntity<AuthorizationResponse> login() {
		AuthorizationResponse response = new AuthorizationResponse();
		response.setToken("DummyToken");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
