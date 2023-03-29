package com.srini.services;

import com.srini.Dao.AtmDAO;
import com.srini.Dao.AtmDAOImpl;
import com.srini.model.Atm;

public interface AtmServices {
	AtmDAO dao = new AtmDAOImpl();
	
	boolean DepositeMoney();
	boolean Withdraw();
	boolean OpenAccount();
	boolean MiniStatement();
	boolean BalanceEnquery();
	public void menu();
}
