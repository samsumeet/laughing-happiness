package com.app.repaymentapi.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.app.repaymentapi.dao.IRepaymentScheduleDAO;
import com.app.repaymentapi.domain.RepaymentScheduleEntity;
import com.app.repaymentapi.domain.RepaymentScheduleResponse;
import com.app.repaymentapi.utility.ErrorMessage;
import com.app.repaymentapi.utility.UtilityHelper;

@Component
public class RepaymentScheduleDAO implements IRepaymentScheduleDAO {
	private DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

	@Override
	public List<RepaymentScheduleResponse> fetchRepaymentSchedule(RepaymentScheduleEntity repaymentScheduleEntity) {
		List<RepaymentScheduleResponse> list = new ArrayList<RepaymentScheduleResponse>();
		RepaymentScheduleResponse repaymentScheduleResponse = new RepaymentScheduleResponse();

		// we can handle error for non numbers and provide cutomize message
		double actualLoanAmount;
		double nomnialRate;

		Calendar cal = Calendar.getInstance();
		try {
			actualLoanAmount = Double.valueOf(repaymentScheduleEntity.getLoanAmount());
			nomnialRate = Double.valueOf(repaymentScheduleEntity.getNominalRate());

			cal.setTime(dateformat.parse(repaymentScheduleEntity.getStartDate()));
			cal.add(Calendar.DAY_OF_MONTH, 1);
		} catch (ParseException | NumberFormatException e) {
			// we can use logging here for any failure
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessage.INVALID_INPUT, e);
		}

		// Calculating Annunity Amount Here
		double annunityAmount = UtilityHelper.AnnuityCalculator(actualLoanAmount, repaymentScheduleEntity.getDuration(),
				nomnialRate);

		for (int i = 0; i < repaymentScheduleEntity.getDuration(); i++) {
			repaymentScheduleResponse = new RepaymentScheduleResponse();

			double loanAmount = Double.valueOf(repaymentScheduleEntity.getLoanAmount());

			// Interest calculation; Interest = (Nominal-Rate * Days in Month * Initial
			// Outstanding Principal) / days in year
			double interest = (nomnialRate * 30 * loanAmount) / (360 * 100);

			if (i == repaymentScheduleEntity.getDuration() - 1) {
				annunityAmount = loanAmount + interest;
			}
			// Calculating Principal = Annuity - Interest
			double principal = annunityAmount - Double.valueOf(UtilityHelper.convertToNdigitDecimal(interest));

			if (principal < 0) {
				principal = actualLoanAmount;
			}
			repaymentScheduleResponse.setInterest(UtilityHelper.convertToNdigitDecimal(interest));
			repaymentScheduleResponse.setPrincipal(UtilityHelper.convertToNdigitDecimal(principal));
			// Borrower Payment Amount (Annuity) = Principal + Interest
			repaymentScheduleResponse.setBorrowerPaymentAmount(UtilityHelper.convertToNdigitDecimal(annunityAmount));
			repaymentScheduleResponse.setInitialOutstandingPrincipal(String.valueOf(loanAmount));
			repaymentScheduleResponse.setDate(cal.toInstant().toString());

			repaymentScheduleResponse
					.setRemainingOutstandingPrincipal(UtilityHelper.convertToNdigitDecimal(loanAmount - principal));

			// Update the loan amount with latest
			repaymentScheduleEntity.setLoanAmount(repaymentScheduleResponse.getRemainingOutstandingPrincipal());

			list.add(repaymentScheduleResponse);
			cal.add(Calendar.MONTH, 1);

		}

		return list;
	}

}
