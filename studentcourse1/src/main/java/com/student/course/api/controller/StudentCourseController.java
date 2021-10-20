/*
 * Copyright (c) 2021, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.student.course.api.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.course.errorresponse.ErrorResponse;
import com.student.course.service.StudentCourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/** Class to handle two control methods get and post
 * @author Senthil M
 *
 */
@RestController
@RequestMapping("/student")
@Api(value = "new-controller", tags = "new-controller")
public class StudentCourseController {
	
	@Autowired
	StudentCourseService studentCourseService;

	@Autowired
	public StudentCourseController() {
		
	}
	
	@GetMapping(name = "/student", produces = { "application/json" })
	public ResponseEntity<List> getResponse(@RequestParam(required = false) String number) {
		List response = studentCourseService.getAllStudent();
		return ResponseEntity.ok(response);
	}
//	@ApiOperation(
//			value = "Post a json form request",
//			nickname = "postFormRequest",
//			notes = "Post a form request",
//			response = FormResponse.class)
//	@ApiResponses({
//			@ApiResponse(
//					code = 200,
//					message = "A form response",
//					response = String.class),
//			@ApiResponse(
//					code = 400,
//					message = "Invalid/insufficient data provided by the client",
//					response = ErrorResponse.class),
//			@ApiResponse(
//					code = 403,
//					message = "Client is not permitted to use this operation",
//					response = ErrorResponse.class),
//			@ApiResponse(
//					code = 500,
//					message = "Internal server error",
//					response = ErrorResponse.class)
//	})
	@PostMapping(name = "/post-response", produces = { "application/json" })
	public ResponseEntity<> postForm(@RequestBody final FormResponse request) {
		Insured insured = new Insured();
		insured.setFullName(request.getInsured().getFullName());
		
		return ResponseEntity.ok("ok response");
		Policy policy = new Policy();
		// How do we validate the LineOfBusiness ?
		policy.setLineOfBusinessCode(request.getPolicy().getLineOfBusinessCode());
		policy.setNumber(request.getPolicy().getNumber());

		FormResponse response = new FormResponse();
		response.setInsured(insured);
		response.setPolicy(policy);
		return ResponseEntity.ok(response);
	}
