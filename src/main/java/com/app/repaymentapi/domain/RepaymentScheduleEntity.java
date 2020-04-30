package com.app.repaymentapi.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RepaymentScheduleEntity {
	@NotBlank
	private String loanAmount;
	@NotBlank
	private String nominalRate;
	@NotNull
	private int duration;
	@NotBlank
	private String startDate;
}
