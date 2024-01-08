package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.request.topic.CreateTopicRequest;
import com.tolgaozgun.gdscturkweb.dto.request.topic.EditTopicRequest;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.model.Topic;
import com.tolgaozgun.gdscturkweb.service.TopicService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("topics")
public class TopicController {

    private final TopicService topicService;

    @GetMapping( path = "")
    public ResponseEntity<Object> getAllTopics() {
        try {
            List<Topic> topicList = topicService.getAllTopics();
            return Response.create("Gathered all topics", HttpStatus.OK, topicList);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping( path = "{topicId}")
    public ResponseEntity<Object> getTopicById(@PathVariable Long topicId) {
        try {
            Topic topic = topicService.getTopic(topicId);
            return Response.create("Found the topic", HttpStatus.OK, topic);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "create")
    public ResponseEntity<Object> createTopic(@Valid @RequestBody CreateTopicRequest createTopicRequest) {
        try {
            Topic topic = topicService.createTopic(createTopicRequest);
            return Response.create("Topic created successfully", HttpStatus.OK, topic);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "edit/{topicId}")
    public ResponseEntity<Object> editTopic(@PathVariable Long topicId, @Valid @RequestBody EditTopicRequest editTopicRequest) {
        try {
            Topic topic = topicService.editTopic(topicId, editTopicRequest);
            return Response.create("Topic edited successfully", HttpStatus.OK, topic);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
