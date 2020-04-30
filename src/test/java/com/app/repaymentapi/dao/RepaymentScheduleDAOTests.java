package com.app.repaymentapi.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.repaymentapi.dao.impl.RepaymentScheduleDAO;
import com.app.repaymentapi.domain.RepaymentScheduleEntity;
import com.app.repaymentapi.domain.RepaymentScheduleResponse;

@RunWith(SpringRunner.class)
public class RepaymentScheduleDAOTests {

	private RepaymentScheduleDAO repaymentScheduleDAO= new RepaymentScheduleDAO();
	private RepaymentScheduleEntity repaymentScheduleEntity = new RepaymentScheduleEntity();

	@BeforeClass
	public static void  setup() {
		// Here define something which should be available before class object creation
	}

	@Test
	public void fetchRepaymentScheduleTest() {
		repaymentScheduleEntity.setDuration(24);
		repaymentScheduleEntity.setLoanAmount("5000");
		repaymentScheduleEntity.setNominalRate("5");
		repaymentScheduleEntity.setStartDate("2018-01-01T00:00:01Z");
		List<RepaymentScheduleResponse> repaymentScheduleResponsesList = repaymentScheduleDAO
				.fetchRepaymentSchedule(repaymentScheduleEntity);

		assertEquals(repaymentScheduleResponsesList.get(0).getBorrowerPaymentAmount(), "219.36");  
		assertEquals(repaymentScheduleResponsesList.get(0).getInterest(),"20.83");

	}
}
