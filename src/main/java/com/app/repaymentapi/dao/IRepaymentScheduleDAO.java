package com.app.repaymentapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.repaymentapi.domain.RepaymentScheduleEntity;
import com.app.repaymentapi.domain.RepaymentScheduleResponse;
/**
 * This class is Data Access Object used to interact with Persistent Layer like database
 * @author sumeet
 *
 */
@Repository
public interface IRepaymentScheduleDAO {
/**
 * Calculating the Repayments of amount for given duration
 * @param repaymentScheduleEntity
 * @return
 */
	List<RepaymentScheduleResponse> fetchRepaymentSchedule(RepaymentScheduleEntity repaymentScheduleEntity);
}
