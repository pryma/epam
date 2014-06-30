package by.epam.xmlparser.dao.staximpl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.xmlparser.dao.DepositTags;
import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.pojo.Bank;
import by.epam.xmlparser.pojo.Deposit;
import by.epam.xmlparser.pojo.Depositor;



public class StaxDepositParser {
	
	List<Deposit> deposits = new ArrayList<Deposit>();
    Deposit deposit;
    Bank bank;
    Depositor depositor;
    
private Deposit initDeposit() {
    	
    	deposit = new Deposit();
    	deposits.add(deposit);
    	bank = new Bank();
    	deposit.setBank(bank);
    	depositor = new Depositor();
    	deposit.setDepositor(depositor);
    	
    	return deposit;
    }
	
	public List<Deposit> parse(XMLStreamReader xmlStreamReader) throws XmlDaoException {
        
        String content = null;
        try {
			while (xmlStreamReader.hasNext()) {
			    int event = xmlStreamReader.next();

			    switch (event) {
			        case XMLStreamConstants.START_ELEMENT:
			            if (xmlStreamReader.getLocalName().equals(DepositTags.DEPOSIT.toString())) {
			            	deposit = initDeposit();
			            	depositor.setAccountId(xmlStreamReader.getAttributeValue(0));
			            	deposit.setDepositType(xmlStreamReader.getAttributeValue(1));
			            } else if (xmlStreamReader.getLocalName().equals(DepositTags.BANK_NAME.toString())) {
							bank.setCountryRegistration(xmlStreamReader.getAttributeValue(0));
						}
			            break;
			        case XMLStreamConstants.CHARACTERS:
			            content = xmlStreamReader.getText().trim();
			            break;
			        case XMLStreamConstants.END_ELEMENT:
			            if (xmlStreamReader.getLocalName().equals(DepositTags.BANK_NAME.toString())) {
			            	bank.setBankName(content);
			            } else if (xmlStreamReader.getLocalName().equals(DepositTags.DEPOSITOR.toString())) {
			            	depositor.setDepositorName(content);
			            } else if (xmlStreamReader.getLocalName().equals(DepositTags.AMOUNT_ON_DEPOSIT.toString())) {
			                deposit.setAmountOnDeposit(Long.valueOf(content));
			            } else if (xmlStreamReader.getLocalName().equals(DepositTags.PROFITABILITY.toString())) {
			                deposit.setProfitability(Double.valueOf(content));
			            } else if (xmlStreamReader.getLocalName().equals(DepositTags.TIME_CONSTRAINTS.toString())) {
			                deposit.setTimeConstraints(Integer.valueOf(content));
			            } 
			            break;
			    }
			}
		} catch (NumberFormatException e) {
			throw new XmlDaoException("", e);
		} catch (XMLStreamException e) {
			throw new XmlDaoException("", e);
		}
        return deposits;
    }

}
