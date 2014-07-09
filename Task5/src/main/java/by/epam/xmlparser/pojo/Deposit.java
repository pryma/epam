package by.epam.xmlparser.pojo;

public class Deposit {
	
	private Depositor depositor;
	private Bank bank;
    private String depositType;
    private long amountOnDeposit;
    private double profitability;
    private int timeConstraints;
    
	public Deposit() {
		super();
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (amountOnDeposit ^ (amountOnDeposit >>> 32));
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result
				+ ((depositType == null) ? 0 : depositType.hashCode());
		result = prime * result
				+ ((depositor == null) ? 0 : depositor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(profitability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + timeConstraints;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposit other = (Deposit) obj;
		if (amountOnDeposit != other.amountOnDeposit)
			return false;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (depositType == null) {
			if (other.depositType != null)
				return false;
		} else if (!depositType.equals(other.depositType))
			return false;
		if (depositor == null) {
			if (other.depositor != null)
				return false;
		} else if (!depositor.equals(other.depositor))
			return false;
		if (Double.doubleToLongBits(profitability) != Double
				.doubleToLongBits(other.profitability))
			return false;
		if (timeConstraints != other.timeConstraints)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Deposit [depositor=" + depositor + ", bank=" + bank
				+ ", depositType=" + depositType + ", amountOnDeposit="
				+ amountOnDeposit + ", profitability=" + profitability
				+ ", timeConstraints=" + timeConstraints + "]";
	}
	
	
	
    
    

}
