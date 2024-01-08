package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.model.Permission;
import com.tolgaozgun.gdscturkweb.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("permissions")
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping( path = "")
    public ResponseEntity<Object> getCurrentUserPermissions() {
        try {
            List<Permission> permissions = permissionService.getCurrentUserPermissions();
            return Response.create("Gathered all permissions for the user", HttpStatus.OK, permissions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping( path = "by-user/{userId}")
    public ResponseEntity<Object> getPermissionsForUser(@PathVariable Long userId) {
        try {
            List<Permission> permissions = permissionService.getUserPermissions(userId);
            return Response.create("Gathered all permissions for the user", HttpStatus.OK, permissions);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
