package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class CampaignPageNotFoundException extends BaseException {
    public CampaignPageNotFoundException() {
        super("Campaign page is not found!", HttpStatus.NOT_FOUND);
    }

    public CampaignPageNotFoundException(Long campaignId) {
        super("Campaign page with ID " + campaignId + " is not found!", HttpStatus.NOT_FOUND);
    }
}
