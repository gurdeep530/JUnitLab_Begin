package csc131.junit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GiftCardTest {

	@Test
	void testGetIssuingStore() {
		
		double       balance;
		GiftCard     card; 
		int 		issuingStore;
		
		issuingStore = 1337; 
		balance      = 100.00; 
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()",  issuingStore, card.getIssuingStore()); 
		
	}
	@Test
	void getBalance() {
		
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	void deduct_RemainingBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Remaining Balance: " + String.format("%6.2f", 90.00);
		assertEquals("deduct(10.00)", s, card.deduct(10.0));
		
	}
	
	@Test 
	void deduct_AmountDue() {
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Amount Due: " + String.format("%6.2f", 10.00);
		assertEquals("deduct 110.00 form 100.00", s, card.deduct(110.0));
		
	}
	
	@Test
	void deduct_InvalidTransaction(){
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Invalid Transaction: ";
		assertEquals("deduct -10.00 from 100.00", s, card.deduct(-10.00));
			
	}
	
	@Test
	void constructor_IncorrectID_Low()
	{
		Assert.assertThrows(IllegalArgumentException.class, () -> { 
		new GiftCard(-1,100.00);
		});
	}
	
	@Test
	void constructor_IncorrectID_High()
	{
		Assert.assertThrows(IllegalArgumentException.class, () -> { 
		new GiftCard(100000,100.00);
		});
	}


}
