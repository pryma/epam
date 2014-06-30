package by.epam.xmlparser.pojo;

public class Deposit {
	
	private Depositor depositor;
	private Bank bank;
    private String depositType;
    private long amountOnDeposit;
    private double profitability;
    private int timeConstraints;
    
	public Depositor getDepositor() {
		return depositor;
	}
	public void setDepositor(Depositor depositor) {
		this.depositor = depositor;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public long getAmountOnDeposit() {
		return amountOnDeposit;
	}
	public void setAmountOnDeposit(long amountOnDeposit) {
		this.amountOnDeposit = amountOnDeposit;
	}
	public double getProfitability() {
		return profitability;
	}
	public void setProfitability(double profitability) {
		this.profitability = profitability;
	}
	public int getTimeConstraints() {
		return timeConstraints;
	}
	public void setTimeConstraints(int timeConstraints) {
		this.timeConstraints = timeConstraints;
	}
    
    

}
