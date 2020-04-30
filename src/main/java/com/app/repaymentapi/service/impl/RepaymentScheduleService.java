package com.app.repaymentapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repaymentapi.dao.IRepaymentScheduleDAO;
import com.app.repaymentapi.domain.RepaymentScheduleEntity;
import com.app.repaymentapi.domain.RepaymentScheduleResponse;
import com.app.repaymentapi.service.IRepaymentScheduleService;

@Service
public class RepaymentScheduleService implements IRepaymentScheduleService{
	@Autowired
	private IRepaymentScheduleDAO repaymentScheduleDAO;
	
	@Override
	public List<RepaymentScheduleResponse> getRepaymentSchedule(RepaymentScheduleEntity repaymentScheduleEntity) {
		
		return repaymentScheduleDAO.fetchRepaymentSchedule(repaymentScheduleEntity);
	}

}
