package by.epam.xmlparser.dao.saximpl;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.xmlparser.dao.DepositTags;
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
        if (qName.equals(DepositTags.DEPOSIT.getTag())) {
        	deposit = initDeposit();
        	
        	depositor.setAccountId(attributes.getValue(DepositTags.ACCOUNT_ID.getTag()));
        	deposit.setDepositType(attributes.getValue(DepositTags.DEPOSIT_TYPE.getTag()));
        }
        if (qName.equals(DepositTags.BANK_NAME.getTag())) {
			bank.setCountryRegistration(attributes.getValue(DepositTags.BANK_COUNTRY.getTag()));
		}
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	
    	if (qName.equals(DepositTags.BANK_NAME.getTag())) {
        	bank.setBankName(content);
        } 
        if (qName.equals(DepositTags.DEPOSITOR.getTag())) {
        	depositor.setDepositorName(content);
        }
        if (qName.equals(DepositTags.AMOUNT_ON_DEPOSIT.getTag())) {
            deposit.setAmountOnDeposit(Long.valueOf(content));
        }
        if (qName.equals(DepositTags.PROFITABILITY.getTag())) {
        	deposit.setProfitability(Double.valueOf(content));
        }
        if (qName.equals(DepositTags.TIME_CONSTRAINTS.getTag())) {
        	deposit.setTimeConstraints(Integer.valueOf(content));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.valueOf(ch, start, length).trim();
    }
}
