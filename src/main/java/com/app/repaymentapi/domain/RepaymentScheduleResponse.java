package com.app.repaymentapi.domain;

import lombok.Data;

@Data
public class RepaymentScheduleResponse {

	private String borrowerPaymentAmount;
	private String date;
	private String initialOutstandingPrincipal;
	private String interest;
	private String principal;
	private String remainingOutstandingPrincipal;
	
}
