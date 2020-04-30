package com.app.repaymentapi.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.app.repaymentapi.controller.IRepaymentScheduleAPI;
import com.app.repaymentapi.domain.RepaymentScheduleEntity;
import com.app.repaymentapi.domain.RepaymentScheduleResponse;
import com.app.repaymentapi.service.IRepaymentScheduleService;

/**
 * 
 * @author sumeet
 *
 */
@Component
public class RepaymentScheduleAPI implements IRepaymentScheduleAPI {
	@Autowired
	private IRepaymentScheduleService repaymentScheduleService;

	@Override
	public ResponseEntity<List<RepaymentScheduleResponse>> getRepaymentPlan(
			RepaymentScheduleEntity repaymentScheduleEntity) {

		return new ResponseEntity<List<RepaymentScheduleResponse>>(
				repaymentScheduleService.getRepaymentSchedule(repaymentScheduleEntity), HttpStatus.OK);
	}

}
