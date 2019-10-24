package com.xabia.retailstorediscountsystem.discmeter;

import com.xabia.retailstorediscountsystem.model.ProductDetails;
import com.xabia.retailstorediscountsystem.model.User;

public interface DiscountCalculator {
	
	double calculateDiscountForGroceries(User user,ProductDetails prd);

}
