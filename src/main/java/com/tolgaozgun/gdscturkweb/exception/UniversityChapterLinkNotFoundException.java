package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class UniversityChapterLinkNotFoundException extends BaseException {
    public UniversityChapterLinkNotFoundException() {
        super("University chapter link is not set!", HttpStatus.NOT_FOUND);
    }

}
