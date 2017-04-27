package com.iwona.operationsonnumbers.numbers.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ServerErrorResponseHandler {

	public ResponseEntity<AbstractResponse> prepareErrorResponse() {
		EmptyResponse response = new EmptyResponse();
		response.addMessage("Server problem. Check server logs.");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
