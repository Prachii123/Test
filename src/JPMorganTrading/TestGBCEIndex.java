package JPMorganTrading;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGBCEIndex {

	@Test
	public void testCalculateGBCEIndex() {
		System.out.println("Inside testing GBCE Index");
		SuperSimpleStock s = new SuperSimpleStock();
		double d = s.calculateGBCEIndex();
		System.out.println(" GBCE Index is >>" + d);
	}

}
