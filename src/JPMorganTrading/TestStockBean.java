package JPMorganTrading;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStockBean {

	@Test
	public void test() {
		StockBean b = new StockBean("TEA", "Common", 0, 0, 100);
		System.out.println("name = " + b.getStockSymobol());
	}

}
