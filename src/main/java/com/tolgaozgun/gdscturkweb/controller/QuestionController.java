package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.QuestionDTO;
import com.tolgaozgun.gdscturkweb.dto.request.question.*;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.model.QuestionCategory;
import com.tolgaozgun.gdscturkweb.service.QuestionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(path = "")
    public ResponseEntity<Object> getAllQuestions() {
        try {
            List<QuestionDTO> questions = questionService.getAllQuestions();
            return Response.create("Successfully listed questions", HttpStatus.OK, questions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "by-category/{categoryId}")
    public ResponseEntity<Object> getAllQuestions(@PathVariable Long categoryId) {
        try {
            List<QuestionDTO> questions = questionService.getAllQuestionsByCategory(categoryId);
            return Response.create("Successfully listed questions", HttpStatus.OK, questions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "categories")
    public ResponseEntity<Object> getAllQuestionCategories() {
        try {
            List<QuestionCategory> questionCategories = questionService.getAllQuestionCategories();
            return Response.create("Gathered all categories", HttpStatus.OK, questionCategories);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "categories/{categoryId}")
    public ResponseEntity<Object> getQuestionCategoryById(@PathVariable Long categoryId) {
        try {
            QuestionCategory questionCategory = questionService.getQuestionCategoryById(categoryId);
            return Response.create("Gathered the category", HttpStatus.OK, questionCategory);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "{questionId}")
    public ResponseEntity<Object> getQuestionById(@PathVariable Long questionId) {
        try {
            QuestionDTO question = questionService.getQuestion(questionId);
            return Response.create("Found the question", HttpStatus.OK, question);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "asked-by-me")
    public ResponseEntity<Object> getAllQuestionsAskedByCurrentUser() {
        try {
            List<QuestionDTO> questions = questionService.getQuestionsAskedByCurrentUser();
            return Response.create("Successfully listed questions", HttpStatus.OK, questions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "answered-by-me")
    public ResponseEntity<Object> getAllQuestionsAnsweredByCurrentUser() {
        try {
            List<QuestionDTO> questions = questionService.getAnsweredQuestionsByCurrentUser();
            return Response.create("Successfully listed questions", HttpStatus.OK, questions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "asked-answered-by-me")
    public ResponseEntity<Object> getAllQuestionsAskedOrAnsweredByCurrentUser() {
        try {
            List<QuestionDTO> questions = questionService.getQuestionsAskedOrAnsweredByCurrentUser();
            return Response.create("Successfully listed questions", HttpStatus.OK, questions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( path = "asked-by-user/{userId}")
    public ResponseEntity<Object> getAllQuestionsAskedByUser(@PathVariable Long userId) {
        try {
            List<QuestionDTO> questions = questionService.getQuestionsAskedByUser(userId);
            return Response.create("Successfully listed questions", HttpStatus.OK, questions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( path = "answered-by-user/{userId}")
    public ResponseEntity<Object> getAllQuestionsAnsweredByUser(@PathVariable Long userId) {
        try {
            List<QuestionDTO> questions = questionService.getAnsweredQuestionsByUser(userId);
            return Response.create("Successfully listed questions", HttpStatus.OK, questions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( path = "asked-answered-by-user/{userId}")
    public ResponseEntity<Object> getAllQuestionsAskedOrAnsweredByUser(@PathVariable Long userId) {
        try {
            List<QuestionDTO> questions = questionService.getQuestionsAskedOrAnsweredByUser(userId);
            return Response.create("Successfully listed questions", HttpStatus.OK, questions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "ask")
    public ResponseEntity<Object> askQuestion(@Valid @RequestBody AskQuestionRequest askQuestionRequest) {
        try {
            QuestionDTO question = questionService.askQuestion(askQuestionRequest);
            return Response.create("Successfully asked question", HttpStatus.OK, question);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "answer")
    public ResponseEntity<Object> answerQuestion(@Valid @RequestBody AnswerQuestionRequest answerQuestionRequest) {
        try {
            QuestionDTO question = questionService.answerQuestion(answerQuestionRequest);
            return Response.create("Successfully answered question", HttpStatus.OK, question);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
