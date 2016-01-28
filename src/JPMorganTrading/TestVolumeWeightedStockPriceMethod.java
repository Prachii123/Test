package JPMorganTrading;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVolumeWeightedStockPriceMethod {

	@Test
	public void testVolumeWeightedStockPrice() {
		System.out.println("Testing Volumen Weighted Stock method");
		SuperSimpleStock s = new SuperSimpleStock();
		double d = s.volumeWeightedStockPrice("TEA");
		System.out.println("exit testing  Volumen Weighted Stock method");
	}

}
