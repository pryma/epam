package by.epam.xmlparser.dao.saximpl;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.xmlparser.dao.DepositTags;
import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.pojo.Bank;
import by.epam.xmlparser.pojo.Deposit;
import by.epam.xmlparser.pojo.Depositor;

public class SaxDepositHandler extends DefaultHandler {

    List<Deposit> deposits = new ArrayList<Deposit>();
    Deposit deposit;
    Bank bank;
    Depositor depositor;
    String content;

    public List<Deposit> getDeposits() {
        return deposits;
    }
    
    private Deposit initDeposit() {
    	
    	deposit = new Deposit();
    	deposits.add(deposit);
    	bank = new Bank();
    	deposit.setBank(bank);
    	depositor = new Depositor();
    	deposit.setDepositor(depositor);
    	
    	return deposit;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(DepositTags.DEPOSIT.toString())) {
        	deposit = initDeposit();
        	
        	depositor.setAccountId(attributes.getValue(DepositTags.ACCOUNT_ID.toString()));
        	deposit.setDepositType(attributes.getValue(DepositTags.DEPOSIT_TYPE.toString()));
        }
        if (qName.equals(DepositTags.BANK_NAME.toString())) {
			bank.setBankName(attributes.getValue(DepositTags.BANK_NAME.toString()));
		}
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch (DepositTags.valueOf(qName)) {
		case BANK_NAME:
			bank.setBankName(content);
			break;
		case DEPOSITOR:
			depositor.setDepositorName(content);
			break;
		case AMOUNT_ON_DEPOSIT:
			deposit.setAmountOnDeposit(Long.valueOf(content));
			break;
		case PROFITABILITY:
			deposit.setProfitability(Double.valueOf(content));
			break;
		case TIME_CONSTRAINTS:
			deposit.setTimeConstraints(Integer.valueOf(content));

		default:
			
			
		}
    	
    	
    	/*if (qName.equals(DepositTags.BANK_NAME.toString())) {
        	bank.setBankName(content);
        } 
        if (qName.equals(DepositTags.DEPOSITOR.toString())) {
        	depositor.setDepositorName(content);
        }
        if (qName.equals(DepositTags.AMOUNT_ON_DEPOSIT.toString())) {
            deposit.setAmountOnDeposit(Long.valueOf(content));
        }
        if (qName.equals(DepositTags.PROFITABILITY.toString())) {
        	deposit.setProfitability(Double.valueOf(content));
        }
        if (qName.equals(DepositTags.TIME_CONSTRAINTS.toString())) {
        	deposit.setTimeConstraints(Integer.valueOf(content));
        }*/
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.valueOf(ch, start, length).trim();
    }
}
