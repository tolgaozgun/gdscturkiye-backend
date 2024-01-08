package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class AnnouncementNotFoundException extends BaseException {
    public AnnouncementNotFoundException() {
        super("Announcement not found!", HttpStatus.NOT_FOUND);
    }

    public AnnouncementNotFoundException(Long campaignId) {
        super("Announcement with ID " + campaignId + "not found!", HttpStatus.NOT_FOUND);
    }
}
