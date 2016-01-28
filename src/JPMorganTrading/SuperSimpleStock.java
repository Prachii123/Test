package JPMorganTrading;

import java.sql.Timestamp;
import java.util.*;

public class SuperSimpleStock {

	public HashMap<String, StockBean> stocks;

	public TreeMap<Timestamp, TradeBean> trades;

	/**
	 * @param args
	 */

	public SuperSimpleStock() {
		// create the hasmap here so that a new one is not created everytime a
		// wrong call is given to populate method
		stocks = new HashMap<String, StockBean>();
		trades = new TreeMap<Timestamp, TradeBean>();
		populateStockTable();
		createSampleTestTrades();
	}

	public void createSampleTestTrades() {
		try {
			Date now;
			Timestamp currentTimestamp;
			Calendar calendar;
			String buySellIndicator;
			String stockSymbol;
			// The loop below creates random sample trades dating for last 30
			// minutes
			for (int i = 0; i < 30; i++) {
				// reset calendar at each iteration
				calendar = Calendar.getInstance();
				calendar.add(Calendar.MINUTE, -30 + i);
				now = calendar.getTime();
				currentTimestamp = new java.sql.Timestamp(now.getTime());
				buySellIndicator = (i % 2 == 0) ? "BUY" : "SELL";
				stockSymbol = (i % 2 == 0) ? "TEA" : (i % 3 == 0) ? "ALE"
						: "GIN";
				trades.put(currentTimestamp, new TradeBean(stockSymbol,
						currentTimestamp, 100 * (i + 1), buySellIndicator,
						10 * (i + 1)));
			}

			// CHeck the trades map, can be commented
			Set set = trades.entrySet();
			Iterator iter = set.iterator();
			while (iter.hasNext()) {
				Map.Entry me = (Map.Entry) iter.next();
				System.out.print("key is: " + me.getKey() + " & Value is: ");
				System.out.println(me.getValue());
			}
			// end check the trades map
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createTrade() {

	}

	public void populateStockTable() {
		stocks.put("TEA", new StockBean("TEA", "Common", 0, 0, 100));
		stocks.put("POP", new StockBean("POP", "Common", 8, 0, 100));
		stocks.put("ALE", new StockBean("ALE", "Common", 23, 0, 60));
		stocks.put("GIN", new StockBean("GIN", "Preferred", 8, 2, 100));
		stocks.put("JOE", new StockBean("JOE", "Common", 13, 0, 250));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	// these are calculation methods, no point in putting in spearate util as it
	// always referes back to the hashmap
	// all these can be private methods so as to avoid publishing the business
	// logic

	/*
	 * Takes Stock symbol and price as inputs and returns dividend Will return
	 * dividend as -1 on error so the caller should check it
	 */
	public double dividendYield(String stockSymbol, double price) {
		double dividend = 0.0;
		double lastDividend = 0;
		try {
			// can throw null pointer if the stock symbol is not in the hashmap
			// so try / catch
			StockBean stock = (StockBean) stocks.get(stockSymbol);
			/*
			 * can write this as Object o = stocks.get(stockSymbol); if
			 * (o!=null) then {stockbean etc}
			 */
			lastDividend = stock.getLastDividend();
			dividend = lastDividend / price; // can throw divide by zero so try
												// catch, Last dividend is not %
												// value but awhole number so no
												// need to divide by 100.
		} catch (Exception e) {
			dividend = -1;
			e.printStackTrace();
			// System.out.println(" Exception " + e.getMessage());
		}
		return dividend;

	}

	public double peRatio(String stockSymbol, double price) {

		double peratio = 0;

		try {

			double dividend = dividendYield(stockSymbol, price);

			peratio = price / dividend;
		} catch (Exception e) {
			peratio = -1;
			System.out.println(" Exception " + e.getMessage());
		}

		return peratio;
	}

	public double geometricMean(double price) {

		double geoMean = 0;

		return geoMean;
	}

	public double volumeWeightedStockPrice(String stockSym) {
		double vwsPrice = 0.00;
		double sumTradenQuantity = 0.00;
		double sumOfQuantity = 0.00;
		String stockSymbol;
		// get current time and time before last 15 mins as boundary conditions
		Date now, min15Before, keyTS;
		TradeBean valBean;
		Calendar calendar = Calendar.getInstance();
		now = calendar.getTime();
		calendar.add(Calendar.MINUTE, -15);
		min15Before = calendar.getTime();
		System.out.println("Current Time obtained from caledary == " + now
				+ "  15 mins before is " + min15Before);
		// Check the trades map
		Set set = trades.entrySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			try { // type casts etc may throw null pointer
				Map.Entry me = (Map.Entry) iter.next();
				keyTS = (Date) me.getKey();
				valBean = (TradeBean) me.getValue();
				stockSymbol = valBean.getStockSymobol();
				System.out.print("Value found from the bean is key is: "
						+ keyTS + " & Value is: ");
				System.out.println(valBean);
				System.out.println("Stock Symobol in Found >> " + stockSymbol
						+ "  Stock Symbol Received " + stockSym);
				if ((keyTS.compareTo(min15Before) > 0 || keyTS
						.compareTo(min15Before) == 0)
						&& (keyTS.compareTo(now) < 0 || keyTS.compareTo(now) == 0)) {
					if (stockSym.equals(stockSymbol)) {
						System.out
								.print("This value should come in the report : key is: "
										+ keyTS + " & Value is: ");
						System.out.println(valBean);
						// start creating total
						// Sum(i)[ Traded Pricei × Quantityi ]/ Sum(i) Quantityi
						sumTradenQuantity += valBean.getTradedPrice()
								* valBean.getStockQuantity();
						sumOfQuantity += valBean.getStockQuantity();
						System.out.println("Quantity Total is >> "
								+ sumOfQuantity + " Revenue Total >> "
								+ sumTradenQuantity);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		vwsPrice = sumTradenQuantity / sumOfQuantity;
		System.out.println("For the stock " + stockSym
				+ " The Volume Weighted Stock Price  is  >> " + vwsPrice);
		return vwsPrice;
	}

	public double calculateGBCEIndex() {
		double dGBCEIndex = 0.00;
		TradeBean valBean;
		double iOperand = 0;
		double sumOfPrices = 0.00;

		Set set = trades.entrySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			try { // type casts etc may throw null pointer
				Map.Entry me = (Map.Entry) iter.next();
				valBean = (TradeBean) me.getValue();
				sumOfPrices += valBean.getTradedPrice();
				iOperand++;
				System.out.println("Details of trade  is >> " + valBean);
				System.out.println("Current price total is >> " + sumOfPrices);
				System.out.println("Current root is  >> " + iOperand);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		try {
			System.out.println("Final price total is >> " + sumOfPrices);
			System.out.println("Final  root is  >> " + iOperand);
			dGBCEIndex = Math.pow(sumOfPrices, (1 / iOperand));
		} catch (Exception e) {
			e.printStackTrace();
			dGBCEIndex = -1;
		}
		System.out.println(" The GBCE Index is >> " + dGBCEIndex);
		// System.out.println("Test GBCE square root "+Math.pow(sumOfPrices,(1/2.00)));
		return dGBCEIndex;
	}
}
