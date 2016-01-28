package JPMorganTrading;

import java.util.Date;

public class TradeBean {

	private String stockSymobol;
	private Date tradeTimestamp;
	private double stockQuantity;
	private String buySell;
	private double tradedPrice;

	public TradeBean(String stockSymobol, Date tradeTimestamp,
			double stockQuantity, String buySell, double tradedPrice) {
		super();
		this.stockSymobol = stockSymobol;
		this.tradeTimestamp = tradeTimestamp;
		this.stockQuantity = stockQuantity;
		this.buySell = buySell;
		this.tradedPrice = tradedPrice;
	}

	public String getStockSymobol() {
		return stockSymobol;
	}

	public void setStockSymobol(String stockSymobol) {
		this.stockSymobol = stockSymobol;
	}

	public Date getTradeTimestamp() {
		return tradeTimestamp;
	}

	public void setTradeTimestamp(Date tradeTimestamp) {
		this.tradeTimestamp = tradeTimestamp;
	}

	public double getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(double stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public double getTradedPrice() {
		return tradedPrice;
	}

	public void setTradedPrice(double tradedPrice) {
		this.tradedPrice = tradedPrice;
	}

	@Override
	public String toString() {
		return "TradeBean [stockSymobol=" + stockSymobol + ", tradeTimestamp="
				+ tradeTimestamp + ", stockQuantity=" + stockQuantity
				+ ", buySell=" + buySell + ", tradedPrice=" + tradedPrice + "]";
	}

}
