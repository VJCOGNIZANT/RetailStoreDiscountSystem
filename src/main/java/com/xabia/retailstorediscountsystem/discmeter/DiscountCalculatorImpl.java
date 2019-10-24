package com.xabia.retailstorediscountsystem.discmeter;

import java.time.LocalDate;
import java.time.Period;

import com.xabia.retailstorediscountsystem.model.ProductDetails;
import com.xabia.retailstorediscountsystem.model.User;

public class DiscountCalculatorImpl implements DiscountCalculator {
	private double  discAmt=0;
	public double calculateDiscountForGroceries(User user, ProductDetails prd) {
		if (prd.isGrocery()) {
			discAmt=getDiscOnPrice(prd.getPrice());

		} else {
			discAmt=calculateDiscPrice(user,prd.getPrice());

		}
		return discAmt;
	}

	private double calculateDiscPrice(User user, int  price) {
		LocalDate now=LocalDate.now();
		LocalDate date=LocalDate.parse(user.getDoa());
		Period period = Period.between(date,now);
		if(user.isEmployee()) {
			discAmt=price*0.3;
			discAmt=discAmt+getDiscOnPrice(price);
		}
		else if(user.isAffiliated()) {
			discAmt=price*0.1;
			discAmt=discAmt+getDiscOnPrice(price);
		}
		else if(period.getYears()>=2) {
			discAmt=price*0.05;
			discAmt=discAmt+getDiscOnPrice(price);
		}
		return discAmt;
		
		
	}

	private double getDiscOnPrice(int price) {
		return (double)(price/100)*5;
	}

}
