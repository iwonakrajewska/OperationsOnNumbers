package com.iwona.operationsonnumbers.numbers.response;

import java.util.ArrayList;
import java.util.List;

public class AbstractResponse {

	List<String> errorMessages = new ArrayList<>();

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public void addMessage(final String message) {
		errorMessages.add(message);
	}

	public boolean hasMessages() {
		return errorMessages.size() > 0;
	}

}
