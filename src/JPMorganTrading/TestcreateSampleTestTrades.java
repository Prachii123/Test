package JPMorganTrading;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestcreateSampleTestTrades {

	@Test
	public void test() {
		SuperSimpleStock s = new SuperSimpleStock();
		s.createSampleTestTrades();
	}

}
