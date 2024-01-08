package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class TopicNotFoundException extends BaseException {
    public TopicNotFoundException() {
        super("Topic not found!", HttpStatus.NOT_FOUND);
    }
    public TopicNotFoundException(Long topicId) {
        super("Topic with ID " + topicId + " not found!", HttpStatus.NOT_FOUND);
    }
}
