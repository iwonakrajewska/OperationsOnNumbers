package com.iwona.operationsonnumbers.numbers.response;

import java.util.ArrayList;
import java.util.List;

public class AbstractResponse {

    List<String> messages = new ArrayList<>();

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(final List<String> messages) {
        this.messages = messages;
    }

    public void addMessage(final String message) {
        messages.add(message);
    }

    public boolean hasMessages() {
        return messages.size() > 0;
    }

}
