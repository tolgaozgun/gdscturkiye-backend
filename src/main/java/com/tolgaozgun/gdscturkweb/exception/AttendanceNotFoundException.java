package com.tolgaozgun.gdscturkweb.exception;

import org.springframework.http.HttpStatus;

public class AttendanceNotFoundException extends BaseException {
    public AttendanceNotFoundException() {
        super("Attendance not found!", HttpStatus.NOT_FOUND);
    }

    public AttendanceNotFoundException(Long attendanceId) {
        super("Attendance with ID " + attendanceId + "not found!", HttpStatus.NOT_FOUND);
    }
}
