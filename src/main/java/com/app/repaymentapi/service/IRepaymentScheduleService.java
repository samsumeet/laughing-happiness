package com.app.repaymentapi.service;

import java.util.List;

import com.app.repaymentapi.domain.RepaymentScheduleEntity;
import com.app.repaymentapi.domain.RepaymentScheduleResponse;
/**
 * This is Service layer used to interact with DAO Layer
 * @author sumeet
 *
 */
public interface IRepaymentScheduleService {
/**
 * 
 * @param repaymentScheduleEntity This is input object for querying repayments of loan
 * @return List of Repayments Amount for given interval
 */
	List<RepaymentScheduleResponse> getRepaymentSchedule(RepaymentScheduleEntity repaymentScheduleEntity);
}
