package com.iwona.operationsonnumbers.operations.controller;

import com.iwona.operationsonnumbers.numbers.response.AbstractResponse;

public class AuthorizationResponse extends AbstractResponse {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
