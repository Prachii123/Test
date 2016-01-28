package JPMorganTrading;

import java.util.Date;

import org.junit.Test;

public class TestTradeBean {

	@Test
	public void test() {
		TradeBean b = new TradeBean("TEA", new Date(), 20, "BUY", 100);
		System.out.println("name = " + b.getStockSymobol());
		System.out.println("date = " + b.getTradeTimestamp());
	}
}
