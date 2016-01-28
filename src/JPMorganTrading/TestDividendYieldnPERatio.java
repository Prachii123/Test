package JPMorganTrading;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDividendYieldnPERatio {
	SuperSimpleStock s;

	@Before
	public void setUp() throws Exception {
		s = new SuperSimpleStock();
	}

	@Test
	public void testDividendYield() {
		double d = s.dividendYield("GIN", 20);
		System.out.println("Dividend yeild is >>  " + d);
	}

	@Test
	public void testPeRatio() {

		double pe = s.peRatio("ALE", 20);
		System.out.println("PERatio is >>  " + pe);
	}
}
