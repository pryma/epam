package by.epam.xmlparser.service;

import java.util.ArrayList;
import java.util.List;

import by.epam.xmlparser.dao.XmlDao;
import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.dao.factory.DaoType;
import by.epam.xmlparser.dao.factory.XmlDaoFactory;
import by.epam.xmlparser.pojo.Deposit;
import by.epam.xmlparser.service.exception.ServiceException;

public class ParserService {
	
	public static List<DepositModel> parse(DaoType daoType, String nameXmlFile) throws ServiceException {
		List<DepositModel> depositModels = null;
		try {
			XmlDao xmlDao = XmlDaoFactory.getInstance().getXmlDao(daoType);
			List<Deposit> deposits = xmlDao.parse(nameXmlFile);
			depositModels = getDepositModel(deposits);
		} catch (XmlDaoException e) {
			throw new ServiceException(daoType+" Cannot parse XML file "+nameXmlFile, e);
		}
		return depositModels;
		
	}
	
	private static List<DepositModel> getDepositModel(List<Deposit> deposits) {
		List<DepositModel> depositModels = new ArrayList<DepositModel>();
		for (Deposit deposit : deposits) {
			DepositModel depositModel = new DepositModel();
			depositModels.add(depositModel);
			depositModel.setBankName(deposit.getBank().getBankName());
			depositModel.setCountryRegistration(deposit.getBank().getCountryRegistration());
			depositModel.setDepositorName(deposit.getDepositor().getDepositorName());
			depositModel.setAccountId(deposit.getDepositor().getAccountId());
			depositModel.setAmountOnDeposit(deposit.getAmountOnDeposit());
			depositModel.setDepositType(deposit.getDepositType());
			depositModel.setProfitability(deposit.getProfitability());
			depositModel.setTimeConstraints(deposit.getTimeConstraints());
		}
		return depositModels;
	}

}
