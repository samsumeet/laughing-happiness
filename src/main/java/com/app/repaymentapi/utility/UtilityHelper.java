package com.app.repaymentapi.utility;

import java.text.DecimalFormat;

/**
 * Define functions here that we can reuse
 * 
 * @author sumeet
 *
 */
public class UtilityHelper {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    
    /**
     * convert double number to 2 digit
     * @param number
     * @return
     */
	public static String convertToNdigitDecimal(double number) {
		return df2.format(number);
	}
	
	/**
	 * Annuity is calculating here using given formula 
	 * @param loanAmount
	 * @param termInMonths
	 * @param interestRate
	 * @return
	 */
	public static double AnnuityCalculator(double loanAmount, int termInMonths, double interestRate) {
		// Convert interest rate into a decimal eg. 5% = 0.05
		interestRate /= 100.0;

		// Monthly interest rate is the yearly rate divided by 12
		double monthlyRate = interestRate / 12.0;

		// The Math.pow() method is used calculate values raised to a power
		double monthlyPayment = (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));

		return monthlyPayment;
	}

}
