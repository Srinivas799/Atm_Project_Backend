package com.srini.app;

import com.srini.services.AtmServices;
import com.srini.services.AtmServicesImpl;

public class AtmApp {
	public static void main(String[] args) {
		AtmServices service = new AtmServicesImpl();
		service.menu();
	}
}
