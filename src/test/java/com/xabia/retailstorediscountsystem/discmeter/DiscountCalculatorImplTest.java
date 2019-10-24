package com.xabia.retailstorediscountsystem.discmeter;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.xabia.retailstorediscountsystem.model.ProductDetails;
import com.xabia.retailstorediscountsystem.model.User;

public class DiscountCalculatorImplTest  {
	private DiscountCalculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator=new DiscountCalculatorImpl();
		
	}
	@Test
	public void testCalculateDiscountForGroceries_G() {
		User user=new User();
		user.setEmployee(true);
		user.setAffiliated(false);
		user.setDoa("2008-12-02");
		ProductDetails prd=new  ProductDetails();
		prd.setGrocery(true);
		prd.setName("name1");
		prd.setPrdId(11);
		prd.setPrice(200);
		Double disc = calculator.calculateDiscountForGroceries(user, prd);
		assertEquals(new Double(10.0),disc);
		
	}
	@Test
	public void testCalculateDiscountForGroceries_NG_IsEmployee() {
		User user=new User();
		user.setId(12);
		user.setName("nameUser");
		user.setEmployee(true);
		user.setAffiliated(false);
		user.setDoa("2008-12-02");
		ProductDetails prd=new  ProductDetails();
		prd.setGrocery(false);
		prd.setName("name1");
		prd.setPrdId(11);
		prd.setPrice(200);
		Double disc = calculator.calculateDiscountForGroceries(user, prd);
		assertEquals(new Double(70.0), disc);
		assertNotNull(user.getId());
		assertNotNull(user.getName());
		assertNotNull(prd.getPrdId());
		assertNotNull(prd.getName());
	}
	@Test
	public void testCalculateDiscountForGroceries_NG_isAffiliated() {
		User user=new User();
		user.setEmployee(false);
		user.setAffiliated(true);
		user.setDoa("2008-12-02");
		ProductDetails prd=new  ProductDetails();
		prd.setGrocery(false);
		prd.setName("name1");
		prd.setPrdId(11);
		prd.setPrice(200);
		Double disc = calculator.calculateDiscountForGroceries(user, prd);
		assertEquals(new Double(30.0),disc);
		assertNull(user.getName());
	}
	@Test
	public void testCalculateDiscountForGroceries_NG_DaoMOreThan2() {
		User user=new User();
		user.setEmployee(false);
		user.setAffiliated(false);
		user.setDoa("2008-12-02");
		ProductDetails prd=new  ProductDetails();
		prd.setGrocery(false);
		prd.setName("name1");
		prd.setPrdId(11);
		prd.setPrice(200);
		Double disc = calculator.calculateDiscountForGroceries(user, prd);
		assertEquals(new Double(20.0),disc);
	}

}
