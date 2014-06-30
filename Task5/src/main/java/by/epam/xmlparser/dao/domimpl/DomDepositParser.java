package by.epam.xmlparser.dao.domimpl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.epam.xmlparser.dao.DepositTags;
import by.epam.xmlparser.pojo.Bank;
import by.epam.xmlparser.pojo.Deposit;
import by.epam.xmlparser.pojo.Depositor;



public class DomDepositParser {
	
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
	
	public List<Deposit> parse(Document depositDocument) {
		
        NodeList nodeDeposits = depositDocument.getDocumentElement().getChildNodes();
        
        for (int i = 0; i < nodeDeposits.getLength(); i++) {
            Node nodeDeposit = nodeDeposits.item(i);
            
            if (nodeDeposit instanceof Element) {
            	deposit = initDeposit();
                Node nodeAttribute = nodeDeposit.getAttributes().getNamedItem(DepositTags.ACCOUNT_ID.toString());
                
                if (null != nodeAttribute) {
                	depositor.setAccountId(nodeAttribute.getNodeValue());
                }
                nodeAttribute = nodeDeposit.getAttributes().getNamedItem(DepositTags.DEPOSIT_TYPE.toString());
                if (null != nodeAttribute) {
                	deposit.setDepositType(nodeAttribute.getNodeValue());
                }
                NodeList depositChildNodes = nodeDeposit.getChildNodes();
                
                for (int j = 0; j < depositChildNodes.getLength(); j++) {
                    Node depositChildNode = depositChildNodes.item(j);

                    if (depositChildNode instanceof Element) {
                        Node lastChildNode = depositChildNode.getLastChild();

                        if (lastChildNode != null) {
                            String nodeContent = lastChildNode.getTextContent().trim();
                            String nodeName = depositChildNode.getNodeName();

                            if (nodeName.equals(DepositTags.BANK_NAME.toString())) {
                            	bank.setBankName(nodeContent);
                            	nodeAttribute = depositChildNode.getAttributes().getNamedItem(DepositTags.BANK_COUNTRY.toString());
                            	if(null != nodeAttribute) {
                            		bank.setCountryRegistration(nodeAttribute.getNodeValue());
                            	}
                            	
                            } else if (nodeName.equals(DepositTags.DEPOSITOR.toString())) {
                            	depositor.setDepositorName(nodeContent);
                            } else if (nodeName.equals(DepositTags.AMOUNT_ON_DEPOSIT.toString())) {
                                deposit.setAmountOnDeposit(Long.valueOf(nodeContent));
                            } else if (nodeName.equals(DepositTags.PROFITABILITY.toString())) {
                                deposit.setProfitability(Double.valueOf(nodeContent));
                            } else if (nodeName.equals(DepositTags.TIME_CONSTRAINTS.toString())) {
                                deposit.setTimeConstraints(Integer.valueOf(nodeContent));
                            }
                        }
                    }
                }
            }
        }
        return deposits;
    }

}
