package com.app.repaymentapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.repaymentapi.domain.RepaymentScheduleEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * This is API contract all API is defined here related to Repayments Schedule
 * 
 * @author sumeet
 *
 */
@RestController
@RequestMapping()
public interface IRepaymentScheduleAPI {

	@PostMapping(value = "/generate-plan", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Create Replayment Plan", notes = "Create Replayment Plan", response = List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity getRepaymentPlan(@RequestBody RepaymentScheduleEntity body);
}
