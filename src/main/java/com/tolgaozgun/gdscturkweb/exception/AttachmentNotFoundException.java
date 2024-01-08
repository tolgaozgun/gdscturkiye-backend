package com.tolgaozgun.gdscturkweb.exception;


import org.springframework.http.HttpStatus;

public class AttachmentNotFoundException extends BaseException {

    public AttachmentNotFoundException() {
        super("Attachment not found!", HttpStatus.NOT_FOUND);
    }

    public AttachmentNotFoundException(Long attachmentId) {
        super("Attachment with ID " + attachmentId + " not found!", HttpStatus.NOT_FOUND);
    }
}
