package JPMorganTrading;

public class StockBean {

	/**
	 * @param args
	 */
	private String stockSymobol;
	private String stockType;
	private double lastDividend;
	private double fixedDividend;
	private double parValue;

	public StockBean() {
		System.out.println("defautltt");
	}

	public StockBean(String stockSymobol, String stockType,
			double lastDividend, double fixedDividend, double parValue) {
		super();
		this.stockSymobol = stockSymobol;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	public String getStockSymobol() {
		return stockSymobol;
	}

	public void setStockSymobol(String stockSymobol) {
		this.stockSymobol = stockSymobol;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public double getParValue() {
		return parValue;
	}

	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

	@Override
	public String toString() {
		return "StockBean [stockSymobol=" + stockSymobol + ", stockType="
				+ stockType + ", lastDividend=" + lastDividend
				+ ", fixedDividend=" + fixedDividend + ", parValue=" + parValue
				+ "]";
	}

}
