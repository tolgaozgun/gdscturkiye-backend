package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.response.LeadDashboardResponse;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.model.Event;
import com.tolgaozgun.gdscturkweb.service.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("events")
public class EventController {

    private final EventService eventService;

    @GetMapping( path = "")
    public ResponseEntity<Object> getAllEvents() {
        try {
            List<Event> events = eventService.getAllEvents();
            return Response.create("Gathered all events", HttpStatus.OK, events);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( path = "university/{universityId}")
    public ResponseEntity<Object> getEventsByUniversityId(@Valid @PathVariable Long universityId) {
        try {
            List<Event> events = eventService.getEventsByUniversity(universityId);
            return Response.create("Gathered university events", HttpStatus.OK, events);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( path = "university/current-user")
    public ResponseEntity<Object> getEventsByCurrentUserUniversity() {
        try {
            List<Event> events = eventService.getEventsByCurrentUserUniversity();
            return Response.create("Gathered university events", HttpStatus.OK, events);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping( path = "buddy-team/current-user")
    public ResponseEntity<Object> getEventsByCurrentUserBuddy() {
        try {
            List<Event> events = eventService.getEventsByCurrentBuddyTeam();
            return Response.create("Gathered buddy events", HttpStatus.OK, events);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping( path = "parse/current-university")
    public ResponseEntity<Object> parseCurrentUserUniversityEvents() {
        try {
            List<Event> events = eventService.scrapeCurrentChapterEvents();
            return Response.create("Gathered university events", HttpStatus.OK, events);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping( path = "parse/{universityId}")
    public ResponseEntity<Object> parseUniversityEvents(@Valid @PathVariable Long universityId) {
        try {
            List<Event> events = eventService.scrapeChapterEventsByUniversityId(universityId);
            return Response.create("Gathered university events", HttpStatus.OK, events);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
