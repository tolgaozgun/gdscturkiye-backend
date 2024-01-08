package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class CampaignNotFoundException extends BaseException {
    public CampaignNotFoundException() {
        super("Campaign is not found!", HttpStatus.NOT_FOUND);
    }

    public CampaignNotFoundException(Long campaignId) {
        super("Campaign with ID " + campaignId + " is not found!", HttpStatus.NOT_FOUND);
    }
}
